package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.xacthucchitiethoadonbean;
import bo.hoadonbo;
import bo.xacthuCTHDbo;

/**
 * Servlet implementation class xacnhanhoadoncontroller
 */
@WebServlet("/xacnhanhoadoncontroller")
public class xacnhanhoadoncontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanhoadoncontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hoadonbo hdb = new hoadonbo();
		HttpSession session = request.getSession();
		xacthuCTHDbo xnb = new xacthuCTHDbo();
		String mahoadon = request.getParameter("mahoadon");
		String hoadon = request.getParameter("mct");
		try {
			if(mahoadon != null) {
				hdb.XacNhan(mahoadon);
				RequestDispatcher rd = request.getRequestDispatcher("donhangdaxacnhan");
				rd.forward(request, response);
			}
			if(hoadon != null) {
				ArrayList<xacthucchitiethoadonbean> dsxn = xnb.xacthucCTHD(hoadon);
				for(xacthucchitiethoadonbean h: dsxn) {
					if(h.isDaMua() == true) {
						System.out.print(h.isDaMua());
						hdb.XacNhan(mahoadon);
						RequestDispatcher rd = request.getRequestDispatcher("donhangdaxacnhan");
						rd.forward(request, response);
					}
				}
				session.setAttribute("dsxn", dsxn);
				RequestDispatcher rd = request.getRequestDispatcher("chitietxacnhan.jsp");
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
