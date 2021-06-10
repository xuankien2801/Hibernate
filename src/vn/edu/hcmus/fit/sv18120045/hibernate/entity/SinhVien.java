package vn.edu.hcmus.fit.sv18120045.hibernate.entity;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "account_sinhvien")
public class SinhVien implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;
	
	@Column (name = "mssv")
	private String mssv;
	
	@Column (name = "hoten")
	private String hoten;
	
	@Coulmn (name = "gioitinh")
	private String gioitinh;
	
	@Column (name = "email")
	private String email;
	
	public int getid() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
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
