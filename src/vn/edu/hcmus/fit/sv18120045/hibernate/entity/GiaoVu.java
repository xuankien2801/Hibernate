package vn.edu.hcmus.fit.sv18120045.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.*;

@Entity
@Table(name = "account_giaovu")

public class GiaoVu {	
	@Columns (columns = "maGV")
	private String maGV;
	
	@Columns (columns = "hoten")
	private String hoten;
	
	@Columns (columns = "gioitinh")
	private String gioitinh;
	
	@Columns (columns = "email")
	private String email;
	
	@Columns (columns = "password")
	private String password;
	
	public String getmaGV() {
		return maGV;
	}
	
	public void setmaGV(String maGV) {
		this.maGV = maGV;
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
	
	public GiaoVu(String maGV, String hoten, String gioitinh, String email, String password) {
		this.maGV = maGV;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.email = email;
		this.password = password;
	}
}
