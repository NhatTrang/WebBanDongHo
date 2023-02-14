package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	 public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	  public ArrayList<giohangbean> getDs() {
			return ds;
		}
	 public void Them(String Anh,String MaDongHo, String TenDongHo, int Gia, int SoLuong) {
		  giohangbean gh = new giohangbean(Anh, MaDongHo, TenDongHo, Gia, SoLuong, SoLuong);
		  for(giohangbean h: ds)
			  if(h.getMaDongHo().equals(MaDongHo)) {
				  h.setSoLuong(h.getSoLuong() + SoLuong);
				  h.setThanhTien(h.getSoLuong(), h.getGia());
				  return;
			  }
		ds.add(gh);
	  }
	  public int SoLuongSanPham() {
		  int total = 0;
		  for(giohangbean h : ds) {
			  total += Math.toIntExact(h.getSoLuong());
		  }
		  return total;
	  }
	  public void Sua(String MaDongHo, int slmoi) {
		  for(giohangbean h : ds) {
			  if(h.getMaDongHo().equals(MaDongHo)){
				  h.setSoLuong(slmoi);
				  return;
			  }
		  }
	  }
	  public void Xoa(String MaDongHo) {
		  for(giohangbean h: ds) {
			  if(h.getMaDongHo().equals(MaDongHo)) {
				  ds.remove(h);
				  return;
			  }
		  }
	  }
	  public void Xoatatca() {
		  ds.clear();
	  }
	  public void XoaCheck(String name) {
		  for(int i=0; i < ds.size();i++) {
			  if(ds.get(i).getMaDongHo().equals(name)) {
				  ds.remove(i);
			  }
		  }
	  }
	  public long Tongtien() {
		  long s=0;
		  for(giohangbean h: ds)
			  s=s+h.getThanhTien();
		  return s;
	  }
}
