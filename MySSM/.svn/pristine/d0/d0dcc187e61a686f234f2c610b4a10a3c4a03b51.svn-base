<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="../static/jquery.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小白码饭店</title>

</head>
<body style="height:800px;">
	<div style="width:100%; height: 10%;background-color: whilt;" align="center"></div>
	<div style="width:100%; height: 10%; background-color: red;" align="center">热菜:</div>
	<div style="width:100%; height: 10%; background-color: green;" align="center">凉菜:</div>
	<div style="width:100%; height: 10%; background-color: orange;" align="center">冷饮:</div>
	<div style="width:100%; height: 10%; background-color: blue;" align="center">汤类:</div>
	<div style="width:100%; height: 10%; background-color: yellow;" align="center">主食:</div>
	<div style="width:100%; height: 10%;" align="center"><input style="width: 40%;height: 100%" readonly="readonly" type="button" value="上一页" /><input style="width: 40%;height: 100%" type="button" value="下一页" /></div>
</body>
<script type="text/javascript">
//页面显示当前时间
function dingshi() {
	var dat = new Date();
	$("div").eq(0).html("<a href='javascript:void(0)'>"+
			dat.getHours() + ":" + dat.getMinutes() + ":"
					+ dat.getSeconds()+"</a>");
};
//循环调用显示时间方法以实现时间的变换
window.setInterval(function(){dingshi()},1000);

if("WebSocket" in window){
	 // 打开一个 web socket
    var ws = new WebSocket("ws://localhost:8088/XBMMavenSSM/MyWebSocket");
     
    ws.onopen = function()
    {
       // Web Socket 已连接上，使用 send() 方法发送数据
       ws.send("发送数据");
       alert("数据发送中...");
    };
     
    ws.onmessage = function (evt) 
    { 
       var received_msg = evt.data;
       alert("数据已接收...");
    };
     
    /* ws.onclose = function()
    { 
       // 关闭 websocket
       alert("连接已关闭..."); 
    }; */
}else{
	alert("您的浏览器不支持websocket");
}

//渲染整个页面内容
/* $.ajax({
	url:"http://localhost:8088/XBMMavenSSM/Chef/renderingPage",
	success:function(data){
		alert(data);
		$("body").html(data);
	},
	error:function(errorData){
		alert("errorData:"+errorData);
	}
}) 
 */
/* //查询一个桌子上的菜品，并实时刷新
function selOneTableMessage(){
	$.ajax({
		url:"http://localhost:8088/XBMMavenSSM/Chef/getOneTableAllMesage",
		data:{page:1,}
		success:function(data){
			
		},
		error:function(errorData){
			alert("errorData:"+errorData);
		}
	}) 
} */
 	
	
</script>

</html>