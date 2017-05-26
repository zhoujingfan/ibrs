<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="common/css/bootstrap.css">
<link rel="stylesheet" href="common/css/ibrs.css">
<script src="common/js/jquery-3.1.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script src="common/js/bootstrap.js"></script>
<title>查看我的发票</title>
</head>
<body>
	<%@include file="../head.jsp"%>

	<div class="padding-top-15">
		<div class="mainpad col-12 row">
			<div class="padding-top-15 padding-bottom-10 col-2">
				<span>预览：</span>
			</div>
			<div class="padding-top-15 padding-bottom-10 col-10"
				style="text-align:right">
				<a href="#">重新选择</a>
			</div>
			<table class="table table-striped">
				<thead class="thead-inverse">
					<tr>
						<c:forEach items="${head }" var="head">
							<th>${head }</th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${invoices }" var="invoice">
						<tr>
							<c:forEach items="${invoice }" var="invoi">
								<td>${invoi}</td>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add_invoice_submit">
				<button class="btn btn-primary">确认添加</button>
			</a>
		</div>
	</div>
</body>
</html>