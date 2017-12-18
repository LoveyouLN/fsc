<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="../static/jquery.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小白码饭店</title>

</head>
<body>
我是登录页面！
<form action="user/handleLogin" method="post">
<table>
<tr><td>用户名:</td><td><input name="username"  type="text"/></td></tr>
<tr><td>密码:</td><td><input name="userpsw"  type="text"/></td></tr>
<tr><td><button>确定</button></td><td><input value="清除" type="reset"/></td></tr>
</table>
</form>
</body>

</html>