<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<h1>Khách hàng</h1>
		<h2>
			<a href="/ProjectWeb/Admin/mainadmin.jsp">Trang quản lý</a>
		</h2>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Danh sách khách hàng</h2>
			</caption>
			<tr>
				<th>Tên đăng nhập</th>
				<th>Mật khẩu</th>
				<th>Email</th>
				<th>Số điện thoại</th>
				<th>Địa chỉ</th>
				<th>Allowed</th>
			</tr>
			<c:forEach var="user" items="${listUser}">
				<tr>
					<td><c:out value="${user.userName}" /></td>
					<td><c:out value="${user.password}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.sdt}" /></td>
					<td><c:out value="${user.address}" /></td>
					<td><c:if test="${user.allowed eq 1}">Quản lý</c:if>
					<c:if test="${user.allowed eq 2}">Khách hàng</c:if></td>
					<td>
					<a href="UsersServlet?action=edit&id=<c:out value='${user.userId}' />">Chỉnh sửa</a>&nbsp;&nbsp;&nbsp;
					<a href="UsersServlet?action=delete&id=<c:out value='${user.userId}' />">Xóa</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>