<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>成绩录入</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<%-- <s:debug></s:debug> --%>           
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>成绩录入</legend>
</fieldset>
<br>
<form class="layui-form" action="">

  <div class="layui-form-item">
      <div class="layui-inline">
      <label class="layui-form-label">学生</label>
      <div class="layui-input-inline">
        <select name="studentId" id="studentId" lay-verify="required" lay-search="">
          <option value="">可输入搜索下拉框</option>
          <s:iterator value="students">
          <option value=<s:property value="studentId"/>><s:property value="studentId"/><s:property value="studentName"/></option>
          </s:iterator>
        </select>
      </div>
    </div>
  </div>
  
  <div class="layui-form-item">
      <div class="layui-inline">
      <label class="layui-form-label">课程号</label>
      <div class="layui-input-inline">
        <select name="courseId" id="courseId" lay-verify="required" lay-search="">
          <option value="">请选择课程</option>
          <s:iterator value="courses">
          <option value=<s:property value="courseId"/>><s:property value="courseId"/><s:property value="courseName"/></option>
          </s:iterator>
        </select>
      </div>
    </div>
  </div>
   
  <div class="layui-form-item">
    <label class="layui-form-label">成绩</label>
    <div class="layui-input-block">
      <input name="grade" id="grade" lay-verify="required" placeholder="请输入" style="width:189px" class="layui-input" type="text">
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
    }); */
   /*  var datas=JSON.stringify(data.field);
    alert(datas); */
    var courseId=document.getElementById("courseId").value;
    var studentId=document.getElementById("studentId").value;
    var grade=document.getElementById("grade").value;
    //alert(courseId+studentId+grade);
    $.ajax({ 
			 type:"POST",
  			 url:"addGrade",
  			 async:false,
  			 dataType: "text",
  			 scriptCharset:'UTF-8',
  			 data:{"courseId":courseId,"studentId":studentId,"grade":grade},
  			 success:function(result)
  			 { 
  				 	 if(result==1)
  				 	 {
  				 		alert("保存成功，点击确认继续！"); 	
  				 	 }
  				 	 else
  				 	 {
  				 		alert("保存失败,该成绩已存在！"); 
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