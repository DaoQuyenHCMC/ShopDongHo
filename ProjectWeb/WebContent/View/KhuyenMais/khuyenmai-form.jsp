<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thời gian khuyến mãi</title>
</head>
<body>
<div>
		<h1>Thời gian khuyến mãi</h1>
		<h2>
			<a href="/ProjectWeb/Admin/mainadmin.jsp">Trang quản lý</a>
			<a href="KhuyenMaiServlet?action=list">Danh sách khuyến mãi</a>
		</h2>
	</div>
	<div align="center">
		<c:if test="${khuyenMai != null}">
			<form action="KhuyenMaiServlet?action=update" method="post">
		</c:if>
		<c:if test="${khuyenMai ==null}">
			<form action="KhuyenMaiServlet?action=insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${khuyenMai != null}">Chỉnh sửa khuyến mãi</c:if>
					<c:if test="${khuyenMai == null}">Thêm khuyến mãi</c:if>
				</h2>
			</caption>
			<c:if test="${khuyenMai != null}">
				<input type="hidden" name="maKm" value="<c:out value='${khuyenMai.maKm}' />" />
			</c:if>
			<tr>
				<th>Ngày bắt đầu:</th>
				<td><input type="date" name="thoigianBd" size="45"
					value="<c:out value='${khuyenMai.thoiGianBd}' />" /></td>
			</tr>
			<tr>
				<th>Ngày kết thúc:</th>
				<td><input type="date" name="thoigianKt" size="45"
					value="<c:out value='${khuyenMai.thoiGianKt}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Lưu" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>