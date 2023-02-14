package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public Connection cn;
	public void KetNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Xong b1");
			String url="jdbc:sqlserver://LAPTOP-KHGRS0P6:1433;databaseName=QLDongHo; user=sa; password=12345";
			cn = DriverManager.getConnection(url);
			System.out.println("Xong b2");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
	}
}
