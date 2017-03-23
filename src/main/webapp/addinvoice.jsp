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
	<%@include file="head.jsp"%>

	<div class="container padding-top-15">
		<div class="row">
			<div class="col-2 bd-sidebar" id="sidebar">
				<div class="list-group">
					<a href="#" class="list-group-item">首页</a> <a href="#"
						class="list-group-item active">我的发票</a> <a href="#"
						class="list-group-item">查看企业</a> <a href="#"
						class="list-group-item">交易记录</a> <a href="#"
						class="list-group-item">呵呵哒</a>
				</div>
			</div>
			<div class="row col-10">

				<div class="mainpad col-12">
					<div class=" padding-top-15 padding-bottom-10">
						<span>填写发票信息：</span>
					</div>

					<form class="form-horizontal">
						<div class="form-group row">
							<label for="label-invoice-id" class="col-2 col-form-label">发票代码</label>
							<div class="col-9">
								<input class="form-control" type="text" value=""
									id="example-text-input">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-invoice-number" class="col-2 col-form-label">发票号码</label>
							<div class="col-9">
								<input class="form-control" type="text"
									value="" id="example-search-input">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-invoice-password" class="col-2 col-form-label">密 码</label>
							<div class="col-9">
								<input class="form-control" type="text"
									value="" id="example-email-input">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-invoice-enterprice" class="col-2 col-form-label">收款单位</label>
							<div class="col-9">
								<input class="form-control" type="text"
									value="" id="example-url-input">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-tax-number" class="col-2 col-form-label">税号</label>
							<div class="col-9">
								<input class="form-control" type="text" value=""
									id="example-tel-input">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-date" class="col-2 col-form-label">开票日期</label>
							<div class="col-9">
								<input class="form-control" type="date" value=""
									id="example-password-input">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-payee" class="col-2 col-form-label">开票人</label>
							<div class="col-9">
								<input class="form-control" type="text" value=""
									id="example-number-input">
							</div>
						</div>
						 
			 			<div class="form-group row">
							<label for="label-payer" class="col-2 col-form-label">付款单位(个人)</label>
							<div class="col-9">
								<input class="form-control" type="text" value=""
									id="example-date-input">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-paysum" class="col-2 col-form-label">总额</label>
							<div class="col-9">
								<input class="form-control" type="text" value=""
									id="example-month-input">
							</div>
						</div>

						<div class="offset-sm-2 col-sm-10">
						        <button type="submit" class="btn">保存</button>
						      </div>


						

					</form>

				</div>



			</div>

		</div>
	</div>
</body>
</html>