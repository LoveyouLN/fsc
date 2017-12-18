<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>demo</title>
<script src="http://localhost:8088/XBMMavenSSM/static/jquery.min.js" type="text/javascript" ></script>
<link rel="stylesheet" type="text/css" href="http://localhost:8088/XBMMavenSSM/static/css/register.css"/>
</head>
<body>

<div class='signup_container'>
	<h1 class='signup_title'>用户登陆</h1>
	<img src='images/people.png' id='admin' />
	<div id="signup_forms" class="signup_forms clearfix">
		<form class="signup_form_form" id="signup_form" method="post" action="ss" >
			<div class="form_row first_row">
				<label for="signup_email">请输入用户名</label><div class='tip ok'></div>
				<input type="text" name="user[email]" placeholder="请输入用户名" id="signup_name" data-required="required">
			</div>
			<div class="form_row">
				<label for="signup_password">请输入密码</label><div class='tip error'></div>
				<input type="password" name="user[password]" placeholder="请输入密码" id="signup_password" data-required="required">
			</div>
		</form>
	</div>
	<div class="login-btn-set">
		<div class='rem'>记住我</div>
		<a href='javascript:void(0)' onclick="aa()" class='login-btn'></a>
	</div>
	<p class='copyright'>版权所有</p>
</div>

</body>

<script type="text/javascript">

$(function(){

    $('.rem').click(function(){
        $(this).toggleClass('selected');
    })

})

function aa(){
	alert("aa");
	$("#signup_form").submit();
}
</script>

</html>