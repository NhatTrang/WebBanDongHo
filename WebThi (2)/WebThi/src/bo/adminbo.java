package bo;

import bean.Admin;
import dao.admindao;

public class adminbo {
	admindao add = new admindao();
	public Admin ktdn(String Tendn, String mk) {
		return add.ktdn(Tendn, mk);
	}
}
