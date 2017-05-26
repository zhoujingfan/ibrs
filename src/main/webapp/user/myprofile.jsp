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
<title>${username }的主页</title>
</head>
<body>
	<%@include file="head.jsp"%>

	<div class="container padding-top-15">
		<div class="row">
			<div class="col-2 bd-sidebar" id="sidebar">
				<div class="list-group">
					<a href="main" class="list-group-item">首页</a> 
					<a href="myInvoice"
						class="list-group-item">我的发票</a> 
					<a href="my_enterprise"
						class="list-group-item">查看企业</a> 
					
						
				</div>
			</div>
			
			<div class="row col-10">
				<div class="mainpad col-12">
					<div class="padding-top-15 padding-bottom-10 form-title">
						<span>个人资料设置：</span>
					</div>
					
					<form class="form-horizontal" action="myprofile_submit" method="post">
						<div class="form-group row">
							<label class="col-2 col-form-label">我的真实姓名：</label>
							<div class="col-10">
								<input class="form-control" type="text" name="truename" value="${user.userInfo.truename}" disabled="true">
							</div>
						</div>
						
							<div class="form-group row">
							<label class="col-2 fol-form-lable">证件号码：</label>
								<div class="col-10">
									<input class="form-control" type="text" name="idNumber" value="${user.userInfo.idNumber }" disabled="true">
								</div>
							</div>
						<div class="form-group row">
							<label class="col-2 fol-form-lable">我的手机号码：</label>
								<div class="col-10">
									<input class="form-control" type="text" name="phoneNumber" value="${user.userInfo.phoneNumber }">
								</div>
							</div>
							<div class="form-group row">
							<label class="col-2 fol-form-lable">我的邮箱：</label>
								<div class="col-10">
									<input class="form-control" type="text" name="email" value="${user.email }">
								</div>
							</div>
							<div class="form-group row">
							<label class="col-2 fol-form-lable">我的地址：</label>
								<div class="col-10">
									<input class="form-control" type="text" name="address" value="${user.userInfo.address }">
								</div>
							</div>
							<div class="text-center">
								<button class="mybtn btn-primary">确定</button>
							</div>
					</form>
				</div>
			
			</div>
		</div>
	</div>
</body>
</html>