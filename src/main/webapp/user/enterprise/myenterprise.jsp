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
<title>查看我关联的企业</title>
</head>
<body>
	<%@include file="../head.jsp"%>

	<div class="container padding-top-15">
		<div class="row">
			<div class="col-2 bd-sidebar" id="sidebar">
				<div class="list-group">
					<a href="main" class="list-group-item ">首页</a> <a
						href="myInvoice" class="list-group-item">我的发票</a> <a
						href="my_enterprise" class="list-group-item active">查看企业</a> <a
						href="myRecord" class="list-group-item">交易记录</a>
				</div>
			</div>
			<div class="row col-10">

				<div class="mainpad col-12">
					<div class=" padding-top-15 padding-bottom-10">
						<a >我关联的企业数量: ${myEnterpriseNum }</a>
					</div>
				</div>

				<c:forEach items="${myEnterprise }" var="enterprises">
					<div class="col-4 card">
						<div class="form-title">
							<span>${enterprises.enterpriseName }</span>
						</div>

						<div class="padding-top-15">
							<span>关联时间：${map.get(enterprise.id) }</span>
						</div>
						<div class="padding-top-15">
							<span><a href="#">管理</a></span>
						</div>
					</div>

				</c:forEach>
				<div class="col-4 card">
					<span style="padding-top:15%;" class="text-center"><a
						href="add_enterprise">关联新的企业</a></span>
				</div>

			</div>

		</div>
	</div>
</body>
</html>