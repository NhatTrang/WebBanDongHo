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

import bean.hoadonbean;
import bo.hoadonbo;

/**
 * Servlet implementation class donhangdaxacnhan
 */
@WebServlet("/donhangdaxacnhan")
public class donhangdaxacnhan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public donhangdaxacnhan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hoadonbo hdb = new hoadonbo();
		ArrayList<hoadonbean> dshdxn = hdb.getdamua();
		HttpSession session = request.getSession();
		session.setAttribute("dshdxn", dshdxn);
		RequestDispatcher rd = request.getRequestDispatcher("donhangdaxacnhan.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
