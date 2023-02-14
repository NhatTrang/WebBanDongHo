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

import bean.lichsumuahangbean;
import bo.hoadonbo;
import bo.lichsumuahangbo;

/**
 * Servlet implementation class lichsumuahangcontroller
 */
@WebServlet("/lichsumuahangcontroller")
public class lichsumuahangcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsumuahangcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		lichsumuahangbo lsb = new lichsumuahangbo();
		hoadonbo hdb = new hoadonbo();
		HttpSession session = request.getSession();
		String un = (String) session.getAttribute("dn");
		try {
			long makh = hdb.getMaKH(un);
			ArrayList<lichsumuahangbean> dsls = lsb.getLSMH(makh);
			request.setAttribute("dsls", dsls);
			RequestDispatcher rd = request.getRequestDispatcher("lichsumuahang.jsp");
	        rd.forward(request, response);
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
