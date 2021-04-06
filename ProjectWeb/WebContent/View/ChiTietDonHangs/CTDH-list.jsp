<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div>
		<h2>
			<c:if test="${empty cart}">
					<a href="/ProjectWeb/Admin/mainadmin.jsp">Trang quản lý</a>
			</c:if>
			<c:if test="${not empty cart}">
					<a href="/ProjectWeb/DonHangServlet?action=lichsumuahang">Trở về</a>
			</c:if>

		</h2>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Danh sách chi tiết đơn hàng</h2>
			</caption>
			<tr>
				<th>Mã đơn hàng</th>
				<th>Mã sản phẩm</th>
				<th>Số lượng</th>
				<th>Giá</th>
			</tr>
			<c:forEach var="ctdh" items="${listctdh}">
				<tr>
					<td><c:out value="${ctdh.maDh}" /></td>
					<td><c:out value="${ctdh.maSp}" /></td>
					<td><c:out value="${ctdh.soLuong}" /></td>
					<td><c:out value="${ctdh.gia}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>