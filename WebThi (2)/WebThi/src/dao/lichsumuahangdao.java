package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.lichsumuahangbean;


public class lichsumuahangdao {
	KetNoi kn = new KetNoi();
	public ArrayList<lichsumuahangbean> getLSMH(long makh){
		ArrayList<lichsumuahangbean> ds = new ArrayList<lichsumuahangbean>();
		try {
			kn.KetNoi();
			String sql = "select * from LichSuMua where makh = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, makh);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String tenDongHo = rs.getString("TenDongHo");
				int soLuongMua = rs.getInt("SoLuongMua");
				int gia = rs.getInt("Gia");
				Date ngayMua = rs.getDate("NgayMua");
				String daMua = rs.getString("DaMua");
				long maKH = rs.getLong("MaKH");
				int thanhTien = rs.getInt("ThanhTien");
				lichsumuahangbean ls = new lichsumuahangbean(tenDongHo, soLuongMua, gia, ngayMua, daMua, maKH, thanhTien);
				ds.add(ls);
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
