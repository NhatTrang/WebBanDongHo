package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class giohangcontroller
 */
@WebServlet("/giohangcontroller")
public class giohangcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohangcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String madh = request.getParameter("mdh");
		String tendh = request.getParameter("tdh");
		String anh = request.getParameter("anh");
		if(madh!=null && tendh != null && request.getParameter("gia") != null && anh != null){
    		int gia=Integer.parseInt(request.getParameter("gia"));
    		giohangbo gh= null;
    		//Nếu mua hàng lần đầu
    		HttpSession session = request.getSession();
			if(session.getAttribute("gio")==null){
    			gh = new giohangbo();// cấp vùng nhớ
    			session.setAttribute("gio", gh);// tạo session
    		}
    		//b1: lưu session ra biến
    		gh =(giohangbo) session.getAttribute("gio");
    		//b2: thao tác trên biến
    		gh.Them(anh, madh, tendh, gia, (int)1);
    	}
		HttpSession session = request.getSession();
    	giohangbo gh = (giohangbo)session.getAttribute("gio");
    	if(gh == null) {
    		RequestDispatcher dr = request.getRequestDispatcher("donghocontroller");
        	dr.forward(request, response);
    	}
    	int kt=0;
    	//Xóa check
    	if(request.getParameter("btnXoaCheck")!=null){
    		String[] gtcheck=request.getParameterValues("check");
    			if(gtcheck != null){
    				for(String s:gtcheck){
    					gh.Xoa(s);
    				}	
    			}else {	
    				kt=1;
    			}
    	}
    	//Sửa số lượng
    	if(request.getParameter("btnSua") != null){
			String mdh = request.getParameter("btnSua");
			int sl = Integer.parseInt(request.getParameter(mdh));
			
			if(sl == 0) {
				gh.Xoa(mdh);
			}else {
				gh.Sua(mdh, sl);
			}
		}
    	//Xóa sách
    	if(request.getParameter("btnXoa") != null) {
    		String ms = request.getParameter("btnXoa");
    			gh.Xoa(ms);
    	}
    	//Xóa toàn bộ
    	String btnxoaal = request.getParameter("btnxoaall");
    		if(btnxoaal != null){
    			gh.Xoatatca();
    		}
    	if(gh.ds.size()==0){
    	    RequestDispatcher dr = request.getRequestDispatcher("donghocontroller");
    	    dr.forward(request, response);
    	}
    	else {
    		if(kt==1)
    			response.sendRedirect("htdonghocontroller?kt=1");
    	    else
    	    	response.sendRedirect("htdonghocontroller");
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
