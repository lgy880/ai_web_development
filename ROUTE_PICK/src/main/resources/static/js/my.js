$(document).ready(function(){
		var login=$.cookie('logined');
		$("#msgDiv").html(login);
		
		

		/////////////////////회원 가입 처리
			$("#memberInsertBtn").click(function(){
			
				const name=$("#name").val();
				const id=$("#id").val();
				const pw=$("#pw").val();
				
				//alert(name+":"+id+":"+pw);
				
				$.post("../memberInsert.rp",
					  {
					    name,
					    id,
					    pw
					  },
					  function(data, status){
					    alert( data);
					    window.close();
					  });		
			});
			
			////////////////////////////로그인 처리	
			
			$("#loginBtn").click(function(){
				
				var id=$("#id").val();
				var pw=$("#pw").val();
				
				//alert(id+":"+pw);		
				
				$.post("login.rp",
					  {			   
					    id,
					    pw
					  },
					  function(data, status){	
					  	//const obj=JSON.parse(data);
					  	if(data.name){
					  		data = data.name+ "<input type='button' value='logout' id='logoutBtn' class='btn btn-primary'><input type='button' value='탈퇴' id='deleteBtn' class='btn btn-warning'>";	
						  	$.cookie("logined",data);    			  	
							$("#msgDiv").html(data);		
					  	}else{
					  		alert("login fail");
							location.reload();	
					  	}
					  	
					  					   
					  }
				);//end post() 
			});//end 로그인 처리
			
			///////////////////////로그아웃 처리
			$(document).on("click", "#logoutBtn", function(event) { 
			
				$.post("logout.rp",
					  {			   
					   
					  },
					  function(data, status){		  	
					  	
					  	$.removeCookie("logined");	    
						location.reload();						   
					  }
				);//end post() 
			});//end 로그아웃 처리
			
			/////////////////////회원 탈퇴
			$(document).on("click", "#deleteBtn", function(event) { 
				alert("정말 탈퇴하시겠습니까?");
				$.post("memberDelete.rp",
					  {			   
					   
					  },
					  function(data, status){		 
					  	
					  	$.removeCookie("logined");	    
						location.reload();						   
					  }
				);//end post() 
			});//
		

});














