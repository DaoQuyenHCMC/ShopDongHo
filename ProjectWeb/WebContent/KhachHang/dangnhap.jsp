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
		<div align="center">
			<form action="TaiKhoan" method="post">
				<table border="1" cellpadding="5">
				<caption><h2>Đăng nhập</h2></caption>
					<tr>
						<th>Tên đăng nhập:</th>
						<td><input type="text" name="userName" size="45" maxlength="30"/>
							<p style="color: red">
								<c:out value="${error.userName}"></c:out>
							</p></td>
					</tr>
					<tr>
						<th>Mật khẩu:</th>
						<td><input type="password" name="password" size="45" maxlength="30"/>
						<p style="color: red"><c:out value="${error.password}"></c:out></p></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Đăng nhập" /></td>
					</tr>
					<input type="hidden" name="action" value="checklogin" />
				</table>
			</form>
		</div>
</body>
</html>