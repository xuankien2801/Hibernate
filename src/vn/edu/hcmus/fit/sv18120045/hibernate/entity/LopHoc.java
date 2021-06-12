package vn.edu.hcmus.fit.sv18120045.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table(name = "class")
public class LopHoc {
	@Columns (columns = "maLop")
	private String maLop;
	
	@Columns (columns = "TongSoSV")
	private int TongSoSV;
	
	@Columns (columns = "TongSoNam")
	private int TongSoNam;
	
	@Columns (columns = "TongSoNu")
	private int TongSoNu;
	
	public String getId() {
		return id;
	}
	
	public void setId(String maLop) {
		this.maLop = maLop;
	}
	
	public int getTongSoSV() {
		return TongSoSV;
	}
	
	public void setTongSoSV(int TongSoSV) {
		this.TongSoSV = TongSoSV;
	}
	
	public int getTongSoNam() {
		return TongSoNam;
	}
	
	public void setTongSoNam(int TongSoNam) {
		this.TongSoNam = TongSoNam;
	}
	
	public int getTongSoNu() {
		return TongSoNu;
	}
	
	public void setTongSoNu(int TongSoNu) {
		this.TongSoNu = TongSoNu;
	}
	
	public LopHoc() {
	}
	
	public LopHoc(String maLop, int TongSoSV, int TongSoNam, int TongSoNu) {
		this.maLop = maLop;
		this.TongSoSV = TongSoSV;
		this.TongSoNam = TongSoNam;
		this.TongSoNu = TongSoNu;
	}
}