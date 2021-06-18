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



	<sql:query dataSource="${snapshot}" var="listsp">
            SELECT * from SanPham;
         </sql:query>

	<sql:query dataSource="${snapshot}" var="listdonhang">
            SELECT * from DonHang;
         </sql:query>

	<div>
		<h1>Chi tiết đơn hàng</h1>
		<h2>
			<a href="/ProjectWeb/Admin/mainadmin.jsp">Trang quản lý</a> 
			&nbsp;&nbsp;&nbsp; <a href="ChiTietDonHang?action=list">Danh
				sách chi tiết đơn hàng</a>
		</h2>
	</div>
	<div align="center">
		<c:if test="${ctdh != null}">
			<form action="ChiTietDonHang?action=update" method="post">
		</c:if>
		<c:if test="${ctdh ==null}">
			<form action="ChiTietDonHang?action=insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${ctdh != null}">Chỉnh sửa chi tiết đơn hàng</c:if>
					<c:if test="${ctdh == null}">Thêm chi tiết đơn hàng</c:if>
				</h2>
			</caption>
			<c:if test="${ctdh != null}">
				<input type="hidden" name="id" value="<c:out value='${ctdh.id}' />" />
			</c:if>
			<tr>
				<th>Mã đơn hàng:</th>
				<td><select name="maDh">

						<c:forEach var="dh" items="${listdonhang.rows}">
							<option value="<c:out value='${dh.MaDH}' />">${dh.MaDH}</option>
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
				<th>Số lượng:</th>
				<td><input type="number" name="soLuong"
					value="<c:out value='${ctdh.soLuong}' />" />
					<p style="color: red">
						<c:out value="${error.soLuong}"></c:out>
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