package bean;

import java.util.Date;

public class lichsumuahangbean {
	private String TenDongHo;
	private int SoLuongMua;
	private int Gia;
	private Date NgayMua;
	private String DaMua;
	private long MaKH;
	private int ThanhTien;
	public lichsumuahangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public lichsumuahangbean(String tenDongHo, int soLuongMua, int gia, Date ngayMua, String daMua, long maKH,
			int thanhTien) {
		super();
		TenDongHo = tenDongHo;
		SoLuongMua = soLuongMua;
		Gia = gia;
		NgayMua = ngayMua;
		DaMua = daMua;
		MaKH = maKH;
		ThanhTien = thanhTien;
	}
	public String getTenDongHo() {
		return TenDongHo;
	}
	public void setTenDongHo(String tenDongHo) {
		TenDongHo = tenDongHo;
	}
	public int getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public int getGia() {
		return Gia;
	}
	public void setGia(int gia) {
		Gia = gia;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public String getDaMua() {
		return DaMua;
	}
	public void setDaMua(String daMua) {
		DaMua = daMua;
	}
	public long getMaKH() {
		return MaKH;
	}
	public void setMaKH(long maKH) {
		MaKH = maKH;
	}
	public int getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(int thanhTien) {
		ThanhTien = thanhTien;
	}
}
