package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class Loaibo {
	loaidao ld = new loaidao();
	ArrayList<loaibean> ds;
	public ArrayList<loaibean> getloai(){
		ds =ld.getloai();
		return ds;
	}
	public int ThemLoai(String maloai, String tenloai) throws Exception{
		return ld.ThemLoai(maloai, tenloai);
	}
	public int SuaLoai(String maloai, String tenloai) throws Exception{
		return ld.SuaLoai(maloai, tenloai);
	}
	public int Xoa(String maloai) throws Exception{
		return ld.XoaLoai(maloai);
	}
}
