package vn.edu.hcmus.fit.sv18120045.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "class")
public class LopHoc {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "maLop")
	private String maLop;
	
	@Column (name = "TongSoSV")
	private int TongSoSV;
	
	@Column (name = "TongSoNam")
	private int TongSoNam;
	
	@Column (name = "TongSoNu")
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