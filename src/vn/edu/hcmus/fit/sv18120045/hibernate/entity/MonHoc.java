package vn.edu.hcmus.fit.sv18120045.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table (name = "_subject")
public class MonHoc {
	@Columns (columns = "maMH")
	private String maMH;
	
	@Columns (columns = "tenMH")
	private String tenMH;
	
	@Columns (columns = "sotinchi")
	private int sotinchi;
	
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
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.sotinchi = sotinchi;		
	}
}
