<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>
</head>
<body>
	<div>
		<h1>Sản phẩm</h1>
		<h2>
			<a href="SanPhamServlet?action=new">Thêm sản phẩm</a>
			&nbsp;&nbsp;&nbsp; <a href="/ProjectWeb/Admin/mainadmin.jsp">Trang
				quản lý</a>
		</h2>
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
				<th>Số lượng kho</th>
				<th>Số lượng bán</th>
				<th>Tính năng</th>
				<th>Mô tả</th>
				<th>Hình</th>
			</tr>
			<c:forEach var="sanpham" items="${listOfSanPham}">
				<tr>
					<td><c:out value="${sanpham.maSp}" /></td>
					<td><c:out value="${sanpham.maLoai}" /></td>
					<td><c:out value="${sanpham.gia}" /></td>
					<td><c:out value="${sanpham.soLuongKho}" /></td>
					<td><c:out value="${sanpham.soLuongBan}" /></td>
					<td><c:out value="${sanpham.tinhNang}" /></td>
					<td><c:out value="${sanpham.moTa}" /></td>
					<td><img
						src="Root/SanPhamImage/${fn:trim(sanpham.maLoai)}/${fn:trim(sanpham.hinh)}.png"
						width="70px" /></td>
					<td><a
						href="SanPhamServlet?action=edit&maSp=<c:out value='${sanpham.maSp}' />">Chỉnh
							sửa</a>&nbsp;&nbsp;&nbsp; <a
						href="SanPhamServlet?action=delete&maSp=<c:out value='${sanpham.maSp}' />">Xóa</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>