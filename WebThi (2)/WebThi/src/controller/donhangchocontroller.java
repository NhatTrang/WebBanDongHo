package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.hoadonbo;

/**
 * Servlet implementation class donhangchocontroller
 */
@WebServlet("/donhangchocontroller")
public class donhangchocontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public donhangchocontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		hoadonbo hdb = new hoadonbo();
		if(session.getAttribute("admin") != null) {
			session.setAttribute("dshd", hdb.getHDC());
			RequestDispatcher rd = request.getRequestDispatcher("hoadoncho.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("dangnhapadmincontroller");
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
