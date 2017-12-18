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
  		<div>
            <input type="button" id="btnConnection" value="连接" />
            <input type="button" id="btnClose" value="关闭" />
            <input type="button" id="btnSend" value="发送" />
        </div>
        <div>
        </div>
        <script type="text/javascript">
            var socket;
            if(typeof(WebSocket) == "undefined") {
                alert("您的浏览器不支持WebSocket");
            }

            $("#btnConnection").click(function() {
                //实现化WebSocket对象，指定要连接的服务器地址与端口
                socket = new WebSocket("ws://127.0.0.1:8088/XBMMavenSSM/MyWebSocket");
                //打开事件
                socket.onopen = function() {
                    alert("Socket 已打开");
                    //socket.send("这是来自客户端的消息" + location.href + new Date());
                };
                //获得消息事件
                socket.onmessage = function(msg) {
                    $("div").eq(1).html(msg.data);
                };
                //关闭事件
                socket.onclose = function() {
                    alert("Socket已关闭");
                };
                //发生了错误事件
                socket.onerror = function() {
                    alert("发生了错误");
                }
            });
            
            //发送消息
            $("#btnSend").click(function() {
                socket.send("这是来自客户端的消息" + location.href + new Date());
            });
            
            //关闭
            $("#btnClose").click(function() {
                socket.close();
            });
            
            
            //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。  
            window.onbeforeunload = function(){  
                websocket.close();  
            }  
        </script>
    </body>

</html>