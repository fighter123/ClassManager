
function deleteStudent(studentId)
{
	//alert(studentId);
	$.ajax({ 
		 type:"POST",
			 url:"deleteStudent",
			 async:false,
			 dataType: "text",
			 scriptCharset:'UTF-8',
			 data:{"studentId":studentId},
			 success:function(result)
				 { 
				 //$("#box").text(result);
				 	 //alert(result);
				 result=result.substring(1,result.length-1);
				 if(result=="1")
					 {
					 	alert("删除成功");
					 	window.location.href="allStudentJsp"; 
					 }
				 else
					 {
					 	alert("删除失败！");
					 }				 	 
				 } 
		}); 
}
function forStudents()
{
	var clasId = document.getElementById("clasId").value;
	if(clasId=="")return;
	alert(clasId);
	$.ajax({ 
		 type:"POST",
			 url:"studentInfo",
			 async:false,
			 dataType: "text",
			 scriptCharset:'UTF-8',
			 data:{"clasId":clasId},
			 success:function(result)
				 { 
				 //$("#box").text(result);
				 	 alert(result);
				 } 
		}); 
}