package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bo.chitiethoadonbo;
import bo.giohangbo;
import bo.hoadonbo;
import dao.chitiethoadondao;

/**
 * Servlet implementation class thanhtoancontroller
 */
@WebServlet("/thanhtoancontroller")
public class thanhtoancontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thanhtoancontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		giohangbo gh = (giohangbo)session.getAttribute("gio");
		String dathang = request.getParameter("btndathang");
		if(dathang != null) {
			if(session.getAttribute("dn") == null) {
				RequestDispatcher dr = request.getRequestDispatcher("dangnhapcontroller");
		        dr.forward(request, response);
			}
			else {
				hoadonbo hdb = new hoadonbo();
				chitiethoadonbo cthd = new chitiethoadonbo();
				try {
					String un = (String) session.getAttribute("dn");
					if(un != null) {
						long khbean = hdb.getMaKH(un);
						hdb.Them(khbean);
						int mahd = hdb.maxhd();
						for(giohangbean h: gh.ds) {
							cthd.ThemCTHD(h.getMaDongHo(), h.getSoLuong(), mahd);
						}
						session.removeAttribute("gio");
						response.sendRedirect("thanhtoan");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
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
