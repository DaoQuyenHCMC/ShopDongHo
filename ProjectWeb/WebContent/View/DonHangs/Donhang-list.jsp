<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>
		<a href="/ProjectWeb/Admin/mainadmin.jsp">Trang
				quản lý</a>
		</h2>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Danh sách đơn hàng</h2>
			</caption>
			<tr>
				<th>Mã đơn hàng</th>
				<th>Họ tên người nhận</th>
				<th>Địa chỉ</th>
				<th>Số điện thoại</th>
				<th>Tổng tiền</th>
				<th>Ngày mua</th>
				<th>Trạng thái</th>
			</tr>
			<c:forEach var="donhang" items="${listOfdonhang}">
				<tr>
					<td><c:out value="${donhang.maDh}" /></td>
					<td><c:out value="${donhang.hoTen}" /></td>
					<td><c:out value="${donhang.diaChi}" /></td>
					<td><c:out value="${donhang.sdt}" /></td>
					<td><c:out value="${donhang.tongTien}" /></td>
					<td><c:out value="${donhang.ngayMua}" /></td>
					<td><c:out value="${donhang.trangThai}" /></td>
					<td><a
						href="DonHangServlet?action=edit&maDh=<c:out value='${donhang.maDh}' />">Chỉnh
							sửa</a>&nbsp;&nbsp;&nbsp; <a
						href="DonHangServlet?action=delete&maDh=<c:out value='${donhang.maDh}' />">Xóa</a>&nbsp;&nbsp;&nbsp;
						<a
						href="ChiTietDonHangServlet?maDh=<c:out value='${donhang.maDh}' />">Chi
							tiết</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>