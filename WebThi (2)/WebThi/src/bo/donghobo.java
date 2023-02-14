package bo;

import java.util.ArrayList;

import bean.donghobean;
import dao.donghodao;

public class donghobo {
	donghodao dhd = new donghodao();
	ArrayList<donghobean> ds;
	public ArrayList<donghobean> getdongho(){
		ds= dhd.gedongho();
		return ds;
	}
	public ArrayList<donghobean> getNoiBat(String MaLoai){
		ds= dhd.getNoiBat(MaLoai);
		return ds;
	}
	public ArrayList<donghobean> getphantrang(){
		return dhd.getphantrang();
	}
	public ArrayList<donghobean> getphan(int page){
		return dhd.getphan(page);
	}
	public ArrayList<donghobean> TimLoai(String MaLoai){
		   ArrayList<donghobean> tam= new ArrayList<donghobean>();
		   for(donghobean s: ds)
			   if(s.getMaLoai().equals(MaLoai))
				   tam.add(s);
		   return tam;
	}
	public ArrayList<donghobean> Tim(String key){
		   ArrayList<donghobean> tam= new ArrayList<donghobean>();
		   for(donghobean s: ds)
			   if(s.getTenDongHo().toLowerCase().contains(key.toLowerCase())||s.getMaLoai().toLowerCase().contains(key.toLowerCase()))
				   tam.add(s);
		   return tam;
	}
	public int ThemDH(String maDongHo, String maLoai, String tenDongHo, int soLuong, int gia, String anh) throws Exception{
		return dhd.ThemDH(maDongHo, maLoai, tenDongHo, soLuong, gia, anh);
	}
	public int SuaDH(String maDongHo, String maLoai, String tenDongHo, int soLuong, int gia, String anh) throws Exception{
		return dhd.SuaDH(maDongHo, maLoai, tenDongHo, soLuong, gia, anh);
	}
	public int XoaDH(String maDongHo) throws Exception{
		return dhd.XoaDH(maDongHo);
	}
}
