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
 * Servlet implementation class Loai
 */
@WebServlet("/Loai")
public class Loai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Loaibo lb = new Loaibo();
		if(session.getAttribute("admin") != null) {
		if(request.getParameter("btnloai") != null || request.getParameter("btnSua") !=null) {
			RequestDispatcher rd = request.getRequestDispatcher("addloai.jsp");
			rd.forward(request, response);
		}
		String maloai = request.getParameter("txtmaloai");
		String tenloai = request.getParameter("txttenloai");
		try {
			if(request.getParameter("btnThem") != null) {
				int n = lb.ThemLoai(maloai, tenloai);
				if(n ==0 ) {
					session.setAttribute("Check", maloai);
					RequestDispatcher rd = request.getRequestDispatcher("addloai.jsp?kt=1");
					rd.forward(request, response);
				}
			}
			if(request.getParameter("btnSua") != null) {
				lb.SuaLoai(maloai, tenloai);
				RequestDispatcher dr = request.getRequestDispatcher("danhsachloaicontroller");
		    	dr.forward(request, response);
			}
			if(request.getParameter("btnXoa") != null) {
				int n = lb.Xoa(request.getParameter("btnXoa"));
			}
			RequestDispatcher dr = request.getRequestDispatcher("danhsachloaicontroller");
	    	dr.forward(request, response);
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
