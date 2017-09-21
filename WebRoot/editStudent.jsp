<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript" src="js/jquery-1.8.js"></script>
<link rel="stylesheet" href="css/layui.css"  media="all">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script src="layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="js/editStudent.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>
<s:debug></s:debug>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">学生管理</a></li>
    <li><a href="#">修改学生信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
  	<div id="tab1" class="tabson">
    
    
    <ul class="forminfo">   
    
    <li><label style="padding-left:325px";>选择班级<b>*</b></label>  
    
	<form name="studentInfo"  method="post" action=""  id="studentInfo">
    <div class="vocation">
    <select name="clasId" id="clasId" class="select2">
    <option value=<s:property value="student.clas.clasId"/>><s:property value="student.clas.clasId"/></option>
    <s:iterator value="cList">
			<option value=<s:property value="clasId"/>><s:property value="clasName"/></option>
	</s:iterator>
    </select>
    </div>
    
    </li>
    
    <li><label style="padding-left:325px";>学号</label><input name="studentId" id="studentId" value=<s:property value="student.studentId"/> type="text" class="scinput" readonly/>&nbsp;&nbsp;学号不允许修改！</li>
    <li><label style="padding-left:325px";>密码</label><input name="password" id="password" value=<s:property value="student.password"/> type="text" class="scinput" /></li>
    <li><label style="padding-left:325px";>姓名</label><input name="studentName" id="studentName" value=<s:property value="student.studentName"/> type="text" class="scinput" /></li>
    <li><label style="padding-left:325px";>出生年月</label>
    <div class="layui-inline">
  	<input name="birthday" id="birthday" value=<s:property value="student.birthday"/> style="width: 168px" class="layui-input" placeholder="出生年月" onclick="layui.laydate({elem: this, festival: false})">
	</div>
    <li><label style="padding-left:325px";>联系电话</label><input name="phone" id="phone" value=<s:property value="student.phone"/> type="text" class="scinput" /></li>
    <li><label style="padding-left:325px";>家庭住址</label><input name="adress" id="adress" value=<s:property value="student.adress"/> type="text" class="scinput" /></li>
        
    </div>
      
    <li><label style="padding-left:425px";>&nbsp;&nbsp;&nbsp;</label>
    <input name="" id="addStudent" type="button" class="btn" value="确认修改" onclick="updateTheStudent()" /></li>
    </ul>
     </from> 
    </div>       
   
	</div> 
	
<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  var start = {
    min: laydate.now()
    ,max: '2099-06-16 23:59:59'
    ,istoday: false
    ,choose: function(datas){
      end.min = datas; //开始日选好后，重置结束日的最小日期
      end.start = datas //将结束日的初始值设定为开始日
    }
  };
  
  var end = {
    min: laydate.now()
    ,max: '2099-06-16 23:59:59'
    ,istoday: false
    ,choose: function(datas){
      start.max = datas; //结束日选好后，重置开始日的最大日期
    }
  };
  
  document.getElementById('LAY_demorange_s').onclick = function(){
    start.elem = this;
    laydate(start);
  }
  document.getElementById('LAY_demorange_e').onclick = function(){
    end.elem = this
    laydate(end);
  }
  
});
</script>
</body>
</html>
