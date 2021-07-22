<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="../js/my.js"></script>

</head>
    <script>
        function check_pw(){
 
            var pw = document.getElementById('pw').value;
            var SC = ["!","@","#","$","%"];
            var check_SC = 0;
 
            if(pw.length < 6 || pw.length>16){
                window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
                document.getElementById('pw').value='';
            }
            for(var i=0;i<SC.length;i++){
                if(pw.indexOf(SC[i]) != -1){
                    check_SC = 1;
                }
            }
            if(check_SC == 0){
                window.alert('!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.')
                document.getElementById('pw').value='';
            }
            if(document.getElementById('pw').value !='' && document.getElementById('pw2').value!=''){
                if(document.getElementById('pw').value==document.getElementById('pw2').value){
                    document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
                    document.getElementById('check').style.color='blue';
                }
                else{
                    document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                    document.getElementById('check').style.color='red';
                }
            }
        }
        
        function validate(){
            if(id.value=="") {
                alert("아이디를 입력해 주세요");
                id.focus();
                return false;
            }
            
            if(pw.value=="") {
                alert("비밀번호를 입력해 주세요");
                pw.focus();
                return false;
            }
            
            if(pw.value != pw2.value) {
                alert("비밀번호가 일치하지 않습니다.");
                pw2.focus();
                return false;
            }
            
            if(name.value=="") {
                alert("이름을 입력해 주세요");
                name.focus();
                return false;
            }
            
            if(email.value=="") {
                alert("이메일을 입력해 주세요");
                email.focus();
                return false;
            }
            
            if(age.value=="") {
                alert("나이를 입력해 주세요");
                age.focus();
                return false;
            }
            
            if(weight.value=="") {
                alert("몸무게를 입력해 주세요");
                weight.focus();
                return false;
            }
            
            if(height.value=="") {
                alert("키를 입력해 주세요");
                height.focus();
                return false;
            }
            
            if(gender.value=="") {
                alert("성별을 입력해 주세요");
                gender.focus();
                return false;
            }
        	
        }
    </script>
<body>
	<article class="container"><br>
	        <div class="page-header">
                <div class="col-md-6 col-md-offset-3">
                <h3>Member Profile</h3>
                </div>
            </div>
            <div class="col-sm-6 col-md-offset-3">
                <form role="form">
                    <div class="form-group">
                        <label for="inputName">Name</label>
                        <input type="text" class="form-control" id="name" value='${vo.getName() }' readonly />
                    </div>   
                    <div class="form-group">
                        <label for="inputEmail">Email</label>
                        <input type="email" class="form-control" id="email" value='${vo.getEmail() }' disabled="disabled" />
                    </div>
                    <div class="form-group">
                    	<label for="inputAge">Age</label>
						<input type="number" class="form-control" id="age" style="width:100px;" value='${vo.getAge() }' disabled="disabled" />
                    </div>
                    <div class="form-group">
                    	<label for="inputAge">Weight</label>
						<input type="number" class="form-control" id="weight" style="width:100px;" value='${vo.getWeight() }' disabled="disabled" />
                    </div>
                    <div class="form-group">
                    	<label for="inputAge">Height</label>
						<input type="number" class="form-control" id="height" style="width:100px;" value='${vo.getHeight() }' disabled="disabled" />
                    </div>
                    <div class="form-group">
                        <label for="inputGender">Gender</label><br>
						<input type="number" class="form-control" id="gender" style="width:100px;" value='${vo.getGender() }' readonly />		
                   				<% if(${vo.getGender()}.equals("male")){%>
										<input type="radio" name="gender" value="m" checked>남자
										<input type="radio" name="gender" value="f">여자
								<% } else { %>
										<input type="radio" name="gender" value="m">남자
										<input type="radio" name="gender" value="f" checked>여자
								<% } %>
                    </div>

                    <div class="form-group text-center"  onclick="validate();">
                        <input type="button" id="updateMemberInfoBtn" class="btn btn-primary" 
                        value="Edit Profile">
                    </div>
                    <div class="form-group text-center">
                        <input type="button" id="updateMemberInfoBtn" class="btn btn-primary" 
                        value="Delete Account">
                    </div>
                </form>
            </div>

        </article>

</body>
</html>




<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>글 보기</title>
 	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
 	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#replyBtn").click(function(){
				const id=$.cookie("id");
				if(id){
					$('#replyWriterInput').val(id);
					$("#replyDiv").css("display","block");
				}else{
					alert("로그인부터 하세요");
					window.close();
				}				
			});
			
			$("#replyInsertBtn").click(function(){
				const id=$("#replyWriterInput").val();
				const title=$("#replyTitle").val();
				const content=$("#replyContent").val();
				const parentNO=$("#articleNO").val();
					$.post('main',
							{
								sign:'replyInsert',
								id,
								title,
								content,
								parentNO
							},
							function(data){
								alert(data);
								location.replace("html/boardList.html");
							}
					);		
			});
			
			$("#replyEditBtn").click(function(){
				const id=$("#replyWriterInput").val();
				const title=$("#replyTitle").val();
				const content=$("#replyContent").val();
				const parentNO=$("#articleNO").val();
					$.post('main',
							{
								sign:'replyInsert',
								id,
								title,
								content,
								parentNO
							},
							function(data){
								alert(data);
								location.replace("html/boardList.html");
							}
					);		
			});
			
			$("#replyDeleteBtn").click(function(){
				const r=confirm("정말 삭제하실 건가요?");
				  if (r == true) {
				    $.post('main',
				    	{sign : "replyDelete"},
				    	function(data){
				    		alert(data);
				    		$.removeCookie('id',{path:'/'});
				    		location.reload();
				    	}
				    );
				  }				
			});
			
			
		});//end ready
	 
	</script>
</head>
<body>
<h1 style="text-align:center">글 보기</h1>
  
  	<input type="hidden" id="articleNO" value='${vo.getArticleNO() }' > 
    <table border="0" align="center">
     <tr>
	   <td align="right">글제목: </td>
	   <td colspan="2"><input type="text" size="67"  maxlength="500" name="title" value='${vo.getTitle() }' disabled="disabled" /></td>
	 </tr>
	 <tr>
		<td align="right" valign="top"><br>글내용: </td>
		<td colspan=2><textarea name="content" rows="10" cols="65" maxlength="4000" disabled="disabled">${vo.getContent() }</textarea> </td>
     </tr>
     <tr>
        <td align="right">첨부된 이미지파일:  </td>
	     <td> ${vo.getImageFileName() }</td>
         <td><img  id="preview" src="#"   width=100 height=100/></td>
	 </tr>
	 <tr>
	    <td align="right"> </td>
	    <td colspan="2">
	       <input type="button" value="수정" id="replyEditBtn"/>
	       <input type="button" value="삭제" id="replyDeleteBtn"/>
	       <input type="button" value="댓글 달기" id="replyBtn" />
	       <input type=button value="목록보기" onClick="window.history.back()" />
	    </td>
     </tr>
    </table>
    
    <div style='padding:20px;display:none;background:#ccccff' id="replyDiv">
    	<table>
    		<tr><td>댓글 작성자</td><td><input id='replyWriterInput' disabled="disabled"></td></tr>
    		<tr><td>댓글 제목</td><td><input id="replyTitle"></td></tr>
    		<tr><td>댓글 내용</td><td><textarea rows='3' cols="65" id="replyContent"></textarea></td></tr>
    	</table>
    	<center><button id='replyInsertBtn'>댓글 등록</button></center>
    </div>
    

</body>
</html>

 --%>
