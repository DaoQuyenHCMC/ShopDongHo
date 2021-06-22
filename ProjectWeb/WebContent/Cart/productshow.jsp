<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sản phẩm</title>
</head>
<body>
	<div>
		<h1>Sản phẩm</h1>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Danh sách sản phẩm</h2>
			</caption>
			<tr>
				<th>Mã sản phẩm</th>
				<th>Mã loại</th>
				<th>Giá</th>
				<th>Tính năng</th>
				<th>Mô tả</th>
				<th>Hình</th>
				<th>Số lượng</th>
			</tr>
			<c:forEach var="sanpham" items="${listOfSanPham}">
				<tr>
					<td><c:out value="${sanpham.maSp}" /></td>
					<td><c:out value="${sanpham.maLoai}" /></td>
					<td><c:out value="${sanpham.gia}" /></td>
					<td><c:out value="${sanpham.tinhNang}" /></td>
					<td><c:out value="${sanpham.moTa}" /></td>
					<td><img
						src="Root/SanPhamImage/${fn:trim(sanpham.maLoai)}/${fn:trim(sanpham.hinh)}.png"
						width="70px" /></td>
					<td>
					<form action="./../GioHang" method="post">
						<input type="submit" value="Mua hàng" class="addtocart"/>
						<input type="hidden" name="action" value="buy" />	
						<input type="hidden" name="quantity" value="1" />
						<input type="hidden" name="maSp" value="<c:out value='${sanpham.maSp}' />" />						
					</form>
					</td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>