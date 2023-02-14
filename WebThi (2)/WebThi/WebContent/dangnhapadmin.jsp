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
<link rel="stylesheet" href="login.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="./assect/fontawesome-free-6.1.2-web/fontawesome-free-6.1.2-web/css/all.min.css">
</head>
<body>
		<div class="backgroup_login">
			<form action="dangnhapadmincontroller" method="post" class="login">
		            <div class="login_cart">
		                <span class="login_item1">ĐĂNG </span>
		                <span class="login_item">NHẬP</span>
		            </div>
		            <div class="login_name">
		                <label class="login_username">Tên đăng nhập</label>
		                <input type="text" name="txtadmin" class="login_input-name" placeholder="Nhập tên đăng nhập">
		                <label class="login_pass">Mật khẩu</label>
		                <input type="password" name="txtpass" class="login_input-name" placeholder="Nhập mật khẩu">
		            </div>
		            <input type="submit" name="btn" value="Đăng nhập" class="btn">
		            <% if(request.getParameter("kt")!=null){%>
			    		<script> alert('Login sai');</script>
			    	<%}%>
        	</form>
		</div>
</body>
</html>