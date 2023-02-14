package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.loaibean;



public class loaidao {
	KetNoi kn = new KetNoi();
	public ArrayList<loaibean> getloai(){
		ArrayList<loaibean> ds = new ArrayList<loaibean>();
		try {
			kn.KetNoi();
			String sql = "select*from Loai";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maLoai = rs.getString("MaLoai");
				String tenLoai = rs.getString("TenLoai");
				ds.add(new loaibean(maLoai, tenLoai));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean CheckMa(String maloai) throws Exception {
		String sql = "SELECT MaLoai FROM Loai WHERE MaLoai = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs = cmd.executeQuery();
		boolean check = rs.next();
		rs.close();
		return check;
	}
	public int ThemLoai(String maloai, String tenloai) throws Exception{
		kn.KetNoi();
			if(CheckMa(maloai) == false) {
				String sql="insert into Loai(MaLoai,TenLoai) values(?,?)";
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
				cmd.setString(1, maloai);
				cmd.setString(2, tenloai);
				int check = cmd.executeUpdate();
				kn.cn.close();
				return check;
			}
			else
				return 0;
	}
	public int SuaLoai(String maloai, String tenloai) throws Exception{
		kn.KetNoi();
		String sql="UPDATE Loai SET TenLoai=? where MaLoai=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tenloai);
		cmd.setString(2, maloai);
		int check = cmd.executeUpdate();
		kn.cn.close();
		return check;
	}
	public boolean CheckSach(String maloai) throws Exception{
		kn.KetNoi();
		String sql="select *from DongHo where MaLoai = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs = cmd.executeQuery();
		boolean check = rs.next();
		rs.close();
		return check;
	}
	public int XoaLoai(String maloai) throws Exception {
		kn.KetNoi();
		if(CheckSach(maloai) == false) {
			String sql = "delete from Loai where MaLoai =?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			int check = cmd.executeUpdate();
			kn.cn.close();
			return check;
		}
		else
			return 0;
	}
}
