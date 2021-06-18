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
		<h2>
			<form action="LoaiSanPham" method="post">
				<input type="submit" value="Thêm loại sản phẩm" style="width: 200px" />
				<input type="hidden" name="action" value="new" />
			</form>
			<a href="Admin/mainadmin.jsp">Trang quản lý</a>
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
					<td>
						<form action="LoaiSanPham" method="post">
							<input type="submit" value="Chỉnh sửa" style="width: 100px" /> <input
								type="hidden" name="action" value="edit" /> <input
								type="hidden" name="maLoai"
								value="<c:out value='${loaisanpham.maLoai}' />" />
						</form>
						<form action="LoaiSanPham" method="post">
							<input type="submit" value="Xóa" style="width: 100px" /> <input
								type="hidden" name="action" value="delete" /> <input
								type="hidden" name="maLoai"
								value="<c:out value='${loaisanpham.maLoai}' />" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>