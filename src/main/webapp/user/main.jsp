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
					<a href="main" class="list-group-item active">首页</a> 
					<a href="myInvoice"
						class="list-group-item">我的发票</a> 
					<a href="my_enterprise"
						class="list-group-item">查看企业</a> 
					
						
				</div>
			</div>
			<div class="row col-10">
					<div class="col-4 infopad">
						<div>
							<h4>欢迎， ${username }</h4>
							<div class="padding-top-15">
								<span>上次登录: ${user.lastLoginTime }</span>
							</div>
							
						<div class="padding-top-15">
							<span><a href="add_invoice">添加发票</a></span>
						</div>
						</div>
					</div>

	
					<div class="col-4 infopad">
						<div>
							<span>报销信息预览：</span>
						</div>
	
						<div class="padding-top-15">
							<span>	报销数量：${expensedNum }</span>
						</div>
						<div class="padding-top-15">
							<span>账户余额：${expensedSum }元</span>
							<a  class="form-register" href="tixian">提现</a>
						</div>
					</div>
					
					
					<div class="col-4 infopad">
						<div>
							<span>我关联的企业：${enterpriseSum } 个</span>
						</div>
	
						<div class="padding-top-15">
							<span><a href="my_enterprise">管理我的企业</a></span>
						</div>
					</div>
			
			</div>
		</div>
	</div>
</body>
</html>