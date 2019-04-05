<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
 <%
    String clientId = "Y5w0sYA5mSg7O0ykx5AE";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:8090/cat/callback", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$("#idlogin").on("click",function(event){
			if($("#userid").val().length==0){
				alert("아이디를 입력해주세요");
				 $("#userid").focus();
				event.preventDefault();
			}else if($("#password").val().length==0){
				alert("비밀번호를 입력해주세요");
				 $("#password").focus();
				event.preventDefault();
			}else{
				location.href="loginForm?userid="+$("#userid").val()+"&password="+$("#password").val();
			}
		});
		$("#idlogin").on("mouseover",function(event){
			$("#loginimg").attr("src","images/login2.gif");
		});
		$("#idlogin").on("mouseout",function(event){
			$("#loginimg").attr("src","images/login.gif");
		});
		$("#signupimg").on("mouseover",function(event){
			$("#signupimg").attr("src","images/signup2.gif");
		});
		$("#signupimg").on("mouseout",function(event){
			$("#signupimg").attr("src","images/signup.gif");
		});
		
		$("#naver").on("click",function(event){
			onewin = window.open("<%=apiURL%>","widht='100px',height='100px'");
		});
		
	});

</script>
<style type="text/css">
 
  #remote:link {                         
         text-decoration:none;    
         } 
    #remote:visited { 
         color:#c1c1c1; 
         } 
     #remote:hover { 
         color:#c1c1c1; 
         } 
   #remote:active { 
         color:#c1c1c1; 
         } 

</style>
</head>


<span style="font-size:14px; margin-top:50px;"><b>Member Login</b></span><br>
<input type="text" id="userid" style="text-align:center; margin-top:30px; height:20px;" placeholder="ID" size="40"><br>
<input type="password" id="password" style="text-align:center; height:20px;" placeholder="PASSWORD" size="40"><br>
<a href="#" id="idlogin"><img src="images/login.gif" style="margin-top:10px;" id="loginimg"></a><br>
<a href="/cat/naverLogin"><img src="images/naverlogin.gif"></a><br>
<a href="IdSearchServlet">아이디찾기</a>  <a href="PasswordSearchServlet">비밀번호찾기</a><br>
<span style="font-size:12px"><b>아이디가 없으시다면 회원가입을 해주세요</b></span></br>
<a href="memberSignup" id="signup"><img src="images/signup.gif" style="margin-top:10px;" id="signupimg"></a><br>
</body>
</html>