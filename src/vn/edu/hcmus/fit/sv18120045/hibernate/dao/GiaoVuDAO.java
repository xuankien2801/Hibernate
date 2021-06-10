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
		
		CallableStatement checkLopHocExists = conn.prepareCall("{? = Call check_exists_lopHoc(?)}");
        checkLopHocExists.registerOutParameter(1, Types.INTEGER);
        checkLopHocExists.execute();
        if (checkLopHocExists.getInt(1) == 1) {
            // Import_SinhVien @HoTen NVARCHAR(100), @GioiTinh NVARCHAR(3), @Email CHAR(100), @Password password
            CallableStatement statement = conn.prepareCall("{Call_Import_GiaoVu(?, ?, ?, ?, ?)}");
            statement.setString(1, gv.getHoten());
            statement.setString(2, gv.getGioitinh());
            statement.setString(3, gv.getEmail());
            statement.setString(4, gv.getPassword());
            statement.execute();
        }
        else {
        	throw new RuntimeException();
        }
	}
	
	// Doc 1 dong cua file input
	private static GiaoVu readGiaoVu(String line) {
	    String[] s = line.split(",");
        GiaoVu gv = new GiaoVu(s[1], s[2], s[3], s[4]);
        return gv;
    }
	
}
