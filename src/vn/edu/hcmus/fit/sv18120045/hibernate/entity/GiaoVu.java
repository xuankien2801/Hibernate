package vn.edu.hcmus.fit.sv18120045.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "account_giaovu")

public class GiaoVu {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private long id;
	
	@Column (name = "hoten")
	private String hoten;
	
	@Coulmn (name = "gioitinh")
	private String gioitinh;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "password")
	private String password;
	
	public long getid() {
		return id;
	}
	
	public void setid(long id) {
		this.id = id;
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public GiaoVu() {
	}
	
	public GiaoVu(String hoten, String gioitinh, String email, String password) {
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.email = email;
		this.password = password;
	}
}
