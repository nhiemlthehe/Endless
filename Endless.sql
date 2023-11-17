﻿-- Tạo CSDL EndlessDB
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