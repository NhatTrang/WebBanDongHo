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
import bean.loaibean;
import bo.Loaibo;
import bo.donghobo;

/**
 * Servlet implementation class timcontroller
 */
@WebServlet("/timcontroller")
public class timcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timcontroller() {
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
	    Loaibo lb = new Loaibo();
	    ArrayList<donghobean> dsdongho = dhb.getdongho();
	    ArrayList<loaibean> dsloai = lb.getloai();
	    String ml=request.getParameter("ml");
	    String key = request.getParameter("txttk");
	    if(ml != null) {
    		dsdongho = dhb.TimLoai(ml);
    	}
	    else {
	    	if(key != null) {
				dsdongho = dhb.Tim(key);
			}
	    }
	    request.setAttribute("dsloai", dsloai);
	    request.setAttribute("dsdongho", dsdongho);
	    RequestDispatcher rd = request.getRequestDispatcher("Timdongho.jsp");
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
