package bean;

import java.util.Date;

public class hoadonbean {
	private long MaHoaDon;
	private long MaKH;
	private Date NgayMua;
	private int DaMua;
	public hoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hoadonbean(long maHoaDon, long maKH, Date ngayMua, int daMua) {
		super();
		MaHoaDon = maHoaDon;
		MaKH = maKH;
		NgayMua = ngayMua;
		DaMua = daMua;
	}
	public long getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(long maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public long getMaKH() {
		return MaKH;
	}
	public void setMaKH(long maKH) {
		MaKH = maKH;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public int getDaMua() {
		return DaMua;
	}
	public void setDaMua(int daMua) {
		DaMua = daMua;
	}
}
