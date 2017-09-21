function saveClass()
{
	var clasId = document.getElementById("clasId");
	var clasName = document.getElementById("clasName");
	//alert(clasId.value+clasName.value);
	if(clasId.value=="")
		{
			alert("班级编号不能为空！");
			clasId.focus(); 
		}
	else if(clasName.value=="")
		{
			alert("班级名称不能为空！");
			clasName.focus(); 
		}
	else
	{
		$.ajax({ 
			 type:"POST",
  			 url:"updateClass",
  			 async:false,
  			 dataType: "text",
  			 scriptCharset:'UTF-8',
  			 data:{"clasId":clasId.value,"clasName":clasName.value},
  			 success:function(result)
  				 { 
   				 //$("#box").text(result);
  				 	 //alert(result);
  				 	 if(result==1)
  				 	 {
  				 		alert("保存成功！"); 
  				 		window.location.href="allClassHtml";	
  				 	 }
  				 	 else
  				 	 {
  				 		alert("保存失败！"); 
  				 	 }
   			 } 
			}); 
	}
}