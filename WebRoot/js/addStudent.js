
jQuery(function($){	
	$('#addStudent').click(function ()
		{
			//alert("12");
			var clasId=document.getElementById('clasId').value;
			//alert(clasId);
			if(clasId=="")
				{
					alert("请选择班级！");
					return;
				}
			var studentId=document.getElementById('studentId').value;
			var password=document.getElementById('password').value;
			var studentName=document.getElementById('studentName').value;
			var sex=$("input[name='sex'][type='radio']:checked").val();
			var birthday=document.getElementById('birthday').value;
			var phone=document.getElementById('phone').value;
			var adress=document.getElementById('adress').value;
			if(studentId==""||password==""||studentName==""||sex==""||birthday==""||phone==""||adress=="")
				{
				alert("信息填写完整才可以提交呦，亲！");
				return;
				}
			//alert(password+studentName+sex+birthday+phone+adress);
			$.ajax({ 
	 			 type:"POST",
	   			 url:"addStudent",
	   			 async:false,
	   			 dataType: "text",
	   			 scriptCharset:'UTF-8',
	   			 data:{"studentId":studentId,"passWord":password,"studentName":studentName,
	   				 "sex":sex,"birthday":birthday,"phone":phone,"adress":adress,"clasId":clasId},
	   			 success:function(result)
	   				 { 
	    				 //$("#box").text(result);
	   				 	 result=result.substring(1,result.length-1);
	   				 	 //alert(result);
	   				 	 if(result=="1")
	   				 	 {
	   				 		alert("添加成功,点击确认继续！");	
	   				 		window.location.href="addStudentJsp"; 
	   				 	 }
	   				 	 else if(result=="2")
	   				 	 {
	   				 		alert("该学号已存在！"); 
	   				 	 }
	   				 	 else
	   				 	 {
	   				 		alert("添加失败！"); 
	   				 	 }
	    			 } 
				}); 
		});
});