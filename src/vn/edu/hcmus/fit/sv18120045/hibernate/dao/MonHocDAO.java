package vn.edu.hcmus.fit.sv18120045.hibernate.dao;

import vn.edu.hcmus.fit.sv18120045.hibernate.entity.MonHoc;
import vn.edu.hcmus.fit.sv18120045.hibernate.util.*;
import java.sql.*;

public class MonHocDAO {
	// ghi mon hoc xuong db 
    public static void addMonHoc(MonHoc mh) {
        Connection conn = null;
        try {
            conn = HibernateUtil.getConnection();

            // create_monHoc @maMonHoc NVARCHAR(10), @tenMonHoc CHAR(100), @soTinChi INT
            CallableStatement addMon = conn.prepareCall("{Call create_monHoc(?, ?, ?)}");
            addMon.setString(1, mh.getMaMH());
            addMon.setString(2,mh.getTenMH());
            addMon.setLong(3, mh.getSoTinChi());
            addMon.execute();
        }
        catch (SQLException se) {
            System.err.println("Loi o ham addMonHoc(String tenMonHoc, String maMonHoc) file MonHocDAO");
            do {
                System.out.println("MESSAGE: " + se.getMessage());
                System.out.println();
                se = se.getNextException();
            }
            while (se != null);
        }
    }
}
