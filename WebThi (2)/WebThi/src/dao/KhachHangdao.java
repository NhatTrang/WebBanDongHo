package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.KhachHangbean;

public class KhachHangdao {
	KetNoi kn = new KetNoi();
	public ArrayList<KhachHangbean> getkh(){
		ArrayList<KhachHangbean> ds = new ArrayList<KhachHangbean>();
		try {
			kn.KetNoi();
			String sql = "select*from KhachHang";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				long makh = rs.getLong("MaKH");
				String hoten = rs.getString("HoTen");
				String sodienthoai = rs.getString("Sodth");
				String email = rs.getString("Email");
				String tendn = rs.getString("Tendn");
				String pass = rs.getString("Pass");
				String diachi = rs.getString("diachi");
				ds.add(new KhachHangbean(makh, hoten, sodienthoai, email, tendn, pass, diachi));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public KhachHangbean getdangnhap(String Tendn, String Pass){	
		try {
			KhachHangbean kh = null;
			kn.KetNoi();
			String sql = "select * from KhachHang where Tendn = ? and Pass = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, Tendn);
			cmd.setString(2, Pass);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				long makh = rs.getLong("MaKH");
				String hoten = rs.getString("HoTen");
				String sodienthoai = rs.getString("Sodth");
				String email = rs.getString("Email");
				String diachi = rs.getString("diachi");
				kh = new KhachHangbean(makh, hoten, sodienthoai, email, Tendn, Pass, diachi);
			}
			rs.close();
			kn.cn.close();
			return kh;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean CheckSignIn(String Tendn) throws Exception {
		String sql = "SELECT Tendn FROM KhachHang WHERE Tendn = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, Tendn);
		ResultSet rs = cmd.executeQuery();
		boolean check = rs.next();
		rs.close();
		return check;
	}
	public int getDangKy(String hoten, String sodienthoai, String email, String tendn, String pass,String diachi) throws Exception{
		kn.KetNoi();
		if(CheckSignIn(tendn)==false) {
			String sql = "insert into KhachHang(HoTen,Sodth,Email,Tendn,Pass,diachi) values(?,?,?,?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, hoten);
			cmd.setString(2, sodienthoai);
			cmd.setString(3, email);
			cmd.setString(4, tendn);
			cmd.setString(5, pass);
			cmd.setString(6,diachi);
			int check = cmd.executeUpdate();
			kn.cn.close();
			return check;
		}else return 0;
	}
}
