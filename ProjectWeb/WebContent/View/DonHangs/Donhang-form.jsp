<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đơn hàng</title>
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
		<h2>
			<form action="TaiKhoan" method="post">
				<input type="submit" value="Trang quản lý" style="width: 200px" />
				<input type="hidden" name="action" value="checkquanly" />		
					
			</form>
			&nbsp;&nbsp;&nbsp; <a href="DonHang">Danh sách
				đơn hàng</a>
		</h2>
	</div>
	<div align="center">
		<c:if test="${donhang != null}">
			<form action="DonHang" method="post">
		</c:if>
		<c:if test="${donhang ==null}">
			<form action="DonHang" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${donhang != null}">Chỉnh sửa đơn hàng</c:if>
					<c:if test="${donhang == null}">Thêm đơn hàng</c:if>
				</h2>
			</caption>
			<c:if test="${donhang != null}">
				<input type="hidden" name="maDh"
					value="<c:out value='${donhang.maDh}' />" />
					<input type="hidden" name="tongTien"
					value="<c:out value='${donhang.tongTien}' />" />
			</c:if>
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
				<th>Trạng thái:</th>
				<td><select name="trangThai">
						<option value="Chờ xác nhận"
							<c:if test="${donhang.trangThai == 'Chờ xác nhận'  }">
							selected 
						</c:if>>Chờ
							xác nhận</option>
						<option value="Chờ lấy hàng"
							<c:if test="${donhang.trangThai == 'Chờ lấy hàng'  }">
							selected 
						</c:if>>Chờ
							lấy hàng</option>
						<option value="Đang giao"
							<c:if test="${donhang.trangThai == 'Chờ đang giao'  }">
							selected 
						</c:if>>Đang
							giao</option>
						<option value="Đã giao"
							<c:if test="${donhang.trangThai == 'Đã giao'  }">
							selected 
						</c:if>>Đã
							giao</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Lưu" /></td>
			</tr>
		</table>
		<c:if test="${donhang != null}">
			<input type="hidden" name="action" value="update" />
		</c:if>
		<c:if test="${donhang ==null}">
			<input type="hidden" name="action" value="insert" />
		</c:if>
		</form>
	</div>
</body>
</html>