package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.hoadonbean;

public class hoadondao {
	KetNoi kn = new KetNoi();
	public int Them(long makh) throws Exception{
		kn.KetNoi();
		String sql = "INSERT INTO hoadon(MaKH, NgayMua, DaMua)  VALUES (?,GETDATE(),?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		cmd.setBoolean(2, false);
		int kq = cmd.executeUpdate();
		kn.cn.close();
		return kq;
	}
	public long getMakh(String un) throws Exception{
		long id = 0;
		kn.KetNoi();
		String sql = "select MaKH from KhachHang where Tendn = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, un);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			id = rs.getLong("MaKH");
		}
		return id;
	}
	public int maxhd() {
		try {
			KetNoi kn= new KetNoi();
			kn.KetNoi();
			String sql="select max(MaHoaDon) as maxhd from HoaDon";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			ResultSet rs= cmd.executeQuery();
			int kq=0;
			if(rs.next())
				kq=rs.getInt("maxhd");
			kn.cn.close();
			return kq;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public ArrayList<hoadonbean> gethD(){
		ArrayList<hoadonbean> ds = new ArrayList<hoadonbean>();
		try {
			kn.KetNoi();
			String sql="select*from HoaDon where DaMua=0";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				long mahoadon = rs.getLong("MaHoaDon");
				int makh = rs.getInt("MaKH");
				Date NgayMua = rs.getDate("NgayMua");
				int damua = rs.getInt("DaMua");
				ds.add(new hoadonbean(mahoadon, makh, NgayMua, damua));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<hoadonbean> getdamua(){
		ArrayList<hoadonbean> ds = new ArrayList<hoadonbean>();
		try {
			kn.KetNoi();
			String sql="select*from HoaDon where DaMua=1";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				long mahoadon = rs.getLong("MaHoaDon");
				int makh = rs.getInt("MaKH");
				Date NgayMua = rs.getDate("NgayMua");
				int damua = rs.getInt("DaMua");
				ds.add(new hoadonbean(mahoadon, makh, NgayMua, damua));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int XacNhan(String MaHoaDon) throws Exception{
		kn.KetNoi();
		String sql="update HoaDon set DaMua=1 where MaHoaDon=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, MaHoaDon);
		int check = cmd.executeUpdate();
		kn.cn.close();
		return check;
	}
}
