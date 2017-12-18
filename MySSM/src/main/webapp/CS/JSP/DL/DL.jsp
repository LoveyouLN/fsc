<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8;">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0;"/>
<title>login</title>
<script type="text/javascript" src="http://cdn.bootcss.com/layer/3.0.1/mobile/layer.min.js"></script>
<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/layer/3.0.1/mobile/need/layer.css" />
<link rel="stylesheet" type="text/css" href="http://localhost:8088/XBMMavenSSM/static/css/style.css" />
<script type="text/javascript" src="http://localhost:8088/XBMMavenSSM/static/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="http://localhost:8088/XBMMavenSSM/static/js/phone.js" ></script>
<script type="text/javascript" src="http://localhost:8088/XBMMavenSSM/static/js/login.js"></script>
</head>

<body>
<div class="whole">
	<div class="title">欢迎登陆</div>
    <div class="coordinates-icon">
    	<div class="coordinates topAct">
        	<img src="http://localhost:8088/XBMMavenSSM/static/images/coordinates.png" />
        </div>
        <div class="circle-1-1 circle-show-2"></div>
        <div class="circle-2-2 circle-show-1"></div>
        <div class="circle-3-3 circle-show"></div>
    </div>
    <div class="login-form">
    	<form action="">
        	<div class="user-name common-div">
            	<span class="eamil-icon common-icon">
                	<img src="http://localhost:8088/XBMMavenSSM/static/images/eamil.png" />            
                </span>
                <input type="email" name="username" value="" placeholder="E-mail address" />        
            </div>
            <div class="user-pasw common-div">
            	<span class="pasw-icon common-icon">
                	<img src="http://localhost:8088/XBMMavenSSM/static/images/password.png" />
                </span>
                <input type="password" name="password" value="" placeholder="******" />        
            </div>
            <div class="login-btn common-div">登陆</div>
        </form>
    </div>
    <div class="forgets">
    	<a href="#">Forget password?</a>
        <a href="#">New here?Sign up</a>
    </div>
</div>
</body>
</html>
