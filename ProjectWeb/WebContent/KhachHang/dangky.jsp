<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Đăng ký</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
body {
	background-color: #63738a;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	height: 100vh;
}
.center {
	width: 100%;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	/* (x, y)  => position */
	-ms-transform: translate(-50%, -50%);
	/* IE 9 */
	-webkit-transform: translate(-50%, -50%);
	/* Chrome, Safari, Opera */
}
table {
	width: 50%;
	margin: 0 auto;
	padding: 2%;

	border-radius: 4px;
	background-color: #f2f3f7;
	min-width: 360px;
	max-width: 420px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	border: 1px solid #58677B;
}
input[type=text], [type=email], [type=password], [type=submit] {
	width: 100%;
	height: 40px;
	padding: 12px;
	border: 1px solid #cccccc;
	border-radius: 3px;
	outline: none;
	font-size: 14px;
	color: #4fa64e;
}

input:hover {
	border-color: #4fa64e;
}
input[type=submit] {
	background-color: #53ac53;
	background: linear-gradient(to bottom, #58b358 0%, #449944 100%);
	color: #ffffff;
	font-weight: 600;
	border: none;
}
input[type=submit]:hover {
	cursor: pointer;
}
::placeholder {
	color: #969fa4;
}
p {
	text-align: center;
	font-size: 14px;
	color: #969fa4;
	margin: 12px 0;
}
input[type="checkbox"] {
	vertical-align: middle;
	height: 14px;
	width: 14px;
	background-color: red;
}
.terms>label {
	font-size: 14px;
	color: #969fa4;
	margin-left: 6px;
}
div {
	margin: 10px 0;
}
a {
	color: #4fa64e;
	text-decoration: none;
}
footer {
	margin-top: 16px;
}
footer>p {
	color: #ffffff;
}
footer>p>a {
	color: #ffffff;
	text-decoration: underline;
}
.dash {

	min-height: 2px;
	height: 2px;
	max-height: 2px;
	width: 100%;
	background-color: #D4D4D4;
}
h1 {
	text-align: center;
	font-weight: 500;
	color: #636363;
	text-align: 30px;
}
.top {
	width: 100%;
	background-color: salmon;
}
</style>
</head>
<body>
	<div class="center">
	<form action="TaiKhoan" method="post">
		<table>
			<tr>
				<td style="width: 33.33%;">
					<div class="dash"></div>
				</td>
				<td style="padding: 0 6px;">
					<h1>Đăng ký</h1>
				</td>
				<td style="width: 33.33%;">
					<div class="dash"></div>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<p>Đăng ký tài khoản dành riêng cho bạn</p>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<div>
						<input placeholder="Tên đăng nhập" type="text" name="userName" size="45" maxlength="30"/> 
						<p style="color: red"><c:out value="${error.userName}"></c:out></p>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<div>
						<input placeholder="Mật khẩu" type="password" name="password" size="45" maxlength="30">
						<p style="color: red"><c:out value="${error.password}"></c:out></p>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<div>
						<input type="email" placeholder="Email" name="email" size="45" maxlength="30">
						<p style="color: red"><c:out value="${error.email}"></c:out></p>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<div>
						<input type="text" name="sdt" size="45" maxlength="10" placeholder="Số điện thoại"/>
						<p style="color: red"><c:out value="${error.sdt}"></c:out></p>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<div>
						<input type="text" name="address" size="45" maxlength="30" placeholder="Địa chỉ"/>
						<p style="color: red"><c:out value="${error.address}"></c:out></p>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<div>
						<input type="submit" value="Đăng ký">
					</div>
				</td>
			</tr>
			<input type="hidden" name="action" value="insert4dangky" />
		</table>
		</form>

	</div>
</body>
</html>