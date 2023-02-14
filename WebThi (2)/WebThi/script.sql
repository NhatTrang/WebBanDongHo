USE [master]
GO
/****** Object:  Database [QLDongHo]    Script Date: 21/12/2022 11:25:03 SA ******/
CREATE DATABASE [QLDongHo]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLDongHo', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\QLDongHo.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QLDongHo_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\QLDongHo_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QLDongHo] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLDongHo].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLDongHo] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLDongHo] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLDongHo] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLDongHo] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLDongHo] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLDongHo] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLDongHo] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLDongHo] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLDongHo] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLDongHo] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLDongHo] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLDongHo] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLDongHo] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLDongHo] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLDongHo] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLDongHo] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLDongHo] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLDongHo] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLDongHo] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLDongHo] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLDongHo] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLDongHo] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLDongHo] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLDongHo] SET  MULTI_USER 
GO
ALTER DATABASE [QLDongHo] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLDongHo] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLDongHo] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLDongHo] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [QLDongHo] SET DELAYED_DURABILITY = DISABLED 
GO
USE [QLDongHo]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 21/12/2022 11:25:03 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[TenDangNhap] [nvarchar](50) NOT NULL,
	[MatKhau] [nvarchar](50) NOT NULL,
	[Quyen] [bit] NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 21/12/2022 11:25:03 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaChiTietHoaDon] [bigint] IDENTITY(1,1) NOT NULL,
	[MaHoaDon] [bigint] NOT NULL,
	[SoLuongMua] [int] NOT NULL,
	[MaDongHo] [nvarchar](50) NOT NULL,
	[DaMua] [bit] NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[MaChiTietHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DongHo]    Script Date: 21/12/2022 11:25:03 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DongHo](
	[MaDongHo] [nvarchar](50) NOT NULL,
	[MaLoai] [nvarchar](50) NULL,
	[TenDongHo] [nvarchar](50) NULL,
	[SoLuong] [bigint] NULL,
	[Gia] [bigint] NULL,
	[Anh] [nvarchar](50) NULL,
	[NgayNhap] [datetime] NULL,
 CONSTRAINT [PK_DongHo] PRIMARY KEY CLUSTERED 
(
	[MaDongHo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 21/12/2022 11:25:03 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [bigint] IDENTITY(1,1) NOT NULL,
	[MaKH] [bigint] NULL,
	[NgayMua] [datetime] NOT NULL,
	[DaMua] [bit] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 21/12/2022 11:25:03 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [bigint] IDENTITY(1,1) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[Sodth] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[Tendn] [nvarchar](50) NULL,
	[Pass] [nvarchar](50) NULL,
	[diachi] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Loai]    Script Date: 21/12/2022 11:25:03 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Loai](
	[MaLoai] [nvarchar](50) NOT NULL,
	[TenLoai] [nvarchar](50) NULL,
 CONSTRAINT [PK_Loai] PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  View [dbo].[LichSuMua]    Script Date: 21/12/2022 11:25:03 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[LichSuMua]
AS
SELECT        dbo.DongHo.TenDongHo, dbo.ChiTietHoaDon.SoLuongMua, dbo.DongHo.Gia, dbo.HoaDon.NgayMua, dbo.HoaDon.DaMua, dbo.KhachHang.MaKH, dbo.ChiTietHoaDon.SoLuongMua * dbo.DongHo.Gia AS ThanhTien
FROM            dbo.ChiTietHoaDon INNER JOIN
                         dbo.DongHo ON dbo.ChiTietHoaDon.MaDongHo = dbo.DongHo.MaDongHo INNER JOIN
                         dbo.HoaDon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.HoaDon.MaHoaDon INNER JOIN
                         dbo.KhachHang ON dbo.HoaDon.MaKH = dbo.KhachHang.MaKH

GO
/****** Object:  View [dbo].[XacThuChiTietHoaDon]    Script Date: 21/12/2022 11:25:03 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[XacThuChiTietHoaDon]
AS
SELECT        dbo.ChiTietHoaDon.MaChiTietHoaDon, dbo.HoaDon.MaHoaDon, dbo.HoaDon.MaKH, dbo.DongHo.TenDongHo, dbo.ChiTietHoaDon.SoLuongMua, dbo.DongHo.Gia, 
                         dbo.ChiTietHoaDon.SoLuongMua * dbo.DongHo.Gia AS ThanhTien, dbo.ChiTietHoaDon.DaMua
FROM            dbo.ChiTietHoaDon INNER JOIN
                         dbo.HoaDon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.HoaDon.MaHoaDon INNER JOIN
                         dbo.DongHo ON dbo.ChiTietHoaDon.MaDongHo = dbo.DongHo.MaDongHo
WHERE        (dbo.ChiTietHoaDon.DaMua = 0)

GO
INSERT [dbo].[Admin] ([TenDangNhap], [MatKhau], [Quyen]) VALUES (N'BinhAn', N'345', 1)
INSERT [dbo].[Admin] ([TenDangNhap], [MatKhau], [Quyen]) VALUES (N'DiemMy', N'123', 0)
INSERT [dbo].[Admin] ([TenDangNhap], [MatKhau], [Quyen]) VALUES (N'HaiAnh', N'123', 1)
INSERT [dbo].[Admin] ([TenDangNhap], [MatKhau], [Quyen]) VALUES (N'VanTung', N'345', 1)
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] ON 

INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHoaDon], [MaHoaDon], [SoLuongMua], [MaDongHo], [DaMua]) VALUES (2, 6, 2, N'c6', 1)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHoaDon], [MaHoaDon], [SoLuongMua], [MaDongHo], [DaMua]) VALUES (3, 6, 1, N'c4', 1)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHoaDon], [MaHoaDon], [SoLuongMua], [MaDongHo], [DaMua]) VALUES (4, 7, 1, N'a3', 1)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHoaDon], [MaHoaDon], [SoLuongMua], [MaDongHo], [DaMua]) VALUES (5, 7, 2, N'c10', 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHoaDon], [MaHoaDon], [SoLuongMua], [MaDongHo], [DaMua]) VALUES (6, 12, 3, N'c3', 1)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHoaDon], [MaHoaDon], [SoLuongMua], [MaDongHo], [DaMua]) VALUES (7, 12, 1, N'c12', 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHoaDon], [MaHoaDon], [SoLuongMua], [MaDongHo], [DaMua]) VALUES (8, 14, 3, N'b5', 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHoaDon], [MaHoaDon], [SoLuongMua], [MaDongHo], [DaMua]) VALUES (9, 14, 2, N'a2', 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHoaDon], [MaHoaDon], [SoLuongMua], [MaDongHo], [DaMua]) VALUES (10, 15, 1, N'b2', 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHoaDon], [MaHoaDon], [SoLuongMua], [MaDongHo], [DaMua]) VALUES (11, 15, 1, N'a3', 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHoaDon], [MaHoaDon], [SoLuongMua], [MaDongHo], [DaMua]) VALUES (12, 16, 1, N'c8', 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHoaDon], [MaHoaDon], [SoLuongMua], [MaDongHo], [DaMua]) VALUES (13, 17, 1, N'b1', 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHoaDon], [MaHoaDon], [SoLuongMua], [MaDongHo], [DaMua]) VALUES (14, 17, 1, N'b7', 0)
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] OFF
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'a1', N'Sản Phẩm Nổi Bật', N'BULOVA MARINE STAR DIAMOND WATCH 32 MM', 10, 12530000, N'imageThi/dongho1.jpg', CAST(N'2022-12-08 14:19:59.717' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'a2', N'Sản Phẩm Nổi Bật', N' OMEGA SEAMASTER 39MM', 5, 14000000, N'imageThi/dongho2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'a3', N'Sản Phẩm Nổi Bật', N'BIG BANG MXM18 SANG BLEU 39', 5, 739370000, N'imageThi/dongho10.jpg', CAST(N'2022-12-08 14:19:59.717' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'b1', N'Đồng Hồ Nam', N'Đồng hồ nam chính hãng Lobinni No.9010-8', 15, 5280000, N'imageThi/dongho3.jpg', CAST(N'2018-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'b2', N'Đồng Hồ Nữ', N'Đồng hồ nam chính hãng Teintop T7015-1', 3, 1250000, N'imageThi/dongho18.jpg', CAST(N'2018-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'b3', N'Đồng Hồ Nam', N'Đồng hồ nam chính hãng Lobinni No.5016', 12, 6750000, N'imageThi/dongho5.jpg', CAST(N'2022-12-08 14:19:59.927' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'b4', N'Đồng Hồ Nam', N'Đồng hồ nam chính hãng LORBERN IBV6022-1', 3, 3350000, N'imageThi/dongho6.jpg', CAST(N'2021-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'b5', N'Đồng Hồ Nữ', N'Đồng hồ Chanel', 2, 4450000, N'imageThi/dongho23.jpg', CAST(N'2021-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'b6', N'Đồng Hồ Nam', N'Đồng hồ nam chính hãng LOBINNI L9010-3', 5, 5280000, N'imageThi/dongho14.jpg', CAST(N'2018-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'b7', N'Đồng Hồ Nữ', N'Đồng hồ Dior phiên bản giới hạn', 10, 6450000, N'imageThi/dongho20.jpg', CAST(N'2022-12-08 14:19:59.927' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'b8', N'Đồng Hồ Nam', N'VERSACE VANITAS ROSE GOLD WATCH 40MM', 20, 2280000, N'imageThi/dongho16.jpg', CAST(N'2022-12-08 14:19:59.927' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'c1', N'Đồng Hồ Nữ', N'Đồng hồ thanh lịch quý phái', 20, 2280000, N'imageThi/dongho8.jpg', CAST(N'2022-12-08 14:19:59.927' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'c10', N'Đồng Hồ Nữ', N'Đồng hồ Chanel phiên bản giới hạn', 2, 159999000, N'imageThi/dongho21.jpg', CAST(N'2021-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'c11', N'Đồng Hồ Nữ', N'Đồng hồ nữ phiên bản đặc biệt', 15, 125000000, N'imageThi/dongho22.jpg', CAST(N'2021-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'c12', N'Đồng Hồ Nam', N'BULOVA CORPORATION AUTOMATIC MEN’S WATCH 49MM', 13, 12000000, N'imageThi/dongho7.jpg', CAST(N'2021-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'c2', N'Đồng Hồ Nữ', N'OMEGA DE VILLE PRESTIGE WATCH 39.5MM', 4, 11900000, N'imageThi/dongho9.jpg', CAST(N'2022-12-08 14:19:59.927' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'c3', N'Đồng Hồ Nữ', N'CARTIER W6920071 BALLON BLEU DE CERTIER WATCH 33MM', 5, 156980000, N'imageThi/dongho11.jpg', CAST(N'2021-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'c4', N'Đồng Hồ Nữ', N'Đồng hồ nữ xinh đẹp', 2, 38100000, N'imageThi/dongho12.jpg', CAST(N'2021-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'c5', N'Đồng Hồ Nữ', N'CARTIER W6920071 BALLON BLEU DE CERTIER WATCH 33MM', 15, 12530000, N'imageThi/dongho13.jpg', CAST(N'2021-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'c6', N'Đồng Hồ Nữ', N'Đồng hồ Dior', 2, 156980000, N'imageThi/dongho17.jpg', CAST(N'2021-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'c7', N'Đồng Hồ Nam', N'LOBINNI Ref.1023-8 (Phiên bản đặc biệt Limited)', 15, 11900000, N'imageThi/dongho4.jpg', CAST(N'2021-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'c8', N'Đồng Hồ Nữ', N'Đồng hồ nữ đẹp chất lượng', 20, 11090000, N'imageThi/dongho19.jpg', CAST(N'2021-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'c9', N'Đồng Hồ Nam', N'Đồng hồ nam chính hãng Dior No.9010-8', 2, 135304000, N'imageThi/dongho15.jpg', CAST(N'2021-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'd1', N'Sản phẩm sale', N'Đồng hồ nữ da tốt', 3, 154000000, N'imageThi/dongho24.jpg', CAST(N'2021-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'd2', N'Sản phẩm sale', N'VERSACE VANITAS ROSE GOLD WATCH 30MM', 5, 12000000, N'imageThi/dongho25.jpg', CAST(N'2021-09-15 19:25:58.897' AS DateTime))
INSERT [dbo].[DongHo] ([MaDongHo], [MaLoai], [TenDongHo], [SoLuong], [Gia], [Anh], [NgayNhap]) VALUES (N'd3', N'tinh yeu', N'DONG HO CHAU A', 5, 10000, N'files/dongho29.jpg', CAST(N'2022-12-19 17:54:15.573' AS DateTime))
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKH], [NgayMua], [DaMua]) VALUES (6, 6, CAST(N'2022-12-16 16:25:10.677' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKH], [NgayMua], [DaMua]) VALUES (7, 1, CAST(N'2022-12-16 17:25:51.823' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKH], [NgayMua], [DaMua]) VALUES (12, 7, CAST(N'2022-12-16 17:47:03.970' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKH], [NgayMua], [DaMua]) VALUES (13, 7, CAST(N'2022-12-16 17:54:36.400' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKH], [NgayMua], [DaMua]) VALUES (14, 2, CAST(N'2022-12-20 17:13:10.280' AS DateTime), 0)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKH], [NgayMua], [DaMua]) VALUES (15, 8, CAST(N'2022-12-21 00:06:36.550' AS DateTime), 0)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKH], [NgayMua], [DaMua]) VALUES (16, 2, CAST(N'2022-12-21 08:39:58.740' AS DateTime), 0)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKH], [NgayMua], [DaMua]) VALUES (17, 1, CAST(N'2022-12-21 11:21:33.147' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [Sodth], [Email], [Tendn], [Pass], [diachi]) VALUES (1, N'Nhat Trang', N'0913004163', N'trang@gmail.com', N'trang', N'202cb962ac59075b964b07152d234b70', N'7/14/An Dương Vương')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [Sodth], [Email], [Tendn], [Pass], [diachi]) VALUES (2, N'No ne', N'0326565344', N'no@gmail.com', N'no', N'd81f9c1be2e08964bf9f24b15f0e4900', N'8/24/Ngô Đức Kế')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [Sodth], [Email], [Tendn], [Pass], [diachi]) VALUES (6, N'alo', N'0354568796', N'alo@gmail.com', N'alo', N'202cb962ac59075b964b07152d234b70', N'22 An Duong Vuong')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [Sodth], [Email], [Tendn], [Pass], [diachi]) VALUES (7, N'hanne', N'0354568796', N'han@gmail.com', N'han', N'd81f9c1be2e08964bf9f24b15f0e4900', N'An Duong Vuong')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [Sodth], [Email], [Tendn], [Pass], [diachi]) VALUES (8, N'binh', N'0354568796', N'binh@gmail.com', N'binh', N'698d51a19d8a121ce581499d7b701668', N'7 ho dac di')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (N'Dong Ho Chat Luong', N'Dong Ho Chat Luong')
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (N'Đồng Hồ Nam', N'Đồng Hồ Nam')
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (N'Đồng Hồ Nữ', N'Đồng Hồ Nữ')
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (N'Sản Phẩm Nổi Bật', N'Sản Phẩm Nổi Bật')
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (N'Sản phẩm sale', N'Sản phẩm sale')
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (N'tinh yeu', N'yeu yeu')
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_DongHo] FOREIGN KEY([MaDongHo])
REFERENCES [dbo].[DongHo] ([MaDongHo])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_DongHo]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[DongHo]  WITH CHECK ADD  CONSTRAINT [FK_DongHo_Loai] FOREIGN KEY([MaLoai])
REFERENCES [dbo].[Loai] ([MaLoai])
GO
ALTER TABLE [dbo].[DongHo] CHECK CONSTRAINT [FK_DongHo_Loai]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
/****** Object:  StoredProcedure [dbo].[proc_Question_Select]    Script Date: 21/12/2022 11:25:03 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[proc_Question_Select]
			@SearchValue nvarchar(255) = N'',
			@Page int = 1,
			@PageSize int = 10,
			@RowCount int output,
			@PageCount int output 
as
begin
	set nocount on;
	if(@Page < 1)
		set @Page = 1;
	if(@PageSize < 1)
		set @PageSize = 10
	if(@SearchValue <> N'')
		set @SearchValue = '%' + @SearchValue + '%';
	select *,
			row_number() over(order by (Q.MaDongHo)) as RowNumBer
	into #temp
	from DongHo as Q
	where (@SearchValue = N'') or (Q.TenDongHo like @SearchValue)
	set @RowCount = @@ROWCOUNT;
	set @PageCount = @RowCount / @PageSize;
	if( @RowCount % @PageSize > 1)
			set @PageCount = @PageCount + 1;
	select *
	from #temp
	where RowNumBer between (@Page - 1)*@PageSize +1 and @Page*@PageSize 
	order by RowNumBer
end

GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[41] 4[20] 2[15] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "ChiTietHoaDon"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 136
               Right = 225
            End
            DisplayFlags = 280
            TopColumn = 1
         End
         Begin Table = "DongHo"
            Begin Extent = 
               Top = 6
               Left = 263
               Bottom = 136
               Right = 433
            End
            DisplayFlags = 280
            TopColumn = 3
         End
         Begin Table = "HoaDon"
            Begin Extent = 
               Top = 6
               Left = 471
               Bottom = 136
               Right = 641
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "KhachHang"
            Begin Extent = 
               Top = 6
               Left = 679
               Bottom = 136
               Right = 849
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 5490
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'LichSuMua'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N'
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'LichSuMua'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'LichSuMua'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[41] 4[20] 2[9] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "ChiTietHoaDon"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 136
               Right = 225
            End
            DisplayFlags = 280
            TopColumn = 1
         End
         Begin Table = "HoaDon"
            Begin Extent = 
               Top = 6
               Left = 263
               Bottom = 136
               Right = 433
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "DongHo"
            Begin Extent = 
               Top = 6
               Left = 471
               Bottom = 136
               Right = 641
            End
            DisplayFlags = 280
            TopColumn = 3
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 3540
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'XacThuChiTietHoaDon'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'XacThuChiTietHoaDon'
GO
USE [master]
GO
ALTER DATABASE [QLDongHo] SET  READ_WRITE 
GO
