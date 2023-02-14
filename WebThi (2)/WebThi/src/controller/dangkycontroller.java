package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KhachHangdao;
import dao.mdjavahash;

/**
 * Servlet implementation class dangkycontroller
 */
@WebServlet("/dangkycontroller")
public class dangkycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkycontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hoten = request.getParameter("txtun");
		String sdt = request.getParameter("txtsdt");
		String email = request.getParameter("txtemail");
		String diachi = request.getParameter("txtdiachi");
		String tendn = request.getParameter("txtdn");
		String pass = request.getParameter("txtpass");
		KhachHangdao kh = new KhachHangdao();
		mdjavahash md5 = new mdjavahash();
		if(hoten != null && sdt != null && email != null && diachi !=null && tendn != null && pass != null) {
			try {
				int n = kh.getDangKy(hoten, sdt, email, tendn, md5.getHashPass(pass), diachi);
				if(n ==0){
					request.setAttribute("ktradky", 0);
					HttpSession session = request.getSession();
					session.setAttribute("DangKy", tendn);
					RequestDispatcher rd = request.getRequestDispatcher("DangKy.jsp?kt=1");
					rd.forward(request, response);
				}else {
					HttpSession session = request.getSession();
					session.setAttribute("DangKy", tendn);
					RequestDispatcher rd = request.getRequestDispatcher("dangnhapcontroller");
					rd.forward(request, response);
				}		
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("DangKy.jsp");
			rd.forward(request, response);
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
