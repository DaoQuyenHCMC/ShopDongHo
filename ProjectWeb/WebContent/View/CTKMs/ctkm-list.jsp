<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chương trình khuyến mãi</title>
</head>
<body>
	<sql:setDataSource var="snapshot"
		driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		url="jdbc:sqlserver://localhost;integratedSecurity=True;databaseName=CASIO"
		user="localhost" password="root" />

	<sql:query dataSource="${snapshot}" var="listkm">
            SELECT * from KhuyenMai;
         </sql:query>

	<sql:query dataSource="${snapshot}" var="listsp">
            SELECT * from SanPham;
         </sql:query>
	<div>
		<h1>Chương trình khuyến mãi</h1>
		<h2>
			<a href="CTKMServlet?action=new">Thêm chương trình khuyến mãi</a>
			&nbsp;&nbsp;&nbsp; <a href="/ProjectWeb/Admin/mainadmin.jsp">Trang
				quản lý</a>
		</h2>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Danh sách chương trình khuyến mãi</h2>
			</caption>
			<tr>
				<th>Mã chương trình khuyến mãi</th>
				<th>Mã khuyến mãi</th>
				<th>Mã sản phẩm</th>
				<th>Phần trăm khuyến mãi</th>
			</tr>
			<c:forEach var="ctkm" items="${listOfctkm}">
				<tr>
					<td><c:out value="${ctkm.id}" /></td>
					<td><c:out value="${ctkm.maKm}" /></td>
					<td><c:out value="${ctkm.maSp}" /></td>
					<td><c:out value="${ctkm.phanTram}" /></td>
					<td><a
						href="CTKMServlet?action=edit&id=<c:out value='${ctkm.id}' />">Chỉnh
							sửa</a>&nbsp;&nbsp;&nbsp; <a
						href="CTKMServlet?action=delete&id=<c:out value='${ctkm.id}' />">Xóa</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>