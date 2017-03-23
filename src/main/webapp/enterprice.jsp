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
<title> ${user.username }的主页</title>
</head>
<body>
	<%@include file="head.jsp"%>

	<div class="container padding-top">
		<div class="row">
			<div class="col-2 bd-sidebar" id="sidebar">
				<div class="list-group">
					<a href="#" class="list-group-item">首页</a> <a href="#"
						class="list-group-item">我的发票</a> <a href="#"
						class="list-group-item active">查看企业</a> <a href="#"
						class="list-group-item">交易记录</a> <a href="#"
						class="list-group-item">呵呵哒</a>
				</div>
			</div>
			<div class="row col-10">
			
				
	
			</div>
		</div>
	</div>
</body>
</html>