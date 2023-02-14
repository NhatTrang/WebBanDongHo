package bean;

import java.util.*;

public class donghobean {
	private String MaDongHo;
	private String MaLoai;
	private String TenDongHo;
	private int SoLuong;
	private int Gia;
	private String Anh;
	private Date NgayNhap;
	public donghobean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public donghobean(String maDongHo, String maLoai, String tenDongHo, int soLuong, int gia, String anh,
			Date ngayNhap) {
		super();
		MaDongHo = maDongHo;
		MaLoai = maLoai;
		TenDongHo = tenDongHo;
		SoLuong = soLuong;
		Gia = gia;
		Anh = anh;
		NgayNhap = ngayNhap;
	}
	public String getMaDongHo() {
		return MaDongHo;
	}
	public void setMaDongHo(String maDongHo) {
		MaDongHo = maDongHo;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getTenDongHo() {
		return TenDongHo;
	}
	public void setTenDongHo(String tenDongHo) {
		TenDongHo = tenDongHo;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public int getGia() {
		return Gia;
	}
	public void setGia(int gia) {
		Gia = gia;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public Date getNgayNhap() {
		return NgayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}
}
