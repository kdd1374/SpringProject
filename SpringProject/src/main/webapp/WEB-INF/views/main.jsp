<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
<%
MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
String memberAdd = (String)session.getAttribute("memberAdd");
if(memberAdd != null){
%>
alert("<%=memberAdd%>")
<%
session.removeAttribute("memberAdd");
}
%>
<c:If test="${delmesg != empty}">
alert("${delmesg}")
</c:If>
</script>
<style type="text/css">

	body{
	min-width: 1365px;
	margin: 0;
	}
	
	
	}
	#main{
	width: 100%;
    padding: 40px 270px;
    box-sizing: border-box;
    overflow: hidden;
	}
	
	#wrap{
	display: block;
    padding: 0;
    margin: 0 auto;
    width:100%;
    max-width: 1400px;
    position:relative;
	}
	
	#wrapbox{
	
	clear: both;
    position: relative;
    margin: 0 auto;
    margin-top:20px;
    padding: 0;
    text-align: center;
    width: 100%;
	}
	

	#wrap-left{
	width: 230px;
    position: fixed;
    left: 0;
    top: 0;
    z-index: 99;
    height: 100%;
    padding: 25px;
    box-sizing: border-box;
    letter-spacing: 0.2px;
    background-color:rgba(255,251,139,1);
	}
	@media screen and (max-width: 1200px)
	{#wrap-right{display:none;}
	}
	#wrap-right{
	width: 230px;
    position: fixed;
    right: 0;
    top: 0;
    z-index: 99;
    height: 100%;
    padding: 25px;
    box-sizing: border-box;
    letter-spacing: 0.2px;
    background-color:rgba(255,251,139,1);
	}
	
	#mainbanner{
	width:100%;
	float:left;
	margin:0;
	padding:20px 0 0 0;
	}
	
	
	#member{
	width:100%;
	float:left;
	height:105px;
	margin:0px;
	margin-top:20px;
	}
	#menu{
	width:100%;
	float:left;
	margin:0px;
	margin-top:30px;
	}
		#notis{
	width:100%;
	float:left;
	margin:0px;
	margin-top:30px;
	}
 
  a:link {                         
         color:black;text-decoration:none;    
         } 
    a:visited { 
         color:black; 
         } 
     a:hover { 
         color:black; 
         } 
   a:active { 
         color:black; 
         } 

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="main">
<div id="wrap">
<div id="wrapbox">
<img src="images/전라도1.JPG" width=750px height=350px style="margin-top:30px;"><br>
<img src="images/전라도1.JPG" width=370px height=150px style="margin-top:30px;">
<img src="images/전라도1.JPG" width=370px height=150px style="margin:30px 0 0 10px;">
</div>
</div>

<div id="wrap-left">
<div id="mainbanner">
<a href="main">
<img src="images/zzzz.jpg">
</a>
</div>
<jsp:include page="../common/menu.jsp" flush="true" />
</div>
<div id="wrap-right">
<jsp:include page="../common/menu2.jsp" flush="true" />
</div>
</div>
</body>
</html>