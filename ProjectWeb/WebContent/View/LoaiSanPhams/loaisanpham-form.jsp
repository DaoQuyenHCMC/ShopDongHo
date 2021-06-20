<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loại sản phẩm</title>
</head>
<body>
	<div>
		<h2>
			<form action="LoaiSanPham" method="post">
				<input type="submit" value="Danh sách loại sản phẩm" style="width: 200px" />
				<input type="hidden" name="action" value="list" />
			</form>
			<form action="TaiKhoan" method="post">
				<input type="submit" value="Trang quản lý" style="width: 200px" />
				<input type="hidden" name="action" value="checkquanly" />		
			</form>
		</h2>
	</div>
	<div align="center">
		<c:if test="${loaisanpham != null}">
			<form action="LoaiSanPham" method="post">
		</c:if>
		<c:if test="${loaisanpham ==null}">
			<form action="LoaiSanPham" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${loaisanpham != null}">Chỉnh sửa loại sản phẩm</c:if>
					<c:if test="${loaisanpham == null}">Thêm loại sản phẩm</c:if>
				</h2>
			</caption>
			<tr>
				<th>Mã loại:</th>
				<td><input type="text" name="maLoai" size="45"
					value="<c:out value='${loaisanpham.maLoai}' />" />
					<p style="color: red"><c:out value="${error.maLoai}"></c:out></p>
					</td>
			</tr>
			<tr>
				<th>Tình trạng:</th>
				<td><select name="tinhTrang">
						<option value="Còn hàng"
							<c:if test="${donhang.trangThai eq 'Còn hàng'  }">
							selected 
						</c:if>>Còn hàng</option>
						<option value="Ngưng bán"
							<c:if test="${donhang.trangThai eq 'Ngưng bán'  }">
							selected 
						</c:if>>Ngưng
							bán</option>
						<option value="Tạm hết hàng"
							<c:if test="${donhang.trangThai eq 'Tạm hết hàng'  }">
							selected 
						</c:if>>Tạm
							hết hàng</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Lưu" /></td>
			</tr>
		</table>
		<c:if test="${loaisanpham != null}">
			<input type="hidden" name="action" value="update" />
		</c:if>
		<c:if test="${loaisanpham ==null}">
			<input type="hidden" name="action" value="insert" />
		</c:if>
		</form>
	</div>
</body>
</html>