package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.chitiethoadonbean;

public class chitiethoadondao {
	KetNoi kn = new KetNoi();
	public void ThemCTHD(String maDongHo, long soLuongMua, int maHoaDon) throws Exception{
		kn.KetNoi();
		String sql = "insert into ChiTietHoaDon(MaHoaDon,SoLuongMua,MaDongHo,DaMua) values (?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, maHoaDon);
		cmd.setLong(2, soLuongMua);
		cmd.setString(3, maDongHo);
		cmd.setBoolean(4, false);
		cmd.executeUpdate();
		kn.cn.close();
	}
	public void UpdateCTHD(int maCTHD) throws Exception{
		kn.KetNoi();
		String sql = "update ChiTietHoaDon set DaMua = 1 where MaChiTietHoaDon = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, maCTHD);
		cmd.executeUpdate();
		kn.cn.close();
	}
	public void UpdateTong(String MaHoaDon) throws Exception{
		kn.KetNoi();
		String sql = "update ChiTietHoaDon set DaMua=1 where MaHoaDon=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, MaHoaDon);
		cmd.executeUpdate();
		kn.cn.close();
	}
	public ArrayList<chitiethoadonbean> getDSXN() throws Exception{
		ArrayList<chitiethoadonbean> ds = new ArrayList<chitiethoadonbean>();
		kn.KetNoi();
		String sql="select*from ChiTietHoaDon where DaMua=1";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			int maCTHD = rs.getInt("MaChiTietHoaDon");
			String maDongHo= rs.getString("MaDongHo");
			long soLuongMua = rs.getLong("SoLuongMua");
			int maHoaDon = rs.getInt("MaHoaDon");
			int daMua = rs.getInt("DaMua");
			ds.add(new chitiethoadonbean(maCTHD, maDongHo, soLuongMua, maHoaDon, daMua));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
