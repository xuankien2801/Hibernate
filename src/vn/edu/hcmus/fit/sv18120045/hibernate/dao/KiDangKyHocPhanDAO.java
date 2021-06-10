package vn.edu.hcmus.fit.sv18120045.hibernate.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import vn.edu.hcmus.fit.sv18120045.hibernate.entity.KiDangKyHocPhan;
import vn.edu.hcmus.fit.sv18120045.hibernate.util.HibernateUtil;

public class KiDangKyHocPhanDAO {
	// ghi hoc phan xuong db
	public static void addKiDangKyHocPhan(KiDangKyHocPhan kdkhp) {
		Connection conn = null;
		try {
			conn = HibernateUtil.getConnection();
            // create_kiDangKyHocPhan @ngayBD Date, @ngayKT Date
            CallableStatement addKiDangKyHocPhan = conn.prepareCall("{Call create_hocPhan(?, ?)}");
            addKiDangKyHocPhan.setDate(1, (Date) kdkhp.getNgayBD());
            addKiDangKyHocPhan.setDate(2, (Date) kdkhp.getNgayKT());
            addKiDangKyHocPhan.execute();
        }
        catch (SQLException se) {
            System.err.println("Loi o ham addKiDangKyHocPhan(KiDangKyHocPhan kdkhp) file KiDangKyHocPhanDAO");
            do {
                System.out.println("MESSAGE: " + se.getMessage());
                System.out.println();
                se = se.getNextException();
            }
            while (se != null);
        }
	}

}
