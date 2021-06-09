package vn.edu.hcmus.fit.sv18120045.hibernate.dao;

import vn.edu.hcmus.fit.sv18120045.hibernate.util.HibernateUtil;
import java.util.*;
import java.sql.*;

public class LopHocDAO {
	// ghi data xuong database
    public static void addLopHoc(String tenLop) throws SQLException {
        Connection conn = null;
        conn = HibernateUtil.getConnection();
        // create_lopHoc @tenLop VARCHAR(10)
        // neu da ton tai thi khong tao nua, nguoc lai, tao moi 1 lop hoc
        CallableStatement createLopHoc = conn.prepareCall("{Call create_lopHoc(?)}");
        createLopHoc.setString(1, tenLop);
        createLopHoc.execute();
    }

    // ham xem danh sach lop
    // tra ve 1 arraylist chua bang 
    public static ArrayList<ArrayList<String>> XemDanhSachLop(String tenLop) throws SQLException {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        Connection conn = null;
        conn = HibernateUtil.getConnection();
        // XemDanhSachLop @tenLop VARCHAR(10)
        CallableStatement xemDanhSach = conn.prepareCall("{Call XemDanhSachLop(?)}");
        xemDanhSach.setString(1, tenLop);

        ResultSet rs = xemDanhSach.executeQuery();
        ArrayList<String> l1 = new ArrayList<>();
        ArrayList<String> l2 = new ArrayList<>();
        ArrayList<String> l3 = new ArrayList<>();
        ArrayList<String> l4 = new ArrayList<>();
        while (rs.next()) {
            l1.add(rs.getString(1));
            l2.add(rs.getString(2));
            l3.add(rs.getString(3));
            l4.add(rs.getString(4));
        }
        list.add(l1);
        list.add(l2);
        list.add(l4);
        list.add(l3);
        return list;
    }
}
