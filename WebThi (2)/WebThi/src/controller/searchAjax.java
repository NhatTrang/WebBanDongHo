package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.donghobean;
import bo.donghobo;

/**
 * Servlet implementation class searchAjax
 */
@WebServlet("/searchAjax")
public class searchAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			donghobo dhbo = new donghobo();
			ArrayList<donghobean> dhbean = dhbo.getdongho();
			String key = request.getParameter("key");
			dhbean = dhbo.Tim(key);
			PrintWriter out = response.getWriter();	
			for(donghobean l: dhbean) {
				out.println( "<div class=\"grip__column-2-4\">\r\n"
						+ "		            		<div class=\"home_product-cart\">\r\n"
						+ "		                		<a href=\"giohangcontroller?mdh="+l.getMaDongHo()+"&tdh="+l.getTenDongHo()+"&gia="+l.getGia()+"&anh="+l.getAnh()+"\" class=\"home_product-a\">\r\n"
						+ "		                    		<div class=\"home_product-item_img\" style=\"background-image:url("+l.getAnh()+");\"></div>\r\n"
						+ "			                    	<h4 class=\"product_cart-item1-name\">"+l.getTenDongHo()+"</h4>\r\n"
						+ "			                    	<div class=\"home-product-item__price\">\r\n"
						+ "		                        		<span class=\"home-product-item__price-old\">"+l.getGia()+" ₫</span>\r\n"
						+ "		                       	 	</div>\r\n"
						+ "			                    	<div class=\"btn\">\r\n"
						+ "			                    		<input type=\"submit\" class=\"btn-mua\" value=\"THÊM VÀO GIỎ\">\r\n"
						+ "			                    		</div>\r\n"
						+ "		                    		</a>\r\n"
						+ "		             			</div>\r\n"
						+ "	                 		</div>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
