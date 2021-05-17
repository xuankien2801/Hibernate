package vn.edu.hcmus.fit.sv18120045.hibernate.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table (name = "course registration session")
public class KiDangKyHocPhan {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private String id;
		
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
	
	public KiDangKyHocPhan() {
	}
	
	public KiDangKyHocPhan(String id, Date ngayBD, Date ngayKT) {
		this.id = id;		
		this.ngayBD = ngayBD;
		this.ngayKT = ngayKT;
	}
}
