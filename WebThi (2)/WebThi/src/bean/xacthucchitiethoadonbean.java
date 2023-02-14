package bean;

public class xacthucchitiethoadonbean {
	private long MaChiTietHD;
	private long MaHoaDon;
	private long MaKH;
	private String TenDongHo;
	private int SoLuongMua;
	private int Gia;
	private int ThanhTien;
	private boolean DaMua;
	public xacthucchitiethoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public xacthucchitiethoadonbean(long maChiTietHD, long maHoaDon, long maKH, String tenDongHo, int soLuongMua,
			int gia, int thanhTien, boolean daMua) {
		super();
		MaChiTietHD = maChiTietHD;
		MaHoaDon = maHoaDon;
		MaKH = maKH;
		TenDongHo = tenDongHo;
		SoLuongMua = soLuongMua;
		Gia = gia;
		ThanhTien = thanhTien;
		DaMua = daMua;
	}
	public long getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(long maChiTietHD) {
		MaChiTietHD = maChiTietHD;
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
	public int getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(int thanhTien) {
		ThanhTien = thanhTien;
	}
	public boolean isDaMua() {
		return DaMua;
	}
	public void setDaMua(boolean daMua) {
		DaMua = daMua;
	}
}
