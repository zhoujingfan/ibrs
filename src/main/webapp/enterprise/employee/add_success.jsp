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
<title>主页</title>
</head>
<body>
	<%@include file="../head.jsp"%>
	<div class="container padding-top-15">
		<div class="row">
			<div class="col-2 bd-sidebar" id="sidebar">
				<div class="list-group">
					<a href="enterprise_show_main" class="list-group-item ">首页</a> <a
						href="myEmployee" class="list-group-item active">员工信息</a> <a
						href="enterprise_invoice" class="list-group-item">发票报销</a> <a
						href="#" class="list-group-item">数据统计</a>

				</div>
			</div>

			<div class="row col-10">
				<div class="mainpad col-12">
					<div class="padding-top-15 padding-bottom-10 row">
						<div class="col-9"><span>添加成功，以下是添加的员工信息预览</span></div>
					</div>
					<table class="table table-striped">
						<thead class="thead-inverse">
							<tr>
								<th>姓名</th>
								<th>身份证号码</th>
								<th>出生日期</th>
								<th>常住地主</th>
								<th>手机号码</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${employee}" var="employees">
								<tr>
								<c:forEach items="${employees }" var="employe">
									<td>${employe}</td>
								</c:forEach>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>