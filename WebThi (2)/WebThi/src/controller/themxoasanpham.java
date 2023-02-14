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
import bo.donghobo;

/**
 * Servlet implementation class themxoasanpham
 */
@WebServlet("/themxoasanpham")
public class themxoasanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themxoasanpham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		donghobo dhb = new donghobo();
		Loaibo lb =new Loaibo();
		HttpSession session = request.getSession();
		ArrayList<loaibean> dslb = lb.getloai();
		if(session.getAttribute("admin") != null) {
		try {
			if(request.getParameter("btnthem") != null && request.getParameter("btnSua")!= null) {
				request.setAttribute("dslb",dslb);
				RequestDispatcher rd = request.getRequestDispatcher("adddongho.jsp");
				rd.forward(request, response);
			}
			if(request.getParameter("btnXoa")!=null) {
				dhb.XoaDH(request.getParameter("btnXoa"));
			}
			RequestDispatcher rd = request.getRequestDispatcher("danhsachsanpham.jsp");
	        rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
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
