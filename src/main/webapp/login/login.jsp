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
<title>个人用户登录</title>
</head>


<body>
	<div class="container">
		<form action="main" class="form-signin" method="post">
        	<h4 class="text-center">个人用户登录</h4>
			<label class="sr-only">用户名</label>
			<input class="form-control form-margin" type="text" name="username" placeholder="请输入用户名"/>
			<label class="sr-only">密码</label>
			<input class="form-control form-margin" type="password" name="password" placeholder="请输入密码"/>
			<div>
				<input class="btn btn-primary  btn-block form-margin" type="submit" value="登录" />
				<p class="form-margin">
					<a href="#">忘记密码？</a>
					<a class="form-register" href="../register/user_register.jsp">新用户注册</a>
				</p>
			</div>
		</form>
	</div>
</body>
</html>
