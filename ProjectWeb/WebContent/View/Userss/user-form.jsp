
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tài khoản</title>
</head>
<body>
	<div>
		<h2>
		<form action="TaiKhoan" method="post">
			<input type="submit" value="Danh sách khách hàng" style="width:200px"/>			
		</form>
		</h2>
	</div>
	<div align="center">
		<c:if test="${user != null}">
			<form action="TaiKhoan" method="post">
		</c:if>
		<c:if test="${user == null}">
			<form action="TaiKhoan" method="post">
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
		<c:if test="${user != null}">
			<input type="hidden" name="action" value="update" />
		</c:if>
		<c:if test="${user == null}">
			<input type="hidden" name="action" value="insert" />
		</c:if>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Lưu" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>