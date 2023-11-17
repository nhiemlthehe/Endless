-- Tạo CSDL EndlessDB
CREATE DATABASE EndlessDB;
GO
USE EndlessDB;
GO

-- Tạo bảng LoaiGiay
CREATE TABLE LoaiGiay (
    MaLoaiGiay INT PRIMARY KEY IDENTITY(1,1),
    TenLoaiGiay NVARCHAR(255) NOT NULL,
    Mota NVARCHAR(255)
);
GO

-- Tạo bảng MauSac
CREATE TABLE MauSac (
    MaMauSac INT PRIMARY KEY IDENTITY(1,1),
    TenMauSac NVARCHAR(255) NOT NULL,
    Mota NVARCHAR(255)
);
GO

-- Tạo bảng KichThuoc
CREATE TABLE KichThuoc (
    MaKichThuoc INT PRIMARY KEY IDENTITY(1,1),
    TenKichThuoc NVARCHAR(20) NOT NULL,
    Mota NVARCHAR(255)
);
GO

-- Tạo bảng KhuyenMai
CREATE TABLE KhuyenMai (
    MaKM INT PRIMARY KEY IDENTITY(1,1),
    TenKM NVARCHAR(255) NOT NULL,
    MucGiamGia FLOAT NOT NULL,
    NgayBatDau DATE NOT NULL,
    NgayKetThuc DATE NOT NULL
);
GO

-- Tạo bảng NhanVien
CREATE TABLE NhanVien (
    MaNV INT PRIMARY KEY IDENTITY(1,1),
    TenNV NVARCHAR(255) NOT NULL,
    MaTK VARCHAR(10) UNIQUE NOT NULL,
    MatKhau NVARCHAR(50) NOT NULL,
    NgaySinh DATE NOT NULL,
    SDT NVARCHAR(20) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    DiaChi NVARCHAR(255) NOT NULL,
	Hinh NVARCHAR(50)
);
GO

-- Tạo bảng KhachHang
CREATE TABLE KhachHang (
    MaKH INT PRIMARY KEY IDENTITY(1,1),
    TenKH NVARCHAR(255) NOT NULL,
    SDT NVARCHAR(20) NOT NULL,
    DiaChi NVARCHAR(255)
);
GO

-- Tạo bảng NhaCungCap
CREATE TABLE NhaCungCap (
    MaNCC INT PRIMARY KEY IDENTITY(1,1),
    TenNCC NVARCHAR(255) NOT NULL,
    SDT NVARCHAR(20) NOT NULL,
    Email VARCHAR(50),
    DiaChi NVARCHAR(255) NOT NULL
);
GO

-- Tạo bảng SanPham
CREATE TABLE SanPham (
    MaSP INT PRIMARY KEY IDENTITY(1,1),	
    MaKM INT,
    TenSP NVARCHAR(255) NOT NULL,
    MaLoaiGiay INT NOT NULL,
	MaVach VARCHAR(10) UNIQUE,
    DonGiaNhap DECIMAL(18, 2) NOT NULL,
    DonGiaBan DECIMAL(18, 2) NOT NULL,
	GiaKhuyenMai DECIMAL(18, 2),
	HinhAnh VARCHAR(50),
    FOREIGN KEY (MaKM) REFERENCES KhuyenMai(MaKM),
	FOREIGN KEY (MaLoaiGiay) REFERENCES LoaiGiay(MaLoaiGiay)
);
GO

-- Tạo bảng ChiTietSanPham
CREATE TABLE ChiTietSanPham (
    MaCTSP INT PRIMARY KEY IDENTITY(1,1),
    MaSP INT NOT NULL,
    MaMau INT NOT NULL,
    MaKT INT NOT NULL,
    SoLuong INT NOT NULL,
    Mota NVARCHAR(255),
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP),
    FOREIGN KEY (MaMau) REFERENCES MauSac(MaMauSac),
    FOREIGN KEY (MaKT) REFERENCES KichThuoc(MaKichThuoc)
);
GO

-- Tạo bảng NhapHang
CREATE TABLE NhapHang (
    MaDN INT PRIMARY KEY IDENTITY(1,1),
	MaNCC INT,
    MaSP INT,
    NgayNhap DATE,
    GhiChu NVARCHAR(100),
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP),
	FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC)
);
GO

CREATE TABLE ChiTietNhapHang (
    MaCTDN INT PRIMARY KEY IDENTITY(1,1),
    MaDN INT,
    MaCTSP INT,
    SoLuong INT,
    FOREIGN KEY (MaDN) REFERENCES NhapHang(MaDN),
    FOREIGN KEY (MaCTSP) REFERENCES ChiTietSanPham(MaCTSP)
);
GO

-- Tạo bảng HoaDon
CREATE TABLE HoaDon (
    MaHD INT PRIMARY KEY IDENTITY(1,1),
    MaKH INT,
    MaNV INT,
    NgayBan DATE,
    TongTien FLOAT,
    HTThanhToan NVARCHAR(20),
    TienThanhToan FLOAT,
	TrangThai NVARCHAR(20),	
    FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
);
GO

-- Tạo bảng HoaDonChiTiet
CREATE TABLE HoaDonChiTiet (
    MaHDCT INT PRIMARY KEY IDENTITY(1,1),
    MaHD INT,
    MaCTSP INT,
    SoLuong INT,
    FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
    FOREIGN KEY (MaCTSP) REFERENCES ChiTietSanPham(MaCTSP)
);
GO

-- Tạo bảng DoiHang
CREATE TABLE DoiHang (
    MaPhieuDoi INT PRIMARY KEY IDENTITY(1,1),
    MaHD INT,
    MaNV INT,
    NgayDoi DATE,
    LyDo NVARCHAR(255),
    FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
);
GO

CREATE TABLE ChiTietDoiHang (
	MaCTPD INT PRIMARY KEY IDENTITY(1,1),
	MaPD INT,
	CTBD INT, --Chi tiết ban đầu
	CTCD INT, --Chi tiết cần đổi
	FOREIGN KEY (MaPD) REFERENCES DoiHang(MaPhieuDoi),
	FOREIGN KEY (CTBD) REFERENCES ChiTietSanPham(MaCTSP),
	FOREIGN KEY (CTCD) REFERENCES ChiTietSanPham(MaCTSP)	
)

INSERT INTO LoaiGiay (TenLoaiGiay, Mota)
VALUES 
    ('Giày Sneaker', 'Dành cho hoạt động thể thao'),
    ('Giày Cao Gót', 'Dành cho các sự kiện đặc biệt'),
    ('Giày Bóng Đá', 'Dành cho môn bóng đá'),
    ('Giày Chạy Bộ', 'Phù hợp cho việc tập luyện thể dục'),
    ('Giày Sandal', 'Dành cho mùa hè và đi biển');
GO

INSERT INTO MauSac (TenMauSac, Mota)
VALUES 
    ('Đen', 'Màu cơ bản'),
    ('Trắng', 'Màu trung tính'),
    ('Đỏ', 'Màu nổi bật'),
    ('Xanh Dương', 'Màu tươi sáng'),
    ('Hồng', 'Màu nữ tính');
GO 

INSERT INTO KichThuoc (TenKichThuoc, Mota)
VALUES 
    ('S', 'Kích thước nhỏ'),
    ('M', 'Kích thước trung bình'),
    ('L', 'Kích thước lớn'),
    ('XL', 'Kích thước rất lớn'),
    ('XS', 'Kích thước rất nhỏ');
GO

INSERT INTO KhuyenMai (TenKM, MucGiamGia, NgayBatDau, NgayKetThuc)
VALUES 
    ('Khuyến mãi mùa hè', 0.2, '2023-06-01', '2023-08-31'),
    ('Khuyến mãi cuối năm', 0.15, '2023-11-01', '2023-12-31'),
    ('Khuyến mãi đặc biệt', 0.3, '2023-03-15', '2023-03-31'),
    ('Khuyến mãi Black Friday', 0.25, '2023-11-25', '2023-11-27'),
    ('Khuyến mãi Valentine', 0.1, '2023-02-01', '2023-02-14');
GO

INSERT INTO NhanVien (TenNV, MaTK, MatKhau, NgaySinh, SDT, Email, DiaChi, Hinh)
VALUES 
    ('Nguyen Van A', 'admin', '123', '1990-01-15', '0123456789', 'lytinhnhiem@gmail.com', '123 Đường ABC, Q1, TP.HCM', 'nva.jpg'),
    ('Tran Thi B', 'ttB456', 'matkhau456', '1995-05-20', '0987654321', 'ttb@email.com', '456 Đường XYZ, Q2, TP.HCM', 'ttb.jpg'),
    ('Le Van C', 'lvC789', 'matkhau789', '1988-08-10', '0123456789', 'lvc@email.com', '789 Đường UVW, Q3, TP.HCM', 'lvc.jpg'),
    ('Pham Thi D', 'ptD012', 'matkhau012', '1993-03-25', '0987654321', 'ptd@email.com', '012 Đường DEF, Q4, TP.HCM', 'ptd.jpg'),
    ('Hoang Van E', 'hvE345', 'matkhau345', '1997-07-05', '0123456789', 'hve@email.com', '345 Đường GHI, Q5, TP.HCM', 'hve.jpg');
GO

INSERT INTO KhachHang (TenKH, SDT, DiaChi)
VALUES 
    ('Nguyen Van Khach 1', '0123456789', '123 Đường ABC, Q1, TP.HCM'),
    ('Tran Thi Khach 2', '0987654321', '456 Đường XYZ, Q2, TP.HCM'),
    ('Le Van Khach 3', '0123456789', '789 Đường UVW, Q3, TP.HCM'),
    ('Pham Thi Khach 4', '0987654321', '012 Đường DEF, Q4, TP.HCM'),
    ('Hoang Van Khach 5', '0123456789', '345 Đường GHI, Q5, TP.HCM');
GO

INSERT INTO NhaCungCap (TenNCC, SDT, Email, DiaChi)
VALUES 
    ('NCC 1', '0123456789', 'ncc1@email.com', '123 Đường ABC, Q1, TP.HCM'),
    ('NCC 2', '0987654321', 'ncc2@email.com', '456 Đường XYZ, Q2, TP.HCM'),
    ('NCC 3', '0123456789', 'ncc3@email.com', '789 Đường UVW, Q3, TP.HCM'),
    ('NCC 4', '0987654321', 'ncc4@email.com', '012 Đường DEF, Q4, TP.HCM'),
    ('NCC 5', '0123456789', 'ncc5@email.com', '345 Đường GHI, Q5, TP.HCM');
GO

INSERT INTO SanPham (MaKM, TenSP, MaLoaiGiay, MaVach, DonGiaNhap, DonGiaBan, GiaKhuyenMai, HinhAnh)
VALUES 
    (1, 'Giay Sneaker A', 1, 'SV123', 50.00, 80.00, 70.00, 'sneaker_a.jpg'),
    (2, 'Giay Cao Got B', 2, 'CG456', 70.00, 120.00, NULL, 'cao_got_b.jpg'),
    (3, 'Giay Bong Da C', 3, 'BD789', 40.00, 60.00, 50.00, 'bong_da_c.jpg'),
    (1, 'Giay Chay Bo D', 1, 'CB012', 60.00, 90.00, NULL, 'chay_bo_d.jpg'),
    (2, 'Giay Sandal E', 5, 'SD345', 30.00, 50.00, NULL, 'sandal_e.jpg');
GO

INSERT INTO ChiTietSanPham (MaSP, MaMau, MaKT, SoLuong, Mota)
VALUES 
    (1, 1, 1, 100, 'Size S - Màu Đen'),
    (2, 2, 2, 50, 'Size M - Màu Trắng'),
    (3, 3, 3, 80, 'Size L - Màu Đỏ'),
    (4, 1, 2, 120, 'Size S - Màu Đen'),
    (5, 3, 1, 60, 'Size L - Màu Đỏ');
GO

INSERT INTO NhapHang (MaNCC, MaSP, NgayNhap, GhiChu)
VALUES 
    (1, 1, '2023-11-10', 'Nhập hàng giày Sneaker'),
    (2, 2, '2023-11-11', 'Nhập hàng giày Cao Gót'),
    (3, 3, '2023-11-12', 'Nhập hàng giày Bóng Đá'),
    (4, 4, '2023-11-13', 'Nhập hàng giày Chạy Bộ'),
    (5, 5, '2023-11-14', 'Nhập hàng giày Sandal');
GO

INSERT INTO ChiTietNhapHang (MaDN, MaCTSP, SoLuong)
VALUES 
    (1, 1, 20),
    (2, 2, 15),
    (3, 3, 25),
    (4, 4, 30),
    (5, 5, 10);
GO
INSERT INTO HoaDon (MaKH, MaNV, NgayBan, TongTien, HTThanhToan, TienThanhToan, TrangThai)
VALUES 
    (1, 1, '2023-11-15', 800.00, N'Chuyển khoản', 800.00, N'Đã thanh toán'),
    (2, 2, '2023-11-16', 1500.00, N'Chuyển khoản', 1500.00, N'Chưa thanh toán'),
    (3, 3, '2023-11-17', 1200.00, N'Chuyển khoản', 1200.00, N'Đã thanh toán'),
    (4, 4, '2023-11-18', 1800.00, N'Chuyển khoản', 1800.00, N'Chưa thanh toán'),
    (5, 5, '2023-11-19', 500.00, N'Chuyển khoản', 500.00, N'Đã thanh toán');
go 
-- Thêm dữ liệu vào bảng HoaDonChiTiet
INSERT INTO HoaDonChiTiet (MaHD, MaCTSP, SoLuong)
VALUES 
    (1, 1, 5),
    (1, 2, 10),
    (2, 3, 8),
    (2, 4, 12),
    (3, 5, 15);
GO

-- Thêm dữ liệu vào bảng DoiHang
INSERT INTO DoiHang (MaHD, MaNV, NgayDoi, LyDo)
VALUES 
    (1, 1, '2023-11-20', 'Hàng lỗi'),
    (2, 2, '2023-11-21', 'Đổi size'),
    (3, 3, '2023-11-22', 'Khách không thích'),
    (4, 4, '2023-11-23', 'Không đúng mẫu'),
    (5, 5, '2023-11-24', 'Hỏng hóc');
GO

-- Thêm dữ liệu vào bảng ChiTietDoiHang
INSERT INTO ChiTietDoiHang (MaPD, CTBD, CTCD)
VALUES 
    (1, 1, 2),
    (2, 3, 4),
    (3, 5, 1),
    (4, 2, 3),
    (5, 4, 5);
GO