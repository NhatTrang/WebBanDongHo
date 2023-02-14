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
<link rel="stylesheet" href="danhsachsanpham.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="fontawesome-free-6.1.2-web/fontawesome-free-6.1.2-web/css/all.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
                            <a href="danhsachsanphamcontroller" class="header_navbar-link header_magin ">DANH SÁCH SẢN PHẨM</a>
                        </li>
                        <li class="header_navbar-li header__navbar-item--saparate">
                            <a href="donhangchocontroller" class="header_navbar-link header_magin color">ĐƠN HÀNG CHỜ</a>
                         </li>
                         <li class="header_navbar-li header__navbar-item--saparate">
                            <a href="donhangdaxacnhan" class="header_navbar-link header_magin ">ĐƠN HÀNG ĐÃ XÁC NHẬN</a>
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
        <div class="container">
        	<div class="grip">
        		<h1 class="container_loai-h1">THÔNG TIN CHI TIẾT ĐƠN HÀNG</h1>
	        	<table class="table table-hover">
	        		<thead > 
		        		<tr class="container_loai-header">
		        			<th class="container_loai-span">MÃ CHI TIẾT HÓA ĐƠN</th>
		        			<th class="container_loai-span">MÃ HÓA ĐƠN</th>
			        		<th class="container_loai-span">SỐ LƯỢNG MUA</th>
			        		<th class="container_loai-span">MÃ ĐỒNG HỒ</th>
			        		<th class="container_loai-span">ĐÃ MUA</th>
		        		</tr>
	        		</thead>
	        		<tbody class="container_loai-body">
	        				<c:forEach var="s" items="${dscthd}">
	        					<tr>
	        						<td>${s.getMaCTHD()}</td>
	        						<td>${s.getMaDongHo()}</td>
	        						<td>${s.getSoLuongMua()}</td>
	        						<td>${s.getMaHoaDon()}</td>
	        						<td>${s.getDaMua()}</td>
	        						<td class="container_loai-body-a">
	        							ĐÃ XÁC NHẬN
	        						</td>
	        					</tr>
	        				</c:forEach>
	        		</tbody>
	        	</table>
	        	<form action="donhangchocontroller" method="post">
	        		<button class="container_loai-button" name="btnthem" type="submit">
        				<i class="fa-solid fa-arrow-left"></i>
        				TRỞ VỀ
        			</button>
	        	</form>
        	</div>
        </div>
</body>
</html>