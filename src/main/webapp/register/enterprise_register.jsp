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
<title>企业用户注册</title>
</head>


<body>
	<div class="container">
		<form action="enterprise_register" class="mainpad form-group form-enterprise" method="post">
			<div class="form-title">
				<h4>企业信息</h4>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">企业名称</label>
				<div class="col-10">
					<input class="form-control" type="text" value="" name="enterprise_name"
						id="example-text-input"/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">企业编号</label>
				<div class="col-10">
					<input class="form-control" type="text" value="" name="enterprise_number"
						id="example-search-input"/>
				</div>
			</div>
			
			
			<div class="form-group row">
				<label class="col-2 col-form-label">企业地址</label>
				<div class="col-10">
					<input class="form-control" type="text" value="" name="enterprise_address"
						id="example-search-input"/>
				</div>
			</div>
			
			
			<div class="form-group row">
				<label class="col-2 col-form-label">营业执照号码</label>
				<div class="col-10">
					<input class="form-control" type="text" value="" name="license_number"
						id="example-search-input">
				</div>
			</div>
			
				<div class="form-title">
				<h4>授权人信息</h4>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">姓名</label>
				<div class="col-10">
					<input class="form-control" type="text" value="" name="certigier_name"
						id="example-text-input"/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">身份证号码</label>
				<div class="col-10">
					<input class="form-control" type="text" value="" name="certigier_id_number"
						id="example-search-input"/>
				</div>
			</div>
			
			
			<div class="form-group row">
				<label class="col-2 col-form-label">手机号码</label>
				<div class="col-10">
					<input class="form-control" type="text" value="" name="certigier_phone_number"
						id="example-search-input"/>
				</div>
			</div>
			
			
			<div class="form-group row">
				<label class="col-2 col-form-label">邮箱</label>
				<div class="col-10">
					<input class="form-control" type="text" value="" name="certigier_email"
						id="example-search-input"/>
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-2 col-form-label">家庭住址</label>
				<div class="col-10">
					<input class="form-control" type="text" value="" name="certigier_address"
						id="example-search-input"/>
				</div>
			</div>
			
			<div class="form-title"></div>
			<div class="text-center">
				<input type="checkbox"><span>确认以上信息，并同意《<a href="protocol.jsp">系统服务协议与隐私政策</a>》</span>
			</div>
			<div class="text-center">
				<button class="mybtn btn btn-primary">注册</button></div>
			
		</form>
	</div>
</body>
</html>
