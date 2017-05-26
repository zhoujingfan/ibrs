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
<title>添加发票</title>
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
					</div>
			</div>
			<div class="row col-10">

				<div class="mainpad col-12">
					<div class=" padding-top-15 padding-bottom-10">
						<span>填写发票信息：</span>
					</div>

					<form class="form-horizontal" action="add_review" enctype="multipart/form-data" method="post">
					
					
						<div class="form-group row">
							<label for="label-choose-enterprise" class="col-2 col-form-label">选择报销的企业</label>
							<div class="col-9">
							<select class="form-control" name = "enterprise"> 
								<c:forEach items="${myEnterprise}" var="enterprises">
									<option> ${enterprises.enterpriseId.name }</option>
								</c:forEach>
							</select>
							</div>
						</div>
						<div class="form-group row">
							<input type="file"  required="required" class="col-12" name="file">
						</div>
						<div class="offset-sm-2 col-sm-10">
						        <button type="submit" class="btn">确认</button>
						      </div>
						
						

					</form>

				</div>



			</div>

		</div>
	</div>
</body>
</html>