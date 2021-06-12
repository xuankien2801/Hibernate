package vn.edu.hcmus.fit.sv18120045.hibernate.entity;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table(name = "account_sinhvien")
public class SinhVien implements Serializable {
	@Columns (columns = "mssv")
	private String mssv;
	
	@Columns (columns = "hoten")
	private String hoten;
	
	@Columns (columns = "gioitinh")
	private String gioitinh;
	
	@Columns (columns = "email")
	private String email;
	
	public String getmssv() {
		return mssv;
	}
	
	public void setmssv(String mssv) {
		this.mssv = mssv;
	}
	
	public String getHoten() {
		return hoten;
	}
	
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	
	public String getGioitinh() {
		return gioitinh;
	}
	
	public void setGioiTinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public SinhVien() {
	}
	
	public SinhVien(String mssv, String hoten, String gioitinh, String email) {
		this.mssv = mssv;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.email = email;
	}
}
