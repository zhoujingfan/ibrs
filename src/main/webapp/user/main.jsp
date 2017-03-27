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
<title>${user.username }的主页</title>
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
					<a href="myRecord"
						class="list-group-item">交易记录</a>
						
				</div>
			</div>
			<div class="row col-10">
					<div class="col-4 infopad">
						<div>
							<h4>欢迎， ${user.username }</h4>
							<div class="padding-top-15">
								<span>上次登录：2017-03-21 20:21</span>
							</div>
							
						<div class="padding-top-15">
							<span><a href="add_invoice">添加发票</a></span>
						</div>
						</div>
					</div>

	
					<div class="col-4 infopad">
						<div>
							<span>本月报销信息：</span>
						</div>
	
						<div class="padding-top-15">
							<span>	报销数量：2</span>
						</div>
						<div class="padding-top-15">
							<span>总金额：588元</span>
						</div>
					</div>
					
					
					<div class="col-4 infopad">
						<div>
							<span>我关联的企业：2个</span>
						</div>
	
						<div class="padding-top-15">
							<span><a href="#">管理我的企业</a></span>
						</div>
					</div>
				<div class="mainpad col-12">
					<div class="padding-top-15 padding-bottom-10">
						<span>最近提交交易预览：</span>
					</div>
					<div>
						<table class="table table-striped">
							<thead class="thead-inverse">
								<tr>
									<th>单号</th>
									<th>提交时间</th>
									<th>金额/人民币</th>
									<th>标记信息</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>20170105565</td>
									<td>2017-01-05</td>
									<td>198元</td>
									<td>正确报销</td>
								</tr>
								<tr>
									<td>20170108654</td>
									<td>2017-01-08</td>
									<td>156元</td>
									<td>正确报销</td>
								</tr>
								<tr>
									<td>20170215983</td>
									<td>2017-02-15</td>
									<td>589元</td>
									<td>正确报销</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>