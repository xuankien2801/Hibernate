USE master
GO

DROP DATABASE IF EXISTS  QLSV
GO

CREATE DATABASE QLSV
GO

USE QLSV
GO

CREATE TABLE SinhVien (
    maSinhVien CHAR(10) IDENTITY(1,1),
    mssv CHAR(10) UNIQUE NOT NULL,
    hoten NVARCHAR(100),
    gioitinh NVARCHAR(3),
    email CHAR(100) UNIQUE,
    hocphan CHAR(10) NOT NULL,
    CONSTRAINT PK_SinhVien PRIMARY KEY(maSinhVien),
    CONSTRAINT Check_GioiTinh CHECK (gioitinh in ('Nam', 'nam', N'Nữ', N'nữ'))
)
GO

CREATE TABLE LopHoc (
    maLop CHAR(10) IDENTITY(1,1),
    TongSoSV INT,
    TongSoNam INT,
    TongSoNu INT,
    CONSTRAINT PK_LopHoc PRIMARY KEY(maLop)
)
GO

CREATE TABLE MonHoc (
    maMH CHAR(10) IDENTITY(1,1),
	tenMH NVARCHAR(100) NOT NULL,
    sotinchi INT,
    CONSTRAINT PK_MonHoc PRIMARY KEY(maMH)
)
GO

CREATE TABLE GiaoVu (
	maGV CHAR(10) IDENTITY(1,1),
    hoten NVARCHAR(100),
    gioitinh NVARCHAR(3),
    email CHAR(100) UNIQUE,
    password NVARCHAR(20) UNIQUE,
    CONSTRAINT PK_GiaoVu PRIMARY KEY (maGV)
)
GO

CREATE TABLE HocKi (
	tenHK CHAR(3) IDENTITY(1,1),
    namhoc CHAR(11) NOT NULL,
    ngayBD DATE,
    ngayKT DATE,
    CONSTRAINT PK_HocKI PRIMARY KEY (tenHK, namhoc)
)
GO

CREATE TABLE HocPhan (
	maHP CHAR(10) IDENTITY(1,1),
	maMH CHAR(10),
    tenMH NVARCHAR(100),
    sotinchi INT,
    giaovienLT CHAR(10),
    tenPhongHoc CHAR(10),
    thu NVARCHAR(8),
    ca INT,
    CONSTRAINT PK_HocPhan PRIMARY KEY (maMH, giaovienLT, tenPhongHoc, thu, ca)
)
GO

CREATE TABLE KiDangKyHocPhan(
	ngayBD DATE IDENTITY(1,1),
    NgayKT DATE,
    CONSTRAINT PK_KiDangKyHocPhan PRIMARY KEY (ngayBD, ngayKT)
)
GO

ALTER TABLE SinhVien ADD CONSTRAINT FK_SinhVien_HocPhan FOREIGN KEY (hocphan) REFERENCES HocPhan(maHP)
ALTER TABLE HocPhan ADD CONSTRAINT FK_HocPhan_MonHoc_1 FOREIGN KEY (maMH) REFERENCES MonHoc(maMH)
ALTER TABLE HocPhan ADD CONSTRAINT FK_HocPhan_MonHoc_2 FOREIGN KEY (tenMH) REFERENCES MonHoc(tenMH)
ALTER TABLE HocPhan ADD CONSTRAINT FK_HocPhan_MonHoc_3 FOREIGN KEY (sotinchi) REFERENCES MonHoc(sotinchi)