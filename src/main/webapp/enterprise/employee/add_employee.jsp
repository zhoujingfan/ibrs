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
				
				<div class=" padding-top-15 padding-bottom-10">
						<span>批量添加员工：</span>
					</div>
				
						<form class="form-horizontal" action="add_employee_submit" enctype="multipart/form-data" method="post">
						<div class="form-group row">
							<input type="file" required="required" class="col-12" name="file">
						</div>
						        <button type="submit" class="btn btn-primary">确认</button>
						
						

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>