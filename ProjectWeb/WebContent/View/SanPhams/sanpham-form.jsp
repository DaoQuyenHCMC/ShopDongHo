<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>
</head>
<body>
	<sql:setDataSource var="snapshot"
		driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		url="jdbc:sqlserver://localhost;integratedSecurity=True;databaseName=CASIO"
		user="localhost" password="root" />

	<sql:query dataSource="${snapshot}" var="listloaisp">
            SELECT * from LoaiSanPham;
         </sql:query>

	<div>
		<h1>Sản phẩm</h1>
		<h2>
			<form action="SanPham" method="post">
				<input type="submit" value="Danh sách sản phẩm" style="width: 200px" />
				<input type="hidden" name="action" value="list" />
			</form>
			<a href="Admin/mainadmin.jsp">Trang quản lý</a>
		</h2>
	</div>
	<div align="center">
		<c:if test="${sanpham != null}">
			<form action="SanPham" method="post">
		</c:if>
		<c:if test="${sanpham ==null}">
			<form action="SanPham" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${sanpham != null}">Chỉnh sửa sản phẩm</c:if>
					<c:if test="${sanpham == null}">Thêm sản phẩm</c:if>
				</h2>
			</caption>
			<tr>
				<th>Mã sản phẩm:</th>
				<td><input type="text" name="maSp" size="45" maxlength="30"
					value="<c:out value='${sanpham.maSp}' />" />
					<p style="color: red">
						<c:out value="${error.maSp}"></c:out>
					</p></td>
			</tr>
			<tr>
				<th>Mã loại:</th>
				<td><select name="maLoai">

						<c:forEach var="loaisp" items="${listloaisp.rows}">
							<option value="<c:out value='${loaisp.MaLoai}' />"><c:out
									value='${loaisp.MaLoai}' /></option>
						</c:forEach>
				</select></td>
			<tr>


			</tr>


			<tr>
				<th>Giá:</th>
				<td><input type="text" name="gia" size="45"
					value="<c:out value='${sanpham.gia}' />" />
					<p style="color: red">
						<c:out value="${error.gia}"></c:out>
					</p></td>
			</tr>
			<tr>
				<th>Số lượng kho:</th>
				<td><input type="number" name="soLuongKho" size="45"
					value="<c:out value='${sanpham.soLuongKho}' />" />
					<p style="color: red">
						<c:out value="${error.soLuongKho}"></c:out>
					</p></td>
			</tr>
			<tr>
				<th>Số lượng bán:</th>
				<td><input type="number" name="soLuongBan" size="45"
					value="<c:out value='${sanpham.soLuongBan}' />" />
					<p style="color: red">
						<c:out value="${error.soLuongBan}"></c:out>
					</p></td>
			</tr>
			<tr>
				<th>Tính năng:</th>
				<td><input type="text" name="tinhNang" size="45"
					value="<c:out value='${sanpham.tinhNang}' />" /></td>
			</tr>
			<tr>
				<th>Mô tả:</th>
				<td><input type="text" name="moTa" size="45"
					value="<c:out value='${sanpham.moTa}' />" /></td>
			</tr>
			<tr>
				<th>Hình:</th>
				<td><input type="text" name="hinh" size="45"
					value="<c:out value='${sanpham.hinh}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Lưu" /></td>
			</tr>
			<c:if test="${sanpham != null}">
				<input type="hidden" name="action" value="update" />
			</c:if>
			<c:if test="${sanpham ==null}">
				<input type="hidden" name="action" value="insert" />
			</c:if>
		</table>
		</form>
	</div>
</body>
</html>