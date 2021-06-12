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

INSERT INTO class (maLop, TongSoSV, TongSoNam, TongSoNu) VALUES ('C001', NULL, NULL, NULL);
INSERT INTO class (maLop, TongSoSV, TongSoNam, TongSoNu) VALUES ('C002', NULL, NULL, NULL);
INSERT INTO class (maLop, TongSoSV, TongSoNam, TongSoNu) VALUES ('C003', NULL, NULL, NULL);
INSERT INTO class (maLop, TongSoSV, TongSoNam, TongSoNu) VALUES ('C004', NULL, NULL, NULL);
INSERT INTO class (maLop, TongSoSV, TongSoNam, TongSoNu) VALUES ('C005', NULL, NULL, NULL);

INSERT INTO _subject (maMH, tenMH, sotinchi) VALUES ('S001', 'Lập trình ứng dụng Java', 4);
INSERT INTO _subject (maMH, tenMH, sotinchi) VALUES ('S002', 'Phương pháp tính', 4);
INSERT INTO _subject (maMH, tenMH, sotinchi) VALUES ('S003', 'Nhập môn công nghệ phần mềm', 4);
INSERT INTO _subject (maMH, tenMH, sotinchi) VALUES ('S004', 'Thiết kế phần mềm', 4);

INSERT INTO semester (tenHK, namhoc, ngayBD, ngayKT) VALUES ('HK1', '2020-2021', '2020-09-01', '2021-01-31');
INSERT INTO semester (tenHK, namhoc, ngayBD, ngayKT) VALUES ('HK2', '2020-2021', '2021-03-01', '2021-07-31');

INSERT INTO course (maHP, maMH, tenMH, sotinchi, giaovienLT, tenPhongHoc, thu, ca) VALUES ('S001', 'Lập trình ứng dụng Java', 4, 'GV001', 'F103', 'Thứ Hai', 1);
INSERT INTO course (maHP, maMH, tenMH, sotinchi, giaovienLT, tenPhongHoc, thu, ca) VALUES ('S001', 'Lập trình ứng dụng Java', 4, 'GV002', 'F104', 'Thứ Ba', 1);
INSERT INTO course (maHP, maMH, tenMH, sotinchi, giaovienLT, tenPhongHoc, thu, ca) VALUES ('S002', 'Phương pháp tính', 4, 'GV003', 'E103', 'Thứ Hai', 2);
INSERT INTO course (maHP, maMH, tenMH, sotinchi, giaovienLT, tenPhongHoc, thu, ca) VALUES ('S002', 'Phương pháp tính', 4, 'GV004', 'E104', 'Thứ Ba', 2);
INSERT INTO course (maHP, maMH, tenMH, sotinchi, giaovienLT, tenPhongHoc, thu, ca) VALUES ('S002', 'Phương pháp tính', 4, 'GV005', 'E105', 'Thứ Tư', 2);
INSERT INTO course (maHP, maMH, tenMH, sotinchi, giaovienLT, tenPhongHoc, thu, ca) VALUES ('S003', 'Nhập môn công nghệ phần mềm', 4, 'GV006', 'D103', 'Thứ Năm', 1);
INSERT INTO course (maHP, maMH, tenMH, sotinchi, giaovienLT, tenPhongHoc, thu, ca) VALUES ('S003', 'Nhập môn công nghệ phần mềm', 4, 'GV007', 'D104', 'Thứ Sáu', 1);
INSERT INTO course (maHP, maMH, tenMH, sotinchi, giaovienLT, tenPhongHoc, thu, ca) VALUES ('S003', 'Nhập môn công nghệ phần mềm', 4, 'GV008', 'D105', 'Thứ Bảy', 1);
INSERT INTO course (maHP, maMH, tenMH, sotinchi, giaovienLT, tenPhongHoc, thu, ca) VALUES ('S004', 'Thiết kế phần mềm', 4, 'GV009', 'F203', 'Thứ Năm', 4);
INSERT INTO course (maHP, maMH, tenMH, sotinchi, giaovienLT, tenPhongHoc, thu, ca) VALUES ('S004', 'Thiết kế phần mềm', 4, 'GV010', 'F303', 'Thứ Sáu', 4);

INSERT INTO course_registration_session (ngayBD, ngayKT) VALUES ('2020-08-05', '2020-08-25');
INSERT INTO course_registration_session (ngayBD, ngayKT) VALUES ('2020-02-05', '2020-02-25');

