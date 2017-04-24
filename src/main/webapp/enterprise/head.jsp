<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse bg-inverse navbar-toggleable-md">
	<div class="container">
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarsExampleContainer"
			aria-controls="navbarsExampleContainer" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarsExampleContainer">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link active disable">您好,</a>
				</li>
				<li class="nav-item"><a class="nav-link active disable">${enterprise.name }</a>
				</li>
			</ul>
			<ul class="navbar-nav navbar-right">

				<li class="nav-item">
					<a class="nav-link active" href="#">设置</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="#">退出</a>
				</li>
			</ul>
		</div>


	</div>
</nav>