<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>学生信息</title>
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
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 5px;">
  <legend>按班级查看</legend>
</fieldset>

<form class="layui-form" action="studentInfo">

  
  
  <div class="layui-form-item">

    <div class="layui-inline">
      <label class="layui-form-label">选择班级：</label>
      <div class="layui-input-inline">
        <select name="clasId" id="clasId" lay-verify="required" lay-search="">
          <option value="">直接选择或搜索选择</option>
          <s:iterator value="cList">
			<option value=<s:property value="clasId"/>><s:property value="clasName"/></option>
		  </s:iterator>
        </select>
      </div>
    </div>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
 
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px;">
  <legend>学生信息</legend>
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
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>出生日期</th>
        <th>练习电话</th>
        <th>家庭住址</th>
        <th>操作</th>
      </tr> 
    </thead>
    <tbody id="table2">
	  <s:iterator value="students">
	      <tr>
	      	<td><s:property value="studentId"/></td>
	      	<td><s:property value="studentName"/></td>
	      	<td><s:property value="sex"/></td>
	      	<td><s:property value="birthday"/></td>
	      	<td><s:property value="phone"/></td>
	      	<td><s:property value="adress"/></td>
	      	<td><a href='editStudentJsp?studentId=<s:property value="studentId"/>' style="cursor:pointer;">修改</a>&nbsp;<a style="cursor:pointer;" onclick="deleteStudent(<s:property value="studentId"/>)">删除</a></td>
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
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form()
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  /* //监听提交
  form.on('submit(demo1)', function(data){
  		layer.alert(JSON.stringify(data.field));
		$.post('studentInfo',data.field,function(res){	
        //res就是返回的结果
        alert(res);
		});
		return false;
	}); */
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