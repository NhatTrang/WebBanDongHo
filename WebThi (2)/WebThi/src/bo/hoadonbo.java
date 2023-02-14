package bo;

import java.util.ArrayList;

import bean.hoadonbean;
import dao.hoadondao;

public class hoadonbo {
	hoadondao hdd = new hoadondao();
	public int Them(long MaKH) throws Exception{
		return hdd.Them(MaKH);
	}
	public long getMaKH(String un) throws Exception{
		return hdd.getMakh(un);
	}
	public int maxhd() {
		return hdd.maxhd();
	}
	public ArrayList<hoadonbean> getHDC(){
		return hdd.gethD();
	}
	public ArrayList<hoadonbean> getdamua(){
		return hdd.getdamua();
	}
	public int XacNhan(String MaHoaDon) throws Exception{
		return hdd.XacNhan(MaHoaDon);
	}
}
