package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.donghobean;
import bo.donghobo;

/**
 * Servlet implementation class donghocontroller
 */
@WebServlet("/donghocontroller")
public class donghocontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public donghocontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
		donghobo dhb = new donghobo();
		String so = request.getParameter("so");
		String tk = request.getParameter("txttk");
		ArrayList<donghobean> dsdongho = dhb.getdongho();
		ArrayList<donghobean> dsnb = dhb.getNoiBat("Sản Phẩm Nổi Bật");
		ArrayList<donghobean> dsdh = dhb.getphantrang();
		if(tk != null) {
			dsdongho = dhb.Tim(tk);
		}
		if(so != null && so != "") {	
	        	int page = Integer.parseInt(so);
	        	dsdh = dhb.getphan(page);
	    }
		request.setAttribute("dsnb", dsnb);
		request.setAttribute("dsdh", dsdh);
		request.setAttribute("dsdongho", dsdongho);
		RequestDispatcher rd = request.getRequestDispatcher("TrangChu.jsp");
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
