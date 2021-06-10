package vn.edu.hcmus.fit.sv18120045.hibernate.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import vn.edu.hcmus.fit.sv18120045.hibernate.entity.*;
import vn.edu.hcmus.fit.sv18120045.hibernate.util.*;


public class HocKiDAO {
	// ghi hoc ki xuong db
	public static void addHocKi(HocKi hk) {
		Connection conn = null;
		try {
			conn = HibernateUtil.getConnection();
            // create_hocKi @tenHocKi NVARCHAR(10), @namHoc CHAR(10), @ngayBD Date, @ngayKT Date
            CallableStatement addHocKi = conn.prepareCall("{Call create_hocKi(?, ?, ?, ?)}");
            addHocKi.setString(1, hk.getTenHK());
            addHocKi.setString(2, hk.getNamHoc());
            addHocKi.setDate(3, (Date) hk.getNgayBD());
            addHocKi.setDate(4, (Date) hk.getNgayKT());
            addHocKi.execute();
        }
        catch (SQLException se) {
            System.err.println("Loi o ham addHocKi(HocKi hk) file HocKiDAO");
            do {
                System.out.println("MESSAGE: " + se.getMessage());
                System.out.println();
                se = se.getNextException();
            }
            while (se != null);
        }
	}
}
