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
		<h1>Chi tiết đơn hàng</h1>
		<h2>
			<a href="ChiTietDonHangServlet?action=new">Thêm chi tiết đơn hàng</a> &nbsp;&nbsp;&nbsp; 
			<a href="/ProjectWeb/Admin/mainadmin.jsp">Trang quản lý</a>
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
			<c:forEach var="ctdh" items="${listOfctdh}">
				<tr>
					<td><c:out value="${ctdh.maDh}" /></td>
					<td><c:out value="${ctdh.maSp}" /></td>
					<td><c:out value="${ctdh.soLuong}" /></td>
					<td><c:out value="${ctdh.gia}" /></td>
					<td>
					<a href="ChiTietDonHangServlet?action=edit&id=<c:out value='${ctdh.id}' />">Chỉnh sửa</a>&nbsp;&nbsp;&nbsp;
					<a href="ChiTietDonHangServlet?action=delete&id=<c:out value='${ctdh.id}' />">Xóa</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>