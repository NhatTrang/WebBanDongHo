<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="base.css">
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="giohang.css">
<link rel="stylesheet" href="tienhanhthanhtoan.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="./assect/fontawesome-free-6.1.2-web/fontawesome-free-6.1.2-web/css/all.min.css">
</head>
<body>
<div class="header">
	<div class="grip">
    	<div class="header_navbar ">
        	<ul class="header_navbar-ul">
                        <li class="header_navbar-li ">
                            <a href="donghocontroller" class="header_navbar-link right ">TRANG CHỦ</a>
                        </li>
                        <li class="header_navbar-li header__navbar-item--saparate">
                            <a href="" class="header_navbar-link header_magin ">GIỎ HÀNG</a>
                        </li>
                        <li class="header_navbar-li header__navbar-item--saparate">
                            <a href="" class="header_navbar-link header_magin color">THANH TOÁN</a>
                        </li>
                        <li class="header_navbar-li header__navbar-item--saparate">
                            <a href="lichsumuahangcontroller" class="header_navbar-link header_magin ">LỊCH SỬ MUA HÀNG</a>
                        </li>
			</ul>
			<ul class="header_navbar-ul">
                        <%if(session.getAttribute("dn")==null){ %>
                            <a href="dangnhapcontroller" class="header_navbar-link header_magin">ĐĂNG NHẬP</a>
                         <%}else{ %>
                         	<span class="header_navbar-link header_magin transfom"><%=session.getAttribute("dn")%></span>
                         <%} %>
                        <li class="header_navbar-li header__navbar-item--saparate">
                            <a href="DangKy.jsp" class="header_navbar-link header_magin ">ĐĂNG KÝ</a>
                        </li>
                         <li class="header_navbar-li header__navbar-item--saparate">
                            <a href="logout" class="header_navbar-link header_magin ">ĐĂNG XUẤT</a>
                        </li>
           </ul>
      </div>
          <form action="timcontroller" method="post">
             <div class="header_navbar-input">
             	<div class="header_input">
                    <input  name="txttk" type="text" placeholder="Nhập để tìm kiếm" class="header__cart-input">
                </div>
	            <div class="header__search-btn">
	                 <input name="button" type="submit" class="header__button" value="Tìm kiếm">
	            </div>
        	</div>
    	</form>
	</div>
</div>
<div class="grip">
	<div class="check_info">
		<div class="check_login">
			BẠN ĐÃ CÓ TÀI KHOẢN
			<a href="dangnhapcontroller" class="check_login-a">NHẤN VÀO ĐÂY ĐỂ ĐĂNG NHẬP</a>
		</div>
		<div class="check_login">
			ĐĂNG KÝ TÀI KHOẢN
			<a href="dangnhapcontroller" class="check_login-a">NHẤN VÀO ĐÂY ĐỂ ĐĂNG KÝ</a>
		</div>
		<div class="ccontainer">
		<%giohangbo gh = (giohangbo)session.getAttribute("gio");%>
			<h1 class="container-h1">THÔNG TIN ĐƠN HÀNG CỦA BẠN</h1>
			<div class="container_header">
				<span>SẢN PHẨM</span>
				<span>TỔNG</span>
			</div>
			<div class="container_body-1">
				<%if(gh != null){
					for(giohangbean s: gh.ds){%>
						<div class="container_body-product">
							<div class="container_body-name"><%=s.getTenDongHo()%>  x  <%=s.getSoLuong()%></div>
							<div class="container_body-price"><%=s.getThanhTien()%> ₫</div>
						</div>
					<%}%>
			</div>	
			<div class="container_body-1">
				<div class="container_body-product">
					<span class="container_body-information">TỔNG TIỀN SẢN PHẨM</span>
					<span class="container_body-price"><%=gh.Tongtien()%> ₫</span>
				</div>
				<div class="container_body-product">
					<span class="container_body-information">ĐỊA CHỈ</span>
					<span>Giao hàng miễn phí</span>
				</div>
				<div class="container_body-product">
					<div class="container_body-information">TỔNG</div>
					<div class="container_body-price"><%=gh.Tongtien()%> ₫</div>
				</div>
			</div>
			<%} %>
			<div class="container-body-order">
				<form action="thanhtoancontroller">
					<button type="submit" class="container_body-button" name="btndathang">ĐẶT HÀNG</button>
				</form>
			</div>
		</div>
	</div>
</div>
<footer class="footer">
            <div class="grip">
                <div class="grip__row">
                    <div class="grip__column-2-4">
                        <h3 class="footer__heading">CHĂM SÓC KHÁCH HÀNG</h3>
                        <ul class="footer__list">
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">Trung Tâm Trợ Giúp</a>
                            </li>
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">Hướng Dẫn Mua Hàng</a>
                            </li>
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">Thanh Toán</a>
                            </li>
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">Vận Chuyển</a>
                            </li>
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">Trả Hàng & Hoàn Tiền</a>
                            </li>
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">Chăm Sóc Khách Hàng</a>
                            </li>
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">Chính Sách Bảo Hành</a>
                            </li>
                        </ul>
                    </div>
                    <div class="grip__column-2-4">
                        <h3 class="footer__heading">VỀ SHOP</h3>
                        <ul class="footer__list">
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">Chính Sách Bảo Mật</a>
                            </li>
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">Chính Hãng</a>
                            </li>
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">Kênh Người Bán</a>
                            </li>
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">Flash Sales</a>
                            </li>
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">Liên Hệ Với Truyền Thông</a>
                            </li>
                        </ul>
                    </div>
                    <div class="grip__column-2-4">
                        <h3 class="footer__heading">THANH TOÁN</h3>
                        <div class="footer__check footer__check-test">
                            <li class="check">
                                <a href="" class="footer__chek-app">
                                    <img src="https://cf.shopee.vn/file/d4bbea4570b93bfd5fc652ca82a262a8" alt="AppStore" class="footer__chek-app-img">
                                </a>
                            </li>
                            <li class="check">
                            <a href="" class="footer__chek-app">
                                <img src="https://cf.shopee.vn/file/a0a9062ebe19b45c1ae0506f16af5c16" alt="AppStore" class="footer__chek-app-img">
                            </a>
                            </li>
                            <li class="check">
                            <a href="" class="footer__chek-app">
                                <img src="https://cf.shopee.vn/file/38fd98e55806c3b2e4535c4e4a6c4c08" alt="AppStore" class="footer__chek-app-img">
                            </a>
                            </li>
                            <li class="check">
                            <a href="" class="footer__chek-app">
                                <img src="https://cf.shopee.vn/file/bc2a874caeee705449c164be385b796c" alt="AppStore" class="footer__chek-app-img">
                            </a>
                            </li>
                        </div>
                    </div>
                    <div class="grip__column-2-4">
                        <h3 class="footer__heading">THEO DÕI CHÚNG TÔI TRÊN</h3>
                        <ul class="footer__list">
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">
                                    <i class="footer-item__icon fa-brands fa-facebook"></i>
                                    Facebook
                                </a>
                            </li>
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">
                                    <i class="footer-item__icon fa-brands fa-square-instagram"></i>
                                    Instagram
                                </a>
                            </li>
                            <li class="footer__list-item">
                                <a href="" class="footer-item__link">
                                    <i class="footer-item__icon fa-brands fa-linkedin"></i>
                                    LinkedIn
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="grip__column-2-4">
                        <h3 class="footer__heading">TẢI ỨNG DỤNG SHOP NGAY THÔI</h3>
                        <div class="footer__dow">
                            <img src="https://cf.shopee.vn/file/a5e589e8e118e937dc660f224b9a1472" alt="Download QR" class="footer__dow-QA">
                            <div class="footer__dow-apps"> 
                                <a href="" class="footer__dow-apps-link">
                                    <img src="https://cf.shopee.vn/file/ad01628e90ddf248076685f73497c163" alt="AppStore" class="footer__dow-apps-img">
                                </a>
                                <a href="" class="footer__dow-apps-link">
                                    <img src="https://cf.shopee.vn/file/ae7dced05f7243d0f3171f786e123def" alt="GG Play" class="footer__dow-apps-img">
                                </a>
                                <a href="" class="footer__dow-apps-link">
                                    <img src="https://cf.shopee.vn/file/35352374f39bdd03b25e7b83542b2cb0" alt="AppGali" class="footer__dow-apps-img">
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
</footer>
</body>
</html>