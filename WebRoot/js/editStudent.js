function updateTheStudent()
{
	alert("123");
	var clasId = document.getElementById("clasId").value;
	var studentId=document.getElementById('studentId').value;
	var password=document.getElementById('password').value;
	var studentName=document.getElementById('studentName').value;
	var birthday=document.getElementById('birthday').value;
	var phone=document.getElementById('phone').value;
	var adress=document.getElementById('adress').value;
	alert(clasId+studentId+password+studentName+birthday+phone+adress);
	if(studentId==""||password==""||studentName==""||birthday==""||phone==""||adress=="")
		{
			alert("信息填写完整才可以提交呦，亲！");
			return;
		}
	alert("信息！");
		$.ajax({ 
			type:"POST",
  			url:"updateStudent",
  			async:false,
  			dataType: "text",
  			scriptCharset:'UTF-8',
  			data:{"studentId":studentId,"passWord":password,"studentName":studentName,
  				 "birthday":birthday,"phone":phone,"adress":adress,"clasId":clasId},
  			success:function(result)
  			{ 
   				 //$("#box").text(result);
  				 	 result=result.substring(1,result.length-1);
  				 	 //alert(result);
  				 	 if(result=="1")
  				 	 {
  				 		alert("修改成功！");	
  				 		window.location.href="allStudentJsp"; 
  				 	 }
  				 	 else
  				 	 {
  				 		alert("修改失败！"); 
  				 	 }
   			 } 
			}); 
}