
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<a href="UsersServlet?action=new">Thêm khách hàng</a>
			&nbsp;&nbsp;&nbsp; <a href="UsersServlet?action=list">Danh sách
				khách hàng</a>
		</h2>
	</div>
	<div align="center">
		<c:if test="${user != null}">
			<form action="UsersServlet?action=update" method="post">
		</c:if>
		<c:if test="${user == null}">
			<form action="UsersServlet?action=insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${user != null}">Chỉnh sửa khách hàng</c:if>
					<c:if test="${user == null}">Thêm khách hàng</c:if>
				</h2>
			</caption>
			<c:if test="${user != null}">
				<input type="hidden" name="userId"
					value="<c:out value='${user.userId}' />" />
				<input type="hidden" name="password" size="45"
					value="<c:out value='${user.password}' />" />
				<input type="hidden" name="email" size="45"
					value="<c:out value='${user.email}' />" />
				<input type="hidden" name="sdt" size="45" maxlength="10"
					value="<c:out value='${user.sdt}' />" />
				<input type="hidden" name="address" size="45"
					value="<c:out value='${user.address}' />" />
				<input type="hidden" name="userName" size="45"
					value="<c:out value='${user.userName}' />" />
			</c:if>

			<tr>
				<th>Allowed:</th>
				<td><input type="number" name="allowed" size="45"
					value="<c:out value='${user.allowed}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Lưu" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>