package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.KhachHangbean;
import bo.khachhangbo;
import dao.KhachHangdao;
import dao.VerifyRecaptcha;
import dao.mdjavahash;

/**
 * Servlet implementation class dangnhapcontroller
 */
@WebServlet("/dangnhapcontroller")
public class dangnhapcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapcontroller() {
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
		boolean valid = true;
	    String errorString = null;
		String un = request.getParameter("txtun");
		String pass = request.getParameter("txtpass");
		KhachHangdao kh = new KhachHangdao();
		mdjavahash md5 = new mdjavahash();
		PrintWriter out = response.getWriter();
		String gRecaptchaResponse = request
				.getParameter("g-recaptcha-response");
		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
		if(un != null && pass !=null) {
			try {
				if(kh.getdangnhap(un, md5.getHashPass(pass)) != null && verify){// Đăng nhập đúng
					//Tạo đối tượng session
					session.setAttribute("dn", un);
					RequestDispatcher rd = request.getRequestDispatcher("donghocontroller");
					rd.forward(request, response);
				}
				else{// đăng nhập sai
					RequestDispatcher rd = request.getRequestDispatcher("DangNhap.jsp?kt=1");
					rd.forward(request, response);
					 out.print("<script>alert('Sai tên đăng nhập or pass')</script>");
						if (verify) {
							out.println("<font color=red>Either user name or password is wrong.</font>");
						}else {
							out.println("<font color=red>You missed the Captcha.</font>");
						}
				}
			} catch (NoSuchAlgorithmException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {// chạy lần đầu
			RequestDispatcher rd = request.getRequestDispatcher("DangNhap.jsp");
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
