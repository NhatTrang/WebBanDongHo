<%@page import="bean.loaibean"%>
<%@page import="bean.Admin"%>
<%@page import="bean.donghobean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="base.css">
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="danhsachloai.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="fontawesome-free-6.1.2-web/fontawesome-free-6.1.2-web/css/all.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="header">
            <div class="grip">
                <div class="header_navbar">
                    <ul class="header_navbar-ul">
                        <li class="header_navbar-li ">
                            <a href="Trangchucontroller" class="header_navbar-link right ">TRANG CHỦ</a>
                        </li>
                        <li class="header_navbar-li header__navbar-item--saparate">
                            <a href="danhsachloaicontroller" class="header_navbar-link header_magin ">DANH SÁCH LOẠI</a>
                        </li>
                        <li class="header_navbar-li header__navbar-item--saparate">
                            <a href="danhsachsanphamcontroller" class="header_navbar-link header_magin color">DANH SÁCH SẢN PHẨM</a>
                        </li>
                        <li class="header_navbar-li header__navbar-item--saparate">
                            <a href="donhangchocontroller" class="header_navbar-link header_magin ">ĐƠN HÀNG CHỜ</a>
                         </li>
                         <li class="header_navbar-li header__navbar-item--saparate">
                            <a href="donhangxacnhancontroller" class="header_navbar-link header_magin ">ĐƠN HÀNG ĐÃ XÁC NHẬN</a>
                         </li>
                    </ul>
                    <ul class="header_navbar-ul">
                        <li class="header_navbar-li ">
                        <%Admin kh =(Admin)session.getAttribute("admin");%>
                         	<span class="header_navbar-link header_magin transfom"><%out.print(kh.getTenDangNhap());%></span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="grip">
        	<div class="container_ThemLoai">
        		<h1 class="container_loai-h1">THÔNG TIN LOẠI SẢN PHẨM</h1>
        		<div class="container_addsp">
        			<form method="post" action="addsanphamcontroller" enctype= "multipart/form-data">
						<div class="container_sanpham">
							<label class="input_label">MÃ ĐỒNG HỒ*</label>
							<input type="text" name = "txtmadongho" value="" class="container_sanpham-input"><br>
						</div>
						<div class="container_sanpham">
							<label class="input_label" style="margin-right: 48px">MÃ LOẠI*</label>
							<select name="txtmaloai" class="select-spacing">
								<c:forEach var="l" items="${dslb}">
									<option value="${l.getMaLoai()}" class="container_sanpham-input">${l.getMaLoai()}</option>
								</c:forEach>
							</select><br>
						</div>
						<div class="container_sanpham">
						<label class="input_label" style="margin-right: 10px">TÊN ĐỒNG HỒ*</label>
						<input type="text" name = "txttendongho" value="" class="container_sanpham-input"><br>
						</div>
						<div class="container_sanpham">
						<label class="input_label" style="margin-right: 30px">SỐ LƯỢNG*</label>
						<input type="text" name = "txtsoluong" value="" class="container_sanpham-input"><br>
						</div>
						<div class="container_sanpham">
						<label class="input_label" style="margin-right: 84px">GIÁ*</label>
						<input type="text" name = "txtgia" value="" class="container_sanpham-input"><br>
						</div>
						<div class="container_sanpham">
						<label class="input_label" style="margin-right: 78px">ẢNH*</label>
						<input type="file" name="txtfile"><br>
						</div>
						<div class="container_sanpham">
						<label class="input_label" style="margin-right: 24px">NGÀY NHẬP*</label>
						<input type="date" name="txtngaynhap" class="container_sanpham-input"><br>
						</div>
						<input type="submit"  name="btnThem" class="container_loai-button-a" value="THÊM SẢN PHẨM">
						<input type="submit" name="btnSua"  class="container_loai-button-a left" value="SỬA SẢN PHẨM">
						<%if(request.getParameter("kt") !=null){%>
								<script> alert('trùng mã đồng hồ');</script>;
						<%}%>
					</form>
        		</div>
        	</div>
        </div>
</body>
</html>