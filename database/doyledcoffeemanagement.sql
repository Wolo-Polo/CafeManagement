-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 23, 2021 lúc 06:37 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `doyledcoffeemanagement`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ban`
--

CREATE TABLE `ban` (
  `MaBan` varchar(6) NOT NULL,
  `TenBan` varchar(2) DEFAULT NULL,
  `TinhTrang` varchar(10) NOT NULL,
  `GhiChu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ban`
--

INSERT INTO `ban` (`MaBan`, `TenBan`, `TinhTrang`, `GhiChu`) VALUES
('ban01', '01', 'blank', 'trống'),
('ban02', '02', 'blank', 'trống');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cthoadon`
--

CREATE TABLE `cthoadon` (
  `MaCTHoaDon` int(11) NOT NULL,
  `MaHoaDon` varchar(8) NOT NULL,
  `MaMonAn` varchar(6) NOT NULL,
  `SoLuong` smallint(6) DEFAULT NULL CHECK (`SoLuong` >= 0),
  `DonGia` decimal(10,2) DEFAULT NULL CHECK (`DonGia` >= 0),
  `GhiChu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `cthoadon`
--

INSERT INTO `cthoadon` (`MaCTHoaDon`, `MaHoaDon`, `MaMonAn`, `SoLuong`, `DonGia`, `GhiChu`) VALUES
(1, 'HD01', 'Mon01', 2, '10000.00', 'test nhé'),
(2, 'HD01', 'Mon02', 3, '20000.00', 'đâsdasdasdasd'),
(3, 'HD02', 'Mon01', 5, '10000.00', 'cùng 1 bàn'),
(4, 'HD02', 'Mon02', 1, '20000.00', 'lẻ'),
(5, 'HD02', 'Mon01', 5, '10000.00', 'cùng 1 bàn'),
(6, 'HD02', 'Mon02', 1, '20000.00', 'lẻ'),
(7, 'HD03', 'Mon01', 2, '10000.00', 'gg :V'),
(8, 'HD03', 'Mon02', 1, '20000.00', 'test thôi mà :V'),
(9, 'HD03', 'Mon01', 2, '10000.00', 'ff :V'),
(10, 'HD03', 'Mon02', 1, '20000.00', 'test thôi mà :V'),
(11, 'HD03', 'Mon01', 2, '10000.00', 'ff :V'),
(12, 'HD03', 'Mon02', 8, '20000.00', 'test thôi mà :V'),
(13, 'HD04', 'Mon01', 2, '10000.00', 'ádasdasdasdasdgg :V'),
(14, 'HD04', 'Mon02', 1, '20000.00', '22222sdasdastest thôi mà :V');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHoaDon` varchar(8) NOT NULL,
  `MaBan` varchar(6) DEFAULT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `TongTien` decimal(10,2) DEFAULT NULL CHECK (`TongTien` >= 0),
  `DaThanhToan` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHoaDon`, `MaBan`, `ThoiGian`, `TongTien`, `DaThanhToan`) VALUES
('HD01', 'ban01', '2021-02-18 20:23:18', NULL, 0),
('HD02', 'ban01', '2021-02-18 20:23:18', NULL, 0),
('HD03', 'ban01', '2021-02-18 20:23:18', NULL, 0),
('HD04', 'ban01', '2021-02-18 20:23:18', NULL, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaimon`
--

CREATE TABLE `loaimon` (
  `MaLoaiMon` varchar(5) NOT NULL,
  `TenLoaiMon` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `loaimon`
--

INSERT INTO `loaimon` (`MaLoaiMon`, `TenLoaiMon`) VALUES
('Loai1', 'Món ăn test'),
('Loai2', 'Món ăn test thứ 2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monan`
--

CREATE TABLE `monan` (
  `MaMonAn` varchar(6) NOT NULL,
  `TenMonAn` varchar(255) DEFAULT NULL,
  `HinhAnh` varchar(255) DEFAULT NULL,
  `DonGia` decimal(10,2) DEFAULT NULL CHECK (`DonGia` >= 0),
  `MaLoaiMon` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `monan`
--

INSERT INTO `monan` (`MaMonAn`, `TenMonAn`, `HinhAnh`, `DonGia`, `MaLoaiMon`) VALUES
('Mon01', 'Món ăn này dùng để test', 'dell có', '2043000.00', 'Loai1'),
('Mon02', 'test thứ 2', 'dell có luôn nhé :V', '20000.00', 'Loai1'),
('Mon03', 'test test test', 'dell có để test', '12300.00', 'Loai2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `UserName` varchar(100) NOT NULL,
  `DisplayName` varchar(100) NOT NULL DEFAULT 'DucTien',
  `PassWord` varchar(200) NOT NULL DEFAULT '0',
  `Role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'STAFF' COMMENT 'Nếu có nhiều role, mỗi role cách nhau bởi dấu phẩy (,)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`UserName`, `DisplayName`, `PassWord`, `Role`) VALUES
('test', 'DucTien', '$2a$10$AwcV2isGnMYKza/qS28nY.oei2Tk5wBRqApFhVQjiq406/PXhOBlO', 'ADMIN'),
('test2', 'TruongDzai', '$2a$10$AwcV2isGnMYKza/qS28nY.oei2Tk5wBRqApFhVQjiq406/PXhOBlO', 'STAFF'),
('test3', 'DucTien3', '$2a$10$AwcV2isGnMYKza/qS28nY.oei2Tk5wBRqApFhVQjiq406/PXhOBlO', 'STAFF'),
('testPasswordEndcoder', 'PasswordName', '$2a$10$UB3MHRDlrzE0fKLfP7KxPOG0K7QQaI.H4Uf8UJcP2nwi2l2a9f6QC', 'STAFF');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ban`
--
ALTER TABLE `ban`
  ADD PRIMARY KEY (`MaBan`);

--
-- Chỉ mục cho bảng `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD PRIMARY KEY (`MaCTHoaDon`) USING BTREE,
  ADD KEY `fk_monan` (`MaMonAn`),
  ADD KEY `fk_hoadon` (`MaHoaDon`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHoaDon`),
  ADD KEY `fk_ban` (`MaBan`);

--
-- Chỉ mục cho bảng `loaimon`
--
ALTER TABLE `loaimon`
  ADD PRIMARY KEY (`MaLoaiMon`);

--
-- Chỉ mục cho bảng `monan`
--
ALTER TABLE `monan`
  ADD PRIMARY KEY (`MaMonAn`),
  ADD KEY `fk_loaimon` (`MaLoaiMon`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`UserName`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `cthoadon`
--
ALTER TABLE `cthoadon`
  MODIFY `MaCTHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD CONSTRAINT `fk_hoadon` FOREIGN KEY (`MaHoaDon`) REFERENCES `hoadon` (`MaHoaDon`),
  ADD CONSTRAINT `fk_monan` FOREIGN KEY (`MaMonAn`) REFERENCES `monan` (`MaMonAn`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `fk_ban` FOREIGN KEY (`MaBan`) REFERENCES `ban` (`MaBan`);

--
-- Các ràng buộc cho bảng `monan`
--
ALTER TABLE `monan`
  ADD CONSTRAINT `fk_loaimon` FOREIGN KEY (`MaLoaiMon`) REFERENCES `loaimon` (`MaLoaiMon`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
