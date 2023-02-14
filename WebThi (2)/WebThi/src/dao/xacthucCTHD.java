package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.xacthucchitiethoadonbean;

public class xacthucCTHD {
	KetNoi kn = new KetNoi();
	public ArrayList<xacthucchitiethoadonbean> getCTHD(String MaHoaDon){
		ArrayList<xacthucchitiethoadonbean> ds = new ArrayList<xacthucchitiethoadonbean>();
		try {
			kn.KetNoi();
			String sql = "select*from XacThuChiTietHoaDon where MaHoaDon=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, MaHoaDon);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				long maChiTietHD = rs.getLong("MaChiTietHoaDon");
				long maHoaDon = rs.getLong("MaHoaDon");
				long maKH = rs.getLong("MaKH");
				String tenDongHo = rs.getString("TenDongHo");
				int soLuongMua = rs.getInt("SoLuongMua");
				int gia = rs.getInt("Gia");
				int thanhTien = rs.getInt("ThanhTien");
				boolean daMua = rs.getBoolean("DaMua");
				ds.add(new xacthucchitiethoadonbean(maChiTietHD, maHoaDon, maKH, tenDongHo, soLuongMua, gia, thanhTien, daMua));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<xacthucchitiethoadonbean> getCTHDXN(String MaCTHD){
		ArrayList<xacthucchitiethoadonbean> ds = new ArrayList<xacthucchitiethoadonbean>();
		try {
			kn.KetNoi();
			String sql = "select * from XacThuChiTietHoaDon where MaChiTietHoaDon = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, MaCTHD);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				long maChiTietHD = rs.getLong("MaChiTietHoaDon");
				long maHoaDon = rs.getLong("MaHoaDon");
				long maKH = rs.getLong("MaKH");
				String tenDongHo = rs.getString("TenDongHo");
				int soLuongMua = rs.getInt("SoLuongMua");
				int gia = rs.getInt("Gia");
				int thanhTien = rs.getInt("ThanhTien");
				boolean daMua = rs.getBoolean("DaMua");
				ds.add(new xacthucchitiethoadonbean(maChiTietHD, maHoaDon, maKH, tenDongHo, soLuongMua, gia, thanhTien, daMua));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int xacnhan(String machitiethoadon) throws Exception{
		kn.KetNoi();
		String sql="update XacThuChiTietHoaDon set DaMua=1 where MaChiTietHoaDon=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, machitiethoadon);
		int check = cmd.executeUpdate();
		kn.cn.close();
		return check;
	}
}
