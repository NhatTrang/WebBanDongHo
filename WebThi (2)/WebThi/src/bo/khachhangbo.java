package bo;

import java.util.ArrayList;

import bean.KhachHangbean;
import dao.KhachHangdao;

public class khachhangbo {
	KhachHangdao khd = new KhachHangdao();
	ArrayList<KhachHangbean> ds;
	public ArrayList<KhachHangbean> getkh(){
		ds= khd.getkh();
		return ds;
	}
	public KhachHangbean DangNhap(String tendn, String pass) {
		return khd.getdangnhap(tendn, pass);
	}
	public int DangKy(String hoten, String sodienthoai, String email, String tendn, String pass,String diachi) throws Exception{
		return khd.getDangKy(hoten, sodienthoai, email, tendn, pass, diachi);
	}
}
