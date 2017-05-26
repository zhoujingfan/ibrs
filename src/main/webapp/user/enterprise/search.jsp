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
					<a href="myRecord" class="list-group-item">我的发票</a> 
					<a href="my_enterprise" class="list-group-item active">查看企业</a> 
				
				</div>
			</div>
			<div class="row col-10">
		
				<div class="mainpad col-12">
					
					<form action="search" class="padding-top-15 form-horizontal" method="post">
						<div class="form-group row">
							<label class="col-2 col-form-label">企业名称</label>
							<div class="col-8">
								<input class="form-control" type="text" name="enterpriseName"/>
							</div>
							<div class="col-2">
								<button class="btn btn-secondary">搜索</button>
							</div>
						</div>
					</form>
				</div>
	
					<c:forEach items="${enterprises }" var="enterpisesss">
						<div class="mainpad col-12" >
						<div class="row">
						<div class="col-10">
							<span>${enterpisesss.name}</span>
							</div>
							<div class="col-2"><a href="add_success?enterpriseName=${enterpisesss.name }">确认关联</a></div>
							</div>
						</div>
					</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>