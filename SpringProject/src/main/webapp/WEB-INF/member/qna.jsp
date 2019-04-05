<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
<c:if test="${!empty mailmesg}">
alert("${mailmesg}");
</c:if>



	$(document).ready(function(){
		
		$("#sendMail").on("click",function(event){
			console.log("woijwf");
			location.href="/cat/m/sendQna?name="+$("#name").text()+"&email="+
					$("#email").val()+"&content="+$("#content").val();
		})
		
		
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
<body>
<table width="1200px" cellspacing="0" cellpadding="0" >
<tr>
<td width="325px"></td>
<td colspan="2"><img src="../images/qna1.gif"></td>
<td width="325px"></td>
</tr>
<tr>
<td height="50px"></td>
</tr>
 <tr>
 <td width="378.5px">
 </td>
  <td align = "center" valign="center" colspan="2">
   <table width="550px" cellspacing="0" cellpadding="0" style="margin:0;" border="1" rules="none" bordercolor="#fffb8b">
    <tr>
     <td height="30px">
     </td>
    </tr>
    <tr>
     <td height="10px">
     </td>
    </tr>
    <tr>
     <td align="center" valign="center">
      <table cellspacing="0" cellpadding="0" width="440px" border="1" rules="none" bordercolor="#fffb8b">
       <tr>
        <td valign="center" align="center" bgcolor="#fffb8b"><img src="../images/name.gif" style="margin-top:10px;"></td>
        <c:if test="${!empty logindto}">
        <td valign="center" align="center"><span style="font-size:12px;">${logindto.username}</span></td>
        </c:if>
        <c:if test="${!empty nlogindto}">
        <td valign="center" align="center"><span style="font-size:12px;">${nlogindto.username}</span></td>

        </c:if>
       </tr>
       <tr>
        <td valign="center" align="center"bgcolor="#fffb8b"><img src="../images/email.gif" style="margin-top:10px;"></td>
        <c:if test="${!empty logindto}">
         <td valign="center" align="center"><input name="email" type="text" id="email" value="${logindto.email1}@${logindto.email2}" 
        style="margin:0; text-align:center; border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" size="25"></td>
        </c:if>
        <c:if test="${!empty nlogindto}">
         <td valign="center" align="center"><input name="email" type="text" id="email" value="${nlogindto.email}" 
        style="margin:0; text-align:center; border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" size="25"></td>
        </c:if>
       </tr>
       <tr>
       <td valign="center" align="center"bgcolor="#fffb8b"><img src="../images/qna4.gif" style="margin-top:10px;"></td>
       <td valign="center" align="center">
       <textarea rows="10" cols="55" style="resize:none; border:0; font-size:12px;" id=""></textarea>

       </td>
       </tr>
      </table>
     </td>
    </tr>
    <tr>
    <td height="30px">
    </td>
   </tr>
  </table>
  </td>
 </tr>
 <tr>
 <td width="378.5px">
 </td>
 <td width="367px">
 </td>
  <td align="center" valign="center" bgcolor="#fffb8b">
	<img src="../images/qna3.gif">
  </td>
 <td width="378.5px">
 </td>
 </tr>
</table>
</body>

</html>