<%@page import="bean.loaibean"%>
<%@page import="bean.donghobean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="base.css">
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="timkiem.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="./assect/fontawesome-free-6.1.2-web/fontawesome-free-6.1.2-web/css/all.min.css">
</head>
<body>
<div class="header">
	<div class="grip">
    	<div class="header_navbar">
        	<ul class="header_navbar-ul">
                        <li class="header_navbar-li ">
                            <a href="donghocontroller" class="header_navbar-link right ">TRANG CHỦ</a>
                        </li>
                        <li class="header_navbar-li header__navbar-item--saparate">
                            <a href="" class="header_navbar-link header_magin ">GIỎ HÀNG</a>
                        </li>
                        <li class="header_navbar-li header__navbar-item--saparate">
                            <a href="" class="header_navbar-link header_magin ">THANH TOÁN</a>
                        </li>
                        <li class="header_navbar-li header__navbar-item--saparate">
                            <a href="" class="header_navbar-link header_magin ">LỊCH SỬ MUA HÀNG</a>
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
                    <!--  <input  name="txttk" type="text" placeholder="Nhập để tìm kiếm" class="header__cart-input">-->
                      <input oninput="searchbyname(this)" name="key" type="text" placeholder="Nhập để tìm kiếm" class="header__cart-input" >
                </div>
	            <div class="header__search-btn">
	                 <input name="button" type="submit" class="header__button" value="Tìm kiếm">
	            </div>
        	</div>
    	</form>
	</div>
</div>
<div class="margin-top">
	<div class="container">
		<div class="grip">
			<div class="grip__row">
				<div class="grip__column-2">
                 <nav class="category">
                     	<h3 class="category__heading">Danh Mục</h3>
	                     	<ul class="category-list">
	                     		<%
								ArrayList<loaibean> dsloai = (ArrayList<loaibean>)request.getAttribute("dsloai");
								for (loaibean l : dsloai) {%>
	                         		<li class="category-item category-item--active">
	                             		<a href="timcontroller?ml=<%=l.getMaLoai()%>" class="category-item__link"><%=l.getMaLoai()%></a>
	                         		</li>
	                         	<%}%>
	                     	</ul>
                </nav>
             </div>
			<div class="grip__column-10">
				<div class="home-product5" >
					<div class="grip__row"id="content" >
						<%
						ArrayList<donghobean> dsdongho = (ArrayList<donghobean>) request.getAttribute("dsdongho");
						for (donghobean l : dsdongho) {
						%>
						<div class="grip__column-2-4">
		            		<div class="home_product-cart">
		                		<a href="giohangcontroller?mdh=<%=l.getMaDongHo()%>&tdh=<%=l.getTenDongHo()%>&gia=<%=l.getGia()%>&anh=<%=l.getAnh()%>" class="home_product-a">
		                    		<div class="home_product-item_img" style="background-image:url(<%=l.getAnh()%>);"></div>
			                    	<h4 class="product_cart-item1-name"><%=l.getTenDongHo()%></h4>
			                    	<div class="home-product-item__price">
		                        		<span class="home-product-item__price-old"><%=l.getGia()%> ₫</span>
		                       	 	</div>
			                    	<div class="btn">
			                    		<input type="submit" class="btn-mua" value="THÊM VÀO GIỎ">
			                    		</div>
		                    		</a>
		             			</div>
	                 		</div>
							<%}%>
							<%if(dsdongho.size() == 0){ %>
								<h1>KHÔNG TÌM THẤY KẾT QUẢ</h1>
							<%}%>
						</div>
					</div>
				</div>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="jquery-3.6.1.min.js"></script>
<script >
	function searchbyname(param) {
		var key = param.value;
		$.ajax({
			url: "/WebThi/searchAjax",
			type: "get",
			data: {
				key: key
			},
			success: function (data) {
				var row = document.getElementById("content");
				row.innerHTML = data;
			},
			error: function(xhr){
				console.log("ERROR: ", xhr);
			}
		});
	}
</script>
</body>
</html>