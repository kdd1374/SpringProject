<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberDTO dto = (MemberDTO) session.getAttribute("logindto");
%>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#searchGoods").on("click", function(event) {
			var search = $("#goodsSearch").val();
			if (search == null || search.length == 0) {
				// 		   alert("검색어를 입력해주세요");
				// 		   return false;
				search = "$$$$";
			}
			
			location.href = "/cat/goodsSearch/" + search;

		});

		$("#goodsSearch").on("keypress",function (e) {
			var search = $("#goodsSearch").val();
			if (e.keyCode == 13) {
				location.href = "/cat/goodsSearch/" + search;
				}
	    });//엔터키 이벤트(엔터키코드 13)

	});
</script>
<style>
</style>

<div id="member" style="text-align:center;">
<table width="180px" cellspacing="0" cellpadding="0">
<tr>
<td width="130px" bgcolor="white" align="center">
<input type="text" size="12" id="goodsSearch"
style="font-size:12px; border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px; margin:0; height:20px; margin-right:5px;">
</td>
<td>
<img src="/cat/images/search.gif" id="searchGoods">
</td>
</tr>
</table>
</div>
<div id="menu"></div>
<div id="notis"></div>

</div>

