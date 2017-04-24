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
<title>关联企业</title>
</head>
<body>
	<%@include file="../head.jsp"%>

	<div class="container padding-top-15">
		<div class="row">
			<div class="col-2 bd-sidebar" id="sidebar">
				<div class="list-group">
					<a href="main" class="list-group-item ">首页</a> 
					<a href="myInvoice" class="list-group-item active">我的发票</a> 
					<a href="my_enterprise" class="list-group-item">查看企业</a> 
					<a href="myRecord" class="list-group-item">交易记录</a> 
					
				</div>
			</div>
			<div class="row col-10">
		
				<div class="mainpad col-12">
					<h3>
						添加成功
					</h3>
					<a href="myInvoice">返回</a>
				</div>
	
			</div>
		</div>
	</div>
</body>
</html>