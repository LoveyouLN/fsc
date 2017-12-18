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
	<div align="center">
		<form>
			<table>
				<tr>
					<td>帐号:</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" /></td>
				</tr>
				<tr>
					<td>验证码</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td><input type="text"></td>
					<td><img src="" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="button" value="登录" /><input type="reset"
						value="重置" /><input onclick="dingshi()" type="button"
						value="开始定时" /><input onclick="stopdingshi()" type="button"
						value="停止定时" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>

<script type="text/javascript">
	var t;
	function dingshi() {
		var dat = new Date();
		$("input").eq(3).val(
				dat.getHours() + ":" + dat.getMinutes() + ":"
						+ dat.getSeconds());
		t = setTimeout("dingshi()", 1000);
	};
	window.setInterval(function(){dingshi()},1000);
	function stopdingshi() {
		clearTimeout(t)
	};

	$(":button").eq(0).click(function() {
		$.ajax({
			url : "http://localhost:8088/XBMMavenSSM/Waiter/selOneWaiter",
			data : {
				waitername : $("input").eq(0).val(),
				waiterpsw : $("input").eq(1).val()
			},
			success : function(data) {
				if (data == -1) {
					alert("登录失败");
				} else {

				}
			},
			error : function(errorData) {
				alert("errorMessage:" + errorData);
			}
		})
	})
</script>

</html>