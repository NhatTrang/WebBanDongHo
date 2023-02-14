package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.hoadonbo;
import bo.xacthuCTHDbo;

/**
 * Servlet implementation class chitiethoadoncontroller
 */
@WebServlet("/chitiethoadoncontroller")
public class chitiethoadoncontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chitiethoadoncontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		xacthuCTHDbo xnb = new xacthuCTHDbo();
		hoadonbo hdb = new hoadonbo();
		String MaChiTiet = request.getParameter("mcthd");
		String hoadon = request.getParameter("mhd");
		try {
			if(MaChiTiet != null) {
				xnb.Xacnhan(MaChiTiet);
				RequestDispatcher rd = request.getRequestDispatcher("daxacnhan");
				rd.forward(request, response);
			}
			if(hoadon != null && MaChiTiet!=null) {
				hdb.XacNhan(hoadon);
				RequestDispatcher rd = request.getRequestDispatcher("DanhsachchuyentienController");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
