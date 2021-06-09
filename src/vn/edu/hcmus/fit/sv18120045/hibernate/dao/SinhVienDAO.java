package vn.edu.hcmus.fit.sv18120045.hibernate.dao;

import java.io.*;

import vn.edu.hcmus.fit.sv18120045.hibernate.entity.*;
import vn.edu.hcmus.fit.sv18120045.hibernate.util.HibernateUtil;

public class SinhVienDAO {
	//them sinh vien vao db
	public static void addSinhVien(SinhVien sv, String tenLop) throws SQLException {
		Connection conn = null;
		conn = HibernateUtil.getConnection();
		
		CallableStatement checkLopHocExists = conn.prepareCall("{? = Call check_exists_lopHoc(?)}");
        checkLopHocExists.registerOutParameter(1, Types.INTEGER);
        checkLopHocExists.setString(2, tenLop);
        checkLopHocExists.execute();
        if (checkLopHocExists.getInt(1) == 1) {
            // Import_SinhVien @mssv CHAR(10), @hoTen NVARCHAR(100), @gioiTinh NVARCHAR(3), @cmnd CHAR(9), @tenLop VARCHAR(10)
            CallableStatement statement = conn.prepareCall("{Call Import_SinhVien(?, ?, ?, ?, ?)}");
            statement.setString(1, sv.getmssv());
            statement.setString(2, sv.getHoTen());
            statement.setString(3, sv.getGioiTinh());
            statement.setString(4, sv.getEmail());
            statement.setString(5, tenLop);
            
            //quang loi neu sinh vien them vao bi trung
            statement.execute();
        }
        else {
        	throw new RuntimeException;
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
