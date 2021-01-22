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
	<div>
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

		<div></div>

		<h1>Chương trình khuyến mãi</h1>
		<h2>
			<a href="/ProjectWeb/Admin/mainadmin.jsp">Trang quản lý</a> &nbsp;&nbsp;&nbsp;<a
				href="CTKMServlet?action=list">Danh sách chi tiết khuyến mãi</a>
		</h2>
	</div>
	<div align="center">
		<c:if test="${ctkm != null}">
			<form action="CTKMServlet?action=update" method="post">
		</c:if>
		<c:if test="${ctkm ==null}">
			<form action="CTKMServlet?action=insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${ctkm != null}">Chỉnh sửa chi tiết khuyến mãi</c:if>
					<c:if test="${ctkm == null}">Thêm chi tiết khuyến mãi</c:if>
				</h2>
			</caption>
			<c:if test="${ctkm != null}">
				<input type="hidden" name="id" value="<c:out value='${ctkm.id}' />" />
			</c:if>
			<tr>
				<th>Mã khuyến mãi:</th>
				<td><select name="maKm">

						<c:forEach var="km" items="${listkm.rows}">
							<option value="<c:out value='${km.maKm}' />">${km.maKm}</option>
						</c:forEach>
				</select></td>

			</tr>


			<tr>
				<th>Mã sản phẩm:</th>
				<td><select name="maSp">

						<c:forEach var="sp" items="${listsp.rows}">
							<option value="<c:out value='${sp.maSp}' />">${sp.maSp}</option>
						</c:forEach>
				</select></td>

			</tr>

			<tr>
				<th>Phần trăm khuyến mãi:</th>
				<td><input type="number" name="phanTram" size="45"
					value="<c:out value='${ctkm.phanTram}' />" />
					<p style="color: red">
						<c:out value="${error.phantram}"></c:out>
					</p></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Lưu" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>