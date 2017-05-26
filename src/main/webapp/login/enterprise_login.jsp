<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="common/css/bootstrap.css">
<link rel="stylesheet" href="common/css/ibrs.css">
<script src="../common/js/jquery-3.1.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script src="../common/js/bootstrap.js"></script>
<title>个人用户登录</title>
</head>


<body>
	<div class="container">
		<form action="enterprise_main" class="form-signin" method="post">
        	<h4 class="text-center">企业登录</h4>
			<label class="sr-only">登录名</label>
			<input class="form-control form-margin" type="text" name="name" value="" required="required" placeholder="请输入登录名"/>
			<label class="sr-only">密码</label>
			<input class="form-control form-margin" type="password" name="password" required="required" value="" placeholder="请输入密码"/>
			<div>
				<input class="btn btn-primary  btn-block form-margin" type="submit" value="登录" />
				<p class="form-margin">
					<a href="#">忘记密码？</a>
					<a class="form-register" href="enterprise">企业注册</a>
				</p>
			</div>
		</form>
	</div>
</body>
</html>
