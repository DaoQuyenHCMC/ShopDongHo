<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách tài khoản</title>
</head>
<body>
<div>
		<h2>
			<a href="/ProjectWeb/Admin/mainadmin.jsp">Trang quản lý</a>
		</h2>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Danh sách tài khoản</h2>
			</caption>
			<tr>
				<th>Tên đăng nhập</th>
				<th>Email</th>
				<th>Số điện thoại</th>
				<th>Địa chỉ</th>
				<th>Allowed</th>
			</tr>
			<c:forEach var="user" items="${listUser}">
				<tr>
					<td><c:out value="${user.userName}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.sdt}" /></td>
					<td><c:out value="${user.address}" /></td>
					<td><c:if test="${user.allowed eq 1}">Quản lý</c:if>
					<c:if test="${user.allowed eq 2}">Khách hàng</c:if></td>
					<td>
					<form action="TaiKhoan" method="post">
							<input type="submit" value="Chỉnh sửa" style="width:100px"/>
							<input type="hidden" name="action" value="edit" />	
							<input type="hidden" name="id" value="<c:out value='${user.userId}' />" />							
					</form>
					<form action="TaiKhoan" method="post">
							<input type="submit" value="Xóa" style="width:100px"/>
							<input type="hidden" name="action" value="delete" />	
							<input type="hidden" name="id" value="<c:out value='${user.userId}' />" />							
					</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>