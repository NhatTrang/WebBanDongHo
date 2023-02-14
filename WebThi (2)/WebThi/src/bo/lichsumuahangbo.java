package bo;

import java.util.ArrayList;

import bean.lichsumuahangbean;
import dao.lichsumuahangdao;

public class lichsumuahangbo {
	lichsumuahangdao  mhd = new lichsumuahangdao();
	ArrayList<lichsumuahangbean> ds;
	public ArrayList<lichsumuahangbean> getLSMH(long makh){
		ds = mhd.getLSMH(makh);
		return ds;
	}
}
