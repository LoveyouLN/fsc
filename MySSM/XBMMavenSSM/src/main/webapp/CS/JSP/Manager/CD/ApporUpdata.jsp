<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../../context.jsp" %>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>厨师</title>

<style type="text/css">

</style>
</head>


<body class="layui-layout-body" >

 <div class="layui-container" style="width: 100%">  
	
	<div class="layui-row"  style="">
		
		  
		   <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
		  <form class="layui-form" action="" style="margin-left: 27%;padding-top:4%;">
		  
		    <div class="layui-form-item">
   				  <label class="layui-form-label">桌号ID</label>
				  <div class="layui-inline">
		    		<input class="layui-input" name="zh"   placeholder="桌号为。。"  autocomplete="off">
		  		 </div>
			</div>
			
			<div class="layui-form-item">
   				  <label class="layui-form-label">桌子名字</label>
				  <div class="layui-inline">
		    		<input class="layui-input" name="cai"  placeholder="因设置餐桌名字" autocomplete="off">
		  		 </div>
	  		</div>
	  		<div class="layui-form-item">
   				 <label class="layui-form-label">大厨</label>
	  		  	<div class="layui-inline">
	    		<input class="layui-input" name="dc"   placeholder="查找大厨为。。" autocomplete="off">
	  		 	</div>
	  		 </div>
	  		 
	  		 
	  		 <div class="layui-form-item">
   				 <label class="layui-form-label">金额</label>
		  		  <div class="layui-inline">
		    		<input class="layui-input" name="qian"   placeholder="查找消费金额为。。" autocomplete="off">
		  		 </div>
	  		  </div>
 		 	<div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit="" id="ssd" lay-filter="demo1">立即提交</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			 </div>
		
		  </form>
		 </div>	  
	</div>

</div>
		  
		 
		  
 <input type="hidden" name="id" value="${主键id}">














<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
 


</script>
<script type="text/html" id="barDemo1">
    <a class="layui-btn layui-btn-xs" lay-event="edit">完成</a>
</script>

<script type="text/javascript">

layui.use(['element','layer'], function(){
	  var element = layui.element;
	  var layer = layui.layer;
	  
	  $('#ssd').click(function(){ 
		
		  var index = parent.layer.getFrameIndex(window.name);
		
	/* 	$.ajax({
		  	url:'',    //url添加
		  	async:false,
		  	data:{
		  		"":$('input[name="id"]').val(), //后台判断为  equals("") 为true 就执行添加  false执行修改
		  		"":$('input[name="zh"]').val(),
		  		"":$('input[name="cai"]').val(),
		  		"":$('input[name="dc"]').val(),
		  		"":$('input[name="qian"]').val()
		  	},
		  	success:function(data){
		  			
		  		layer.msg('删除成功', {icon: 1});
		  	     obj.del();
		  	},
		  	error:function(){
		  			
		  	}
		  		  
		 }); */
		  	  
		  
		  
		  
		  
		  parent.layer.msg('操作成功', {icon: 1});
		  parent.$('#ssdf').click();
		  parent.layer.close(index);
		  
	  });
	  
	 
});


</script>

</body>
</html>