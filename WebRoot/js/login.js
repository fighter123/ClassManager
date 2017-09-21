function login() {
		var user = document.getElementById("username");
		var pwd = document.getElementById("password");
		if (user.value == "") {
			alert("用户名不能为空");
			user.focus(); 
			return;
		}
		else if (pwd.value == "") {
			alert("密码不能为空");
			pwd.focus(); 
			
		}
		else {
			$.ajax({ 
	 			 type:"POST",
	   			 url:"loginAction",
	   			 async:false,
	   			 dataType: "text",
	   			 scriptCharset:'UTF-8',
	   			 data:{"studentId":escape(user.value),"passWord":escape(pwd.value)},
	   			 success:function(result)
	   				 { 
	    				 //$("#box").text(result);
	   				 	 result=result.substring(1,result.length-1);
	   				 	 //alert(result);
	   				 	 if(result=="1")
	   				 	 {
	   				 		window.location.href="main.html";	
	   				 	 }
	   				 	 else if(result=="0")
	   				 	 {
	   				 		alert("该用户不存在！"); 
	   				 		user.value = "";
	   				 	 }
	   				 	 else
	   				 	 {
	   				 		alert("密码错误！"); 
	   				 		pwd.value = "";
	   				 	 }
	    			 } 
				}); 
		}	
	}