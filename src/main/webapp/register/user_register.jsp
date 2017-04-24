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
<title>个人用户注册</title>
</head>


<body>
	<div class="container">
		<form action="register" class="form-signin" method="post">
        	<h4 class="form-margin">个人用户注册</h4>
			<label class="sr-only">用户名</label>
			<input class="form-control form-margin" type="text" name="phoneNumber" placeholder="请输入手机号"/>
			<label class="sr-only">密码</label>
			<input class="form-control form-margin" type="password" name="regi_password" placeholder="请输入密码"/>
			<input class="form-control form-margin" type="password" name="regi_password2" placeholder="请确认密码"/>
			<div>
				<input class="btn btn-primary  btn-block form-margin" type="submit" value="立即注册" />
				
				<p class="form-margin">
					<a href="../login/login.jsp">我有账号，立即登录</a>
				</p>
			</div>
		</form>
	</div>
</body>
</html>
