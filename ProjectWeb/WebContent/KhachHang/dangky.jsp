<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
</head>
<body>
	<div>
		<h1>Đăng ký tài khoản</h1>
		<div align="center">
			<form action="UsersServlet?action=insert4dangky" method="post">
				<table border="1" cellpadding="5">
					<tr>
						<th>Tên đăng nhập:</th>
						<td><input type="text" name="userName" size="45"/>
						<p style="color: red"><c:out value="${error.userName}"></c:out></p></td>
					</tr>
					<tr>
						<th>Mật khẩu:</th>
						<td><input type="password" name="password" size="45" />
						<p style="color: red"><c:out value="${error.password}"></c:out></p></td>
					</tr>
					<tr>
						<th>Email:</th>
						<td><input type="text" name="email" size="45"/>
						<p style="color: red"><c:out value="${error.email}"></c:out></p></td>
					</tr>
					<tr>
						<th>Số điện thoại:</th>
						<td><input type="text" name="sdt" size="45" maxlength="10"/>
						<p style="color: red"><c:out value="${error.sdt}"></c:out></p></td>
					</tr>
					<tr>
						<th>Địa chỉ:</th>
						<td><input type="text" name="address" size="45" />
						<p style="color: red"><c:out value="${error.address}"></c:out></p></td>
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