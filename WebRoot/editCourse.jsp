<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>   
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>修改课程</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<s:debug></s:debug>
              
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>修改课程信息</legend>
</fieldset>
<br>
<form class="layui-form" action="">

      <input name="courseId" id="courseId" type="hidden" value=<s:property value="course.courseId"/> lay-verify="required" placeholder="请输入" style="width:239px" class="layui-input" type="text" readonly>

  
  <div class="layui-form-item">
    <label class="layui-form-label">课程名称</label>
    <div class="layui-input-block">
      <input name="courseName" id="courseName" value=<s:property value="course.courseName"/> lay-verify="required" placeholder="请输入" style="width:239px" class="layui-input" type="text">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">课程性质</label>
    <div class="layui-input-block">      <!-- '学位课':'学位课','必修':'必修','选修'：'选修'} -->
      <input name="courseProperty" id="courseProperty" value="学位课" title="学位课" type="radio">
      <input name="courseProperty" id="courseProperty" value="必修" title="必修" type="radio">
      <input name="courseProperty" id="courseProperty" value="选修" title="选修" type="radio">
      <input name="courseProperty" id="courseProperty" value="禁" title="禁用" disabled="" type="radio">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">课程学分</label>
    <div class="layui-input-block">
      <input name="courseCredits" id="courseCredits" value=<s:property value="course.courseCredits"/> lay-verify="required" placeholder="请输入" style="width:239px" class="layui-input" type="text">
    </div>
  </div>
<br>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
<script language="JavaScript" src="js/jquery-1.7.js"></script>          
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form()
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //监听提交
  form.on('submit(demo1)', function(data){
/*     layer.alert(JSON.stringify(data.field), {
      title: '最终的提交信息'
    }); 
    var datas=JSON.stringify(data.field);
    alert(datas);*/
    var courseId=document.getElementById("courseId").value;
    var courseName=document.getElementById("courseName").value;
    var courseProperty=document.getElementById("courseProperty").value;
    var courseCredits=document.getElementById("courseCredits").value;
    //alert(courseId+courseName+courseProperty+courseCredits);
    $.ajax({ 
			 type:"POST",
  			 url:"editCourse",
  			 async:false,
  			 dataType: "text",
  			 scriptCharset:'UTF-8',
  			 data:{"courseId":courseId,"courseName":courseName,"courseProperty":courseProperty,"courseCredits":courseCredits},
  			 success:function(result)
  			 { 
  				 	 if(result==1)
  				 	 {
  				 		alert("修改成功，点击确认继续！");
  				 		window.location.href="allCourseJsp"; 	
  				 	 }
  				 	 else
  				 	 {
  				 		alert("修改失败,该课程编号已存在！"); 
  				 	 }
   			 } 
		});
		//alert("2"); 
    return false;
  });
  
  
});
</script>

</body>
</html>