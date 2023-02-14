package bean;

public class giohangbean {
	private String Anh;
	private String MaDongHo;
	private String TenDongHo;
	private int Gia;
	private int SoLuong;
	private int ThanhTien;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String anh, String maDongHo, String tenDongHo, int gia, int soLuong, int thanhTien) {
		super();
		Anh = anh;
		MaDongHo = maDongHo;
		TenDongHo = tenDongHo;
		Gia = gia;
		SoLuong = soLuong;
		ThanhTien = gia*soLuong;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public String getMaDongHo() {
		return MaDongHo;
	}
	public void setMaDongHo(String maDongHo) {
		MaDongHo = maDongHo;
	}
	public String getTenDongHo() {
		return TenDongHo;
	}
	public void setTenDongHo(String tenDongHo) {
		TenDongHo = tenDongHo;
	}
	public int getGia() {
		return Gia;
	}
	public void setGia(int gia) {
		Gia = gia;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public int getThanhTien() {
		return SoLuong*Gia;
	}
	public void setThanhTien(int thanhTien, int gia) {
		ThanhTien = thanhTien*gia;
	}
	
}
