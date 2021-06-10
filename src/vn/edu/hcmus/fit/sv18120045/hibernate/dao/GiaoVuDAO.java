package vn.edu.hcmus.fit.sv18120045.hibernate.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import vn.edu.hcmus.fit.sv18120045.hibernate.entity.GiaoVu;
import vn.edu.hcmus.fit.sv18120045.hibernate.entity.SinhVien;
import vn.edu.hcmus.fit.sv18120045.hibernate.util.HibernateUtil;

public class GiaoVuDAO {
	//them giao vu vao db
	public static void addGiaoVu(GiaoVu gv) throws SQLException {
		Connection conn = null;
		conn = HibernateUtil.getConnection();
		try {
		
            // Import_SinhVien @HoTen NVARCHAR(100), @GioiTinh NVARCHAR(3), @Email CHAR(100), @Password password
            CallableStatement addGiaoVu = conn.prepareCall("{Call_Import_GiaoVu(?, ?, ?, ?, ?)}");
            addGiaoVu.setString(1, gv.getmaGV());
            addGiaoVu.setString(2, gv.getHoten());
            addGiaoVu.setString(3, gv.getGioitinh());
            addGiaoVu.setString(4, gv.getEmail());
            addGiaoVu.setString(5, gv.getPassword());
            addGiaoVu.execute();
        }
		catch (SQLException se) {
            System.err.println("Loi o ham addGiaoVu(GiaoVu gv) file GiaoVuDAO");
            do {
                System.out.println("MESSAGE: " + se.getMessage());
                System.out.println();
                se = se.getNextException();
            }
            while (se != null);
        }
	}
	
	// Doc 1 dong cua file input
	private static GiaoVu readGiaoVu(String line) {
	    String[] s = line.split(",");
        GiaoVu gv = new GiaoVu(s[1], s[2], s[3], s[4], s[5]);
        return gv;
    }
	
}
