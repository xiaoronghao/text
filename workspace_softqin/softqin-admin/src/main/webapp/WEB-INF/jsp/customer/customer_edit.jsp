<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		
		<meta charset="utf-8" />
		<title></title>
		
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="static/css/bootstrap.min.css" rel="stylesheet" />
		<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="static/css/font-awesome.min.css" />
		<link rel="stylesheet" href="static/css/chosen.css" />
		<link rel="stylesheet" href="static/css/ace.min.css" />
		<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="static/css/ace-skins.min.css" />
		<link rel="stylesheet" href="static/css/datepicker.css" /><!-- 日期框 -->
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<!--提示框-->
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		
<script type="text/javascript">
	
	//保存
	function save(){

		
		if($("#name").val()==""){
			
			$("#name").tips({
				side:3,
	            msg:'输入姓名',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#name").focus();
			return false;
		}
		if($("#phone").val()==""){
			
			$("#phone").tips({
				side:3,
	            msg:'输入内容',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#phone").focus();
			return false;
		}
		
		
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
	//删除图片
	function delP(tpurl,id){
		 if(confirm("确定要删除图片？")){
			var url = "<%=basePath%>customer/deltp.do?tpurl="+tpurl+"&id="+id+"&guid="+new Date().getTime();
			$.get(url,function(data){
				if(data=="success"){
					alert("删除成功!");
					document.location.reload();
				}
			});
		} 
	}
</script>
	</head>
<body>
	<form action="customer/${msg }.do" name="Form" id="Form" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" id="id" value="${pd.id }"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			
				
			<tr>
				<td>姓名:</td>
				<td><input type="text" style="width:95%;" name="name" id="name" value="${pd.name }" placeholder="这里输入姓名" title="姓名"/></td>
			</tr>
			<tr>
				<td>性别:</td>
				<td>
				   	<select name="sex" title="性别">
					<option value="0" <c:if test="${pd.sex == '0' }">selected</c:if> >男</option>
					<option value="1" <c:if test="${pd.sex == '1' }">selected</c:if> >女</option>
					</select> 
				</td>
			</tr>
			<tr>
				<td>手机:</td>
				<td><input type="text" style="width:95%;" name="phone" id="phone" value="${pd.phone }" placeholder="这里输入手机号" title="手机号"/></td>
			</tr>
			<tr>
				<td>邮箱:</td>
				<td><input type="text" style="width:95%;" name="mail" id="mail" value="${pd.mail }" placeholder="这里输入邮箱" title="邮箱"/></td>
			</tr>
			<tr>
				<td>内容:</td>
				<td id="nr">
					<textarea  style="width:93%;height:290px" name="content" id="content">${pd.content }</textarea>
				</td>
			</tr>
			<tr>
				<td>注册时间:</td>
				<td>
					<input style="width:35%;" class="span10 date-picker" name="register_date" id="register_date" value="${pd.register_date}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="注册日期" title="注册日期"/>
				</td>
			</tr>
			
			<tr>
				<td class="center" colspan="2">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
		</table>
		</div>
		
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
		
	</form>
	
	
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 单选框 -->
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		
		<!-- 编辑框-->
		<script type="text/javascript" charset="utf-8">window.UEDITOR_HOME_URL = "<%=path%>/plugins/ueditor/";</script>
		<script type="text/javascript" charset="utf-8" src="plugins/ueditor/ueditor.config.js"></script>
		<script type="text/javascript" charset="utf-8" src="plugins/ueditor/ueditor.all.js"></script>
		<!-- 编辑框-->
		
		<script type="text/javascript">
		$(top.hangge());
		$(function() {
			
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			$('.date-picker').datepicker();
		});
		/* function reurl(){ 
			UE.getEditor('content');
			} 
		setTimeout('reurl()',500); */
		</script>
	
</body>
</html>