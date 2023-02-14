package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.donghobean;
import bean.loaibean;
import bo.Loaibo;
import bo.donghobo;

/**
 * Servlet implementation class addsanphamcontroller
 */
@WebServlet("/addsanphamcontroller")
public class addsanphamcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addsanphamcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		donghobo dhb = new donghobo();
		Loaibo lb = new Loaibo();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ArrayList<donghobean> dsdh = dhb.getphantrang();
		//ArrayList<loaibean> dsloai = l.getloai();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		try {
			List<FileItem> fileItems = new ArrayList<FileItem>();// Lấy về các đối tượng gửi lên
			fileItems = upload.parseRequest(request);
			String maDongHo = "";
			String maLoai = "";
			String TenDongHo = "";
			int SoLuong = (int) 0;
			int Gia = (int) 0;
			String nameimg = "";
			String ngaynhap = "";
			String btnThem ="";	
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "files";
						File dir = new File(dirUrl);
						//File dir = new File("D:/Nam4/JavaNangcao\javanangcaoNhom4\WebContent\image_sach");
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);// lưu file
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else {// Neu la control
					try {
						String tentk = fileItem.getFieldName();
						if (tentk.equals("txtmadongho"))
							maDongHo = fileItem.getString();
						if (tentk.equals("txtmaloai"))
							maLoai = fileItem.getString();
						if (tentk.equals("txttendongho"))
							TenDongHo = fileItem.getString();
						if (tentk.equals("txtsoluong"))
							SoLuong = Integer.parseInt(fileItem.getString());
						if (tentk.equals("txtgia"))
							Gia = Integer.parseInt(fileItem.getString());
						if (tentk.equals("txtngaynhap"))
							ngaynhap = fileItem.getString();
						if (tentk.equals("btnThem")) {
							System.out.print("ahihis");
							int n = dhb.ThemDH(maDongHo, maLoai, TenDongHo, SoLuong, Gia, "files/"+nameimg);
							if (n == 0) {
								RequestDispatcher rd = request.getRequestDispatcher("adddongho.jsp?tt=1");
								rd.forward(request, response);
							}
						}
						if(tentk.equals("btnSua")) {
							dhb.SuaDH(maDongHo, maLoai, TenDongHo, SoLuong, Gia, "files/"+nameimg);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
			try {
				request.setAttribute("dsdh", dsdh);
				request.setAttribute("dslb", lb.getloai());
				RequestDispatcher rd = request.getRequestDispatcher("danhsachsanphamcontroller");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} catch (FileUploadException e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("dsdh", dsdh);
			request.setAttribute("dslb", lb.getloai());
			RequestDispatcher rd = request.getRequestDispatcher("danhsachsanphamcontroller");
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
