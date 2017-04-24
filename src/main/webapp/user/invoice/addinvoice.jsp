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
					<a href="myRecord" class="list-group-item">交易记录</a>
					</div>
			</div>
			<div class="row col-10">

				<div class="mainpad col-12">
					<div class=" padding-top-15 padding-bottom-10">
						<span>填写发票信息：</span>
					</div>

					<form class="form-horizontal" action="add_submit" method="post">
					
					
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
							<label for="label-invoice-id" class="col-2 col-form-label">发票代码</label>
							<div class="col-9">
								<input class="form-control" type="text" value=""
									id="text-invoice-id" placeholder="请填写13位发票代码" name="invoiceId">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-invoice-number" class="col-2 col-form-label">发票号码</label>
							<div class="col-9">
								<input class="form-control" type="text"
									value="" id="text-invoice-number" placeholder="请填写10位发票号码" name="invoiceNumber">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-invoice-password" class="col-2 col-form-label">密 码</label>
							<div class="col-9">
								<input class="form-control" type="text"
									value="" id="text-invoice-password" placeholder="请填写发票密码" name="invoicePassword">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-invoice-enterprice" class="col-2 col-form-label">收款单位</label>
							<div class="col-9">
								<input class="form-control" type="text"
									value="" id="text-invoice-enterprise" placeholder="请填写收款单位名称" name="invoiceEnterprise">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-tax-number" class="col-2 col-form-label">税号</label>
							<div class="col-9">
								<input class="form-control" type="text" value=""
									id="text-tax-number" placeholder="请填写税号" name = "taxNumber">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-date" class="col-2 col-form-label">开票日期</label>
							<div class="col-9">
								<input class="form-control" type="date" value=""
									id="text-date" placeholder="请填写开票日期" name="invoiceDate">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-payee" class="col-2 col-form-label">开票人</label>
							<div class="col-9">
								<input class="form-control" type="text" value=""
									id="text-invoice-payee" placeholder="请填写开票人姓名	" name="invoicePayee">
							</div>
						</div>
						 
			 			<div class="form-group row">
							<label for="label-payer" class="col-2 col-form-label">付款单位(个人)</label>
							<div class="col-9">
								<input class="form-control" type="text" value=""
									id="text-payer" placeholder="请填写付款单位名称或者个人姓名" name="invoicePayer">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-details" class="col-2 col-form-label">项目明细</label>
							<div class="col-9">
								<input class="form-control" type="text" value=""
									id="text-details" placeholder="请填写详细的消费项目" name="invoiceDetails">
							</div>
						</div>
						<div class="form-group row">
							<label for="label-paysum" class="col-2 col-form-label">总额</label>
							<div class="col-9">
								<input class="form-control" type="text" value=""
									id="text-paysum" placeholder="请填写发票总金额" name="invoiceSum">
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