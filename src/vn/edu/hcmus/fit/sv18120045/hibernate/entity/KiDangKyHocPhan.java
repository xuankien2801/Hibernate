package vn.edu.hcmus.fit.sv18120045.hibernate.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.*;

@Entity
@Table (name = "course_registration_session")
public class KiDangKyHocPhan {
	@Columns (columns = "ngayBD")
	private Date ngayBD;
	
	@Columns (columns = "ngayKT")
	private Date ngayKT;
	
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
	
	public KiDangKyHocPhan(Date ngayBD, Date ngayKT) {
		this.ngayBD = ngayBD;
		this.ngayKT = ngayKT;
	}
}
