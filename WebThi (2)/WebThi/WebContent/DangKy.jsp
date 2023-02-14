<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="base.css">
<link rel="stylesheet" href="register.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="./assect/fontawesome-free-6.1.2-web/fontawesome-free-6.1.2-web/css/all.min.css">
</head>
<body>
<div class="backgroup_register">
        <form action="dangkycontroller" method="post"  class="register">
                <div class="login_cart">
                    <span class="login_item1">ĐĂNG</span>
                    <span class="login_item">KÝ</span>
                </div>
            <div class="register_name">
                <label class="register_username general">Nhập họ tên</label>
                <input type="text" name="txtun" class="register_input-name" placeholder="Nhập họ tên">
                <label class="register_cart general">Nhập số điện thoại</label>
                <input type="text" name="txtsdt" class="register_input-name" placeholder="Nhập Số điện thoại">
                <label class="register_cart general">Nhập email</label>
                <input type="email" name="txtemail" class="register_input-name" placeholder="Nhập Email">
                <label class="register_cart general">Nhập địa chỉ</label>
                <input type="text" name="txtdiachi" class="register_input-name" placeholder="Nhập địa chỉ">
                <label class="register_cart general">Tên đăng nhập</label>
                <input type="text" name="txtdn" class="register_input-name" placeholder="Nhập tên đăng nhập">
                <label class="register_cart general">Nhập mật khẩu</label>
                <input type="password" name="txtpass" class="register_input-name" placeholder="Nhập mật khẩu">
            </div>
            <input type="submit" name="btn" value="Đăng ký" class="btn">
            <%if(session.getAttribute("kt") != null) {%>
            	<script> alert('Đã có tài khoản');</script>
            <%} %>
        </form>
</div>
</body>
</html>