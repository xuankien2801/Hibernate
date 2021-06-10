package vn.edu.hcmus.fit.sv18120045.hibernate.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import vn.edu.hcmus.fit.sv18120045.hibernate.entity.HocPhan;
import vn.edu.hcmus.fit.sv18120045.hibernate.util.HibernateUtil;

public class HocPhanDAO {
	// ghi hoc phan xuong db
	public static void addHocPhan(HocPhan hp) {
		Connection conn = null;
		try {
			conn = HibernateUtil.getConnection();
            // create_hocKi @maMonHoc CHAR(10), @tenMonHoc NVARCHAR(100), @soTinChi INT, @GVLT CHAR(10), @tenPhongHoc CHAR(10), @Thu NVARCHAR(8), @Ca INT
            CallableStatement addHocPhan = conn.prepareCall("{Call create_hocPhan(?, ?, ?, ?, ?, ?, ?)}");
            addHocPhan.setString(1, hp.getMaMH());
            addHocPhan.setString(2, hp.getTenMH());
            addHocPhan.setInt(3, hp.getSoTinChi());
            addHocPhan.setString(4, hp.getGiaoVienLT());
            addHocPhan.setString(5, hp.getTenPhongHoc());
            addHocPhan.setString(6, hp.getThu());
            addHocPhan.setInt(7, hp.getCa());
            addHocPhan.execute();
        }
        catch (SQLException se) {
            System.err.println("Loi o ham addHocPhan(HocPhan hp) file HocPhanDAO");
            do {
                System.out.println("MESSAGE: " + se.getMessage());
                System.out.println();
                se = se.getNextException();
            }
            while (se != null);
        }
	}
}
