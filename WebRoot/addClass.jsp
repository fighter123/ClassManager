<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加班级</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery-1.7.js"></script>
<script language="JavaScript" src="js/addClass.js"></script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">班级管理</a></li>
    <li><a href="#">添加班级</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <br>
    
    <ul class="forminfo">
    <center>
    <li>班级编号&nbsp;&nbsp;<input id="clasId" style="width:245px; height:32px; line-height:32px; border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df; background:url(images/inputbg.gif) repeat-x; text-indent:10px;" name="" type="text" /><i>班级编号不能超过30个字符</i></li>
    <li>班级名称&nbsp;&nbsp;<input id="clasName" style="width:245px; height:32px; line-height:32px; border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df; background:url(images/inputbg.gif) repeat-x; text-indent:10px;" name="" type="text" class="dfinput" /><i>班级名称不能超过30个字符</i></li>  
    </center>
    <li><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
    <input name="saveClass" id="saveClass" type="button" class="btn" value="确认保存" onclick="saveClass()"/></li>
    </ul>
   
    
    </div>
</body>
</html>
