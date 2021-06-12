CREATE SCHEMA QLSV;
USE QLSV;

CREATE TABLE account_sinhvien (
    mssv CHAR(10) UNIQUE NOT NULL,
    hoten NVARCHAR(100),
    gioitinh NVARCHAR(3),
    email CHAR(100) UNIQUE,
    hocphan CHAR(10) NOT NULL,
    CONSTRAINT PK_SinhVien PRIMARY KEY(mssv),
    CONSTRAINT Check_GioiTinh CHECK (gioitinh in ('Nam', 'nam', N'Nữ', N'nữ'))
);

CREATE TABLE class (
    maLop CHAR(10),
    TongSoSV INT,
    TongSoNam INT,
    TongSoNu INT,
    CONSTRAINT PK_LopHoc PRIMARY KEY(maLop)
);

CREATE TABLE _subject (
    maMH CHAR(10),
	tenMH NVARCHAR(100) NOT NULL,
    sotinchi INT,
    CONSTRAINT PK_MonHoc PRIMARY KEY(maMH)
);

CREATE TABLE account_giaovu (
	maGV CHAR(10) AUTO_INCREMENT,
    hoten NVARCHAR(100),
    gioitinh NVARCHAR(3),
    email CHAR(100) UNIQUE,
    _password NVARCHAR(20) UNIQUE,
    CONSTRAINT PK_GiaoVu PRIMARY KEY (maGV)
);

CREATE TABLE semester (
	tenHK CHAR(3),
    namhoc CHAR(11) NOT NULL,
    ngayBD DATE,
    ngayKT DATE,
    CONSTRAINT PK_HocKI PRIMARY KEY (tenHK, namhoc)
);

CREATE TABLE course (
	maHP CHAR(10),
	maMH CHAR(10),
    tenMH NVARCHAR(100),
    sotinchi INT,
    giaovienLT CHAR(10),
    tenPhongHoc CHAR(10),
    thu NVARCHAR(8),
    ca INT,
    CONSTRAINT PK_HocPhan PRIMARY KEY (maMH, giaovienLT, tenPhongHoc, thu, ca)
);

CREATE TABLE course_registration_session(
	ngayBD DATE,
    NgayKT DATE,
    CONSTRAINT PK_KiDangKyHocPhan PRIMARY KEY (ngayBD, ngayKT)
);

ALTER TABLE account_sinhvien ADD CONSTRAINT FK_SinhVien_HocPhan FOREIGN KEY (hocphan) REFERENCES course(maHP);
ALTER TABLE course ADD CONSTRAINT FK_HocPhan_MonHoc_1 FOREIGN KEY (maMH) REFERENCES _subject(maMH);
ALTER TABLE course ADD CONSTRAINT FK_HocPhan_MonHoc_2 FOREIGN KEY (tenMH) REFERENCES _subject(tenMH);
ALTER TABLE course ADD CONSTRAINT FK_HocPhan_MonHoc_3 FOREIGN KEY (sotinchi) REFERENCES _subject(sotinchi);

INSERT INTO account_sinhvien (mssv, hoten, gioitinh, email, hocphan) VALUES ('18120001', 'Trần Văn A', 'Nam', '18120001@student.hcmus.edu.vn', NULL);
INSERT INTO account_sinhvien (mssv, hoten, gioitinh, email, hocphan) VALUES ('18120002', 'Trần Văn B', 'Nam', '18120002@student.hcmus.edu.vn', NULL);
INSERT INTO account_sinhvien (mssv, hoten, gioitinh, email, hocphan) VALUES ('18120003', 'Trần Văn C', 'Nam', '18120003@student.hcmus.edu.vn', NULL);
INSERT INTO account_sinhvien (mssv, hoten, gioitinh, email, hocphan) VALUES ('18120004', 'Trần Văn D', 'Nữ', '18120004@student.hcmus.edu.vn', NULL);
INSERT INTO account_sinhvien (mssv, hoten, gioitinh, email, hocphan) VALUES ('18120005', 'Trần Văn E', 'Nữ', '18120005@student.hcmus.edu.vn', NULL);

INSERT INTO account_giaovu (maGV, hoten, email, gioitinh, _password) VALUES ('GVu001', 'Nguyễn Văn A', 'nva@fit.hcmus.edu.vn', 'Nam', '12345');
INSERT INTO account_giaovu (maGV, hoten, email, gioitinh, _password) VALUES ('GVu002', 'Trần Thị B', 'ttb@fit.hcmus.edu.vn', 'Nữ', '54321');


