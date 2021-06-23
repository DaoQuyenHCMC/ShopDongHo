<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lịch sử mua hàng</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Đơn hàng</th>
                        <th>Mã đơn</th>
                        <th class="text-center">Giá</th>
                        <th class="text-center">Ngày đặt hàng</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach var="donhang" items="${listdonhang}">
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="ChiTietDonHang?maDh=<c:out value='${donhang.maDh}' />">Chi tiết</a></h4>
                                <h5 class="media-heading"> Địa chỉ: <a href="#"><c:out value="${donhang.diaChi}" /></a></h5>
                                <span>Tình trạng: </span><span class="text-success"><strong><c:out value="${donhang.trangThai}" /></strong></span>
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                        <input type="email" class="form-control" id="exampleInputEmail1" value="<c:out value="${donhang.maDh}" />">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong><c:out value="${donhang.tongTien}" /></strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong><c:out value="${donhang.ngayMua}" /></strong></td>
                    </tr>
                    </c:forEach>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span>
                            <form action="TaiKhoan" method="post">
								<input type="submit" value="Tiếp tục mua hàng" style="text-decoration: none;  font-size: 18px; height:30px"/>
								<input type="hidden" name="action" value="shoppingcontinue" />							
							</form>
                        </button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>