package bean;

public class chitiethoadonbean {
	private int MaCTHD;
	private String MaDongHo;
	private long SoLuongMua;
	private int MaHoaDon;
	private int DaMua;
	public chitiethoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public chitiethoadonbean(int maCTHD, String maDongHo, long soLuongMua, int maHoaDon, int daMua) {
		super();
		MaCTHD = maCTHD;
		MaDongHo = maDongHo;
		SoLuongMua = soLuongMua;
		MaHoaDon = maHoaDon;
		DaMua = daMua;
	}
	public int getMaCTHD() {
		return MaCTHD;
	}
	public void setMaCTHD(int maCTHD) {
		MaCTHD = maCTHD;
	}
	public String getMaDongHo() {
		return MaDongHo;
	}
	public void setMaDongHo(String maDongHo) {
		MaDongHo = maDongHo;
	}
	public long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public int getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public int getDaMua() {
		return DaMua;
	}
	public void setDaMua(int daMua) {
		DaMua = daMua;
	}
}
