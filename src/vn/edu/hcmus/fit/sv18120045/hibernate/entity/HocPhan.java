package vn.edu.hcmus.fit.sv18120045.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence;

@Entity
@Table (name = "course")
public class HocPhan {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "maHP")
	private String maHP;
	
	@Column (name = "maMH")
	private String maMH;
	
	@Column (name = "tenMH")
	private String tenMH;
	
	@Column (name = "sotinchi")
	private int sotinchi;
	
	@Column (name = "giaovienLT")
	private String giaovienLT;
	
	@Column (name = "tenPhongHoc")
	private String tenPhongHoc;
	
	@Column (name = "thu")
	private String thu;
	
	@Column (name = "ca")
	private int ca;
	
	public String getMaHP() {
		return maHP;
	}
	
	public void setMaHP(String maHP) {
		this.maHP = maHP;
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
	
	public String getGiaoVienLT() {
		return giaovienLT;
	}
	
	public void setGiaoVienLT(String giaovienLT) {
		this.giaovienLT = giaovienLT;
	}
	
	public String getTenPhongHoc() {
		return tenPhongHoc;
	}
	
	public void setTenPhongHoc(String tenPhongHoc) {
		this.tenPhongHoc = tenPhongHoc;
	}
	
	public String getThu() {
		return thu;
	}
	
	public void setThu(String thu) {
		this.thu = thu;
	}
	
	public int getCa() {
		return ca;
	}
	
	public void setCa(int ca) {
		this.ca = ca;
	}
	
	public HocPhan() {
	}
	
	public HocPhan(String maMH, String tenMH, int sotinchi, String giaovienLT, String tenPhongHoc, String thu, int ca) {
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.sotinchi = sotinchi;
		this.giaovienLT = giaovienLT;
		this.tenPhongHoc = tenPhongHoc;
		this.thu = thu;
		this.ca = ca;
	}
}
