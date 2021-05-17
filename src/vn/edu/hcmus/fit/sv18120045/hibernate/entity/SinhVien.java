package vn.edu.hcmus.fit.sv18120045.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "SINHVIEN")
public class SinhVien {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "_maSV")
	private long _maSV;
	
	@Column (name = "_mssv")
	private String _mssv;
	
	@Column (name = "_hoTen")
	private String _hoTen;
	
	@Coulmn (name = "_gioiTinh")
	private String _gioiTinh;
	
	@Column (name = "_email")
	private String _email;
	
	public long get_maSV() {
		return _maSV;
	}
	
	public void set_maSV(long _maSV) {
		this._maSV = _maSV;
	}
	
	public String get_mssv() {
		return _mssv;
	}
	
	public void set_mssv(String _mssv) {
		this._mssv = _mssv;
	}
	
	public String get_hoTen() {
		return _hoTen;
	}
	
	public void set_hoTen(String _hoTen) {
		this._hoTen = _hoTen;
	}
	
	public String get_gioiTinh() {
		return _gioiTinh;
	}
	
	public void set_gioiTinh(String _gioiTinh) {
		this._gioiTinh = _gioiTinh;
	}
	
	public String get_email(String _email) {
		return _email;
	}
	
	public void set_email(String _email) {
		this._email = _email;
	}
	
	public SinhVien() {
	}
	
	public SinhVien(long _maSV, String _mssv, String _hoTen, String _gioiTinh, String _email) {
		this._maSV = _maSV;
		this._mssv = _mssv;
		this._hoTen = _hoTen;
		this._gioiTinh = _gioiTinh;
		this._email = _email;
	}
}
