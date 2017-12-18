<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../../context.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>厨师</title>

<style type="text/css">
</style>
</head>


<body class="layui-layout-body">

	<div class="layui-container" style="width: 100%">

		<div class="layui-row">
			<div class="layui-col-xs2 layui-col-sm2 layui-col-md2 layui-col-lg2">
				<button class="layui-btn" onclick="ans()">
					<i class="layui-icon">&#xe608;</i> 添加
				</button>
			</div>

			<div
				class="layui-col-xs10 layui-col-sm10 layui-col-md10 layui-col-lg10">
				<div class="layui-inline">
					<input class="layui-input" name="tableid" placeholder="桌号为。。"
						autocomplete="off">
				</div>

				<div class="layui-inline">
					<input class="layui-input" name="tablename" placeholder="桌名为。。"
						autocomplete="off">
				</div>

				<div class="layui-inline">
					<input class="layui-input" name="tablesta" placeholder="使用状态为。。"
						autocomplete="off">
				</div>

				<button class="layui-btn" id="ssdf" onclick="ANS()">点击</button>



			</div>
		</div>
		<div class="layui-row">
			<table id="tab1"></table>
		</div>
	</div>









	<script type="text/html" id="barDemo">
{{#  if(d.ISDEL=='0'){ }} 
	
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>

  {{#  } else { }}
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="detail">恢复</a>   
  {{#  } }}
 		
</script>
	<script type="text/html" id="barDemo1">
    <a class="layui-btn layui-btn-xs" lay-event="edit">完成</a>
</script>

	<script type="text/javascript">

layui.use('element', function(){
	  var element = layui.element;
	  
	  
	 
	
	
layui.use(['table','form'], function(){
	  var table = layui.table;
	  var form = layui.form;
	 /*  未被接    //字段如果不对应自己改  */
	  table.render({
	    elem: '#tab1'   
	    ,url: 'http://localhost:8088/XBMMavenSSM/Table/selAllTableInfo' //数据接口
	   // ,height: 932
	   	,height: 'full-200'
		,page: true //开启分页
	    ,cellMinWidth: 80 //最小 width:80px	   
	    ,cols: [[ //表头
	       {field: 'MYTABLEID', title: '桌号', sort: true}
	      ,{field: 'MYTABLENAME', title: '桌名'}
	      ,{field: 'HOWMONEY', title: '消费金额'}
	      ,{field: 'ISUSE', title: '使用状态'}
	      ,{ title: '接桌',toolbar: '#barDemo'}
	    ]]
	  });
	 
	  //监听工具条
	  table.on('tool', function(obj){
	    var data = obj.data;
	  
	    if(obj.event === 'detail'){
	    	/* 回收站恢复 */
	    	
	/*	 $.ajax({     //没xie url包错给注释掉了
    		url:'',  
    		async:false,
    		data:{
    			"":data.id
    		}
    		success:function(data){
    			
    			layer.msg('恢复成功', {icon: 1});
    			$('#ssdf').click(); //分页查询一定要设置成 
  
    		},
    		error:function(){
    			
    		}
    		  
    	  }); */
	    	
	    	
	    	
	      } else if(obj.event === 'del'){
	    	/* 删除 */    	
	      layer.confirm('真的删除行么', function(index){
	    /* 	  $.ajax({     //没xie url包错给注释掉了
	    		url:'',  
	    		async:false,
	    		data:{
	    			"":data.id
	    		}
	    		success:function(data){
	    			
	    			layer.msg('删除成功', {icon: 1});
	    	        obj.del();
	    		},
	    		error:function(){
	    			
	    		}
	    		  
	    	  }); */
	    	  
	        layer.close(index);
	      });
	    } else if(obj.event === 'edit'){
	      layer.alert('编辑行：<br>'+ JSON.stringify(data))
	      ans();
	    }
	  });
});	  
 element.init();
});


	//开启添加弹窗
	
	 function ans(){
		alert("开启弹窗页sss面");
		 layer.msg('hello');
		 layer.open({
			  type: 2,
			  area: ['700px', '450px'],
			  fixed: false, //不固定
			  maxmin: true,
			  content: 'ApporUpdata.jsp'
			});
	} 
	
	//table 查询重载
	function ANS(){
		var tableid = $('input[name="tableid"]').val();  		//桌号 
		var tablename = $('input[name="tablename"]').val();		//桌名
		var tablesta = $('input[name="tablesta"]').val();		//桌子状态
		
		layui.use('table', function(){
			var table = layui.table;
			
			table.reload('tab1', {
				  where: {
				    tableid: tableid,  //如果input 的value="" 提交的也是aaa.equales("") 为true"
				    tablename: tablename,
				    tablesta: tablesta
				  }
				  ,page: {
				    curr: 1 
				  }
				});		
		});
		
	}
	 
	
		setTimeout("aas()",300);
	
		function aas(){
			parent.$("[lay-filter='jd']").hide()
		}
</script>

</body>
</html>