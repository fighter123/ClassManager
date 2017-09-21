<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>课程信息</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <script type="text/javascript" src="js/jquery-1.8.js"></script>
  <script type="text/javascript" src="js/allStudent.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<%-- <s:debug></s:debug> --%>
 
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>课程信息</legend>
</fieldset>
 
<table class="layui-table">
    <colgroup>
     <!--  <col width="150">
      <col width="150">
      <col width="150">
      <col width="200">
      <col> -->
    </colgroup>
    <thead>
      <tr>
        <th>课程编号</th>
        <th>课程名称</th>
        <th>课程性质</th>
        <th>课程学分</th>
        <th>操作</th>
      </tr> 
    </thead>
    <tbody id="table2">
	  <s:iterator value="courses">
	      <tr>
	      	<td><s:property value="courseId"/></td>
	      	<td><s:property value="courseName"/></td>
	      	<td><s:property value="courseProperty"/></td>
	      	<td><s:property value="courseCredits"/></td>
	      	<td><a href='editCourseJsp?courseId=<s:property value="courseId"/>' style="cursor:pointer; color:blue">修改</a>&nbsp;<a style="cursor:pointer;" onclick="deleteCourse('<s:property value="courseId"/>')">删除</a></td>
	      </tr>		
	  </s:iterator>	  
    </tbody>
  </table>
  <div class="pagin">
    <br>&nbsp;&nbsp;
    <span id="spanFirst" style="display:inline;">第一页</span> &nbsp;&nbsp;
    <span style="display:inline;" id="spanPre" >上一页</span> &nbsp;&nbsp;
    <span style="display:inline;" id="spanNext">下一页</span>&nbsp;&nbsp;
    <span style="display:inline;" id="spanLast">最后一页</span>&nbsp;&nbsp; 第
    <span style="display:inline;" id="spanPageNum"></span>页/共<span style="display:inline;" id="spanTotalPage"></span>页
    </div>
  
        
<div id="demo8"></div>
 
<ul id="biuuu_city_list"></ul>              
          
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
function deleteCourse(courseId)
{
	//alert(courseId);
	$.ajax({ 
			 type:"POST",
  			 url:"deleteCourse",
  			 async:false,
  			 dataType: "text",
  			 scriptCharset:'UTF-8',
  			 data:{"courseId":courseId},
  			 success:function(result)
  			 { 
  				 	 if(result==1)
  				 	 {
  				 		alert("删除成功，点击确认继续！"); 	
  				 		window.location.href="allCourseJsp";	
  				 	 }
  				 	 else
  				 	 {
  				 		alert("删除失败,请重试！"); 
  				 	 }
   			 } 
		});
}
layui.use(['laypage', 'layer'], function(){
  var laypage = layui.laypage
  ,layer = layui.layer;
  });
</script>

</body>
</html>
<script>
     var theTable = document.getElementById("table2");
     var totalPage = document.getElementById("spanTotalPage");
     var pageNum = document.getElementById("spanPageNum");


     var spanPre = document.getElementById("spanPre");
     var spanNext = document.getElementById("spanNext");
     var spanFirst = document.getElementById("spanFirst");
     var spanLast = document.getElementById("spanLast");


     var numberRowsInTable = theTable.rows.length;
     var pageSize = 8;
     var page = 1;


     //下一页
     function next() {


         hideTable();


         currentRow = pageSize * page;
         maxRow = currentRow + pageSize;
         if (maxRow > numberRowsInTable) maxRow = numberRowsInTable;
         for (var i = currentRow; i < maxRow; i++) {
             theTable.rows[i].style.display = '';
         }
         page++;


         if (maxRow == numberRowsInTable) { nextText(); lastText(); }
         showPage();
         preLink();
         firstLink();
     }


     //上一页
     function pre() {


         hideTable();


         page--;


         currentRow = pageSize * page;
         maxRow = currentRow - pageSize;
         if (currentRow > numberRowsInTable) currentRow = numberRowsInTable;
         for (var i = maxRow; i < currentRow; i++) {
             theTable.rows[i].style.display = '';
         }




         if (maxRow == 0) { preText(); firstText(); }
         showPage();
         nextLink();
         lastLink();
     }


     //第一页
     function first() {
         hideTable();
         page = 1;
         for (var i = 0; i < pageSize; i++) {
             theTable.rows[i].style.display = '';
         }
         showPage();

		 firstText();	
         preText();
         nextLink();
         lastLink();
     }


     //最后一页
     function last() {
         hideTable();
         page = pageCount();
         currentRow = pageSize * (page - 1);
         for (var i = currentRow; i < numberRowsInTable; i++) {
             theTable.rows[i].style.display = '';
         }
         showPage();


         preLink();
         nextText();
         firstLink();
         lastText();
     }


     function hideTable() {
         for (var i = 0; i < numberRowsInTable; i++) {
             theTable.rows[i].style.display = 'none';
         }
     }


     function showPage() {
         pageNum.innerHTML = page;
     }


     //总共页数
     function pageCount() {
         var count = 0;
         if (numberRowsInTable % pageSize != 0) count = 1;
         return parseInt(numberRowsInTable / pageSize) + count;
     }


     //显示链接
     function preLink() { spanPre.innerHTML = "<a href='javascript:pre();'><font color=blue>上一页</font></a>"; }
     function preText() { spanPre.innerHTML = "上一页"; }


     function nextLink() { spanNext.innerHTML = "<a href='javascript:next();'><font color=blue>下一页</font></a>"; }
     function nextText() { spanNext.innerHTML = "下一页"; }


     function firstLink() { spanFirst.innerHTML = "<a href='javascript:first();'><font color=blue>第一页</font></a>"; }
     function firstText() { spanFirst.innerHTML = "第一页"; }


     function lastLink() { spanLast.innerHTML = "<a href='javascript:last();'><font color=blue>最后一页</font></a>"; }
     function lastText() { spanLast.innerHTML = "最后一页"; }


     //隐藏表格
     function hide() {
         for (var i = pageSize; i < numberRowsInTable; i++) {
             theTable.rows[i].style.display = 'none';
         }


         totalPage.innerHTML = pageCount();
         pageNum.innerHTML = '1';

		 if(pageCount()>1)
		 {
		 	nextLink();
         	lastLink();
		 }
     }


     hide();
</script>