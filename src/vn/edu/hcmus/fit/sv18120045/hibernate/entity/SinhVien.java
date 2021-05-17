package vn.edu.hcmus.fit.sv18120045.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "account_sinhvien")
public class SinhVien {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private String id;
	
	@Column (name = "mssv")
	private int mssv;
	
	@Column (name = "hoten")
	private String hoten;
	
	@Coulmn (name = "gioitinh")
	private String gioitinh;
	
	@Column (name = "email")
	private String email;
	
	public String getid() {
		return id;
	}
	
	public void setid(String id) {
		this.id = id;
	}
	
	public int getmssv() {
		return mssv;
	}
	
	public void setmssv(int mssv) {
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
	
	public String getEmail(String email) {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public SinhVien() {
	}
	
	public SinhVien(String id, int mssv, String hoten, String gioitinh, String email) {
		this.id = id;
		this.mssv = mssv;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.email = email;
	}
}
