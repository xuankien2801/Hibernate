package vn.edu.hcmus.fit.sv18120045.hibernate.dao;

import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import vn.edu.hcmus.fit.sv18120045.hibernate.entity.*;
import vn.edu.hcmus.fit.sv18120045.hibernate.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class SinhVienDAO {
	
	//them sinh vien vao db
	public static void addSinhVien(SinhVien sv, String hocPhan) throws SQLException {
		Connection conn = null;
		conn = HibernateUtil.getConnection();
		
		CallableStatement checkLopHocExists = conn.prepareCall("{? = Call check_exists_lopHoc(?)}");
        checkLopHocExists.registerOutParameter(1, Types.INTEGER);
        checkLopHocExists.setString(2, hocPhan);
        checkLopHocExists.execute();
        if (checkLopHocExists.getInt(1) == 1) {
            // Import_SinhVien @MSSV INT, @HoTen NVARCHAR(100), @GioiTinh NVARCHAR(3), @Email CHAR(100), @TenLop NVARCHAR(10)
            CallableStatement addSV = conn.prepareCall("{Call_Import_SinhVien(?, ?, ?, ?, ?)}");
            addSV.setString(1, sv.getmssv());
            addSV.setString(2, sv.getHoten());
            addSV.setString(3, sv.getGioitinh());
            addSV.setString(4, sv.getEmail());
            addSV.setString(5, hocPhan);
            addSV.execute();
        }
        else {
        	throw new RuntimeException();
        }
	}
	
	// Doc 1 dong cua file input
	private static SinhVien readSinhVien(String line) {
        String[] s = line.split(",");
        SinhVien sv = new SinhVien(s[1], s[2], s[3], s[4]);
        return sv;
    }
	
	//import danh sach lop
	public static String importDanhSachLop(String filename) throws SQLException {
		Connection conn = null;
		BufferedReader br = null;
        String line = null;
        String tenLop = null;
        
        try {
        	conn = HibernateUtil.getConnection();
        	br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "utf8"));
        	CallableStatement importSinhVien = conn.prepareCall("{Call Import_SinhVien(?, ?, ?, ?, ?)}");
        	tenLop = br.readLine();
        	LopHocDAO.addLopHoc(tenLop);
        	
        	br.readLine();
        	while ((line.equals(br.readLine()))) {
        		SinhVien sv = readSinhVien(line);
        		importSinhVien.setString(1, sv.getmssv());
        		importSinhVien.setString(2, sv.getHoten());
        		importSinhVien.setString(3, sv.getGioitinh());
        		importSinhVien.setString(4, sv.getEmail());
        		importSinhVien.setString(5, tenLop);
        		importSinhVien.execute();
        	}
        }
        catch (IOException ioe) {
        	System.err.print(ioe);
        }
        finally {
        	if (br != null) {
        		try {
        			br.close();
        		}
        		catch (IOException e) {
        			System.err.println("importDanhSachLop(String filename) trong SinhVienDAO");
        		}
        	}
        }
        return tenLop;
	}
	
}
