-- Tạo database
USE master;
GO

CREATE DATABASE EBicycleRent;
GO

USE EBicycleRent;
GO

-- Tạo bảng TaiKhoan
CREATE TABLE TaiKhoan (
	TKID VARCHAR(50) NOT NULL PRIMARY KEY,
	MatKhau VARCHAR(100),
	VaiTro NVARCHAR(20),
	Sdt VARCHAR(20),
	SoDu INT
);
GO

-- Tạo bảng NguoiDung
CREATE TABLE NguoiDung (
	UserID VARCHAR(50) NOT NULL PRIMARY KEY,
	TKID VARCHAR(50),
	HoTen NVARCHAR(100),
	Email VARCHAR(100)
);
GO

-- Tạo bảng QuanLy
CREATE TABLE QuanLy (
	QLID VARCHAR(50) NOT NULL PRIMARY KEY,
	TKID VARCHAR(50),
	HoTen NVARCHAR(100),
	Email VARCHAR(100)
);
GO

-- Tạo bảng TramXe
CREATE TABLE TramXe (
	TramXeID VARCHAR(50) NOT NULL PRIMARY KEY,
	TenTram NVARCHAR(100),
	DiaChi NVARCHAR(200),
	TongChoDo INT,
	SoXeKhaDung INT,
	SoChoTrong INT
);
GO

-- Tạo bảng XeDap
CREATE TABLE XeDap (
	XeID VARCHAR(50) NOT NULL PRIMARY KEY,
	TramXeID VARCHAR(50),
	LoaiXe NVARCHAR(50),
	TrangThaiXe NVARCHAR(20)
);
GO

-- Tạo bảng DatXe (có chỉnh sửa theo yêu cầu)
CREATE TABLE DatXe (
	DatXeID VARCHAR(50) NOT NULL PRIMARY KEY,
	UserID VARCHAR(50),
	XeID VARCHAR(50),
	Ngay DATE,  
	ThoiGianBatDau TIME(0),  
	ThoiGianKetThuc TIME(0), 
	ThoiGianChoThue TIME(0),  
	TrangThai NVARCHAR(20),
	ChiPhi INT
);
GO

-- Tạo bảng ThanhToan
CREATE TABLE ThanhToan (
	ThanhToanID VARCHAR(50) NOT NULL PRIMARY KEY,
	DatXeID VARCHAR(50),
	SoTienThanhToan INT
);
GO

-- Thêm dữ liệu vào bảng TaiKhoan (tạo trước để có thể tham chiếu)
INSERT INTO TaiKhoan (TKID, MatKhau, VaiTro, Sdt, SoDu) VALUES 
(N'TK001', N'$2b$10$abcd1234', N'Khách hàng', N'0901234567', 250000),
(N'TK002', N'$2b$10$efgh5678', N'Khách hàng', N'0912345678', 180000),
(N'TK003', N'$2b$10$ijkl9012', N'Khách hàng', N'0923456789', 320000),
(N'TK004', N'$2b$10$mnop3456', N'Khách hàng', N'0934567890', 0),
(N'TK005', N'$2b$10$qrst7890', N'Khách hàng', N'0945678901', 150000),
(N'TK006', N'$2b$10$uvwx1234', N'Quản lý', N'0956789012', 1500000),
(N'TK007', N'$2b$10$yzab5678', N'Khách hàng', N'0967890123', 450000),
(N'TK008', N'$2b$10$cdef9012', N'Khách hàng', N'0978901234', 75000),
(N'TK009', N'$2b$10$ghij3456', N'Khách hàng', N'0989012345', 0),
(N'TK010', N'$2b$10$klmn7890', N'Khách hàng', N'0990123456', 280000),
(N'TK011', N'$2b$10$opqr1234', N'Khách hàng', N'0901234568', 120000),
(N'TK012', N'$2b$10$stuv5678', N'Quản lý', N'0912345679', 2000000),
(N'TK013', N'$2b$10$wxyz9012', N'Khách hàng', N'0923456780', 350000),
(N'TK014', N'$2b$10$abcd3456', N'Khách hàng', N'0934567891', 95000),
(N'TK015', N'$2b$10$efgh7890', N'Khách hàng', N'0945678902', 200000),
(N'TK016', N'$2b$10$ijkl1234', N'Quản lý', N'0956789013', 500000),
(N'TK017', N'$2b$10$mnop5678', N'Khách hàng', N'0967890124', 85000),
(N'TK018', N'$2b$10$qrst9012', N'Khách hàng', N'0978901235', 680000),
(N'TK019', N'$2b$10$uvwx3456', N'Khách hàng', N'0989012346', 410000),
(N'TK020', N'$2b$10$yzab7890', N'Khách hàng', N'0990123457', 160000);
GO

-- Thêm dữ liệu vào bảng NguoiDung
INSERT INTO NguoiDung (UserID, TKID, HoTen, Email) VALUES 
(N'U001', N'TK001', N'Nguyễn Văn Minh', N'minh.nguyen@email.com'),
(N'U002', N'TK002', N'Trần Thị Hương', N'huong.tran@gmail.com'),
(N'U003', N'TK003', N'Lê Hoàng Phúc', N'phuc.le@yahoo.com'),
(N'U004', N'TK004', N'Phạm Thị Mai', N'mai.pham@outlook.com'),
(N'U005', N'TK005', N'Hoàng Văn Đức', N'duc.hoang@email.com'),
(N'U007', N'TK007', N'Ngô Thị Lan', N'lan.ngo@gmail.com'),
(N'U008', N'TK008', N'Vũ Văn Hải', N'hai.vu@yahoo.com'),
(N'U009', N'TK009', N'Đỗ Thị Thảo', N'thao.do@outlook.com'),
(N'U010', N'TK010', N'Bùi Văn Tùng', N'tung.bui@email.com'),
(N'U011', N'TK011', N'Lý Thị Kim', N'kim.ly@gmail.com'),
(N'U013', N'TK013', N'Trương Văn Khoa', N'khoa.truong@yahoo.com'),
(N'U014', N'TK014', N'Phan Thị Linh', N'linh.phan@outlook.com'),
(N'U015', N'TK015', N'Đinh Văn Nam', N'nam.dinh@email.com'),
(N'U017', N'TK017', N'Võ Thị Oanh', N'oanh.vo@gmail.com'),
(N'U018', N'TK018', N'Dương Văn Quân', N'quan.duong@yahoo.com'),
(N'U019', N'TK019', N'Tạ Thị Nhung', N'nhung.ta@outlook.com'),
(N'U020', N'TK020', N'Lưu Văn Sơn', N'son.luu@email.com');
GO

-- Thêm dữ liệu vào bảng QuanLy
INSERT INTO QuanLy (QLID, TKID, HoTen, Email) VALUES 
(N'QL001', N'TK006', N'Nguyễn Thị Hạnh', N'hanh.nguyen@bikerental.com'),
(N'QL002', N'TK012', N'Trần Văn Cường', N'cuong.tran@bikerental.com'),
(N'QL003', N'TK016', N'Lê Thị Nga', N'nga.le@bikerental.com');
GO

-- Thêm dữ liệu vào bảng TramXe (các địa điểm thực tế ở Hà Nội)
INSERT INTO TramXe (TramXeID, TenTram, DiaChi, TongChoDo, SoXeKhaDung, SoChoTrong) VALUES 
(N'T001', N'Trạm Hồ Gươm', N'Số 12 Lê Thái Tổ, Hoàn Kiếm, Hà Nội', 25, 18, 7),
(N'T002', N'Trạm Bách Khoa', N'Số 1 Đại Cồ Việt, Hai Bà Trưng, Hà Nội', 30, 22, 8),
(N'T003', N'Trạm Times City', N'458 Minh Khai, Hai Bà Trưng, Hà Nội', 35, 28, 7),
(N'T004', N'Trạm Keangnam', N'Phạm Hùng, Nam Từ Liêm, Hà Nội', 20, 14, 6),
(N'T005', N'Trạm Vincom Bà Triệu', N'191 Bà Triệu, Hai Bà Trưng, Hà Nội', 15, 9, 6),
(N'T006', N'Trạm Hồ Tây', N'Thanh Niên, Ba Đình, Hà Nội', 40, 35, 5),
(N'T007', N'Trạm Lotte Center', N'54 Liễu Giai, Ba Đình, Hà Nội', 25, 19, 6),
(N'T008', N'Trạm Vincom Mega Mall', N'Tầng B1, Royal City, Thanh Xuân, Hà Nội', 30, 24, 6),
(N'T009', N'Trạm Aeon Mall', N'27 Cổ Linh, Long Biên, Hà Nội', 35, 30, 5),
(N'T010', N'Trạm Big C Thăng Long', N'222 Trần Duy Hưng, Cầu Giấy, Hà Nội', 20, 15, 5),
(N'T011', N'Trạm Công viên Thống Nhất', N'115 Trần Quý Cáp, Đống Đa, Hà Nội', 18, 12, 6),
(N'T012', N'Trạm Vincom Center', N'Ba Tháng Hai, Hai Bà Trưng, Hà Nội', 25, 20, 5),
(N'T013', N'Trạm Sân bay Nội Bài', N'Terminal T1, Nội Bài, Sóc Sơn, Hà Nội', 50, 42, 8),
(N'T014', N'Trạm Ga Hà Nội', N'120 Lê Duẩn, Hoàn Kiếm, Hà Nội', 30, 26, 4),
(N'T015', N'Trạm Đại học Quốc gia', N'144 Xuân Thủy, Cầu Giấy, Hà Nội', 22, 16, 6),
(N'T016', N'Trạm Hồ Thiền Quang', N'Hai Bà Trưng, Hà Nội', 12, 8, 4),
(N'T017', N'Trạm Indochina Plaza', N'241 Xuân Thủy, Cầu Giấy, Hà Nội', 18, 11, 7),
(N'T018', N'Trạm Vinpearl Aquarium', N'Times City, Hai Bà Trưng, Hà Nội', 16, 12, 4),
(N'T019', N'Trạm Lăng Chủ tịch Hồ Chí Minh', N'2 Hùng Vương, Ba Đình, Hà Nội', 15, 10, 5),
(N'T020', N'Trạm Chợ Đồng Xuân', N'Đồng Xuân, Hoàn Kiếm, Hà Nội', 20, 14, 6);
GO

-- Thêm dữ liệu vào bảng XeDap
INSERT INTO XeDap (XeID, TramXeID, LoaiXe, TrangThaiXe) VALUES 
(N'X001', N'T001', N'Xe đạp', N'Trống'),
(N'X002', N'T001', N'Xe đạp điện', N'Trống'),
(N'X003', N'T002', N'Xe đạp thể thao', N'Trống'),
(N'X004', N'T002', N'Xe đạp', N'Trống'),
(N'X005', N'T003', N'Xe đạp điện', N'Trống'),
(N'X006', N'T003', N'Xe đạp', N'Trống'),
(N'X007', N'T004', N'Xe đạp thể thao', N'Trống'),
(N'X008', N'T004', N'Xe đạp', N'Đang sử dụng'),
(N'X009', N'T005', N'Xe đạp điện', N'Trống'),
(N'X010', N'T005', N'Xe đạp', N'Trống'),
(N'X011', N'T006', N'Xe đạp thể thao', N'Trống'),
(N'X012', N'T006', N'Xe đạp điện', N'Trống'),
(N'X013', N'T007', N'Xe đạp', N'Trống'),
(N'X014', N'T007', N'Xe đạp điện', N'Trống'),
(N'X015', N'T008', N'Xe đạp', N'Trống'),
(N'X016', N'T008', N'Xe đạp thể thao', N'Trống'),
(N'X017', N'T009', N'Xe đạp điện', N'Trống'),
(N'X018', N'T009', N'Xe đạp', N'Đang sử dụng'),
(N'X019', N'T010', N'Xe đạp thể thao', N'Trống'),
(N'X020', N'T010', N'Xe đạp', N'Trống'),
(N'X021', N'T011', N'Xe đạp điện', N'Trống'),
(N'X022', N'T011', N'Xe đạp', N'Trống'),
(N'X023', N'T012', N'Xe đạp thể thao', N'Trống'),
(N'X024', N'T012', N'Xe đạp điện', N'Trống'),
(N'X025', N'T013', N'Xe đạp', N'Trống'),
(N'X026', N'T013', N'Xe đạp điện', N'Trống'),
(N'X027', N'T014', N'Xe đạp', N'Trống'),
(N'X028', N'T014', N'Xe đạp thể thao', N'Trống'),
(N'X029', N'T015', N'Xe đạp điện', N'Trống'),
(N'X030', N'T015', N'Xe đạp', N'Trống');
GO

-- Thêm dữ liệu vào bảng DatXe (dữ liệu từ 6 tháng gần đây)
INSERT INTO DatXe (DatXeID, UserID, XeID, Ngay, ThoiGianBatDau, ThoiGianKetThuc, ThoiGianChoThue, TrangThai, ChiPhi) VALUES 
(N'D001', N'U001', N'X001', '2024-12-15', '08:30:00', '10:15:00', '01:45:00', N'Hoàn thành', 35000),
(N'D002', N'U002', N'X005', '2024-12-16', '14:00:00', '16:30:00', '02:30:00', N'Hoàn thành', 50000),
(N'D003', N'U003', N'X003', '2024-12-17', '09:15:00', '11:00:00', '01:45:00', N'Đã hủy', 0),
(N'D004', N'U004', N'X007', '2024-12-18', '16:30:00', '18:45:00', '02:15:00', N'Hoàn thành', 45000),
(N'D005', N'U005', N'X009', '2024-12-19', '10:00:00', '13:30:00', '03:30:00', N'Hoàn thành', 70000),
(N'D006', N'U007', N'X011', '2024-12-20', '07:45:00', '09:30:00', '01:45:00', N'Hoàn thành', 35000),
(N'D007', N'U008', N'X014', '2024-12-21', '15:15:00', '17:00:00', '01:45:00', N'Hoàn thành', 40000),
(N'D008', N'U010', N'X016', '2024-12-22', '11:30:00', '14:15:00', '02:45:00', N'Hoàn thành', 55000),
(N'D009', N'U011', N'X017', '2024-12-23', '08:00:00', '12:00:00', '04:00:00', N'Hoàn thành', 80000),
(N'D010', N'U013', N'X019', '2024-12-24', '13:45:00', '15:30:00', '01:45:00', N'Hoàn thành', 35000),
(N'D011', N'U014', N'X021', '2024-12-25', '09:30:00', '11:15:00', '01:45:00', N'Hoàn thành', 40000),
(N'D012', N'U015', N'X023', '2024-12-26', '16:00:00', '18:30:00', '02:30:00', N'Hoàn thành', 50000),
(N'D013', N'U017', N'X025', '2024-12-27', '10:15:00', '12:45:00', '02:30:00', N'Hoàn thành', 50000),
(N'D014', N'U018', N'X027', '2024-12-28', '14:30:00', '16:00:00', '01:30:00', N'Hoàn thành', 30000),
(N'D015', N'U019', N'X029', '2024-12-29', '08:45:00', '11:15:00', '02:30:00', N'Hoàn thành', 55000),
(N'D016', N'U001', N'X002', '2025-01-02', '09:00:00', '11:30:00', '02:30:00', N'Hoàn thành', 55000),
(N'D017', N'U003', N'X006', '2025-01-03', '15:30:00', '17:45:00', '02:15:00', N'Hoàn thành', 45000),
(N'D018', N'U005', N'X012', '2025-01-04', '11:15:00', '13:00:00', '01:45:00', N'Hoàn thành', 40000),
(N'D019', N'U008', N'X008', '2025-01-05', '08:30:00', '12:30:00', '04:00:00', N'Đã hủy', 0),
(N'D020', N'U010', N'X018', '2025-01-06', '14:00:00', '18:00:00', '04:00:00', N'Đã hủy', 0);
GO

-- Thêm dữ liệu vào bảng ThanhToan
INSERT INTO ThanhToan (ThanhToanID, DatXeID, SoTienThanhToan) VALUES 
(N'TT001', N'D001', 35000),
(N'TT002', N'D002', 50000),
(N'TT003', N'D004', 45000),
(N'TT004', N'D005', 70000),
(N'TT005', N'D006', 35000),
(N'TT006', N'D007', 40000),
(N'TT007', N'D008', 55000),
(N'TT008', N'D009', 80000),
(N'TT009', N'D010', 35000),
(N'TT010', N'D011', 40000),
(N'TT011', N'D012', 50000),
(N'TT012', N'D013', 50000),
(N'TT013', N'D014', 30000),
(N'TT014', N'D015', 55000),
(N'TT015', N'D016', 55000),
(N'TT016', N'D017', 45000),
(N'TT017', N'D018', 40000);
GO


-- Thêm các ràng buộc khóa ngoại (foreign key)
ALTER TABLE DatXe
ADD CONSTRAINT FK_DatXe_NguoiDung
FOREIGN KEY (UserID) REFERENCES NguoiDung(UserID);
GO

ALTER TABLE DatXe
ADD CONSTRAINT FK_DatXe_XeDap
FOREIGN KEY (XeID) REFERENCES XeDap(XeID);
GO

ALTER TABLE NguoiDung
ADD CONSTRAINT FK_NguoiDung_TaiKhoan
FOREIGN KEY (TKID) REFERENCES TaiKhoan(TKID);
GO

ALTER TABLE QuanLy
ADD CONSTRAINT FK_QuanLy_TaiKhoan
FOREIGN KEY (TKID) REFERENCES TaiKhoan(TKID);
GO

ALTER TABLE ThanhToan
ADD CONSTRAINT FK_ThanhToan_DatXe
FOREIGN KEY (DatXeID) REFERENCES DatXe(DatXeID);
GO

ALTER TABLE XeDap
ADD CONSTRAINT FK_XeDap_TramXe
FOREIGN KEY (TramXeID) REFERENCES TramXe(TramXeID);
GO
