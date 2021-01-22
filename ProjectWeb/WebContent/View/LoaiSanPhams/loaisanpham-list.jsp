<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loại sản phẩm</title>
</head>
<body>
	<div>
		<h1>Loại sản phẩm</h1>
		<h2>
			<a href="LoaiSanPhamServlet?action=new">Thêm loại sản phẩm</a>
			&nbsp;&nbsp;&nbsp;<a href="/ProjectWeb/Admin/mainadmin.jsp">Trang
				quản lý</a>
		</h2>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Danh sách loại sản phẩm</h2>
			</caption>
			<tr>
				<th>Mã loại</th>
				<th>Tình trạng</th>
			</tr>
			<c:forEach var="loaisanpham" items="${listOfLoaiSanPham}">
				<tr>
					<td><c:out value="${loaisanpham.maLoai}" /></td>
					<td><c:out value="${loaisanpham.tinhTrang}" /></td>
					<td><a
						href="LoaiSanPhamServlet?action=edit&maLoai=<c:out value='${loaisanpham.maLoai}' />">Chỉnh
							sửa</a>&nbsp;&nbsp;&nbsp; <a
						href="LoaiSanPhamServlet?action=delete&maLoai=<c:out value='${loaisanpham.maLoai}' />">Xóa</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>