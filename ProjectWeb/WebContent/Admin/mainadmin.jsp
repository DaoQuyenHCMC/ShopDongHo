<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial;
	padding: 10px;
	background: #f1f1f1;
}

/* Header/Blog Title */
.header {
	padding: 30px;
	text-align: center;
	background: white;
}

.header h1 {
	font-size: 50px;
}

/* Style the top navigation bar */
.topnav {
	overflow: hidden;
	background-color: #333;
}

/* Style the topnav links */
.topnav a {
	float: left;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
	background-color: #ddd;
	color: black;
}

/* Create two unequal columns that floats next to each other */
/* Left column */
.leftcolumn {
	float: left;
	width: 75%;
}

/* Right column */
.rightcolumn {
	float: left;
	width: 25%;
	background-color: #f1f1f1;
	padding-left: 20px;
}

/* Fake image */
.fakeimg {
	background-color: #aaa;
	width: 100%;
	padding: 20px;
}

/* Add a card effect for articles */
.card {
	background-color: white;
	padding: 20px;
	margin-top: 20px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Footer */
.footer {
	padding: 20px;
	text-align: center;
	background: #ddd;
	margin-top: 20px;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
	.leftcolumn, .rightcolumn {
		width: 100%;
		padding: 0;
	}
}

/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
@media screen and (max-width: 400px) {
	.topnav a {
		float: none;
		width: 100%;
	}
}
</style>
</head>
<body>
	<div class="header">
		<h1>Quản lý</h1>
		<p>Quản lý cửa hàng</p>
	</div>
	<a href="/ProjectWeb/index.html">Đăng xuất</a>
	<div class="topnav">
		<a href="/ProjectWeb/UsersServlet">Tài khoản khách hàng</a> 
		<a href="/ProjectWeb/DonHangServlet">Đơn hàng</a> 
		<a href="/ProjectWeb/ChiTietDonHangServlet">Chi tiết đơn hàng</a> 
		<a href="/ProjectWeb/CTKMServlet">Tạo chương trình khuyến mãi</a> 
		<a href="/ProjectWeb/KhuyenMaiServlet">Thời gian khuyến mãi</a>
		<a href="/ProjectWeb/LoaiSanPhamServlet" style="float: right">Loại sản phẩm</a>
		<a href="/ProjectWeb/SanPhamServlet" style="float: right">Sản phẩm của cửa hàng</a>
	</div>

	<div class="row">
		<div class="leftcolumn">
			<div class="card">
				<h2>UY TÍNH LÀM NÊN THƯƠNG HIỆU</h2>
				<h5>Mang lại sự hài lòng cho người tiêu dùng</h5>
				<div class="fakeimg" style="height: 200px;">
					<img src="/ProjectWeb/Root/MainPage/category.jpg"
						style="width: 80%; height: 100%;" />
				</div>
				<p>Casio</p>
				<p>Casio là công ty thiết bị điện tử, nổi tiếng với các sản phẩm
					như đồng hồ, máy tính cầm tay, thiết bị âm thanh, nhạc cụ. Đồng hồ
					Casio thiết kế đa dạng, độ bền cao với nhiều dòng khác nhau như
					G-shock, Baby-G,...đều có doanh số khổng lồ & rất phổ biến ở thị
					trường Việt Nam.</p>
			</div>
			<div class="card">
				<h2>Thông tin cụ thể của Casio</h2>
				<a href="https://www.casio-intl.com/vn/vi/wat/">Casio </a>
			</div>
		</div>
		<div class="rightcolumn">
			<div class="card">
				<h2>Casio</h2>
				<div class="fakeimg" style="height: 100px;">
					<img src="/ProjectWeb/Root/MainPage/contact_hero.jpg"
						style="width: 100%; height: 100%;" />
				</div>
				<p>Thương hiệu của Nhật Bản. Ra đời vào tháng 4 năm 1946.</p>
			</div>
			<div class="card">
				<h3></h3>
				<div class="fakeimg">
					<img src="/ProjectWeb/Root/MainPage/about_hero.png"
						style="width: 100%; height: 100%;" />
				</div>
				<div class="fakeimg">
					<img src="/ProjectWeb/Root/MainPage/Industries_hero.jpg"
						style="width: 100%; height: 100%;" />
				</div>
				<div class="fakeimg">
					<img src="/ProjectWeb/Root/MainPage/category.jpg"
						style="width: 100%; height: 100%;" />
				</div>
			</div>
		</div>
	</div>

</body>
</html>