<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link rel="stylesheet" href="static/css/datepicker.css" />
<!-- 日期框 -->
<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
<script src="web/layer-v3.1.1/layer/layer.js"></script>
<!--提示框-->
<script type="text/javascript" src="static/js/jquery.tips.js"></script>

<script type="text/javascript">
	
	//保存
	function save(){

		
		if($("#type").val()==""){
			
			$("#type").tips({
				side:3,
	            msg:'输入图片类型',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#type").focus();
			return false;
		}
	/* 	if($("#suffix").val()==""){
			
			$("#nr").tips({
				side:3,
	            msg:'输入内容',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#content").focus();
			return false;
		} */
		
		
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
	//删除图片
	function delP(tpurl,id){
		 if(confirm("确定要删除图片？")){
			var url = "<%=basePath%>picture/deltp.do?tpurl="+tpurl+"&id="+id+"&guid="+new Date().getTime();
			$.get(url,function(data){
				if(data=="success"){
					alert("删除成功!");
					document.location.reload();
				}
			});
		} 
	}
</script>
<style>
.demo-label {
	margin: 20px 20px 0 0;
	display: inline-block;
	margin-left: 4px;
}

.demo-radio {
	display: none
}

.demo-radioInput {
	background-color: #fff;
	border: 2px solid rgba(0, 0, 0, 0.15);
	border-radius: 100%;
	display: inline-block;
	height: 20px;
	margin-right: 10px;
	margin-top: -1px;
	vertical-align: middle;
	width: 20px;
	line-height: 1
}

.demo-radio:checked+.demo-radioInput:after {
	background-color: #00A1E9;
	border-radius: 100%;
	content: "";
	display: inline-block;
	height: 18px;
	width: 18px;
	margin-left: 1px;
	margin-top: 1px;
}

.demo-checkbox.demo-radioInput, .demo-radio:checked+.demo-checkbox.demo-radioInput:after
	{
	border-radius: 0
}

.demo-radio:checked+.demo-radioInput {
	border: 2px solid #00A1E9;
}
</style>
<style>
.demo2-label {
	margin: 20px 20px 0 0;
	display: inline-block;
	margin-left: 4px;
}

.demo2-radio {
	display: none
}

.demo2-radioInput {
	background-color: #fff;
	border: 2px solid rgba(0, 0, 0, 0.15);
	border-radius: 100%;
	display: inline-block;
	height: 20px;
	margin-right: 10px;
	margin-top: -1px;
	vertical-align: middle;
	width: 20px;
	line-height: 1
}

.demo2-radio:checked+.demo2-radioInput:after {
	background-color: #00A1E9;
	border-radius: 100%;
	content: "";
	display: inline-block;
	height: 18px;
	width: 18px;
	margin-left: 1px;
	margin-top: 1px;
}

.demo2-checkbox.demo-radioInput, .demo2-radio:checked+.demo2-checkbox.demo2-radioInput:after
	{
	border-radius: 0
}

.demo2-radio:checked+.demo2-radioInput {
	border: 2px solid #00A1E9;
}
</style>
</head>
<body>
	<form action="picture/${msg }.do" name="Form" id="Form" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="id" id="id" value="${pd.id }" />
		<input  type="hidden" name="typeId" id="typeId"/>
		<div id="zhongxin">
			<table id="table_report"
				class="table table-striped table-bordered table-hover">


				<tr>
					<td>图片类型:</td>
					<td><input type="text" style="width: 95%;" name="type"
						id="type" value="${pd.type}" placeholder="这里输入类型" title="类型"
						readonly /></td>
				</tr>
				<%-- 	<tr>
				<td>图片:</td>
				<td>
					<c:if test="${pd == null || pd.pic == '' || pd.pic == null }">
					 <!-- <input type="file" id="tp" name="tp"/> -->
					<!-- <button type="button" id="addphoto-btn" >图片上传</button> -->
					</c:if>
					<c:if test="${pd != null && pd.pic != '' && pd.pic != null }">
						<a href="TP/${pd.pic}" target="_blank"><img src="TP/${pd.pic}" width="210"/></a>
						<input type="button" class="btn btn-mini btn-danger" value="删除" onclick="delP('${pd.pic}','${pd.id }');" />
						<input type="hidden" name="tpz" id="tpz" value="${pd.pic }"/>
					</c:if>
				</td>
			</tr> --%>

				<tr>
					<td class="center" colspan="2"><a
						class="btn btn-mini btn-primary" onclick="typeChoose();">类型选择</a>
						<a class="btn btn-mini btn-primary" onclick="save();">保存</a> <a
						class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
					</td>
				</tr>
			</table>
		</div>

		<div id="zhongxin2" class="center" style="display: none">
			<br />
			<br />
			<br />
			<br />
			<br />
			<img src="static/images/jiazai.gif" /><br />
			<h4 class="lighter block green">提交中...</h4>
		</div>

	</form>


	<!-- 引入 -->
	<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/ace-elements.min.js"></script>
	<script src="static/js/ace.min.js"></script>
	<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script>
	<!-- 单选框 -->
	<script type="text/javascript"
		src="static/js/bootstrap-datepicker.min.js"></script>
	<!-- 日期框 -->

	<!-- 编辑框-->
	<script type="text/javascript" charset="utf-8">window.UEDITOR_HOME_URL = "<%=path%>/plugins/ueditor/";</script>
	<script type="text/javascript" charset="utf-8"
		src="plugins/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="plugins/ueditor/ueditor.all.js"></script>
	<!-- 编辑框-->

	<script type="text/javascript">
		$(top.hangge());
		$(function() {
			
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			$('.date-picker').datepicker();
			
			//上传
			$('#tp').ace_file_input({
				no_file:'请选择图片 ...',
				btn_choose:'选择',
				btn_change:'更改',
				droppable:false,
				onchange:null,
				thumbnail:false //| true | large
				//whitelist:'gif|png|jpg|jpeg'
				//blacklist:'exe|php'
				//onchange:''
				//
			});
		<%-- 	$('#addphoto-btn').click(function(){
				 top.jzts();
				 var diag = new top.Dialog();
				 diag.Drag=true;
				 diag.Title ="添加图片";
				 diag.URL = '<%=basePath%>picture/goAddPicture.do';
				 diag.Width = 800;
				 diag.Height = 490;
				 diag.CancelEvent = function(){ //关闭事件
					diag.close();
				 };
				 diag.show();
			}); --%>
			
		});
		
	/* 	function reurl(){ 
			UE.getEditor('content');
			} 
		setTimeout('reurl()',500); */
		//类型选择
		function typeChoose(){
			var htmlStr = '';
			var htmlStr2 = '';
			var layerTip = '';
			var layerTip2 = '';
			var ids='';
			htmlStr += '<label class="demo-label"  style="margin-left:">'
			htmlStr += '<input id="r1" type="radio" value="0" name="pictype" class="demo-radio" data-name="lunbo"/>'
			htmlStr += '<span class="demo-radioInput"></span>轮播'
			htmlStr += '</label>'
			htmlStr += '<br/>'
			htmlStr += '<label class="demo-label">'
			htmlStr += '<input id="r2" type="radio" value="1" name="pictype" class="demo-radio" data-name="about""/>'
			htmlStr += '<span class="demo-radioInput"></span>关于'
			htmlStr += '</label>'
			htmlStr += '<br/>'
			htmlStr += '<label class="demo-label">'
			htmlStr += '<input id="r3" type="radio" value="2" name="pictype" class="demo-radio" data-name="news"/>'
			htmlStr += '<span class="demo-radioInput"></span>新闻'
			htmlStr += '</label>'
			htmlStr += '<br/>'
			htmlStr += '<label class="demo-label">'
			htmlStr += '<input id="r4" type="radio" value="3" name="pictype" class="demo-radio" data-name="series"/>'
			htmlStr += '<span class="demo-radioInput"></span>系列'
			htmlStr += '</label>'
			htmlStr += '<br/>'
			htmlStr += '<label class="demo-label">'
			htmlStr += '<input id="r5" type="radio" value="5" name="pictype" class="demo-radio" data-name="project"/>'
			htmlStr += '<span class="demo-radioInput"></span>项目'
			//htmlStr += '< /label>'
				layerTip = layer.open({
					type: 1,
					skin: 'layui-layer-demo', //样式类名
					closeBtn: 0, //不显示关闭按钮
					anim: 2,
					title: '图片类型',
					shadeClose: close, //开启遮罩关闭
					content: htmlStr
				});
			
			//监听单选框被选中，并获得选中的value值
			$(document).on('click', ".demo-radio",function () {
				//layerTip = "";
				/* if(layerTip2.length!=0){
					htmlStr2 = "";
					ids="";
				} */
				//alert($(this).val());
				//如果type值为0,1则关闭layer并直接给target_type赋值并关闭layer
				if($(this).val() == 0 || $(this).val() == 1){
					$('#type').val($(this).attr("data-name"));
					$('#typeId').val("");
					layer.close(layerTip);
					layerTip="";
				}else{
					//如果type值为2,3,4则需要发送请求查询所有新闻或系列或项目.需要弹出新的layer
					layer.close(layerTip);
					layerTip="";
					if($(this).val() == 2){
						ids+=$(this).attr("data-name");
						//请求查询所有新闻
					   $.ajax({
			        		url:'http://47.98.197.158:8080/softqin-admin/webNewsInterface/getAllNews',
			        		dataType:'json',
			    			}).done(function(data){
			    				console.log(data);
			    				if(data){
			    					//reData.data[i].title.substring(0,5)
			    					for(var i=0;i<data.data.length;i++){
			    						htmlStr2 += '<label class="demo2-label">'
			    						htmlStr2 += '<input  type="radio" value="'+data.data[i].id+'"name="pictype2" class="demo2-radio" data-title="'+data.data[i].title+'"/>'
			    						htmlStr2 += '<span class="demo2-radioInput"></span>'+data.data[i].title.substring(0,5)+"...";
			    						htmlStr2 += '</label>'
			    						htmlStr2 += '<br/>'
			    					}
			    					openLayer2();
			    				}else{
			    					layer.msg("内容为空");
			    				}
			    				
			    			})
						}else if($(this).val() ==3){
						 ids+=$(this).attr("data-name");
						 //请求查询所有系列
						  $.ajax({
			        		url:'http://47.98.197.158:8080/softqin-admin/webSeriesInterface/getAllSeries',
			        		dataType:'json',
			    			}).done(function(data){
			    				console.log(data);
			    				if(data){
			    					//reData.data[i].title.substring(0,5)
			    					for(var i=0;i<data.data.length;i++){
			    						htmlStr2 += '<label class="demo2-label">'
			    						htmlStr2 += '<input  type="radio" value="'+data.data[i].id+'"name="pictype2" class="demo2-radio" data-title="'+data.data[i].name+'"/>'
			    						htmlStr2 += '<span class="demo2-radioInput"></span>'+data.data[i].name+"...";
			    						htmlStr2 += '</label>'
			    						htmlStr2 += '<br/>'
			    					}
			    					openLayer2();
			    				}else{
			    					layer.msg("内容为空");
			    				}
			    			})
						}else{
							ids+=$(this).attr("data-name");
						 //请求查询所有项目
						 $.ajax({
			        		url:'http://47.98.197.158:8080/softqin-admin/webProjectInterface/getAllProject',
			        		dataType:'json',
			    			}).done(function(data){
			    				console.log(data);
			    				if(data){
			    					//reData.data[i].title.substring(0,5)
			    					for(var i=0;i<data.data.length;i++){
			    						htmlStr2 += '<label class="demo2-label">'
			    						htmlStr2 += '<input  type="radio" value="'+data.data[i].id+'"name="pictype2" class="demo2-radio" data-title="'+data.data[i].name+'"/>'
			    						htmlStr2 += '<span class="demo2-radioInput"></span>'+data.data[i].name+"...";
			    						htmlStr2 += '</label>'
			    						htmlStr2 += '<br/>'
			    					}
			    					openLayer2();
			    				}else{
			    					layer.msg("内容为空");
			    				}
			    			})	
						}

			 
				}
			});
			$(document).on('click', ".demo2-radio",function (){
				ids+="| "+($(this).attr("data-title").length<100?$(this).attr("data-title"):($(this).attr("data-title").substring(0,80)+"..."));
				//console.log(ids);
				//console.log($(this).val());
				$("#type").val(ids);
			    $("#typeId").val($(this).val());
				layer.close(layerTip2);
				ids="";
			})
			
			function openLayer2(){
				
				//layer.close(layerTip);
				//layerTip="";
				layerTip2 = layer.open({
				type: 1,
				skin: 'layui-layer-demo', //样式类名
				closeBtn: 0, //不显示关闭按钮
				anim: 2,
				title: '图片类型2',
				shadeClose: false, //开启遮罩关闭
				content: htmlStr2
			});
				htmlStr2="";
				
			}
			

		}
  
		</script>

</body>
</html>