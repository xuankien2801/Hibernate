package vn.edu.hcmus.fit.sv18120045.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence;

@Entity
@Table (name = "subject")
public class MonHoc {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private String id;
	
	@Column (name = "maMH")
	private String maMH;
	
	@Column (name = "tenMH")
	private String tenMH;
	
	@Column (name = "sotinchi")
	private int sotinchi;
		
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getMaMH() {
		return maMH;
	}
	
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	
	public String getTenMH() {
		return tenMH;
	}
	
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	
	public int getSoTinChi() {
		return sotinchi;
	}
	
	public void setSoTinChi(int sotinchi) {
		this.sotinchi = sotinchi;
	}
		
	public MonHoc() {
	}
	
	public MonHoc(String maMH, String tenMH, int sotinchi) {
		this.id = id;
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.sotinchi = sotinchi;		
	}
}
