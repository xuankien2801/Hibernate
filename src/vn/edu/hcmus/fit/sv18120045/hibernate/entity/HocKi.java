package vn.edu.hcmus.fit.sv18120045.hibernate.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "semester")
public class HocKi {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private String id;
	
	@Column (name = "tenHK")
	private String tenHK;
	
	@Column (name = "namhoc")
	private String namhoc;
	
	@Column (name = "ngayBD")
	private Date ngayBD;
	
	@Column (name = "ngayKT")
	private Date ngayKT;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
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
	
	public HocKi(String id, String tenHK, String namhoc, Date ngayBD, Date ngayKT) {
		this.id = id;
		this.tenHK = tenHK;
		this.namhoc = namhoc;
		this.ngayBD = ngayBD;
		this.ngayKT = ngayKT;
	}
}
