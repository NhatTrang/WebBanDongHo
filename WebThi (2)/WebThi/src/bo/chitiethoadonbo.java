package bo;

import java.util.ArrayList;

import bean.chitiethoadonbean;
import dao.chitiethoadondao;

public class chitiethoadonbo {
	chitiethoadondao cthd = new chitiethoadondao();
	public void ThemCTHD(String maDongHo, long soLuongMua, int maHoaDon) throws Exception {
		cthd.ThemCTHD(maDongHo, soLuongMua, maHoaDon);
	}
	public void UpDate(int maCTHD) throws Exception{
		cthd.UpdateCTHD(maCTHD);
	}
	public void UpdateTong(String MaHoaDon) throws Exception{
		cthd.UpdateTong(MaHoaDon);
	}
	public ArrayList<chitiethoadonbean> getCTHDXN() throws Exception{
		 return cthd.getDSXN();
	}
}
