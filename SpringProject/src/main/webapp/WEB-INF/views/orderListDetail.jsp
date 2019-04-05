<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String mesg=(String)request.getAttribute("mesg");
%>
<!DOCTYPE html>
<html>
<head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
<%if(mesg!=null){%>
alert("<%=mesg%>")
<%}%>
</script>
<link rel="stylesheet" type="text/css" href="/cat/css/main.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="main">
<div id="wrap-left">
<div id="mainbanner">
<a href="/cat/main">
<img src="/cat/images/zzzz.jpg">
</a>
</div>

<jsp:include page="../common/menu.jsp" flush="true" />





<div id="wrap-right">
<jsp:include page="../common/menu2.jsp" flush="true" />
</div>
<div id="wrap">
<div id="wrapbox">
<jsp:include page="../order/orderListDetail.jsp" flush="true"/>





</div>
</div>
</div>
</div>

</body>
</html>