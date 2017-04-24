<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../common/css/bootstrap.css">
<link rel="stylesheet" href="../common/css/ibrs.css">
<script src="../common/js/jquery-3.1.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script src="../common/js/bootstrap.js"></script>
<title>完成实名认证</title>
</head>


<body>
	<div class="container">
		<form action="identification" class="mainpad form-group form-identification" method="post">
			<div class="form-title">
				<h4>完成实名认证</h4>
			</div>
			<div class="form-group row">
				<label class="col-3 col-form-label">真实姓名</label>
				<div class="col-9">
					<input class="form-control" type="text" value="" name="truename"
						id="example-text-input"/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-3 col-form-label">身份证号码</label>
				<div class="col-9">
					<input class="form-control" type="text" value="" name="idNumber"
						id="example-search-input"/>
				</div>
			</div>
			
			
			<div class="form-group row">
				<label class="col-3 col-form-label">常住地址</label>
				<div class="col-9">
					<input class="form-control" type="text" value="" name="address"
						id="example-search-input"/>
				</div>
			</div>
			
			
			<div class="form-group row">
				<label class="col-3 col-form-label">生日</label>
				<div class="col-9">
					<input class="form-control" type="text" value="" name="birthday"
						id="example-search-input">
				</div>
			</div>
			

			<div class="form-title"></div>
			<div class="text-center">
				<input type="checkbox"><span>确认实名信息，并同意《<a href="protocol.jsp">系统服务协议与隐私政策</a>》</span>
			</div>
			<div class="text-center">
				<button class="mybtn btn btn-primary">注册</button></div>
			
		</form>
	</div>
</body>
</html>
