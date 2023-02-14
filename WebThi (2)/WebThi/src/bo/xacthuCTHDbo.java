package bo;

import java.util.ArrayList;

import bean.xacthucchitiethoadonbean;
import dao.xacthucCTHD;

public class xacthuCTHDbo {
	xacthucCTHD xtd = new xacthucCTHD();
	ArrayList<xacthucchitiethoadonbean> ds;
	public ArrayList<xacthucchitiethoadonbean> xacthucCTHD(String MaHoaDon){
		ds = xtd.getCTHD(MaHoaDon);
		return ds;
	}
	public ArrayList<xacthucchitiethoadonbean> CTHDXN(String MaCTHD){
		return ds = xtd.getCTHDXN(MaCTHD);
	}
	public int Xacnhan(String machitiethoadon) throws Exception{
		return xtd.xacnhan(machitiethoadon);
	}
}
