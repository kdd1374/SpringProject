<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
%>

   
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	
});
</script>
<style>
 
</style>

<div id="member">
<%if(dto==null){ %>
<span style="font-size:12px;"><a href="login" id="login">
로그인</a></span>&nbsp;&nbsp;
<span style="font-size:12px;"><a href="memberSignup">회원가입</a></span>&nbsp;&nbsp;
<span style="font-size:12px;"><a href="m/cartList">장바구니</a></span><br>
<span style="font-size:12px;"><a href="m/mypage">마이페이지</a></span>
<%}else if(dto!=null){ 
if(dto.getMas()!=null){%>
<span style="font-size:12px;"><b>관리자</b> 님 어서오세요</span><br>
<span style="font-size:12px;">
<a href="/cat/logout">로그아웃</a></span><br>
<span style="font-size:12px;"><a href="/cat/m/goodsUpdate">상품관리</a></span><br>
<span style="font-size:12px;"><a href="/cat/m/memberList">회원관리</a></span>
<%} else {%>
<span style="font-size:12px;"><b><%=dto.getUsername() %></b> 님 어서오세요</span>&nbsp;
<span style="font-size:12px;">
<a href="/cat/logout">로그아웃</a></span><br>
<span style="font-size:12px;"><a href="/cat/m/cartList">장바구니</a></span><br>
<span style="font-size:12px;"><a href="/cat/m/favorList">위시 리스트</a></span><br>
<span style="font-size:12px;"><a href="/cat/m/mypage">마이페이지</a></span><br>
<span style="font-size:12px;"><a href="/cat/m/orderListDetail">주문내역</a></span>
<%} %>
<%} %>
</div>
<div id="menu">
<span style="font-size:12px;"><b>상품 둘러보기</b></span><br><br>
<span style="font-size:12px;"><a href="/cat/goodsList?gCategory=rice">사료</a></span><br>
<span style="font-size:12px;"><a href="/cat/goodsList?gCategory=snack">간식</a></span><br>
<span style="font-size:12px;"><a href="/cat/goodsList?gCategory=tower">캣타워</a></span><br>
<span style="font-size:12px;"><a href="/cat/goodsList?gCategory=scratcher">스크래쳐</a></span><br>
<span style="font-size:12px;"><a href="/cat/goodsList?gCategory=send">모래</a></span><br>
<span style="font-size:12px;"><a href="/cat/goodsList?gCategory=toy">장난감</a></span><br>
<span style="font-size:12px;"><a href="/cat/goodsList?gCategory=healthy">건강영양제</a></span>
</div>
<div id="notis">
<span style="font-size:12px;"><b>확인해주세요!</b></span><br><br>
<span style="font-size:12px;"><a href="/cat/notice" id="login">
공지사항</a></span><br>
<span style="font-size:12px;"><a href="/cat/m/qna">1:1문의</a></span><br>
</div>
</div>
<div id="wrap-right">
</div>

    