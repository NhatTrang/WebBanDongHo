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

import bean.loaibean;
import bo.Loaibo;

/**
 * Servlet implementation class danhsachloaicontroller
 */
@WebServlet("/danhsachloaicontroller")
public class danhsachloaicontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public danhsachloaicontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Loaibo lb = new Loaibo();
		ArrayList<loaibean> dslb = lb.getloai();
		HttpSession session = request.getSession();
		if(session.getAttribute("admin") != null) {
			session.setAttribute("dslb", dslb);
			RequestDispatcher dr = request.getRequestDispatcher("danhsachloai.jsp");
	    	dr.forward(request, response);
		}else {
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
