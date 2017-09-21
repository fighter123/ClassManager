<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>所有班级</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/layer/layer.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.js"></script>
<script type="text/javascript" src="js/layer.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
function deleteClass(clasId)
{
	layer.confirm('确认删除吗?', function(index){
  		//do something 
  		layer.close(index);
 	 	 $.ajax({ 
			 type:"POST",
  			 url:"deleteClass",
  			 async:false,
  			 dataType: "text",
  			 scriptCharset:'UTF-8',
  			 data:{"clasId":clasId},
  			 success:function(result)
  				 { 
   				 //$("#box").text(result);
  				 	 //alert(result);
  				 	 if(result==1)
  				 	 {
  				 		layer.msg("删除成功！",{icon: 1});
  				 		window.location.href="allClassHtml"; 	
  				 	 }
  				 	 else
  				 	 {
  				 		layer.msg("删除失败！",{icon: 5}); 	
  				 	 }
   			 } 
			}); 
	});         
}
</script>


</head>


<body>
<%-- <s:debug></s:debug> --%>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">班级</a></li>
    <li><a href="#">所有班级</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    <center>
    <h1><div style="font-family:宋体; font-size:28px">班级信息</div></h1><br>
    </center>
    
    
    <table  style="margin:0 auto;" class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>班级编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>班级名称</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
        <s:iterator value="cList">
        	<td><input name="" type="checkbox" value="" /></td>
			<td><s:property value="clasId"/></td>
			<td><s:property value="clasName"/></td>
			<td><a href="#" class="tablelink">查看</a> <a href="editClassJsp?clasId=<s:property value="clasId"/>" class="tablelink">修改</a> <a href="#" onclick="deleteClass('<s:property value="clasId"/>')" class="tablelink"> 删除</a></td>					 
			</tr> 
		</s:iterator>
        
        
        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul style="align:center" class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>  
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
