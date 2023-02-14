package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.donghobean;

public class donghodao {
	KetNoi kn = new KetNoi();
	public ArrayList<donghobean> gedongho(){
		ArrayList<donghobean> ds = new ArrayList<donghobean>();
		try {
			kn.KetNoi();
			String sql = "select*from DongHo";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maDongHo = rs.getString("MaDongHo");
				String maLoai = rs.getString("MaLoai");
				String tenDongHo = rs.getString("TenDongHo");
				int soLuong = rs.getInt("SoLuong");
				int gia = rs.getInt("Gia");
				String anh = rs.getString("Anh");
				Date ngayNhap = rs.getDate("NgayNhap");
				ds.add(new donghobean(maDongHo, maLoai, tenDongHo, soLuong, gia, anh, ngayNhap));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<donghobean> getNoiBat(String MaLoai){
		ArrayList<donghobean> ds = new ArrayList<donghobean>();
		try {
			kn.KetNoi();
			String sql = "select*from DongHo where MaLoai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, MaLoai);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maDongHo = rs.getString("MaDongHo");
				String maLoai = rs.getString("MaLoai");
				String tenDongHo = rs.getString("TenDongHo");
				int soLuong = rs.getInt("SoLuong");
				int gia = rs.getInt("Gia");
				String anh = rs.getString("Anh");
				Date ngayNhap = rs.getDate("NgayNhap");
				ds.add(new donghobean(maDongHo, maLoai, tenDongHo, soLuong, gia, anh, ngayNhap));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<donghobean> getphantrang(){
		ArrayList<donghobean> ds= new ArrayList<donghobean>();
		try {
			kn.KetNoi();
			String sql = "declare @RowCount int,\r\n"
					+ "		@PageCount int\r\n"
					+ "execute proc_Question_Select\r\n"
					+ "		@Page  = 1,\r\n"
					+ "		@PageSize  = 10,\r\n"
					+ "		@RowCount = @RowCount output,\r\n"
					+ "		@PageCount = @PageCount output \r\n"
					+ "select @PageCount as [PageCount]";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String maDongHo = rs.getString("MaDongHo");
				String maLoai = rs.getString("MaLoai");
				String tenDongHo = rs.getString("TenDongHo");
				int soLuong = rs.getInt("SoLuong");
				int gia = rs.getInt("Gia");
				String anh = rs.getString("Anh");
				Date ngayNhap = rs.getDate("NgayNhap");
				ds.add(new donghobean(maDongHo, maLoai, tenDongHo, soLuong, gia, anh, ngayNhap));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<donghobean> getphan(int page){
		ArrayList<donghobean> ds= new ArrayList<donghobean>();
		try {
			kn.KetNoi();
			String sql = "declare @RowCount int,\r\n"
					+ "		@PageCount int\r\n"
					+ "execute proc_Question_Select\r\n"
					+ "		@Page  = ?,\r\n"
					+ "		@PageSize  = 10,\r\n"
					+ "		@RowCount = @RowCount output,\r\n"
					+ "		@PageCount = @PageCount output \r\n"
					+ "select @PageCount as [PageCount]";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, page);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String maDongHo = rs.getString("MaDongHo");
				String maLoai = rs.getString("MaLoai");
				String tenDongHo = rs.getString("TenDongHo");
				int soLuong = rs.getInt("SoLuong");
				int gia = rs.getInt("Gia");
				String anh = rs.getString("Anh");
				Date ngayNhap = rs.getDate("NgayNhap");
				ds.add(new donghobean(maDongHo, maLoai, tenDongHo, soLuong, gia, anh, ngayNhap));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean CheckMa(String madongho) throws Exception {
		String sql = "SELECT MaDongHo FROM DongHo WHERE MaDongHo = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, madongho);
		ResultSet rs = cmd.executeQuery();
		boolean check = rs.next();
		rs.close();
		return check;
	}
	public int ThemDH(String maDongHo, String maLoai, String tenDongHo, int soLuong, int gia, String anh) throws Exception{
		kn.KetNoi();
		if(CheckMa(maDongHo) == false) {
			String sql = "insert into DongHo(MaDongHo, MaLoai, TenDongHo,SoLuong, Gia, Anh, NgayNhap) values (?,?,?,?,?,?,GETDATE())";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, maDongHo);
			cmd.setString(2, maLoai);
			cmd.setString(3, tenDongHo);
			cmd.setInt(4, soLuong);
			cmd.setInt(5, gia);
			cmd.setString(6, anh);
			int check = cmd.executeUpdate();
			kn.cn.close();
			return check;
		}
		else
			return 0;
	}
	public int SuaDH(String maDongHo, String maLoai, String tenDongHo, int soLuong, int gia, String anh) throws Exception{
		kn.KetNoi();
		String sql="update DongHo set MaLoai=?, TenDongHo=?, SoLuong=?, Gia=?, Anh=?, NgayNhap=GETDATE() where MaDongHo=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1,maLoai);
		cmd.setString(2,tenDongHo);
		cmd.setInt(3,soLuong);
		cmd.setInt(4,gia);
		cmd.setString(5,anh);
		cmd.setString(6,maDongHo);
		int check = cmd.executeUpdate();
		kn.cn.close();
		return check;
	}
	public int XoaDH(String maDongHo) throws Exception{
		kn.KetNoi();
		String sql="delete from DongHo where MaDongHo= ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maDongHo);
		int check = cmd.executeUpdate();
		kn.cn.close();
		return check;
	}
}
