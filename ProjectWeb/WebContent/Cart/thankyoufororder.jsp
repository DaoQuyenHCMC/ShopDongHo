<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<style type="text/css">
body, table, td, a {
	-webkit-text-size-adjust: 100%;
	-ms-text-size-adjust: 100%;
}

table, td {
	mso-table-lspace: 0pt;
	mso-table-rspace: 0pt;
}

img {
	-ms-interpolation-mode: bicubic;
}

img {
	border: 0;
	height: auto;
	line-height: 100%;
	outline: none;
	text-decoration: none;
}

table {
	border-collapse: collapse !important;
}

body {
	height: 100% !important;
	margin: 0 !important;
	padding: 0 !important;
	width: 100% !important;
}

a[x-apple-data-detectors] {
	color: inherit !important;
	text-decoration: none !important;
	font-size: inherit !important;
	font-family: inherit !important;
	font-weight: inherit !important;
	line-height: inherit !important;
}

@media screen and (max-width: 480px) {
	.mobile-hide {
		display: none !important;
	}
	.mobile-center {
		text-align: center !important;
	}
}

div[style*="margin: 16px 0;"] {
	margin: 0 !important;
}
</style>
</head>
<body
	style="margin: 0 !important; padding: 0 !important; background-color: #eeeeee;"
	bgcolor="#eeeeee">
	<div
		style="display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: Open Sans, Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;">
		For what reason would it be advisable for me to think about business
		content? That might be little bit risky to have crew member like them.
	</div>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td align="center" style="background-color: #eeeeee;"
				bgcolor="#eeeeee">
				<table align="center" border="0" cellpadding="0" cellspacing="0"
					width="100%" style="max-width: 600px;">
					<tr>
						<td align="center" valign="top"
							style="font-size: 0; padding: 35px;" bgcolor="#F44336">
							<div
								style="display: inline-block; max-width: 50%; min-width: 100px; vertical-align: top; width: 100%;">
								<table align="left" border="0" cellpadding="0" cellspacing="0"
									width="100%" style="max-width: 300px;">
									<tr>
										<td align="left" valign="top"
											style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 36px; font-weight: 800; line-height: 48px;"
											class="mobile-center">
											<h1
												style="font-size: 36px; font-weight: 800; margin: 0; color: #ffffff;">Casio</h1>
										</td>
									</tr>
								</table>
							</div>
							<div
								style="display: inline-block; max-width: 50%; min-width: 100px; vertical-align: top; width: 100%;"
								class="mobile-hide">
								<table align="left" border="0" cellpadding="0" cellspacing="0"
									width="100%" style="max-width: 300px;">
									<tr>
										<td align="right" valign="top"
											style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; line-height: 48px;">
											<table cellspacing="0" cellpadding="0" border="0"
												align="right">
												<tr>
													<td
														style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400;">
														<p
															style="font-size: 18px; font-weight: 400; margin: 0; color: #ffffff;">
															<a href="CartServlet?action=tieptucmuahang" target="_blank"
																style="color: #ffffff; text-decoration: none;">Cửa hàng
																&nbsp;</a>
														</p>
													</td>
													<td
														style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 24px;">
														<a href="#" target="_blank"
														style="color: #ffffff; text-decoration: none;"><img
															src="https://img.icons8.com/color/48/000000/small-business.png"
															width="27" height="23"
															style="display: block; border: 0px;" /></a>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td align="center"
							style="padding: 35px 35px 20px 35px; background-color: #ffffff;"
							bgcolor="#ffffff">
							<table align="center" border="0" cellpadding="0" cellspacing="0"
								width="100%" style="max-width: 600px;">
								<tr>
									<td align="center"
										style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 25px;">
										<img
										src="https://img.icons8.com/carbon-copy/100/000000/checked-checkbox.png"
										width="125" height="120" style="display: block; border: 0px;" /><br>
										<h2
											style="font-size: 30px; font-weight: 800; line-height: 36px; color: #333333; margin: 0;">
											Đơn hàng</h2>
									</td>
								</tr>
								<tr>
									<td align="left"
										style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 10px;">
										<p
											style="font-size: 16px; font-weight: 400; line-height: 24px; color: #777777;">
											Website Casio ủy quyền chính thức tại Việt Nam </p>
									</td>
								</tr>
								<c:forEach var="i" begin="0" end="${cart.GetSize()-1}">
								<tr>
									<td align="left" style="padding-top: 20px;">
										<table cellspacing="0" cellpadding="0" border="0" width="100%">
											<tr>
												<td width="75%" align="left" bgcolor="#eeeeee"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;">
													Mã sản phẩm #</td>
												<td width="25%" align="left" bgcolor="#eeeeee"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;">
													<c:out value="${cart.getItems(i).maSp}" /></td>
											</tr>
											<tr>
												<td width="75%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;">
													Giá</td>
												<td width="25%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;">
													<c:out value="${cart.getItems(i).getGiaGoc()}" /></td>
											</tr>
											<tr>
												<td width="75%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 5px 10px;">
													Số lượng</td>
												<td width="25%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 5px 10px;">
													<c:out value="${cart.getItems(i).quantity}" /></td>
											</tr>
											<tr>
												<td width="75%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 5px 10px;">
													Khuyến mãi</td>
												<td width="25%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 5px 10px;">
													<c:out value="${cart.getItems(i).getGia()}" /></td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td align="left" style="padding-top: 20px;">
										<table cellspacing="0" cellpadding="0" border="0" width="100%">
											<tr>
												<td width="75%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;">
													Thành tiền</td>
												<td width="25%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;">
													<c:out value="${cart.getItems(i).getGia()}" /></td>
											</tr>
										</table>
									</td>
								</tr>
								</c:forEach>
								<tr>
									<td align="left" style="padding-top: 20px;">
										<table cellspacing="0" cellpadding="0" border="0" width="100%">
											<tr>
												<td width="75%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;">
													Tổng tiền</td>
												<td width="25%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;">
													<c:out value="${tong}" /></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td align="center" height="100%" valign="top" width="100%"
							style="padding: 0 35px 35px 35px; background-color: #ffffff;"
							bgcolor="#ffffff">
							<table align="center" border="0" cellpadding="0" cellspacing="0"
								width="100%" style="max-width: 660px;">
								<tr>
									<td align="center" valign="top" style="font-size: 0;">
										<div
											style="display: inline-block; max-width: 50%; min-width: 240px; vertical-align: top; width: 100%;">
											<table align="left" border="0" cellpadding="0"
												cellspacing="0" width="100%" style="max-width: 300px;">
												<tr>
													<td align="left" valign="top"
														style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px;">
														<p style="font-weight: 800;">Địa chỉ</p>
														<p>
															<c:out value="${diaChi}" />
														</p>
													</td>
												</tr>
											</table>
										</div>
										<div
											style="display: inline-block; max-width: 50%; min-width: 240px; vertical-align: top; width: 100%;">
											<table align="left" border="0" cellpadding="0"
												cellspacing="0" width="100%" style="max-width: 300px;">
												<tr>
													<td align="left" valign="top"
														style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px;">
														<p style="font-weight: 800;">Số điện thoại người nhận</p>
														<c:out value="${sdt}" />
													</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td align="center"
							style="padding: 35px; background-color: #ff7361;"
							bgcolor="#1b9ba3">
							<table align="center" border="0" cellpadding="0" cellspacing="0"
								width="100%" style="max-width: 600px;">
								<tr>
									<td align="center"
										style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 25px;">
										<h2
											style="font-size: 24px; font-weight: 800; line-height: 30px; color: #ffffff; margin: 0;">
											Đơn hàng đã được tiếp nhận</h2>
									</td>
								</tr>
								<tr>
									<td align="center" style="padding: 25px 0 15px 0;">
										<table border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td align="center" style="border-radius: 5px;"
													bgcolor="#66b3b7"><a href="CartServlet?action=tieptucmuahang"
													style="font-size: 18px; font-family: Open Sans, Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; border-radius: 5px; background-color: #F44336; padding: 15px 30px; border: 1px solid #F44336; display: block;">
													Mua hàng</a></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>