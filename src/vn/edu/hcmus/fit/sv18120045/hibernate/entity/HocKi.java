package vn.edu.hcmus.fit.sv18120045.hibernate.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.*;

@Entity
@Table(name = "semester")
public class HocKi {	
	@Columns (columns = "tenHK")
	private String tenHK;
	
	@Columns (columns = "namhoc")
	private String namhoc;
	
	@Columns (columns = "ngayBD")
	private Date ngayBD;
	
	@Columns (columns = "ngayKT")
	private Date ngayKT;
	
	public String getTenHK() {
		return tenHK;
	}
	
	public String setTenHK(String tenHK) {
		this.tenHK = tenHK;
	}
	
	public String getNamHoc() {
		return namhoc;
	}
	
	public void setNamHoc(String namhoc) {
		this.namhoc = namhoc;
	}
	
	public Date getNgayBD() {
		return ngayBD;
	}
	
	public void setNgayBD(Date ngayBD) {
		this.ngayBD = ngayBD;
	}
	
	public Date getNgayKT() {
		return ngayKT;
	}
	
	public void setNgayKT(Date ngayKT) {
		this.ngayKT = ngayKT;
	}
	
	public HocKi() {
	}
	
	public HocKi(String tenHK, String namhoc, Date ngayBD, Date ngayKT) {
		this.tenHK = tenHK;
		this.namhoc = namhoc;
		this.ngayBD = ngayBD;
		this.ngayKT = ngayKT;
	}
}
