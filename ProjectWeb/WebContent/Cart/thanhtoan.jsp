<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="snapshot"
		driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		url="jdbc:sqlserver://localhost;integratedSecurity=True;databaseName=CASIO"
		user="localhost" password="root" />
	<sql:query dataSource="${snapshot}" var="listkh">
            SELECT * from Users;
         </sql:query>
	<div>
		<h1>Đơn hàng</h1>
	</div>
	<div align="center">
		<form
			action="/ProjectWeb/UsersServlet?action=shoppingcontinue"
			method="post">
			<table border="1" cellpadding="5">
				<input type="hidden" name="tongTien"
					value="<c:out value='${tong}' />" />
				<input type="hidden" name="trangThai" maxlength="10" size="45"
					value="Chờ xác nhận" />
				<tr>
					<th>Họ tên người nhận:</th>
					<td><input type="text" name="hoTen" size="45"
						value="<c:out value='${donhang.hoTen}' />" />
						<p style="color: red">
							<c:out value="${error.hoTen}"></c:out>
						</p></td>
				</tr>
				<tr>
					<th>Địa chỉ:</th>
					<td><input type="text" name="diaChi" size="45"
						value="<c:out value='${donhang.diaChi}' />" />
						<p style="color: red">
							<c:out value="${error.diaChi}"></c:out>
						</p></td>
				</tr>
				<tr>
					<th>Số điện thoại:</th>
					<td><input type="text" name="sdt" maxlength="10" size="45"
						value="<c:out value='${donhang.sdt}' />" />
						<p style="color: red">
							<c:out value="${error.sdt}"></c:out>
						</p></td>
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