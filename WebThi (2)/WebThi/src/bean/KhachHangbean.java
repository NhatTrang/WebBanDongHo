package bean;

public class KhachHangbean {
	private long makh;
	private String hoten;
	private String sodienthoai;
	private String email;
	private String tendn;
	private String pass;
	private String diachi;
	public KhachHangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHangbean(long makh, String hoten, String sodienthoai, String email, String tendn, String pass,
			String diachi) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.sodienthoai = sodienthoai;
		this.email = email;
		this.tendn = tendn;
		this.pass = pass;
		this.diachi = diachi;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTendn() {
		return tendn;
	}
	public void setTendn(String tendn) {
		this.tendn = tendn;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
}
