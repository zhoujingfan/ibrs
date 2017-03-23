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
<title>Insert title here</title>
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
					
								<a href="addinvoice.jsp">添加发票</a>
					</div>
				</div>
				<div class="mainpad col-12">

					<div class="padding-top-15 padding-bottom-10">
						<span>企业一：</span>
					</div>
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

					<div class="padding-top-15 padding-bottom-10">
						<span>企业二：</span>
					</div>
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
</body>
</html>