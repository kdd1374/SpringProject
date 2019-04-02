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
</table><br>
<table>
<tr>
<td>
<span style="font-size:12px;"><a href="/cat/map"><span style="font-size:12px;"><strong>오시는 길</strong></span></a></span>&nbsp;&nbsp;

</td>
</tr>
<tr>
<td>
<img src="/cat/images/map.png" width="170" height="120">
</td>
</tr>
<tr height="7">
</tr>
<tr>
<td align="left" style="line-height:12px">
<span style="font-size:12px;"><strong>고양이용품점 꾹꾹이네</strong> </span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>대표이사 : 에이콘</strong> </span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>주소 :</strong> 서울 강남구 강남대로94길 20 삼오빌딩 4층</span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>지번 :</strong> 서울 강남구 역삼동 819-3 삼오빌딩 4층 </span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>전화 :</strong> 02-538-0958 </span>
</td>
</tr>
<tr height="7">
</tr>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:13px;"><strong>입금계좌 안내</strong></span>
</td>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>예금주 :</strong> 에이콘 </span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>Acon은행 :</strong> 122-666666-33322</span>
</td>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>Bcon은행 :</strong> 77777-773334-444</span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>Ccon은행 :</strong> 4444-55555-3331</span>
</td>
</tr>
</tr>
<tr height="7">
</tr>
<tr>
<td align="left"  style="line-height:10px">
<span style="font-size:10px;"><strong>팩스번호 :</strong> 02-333-4444</span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:10px">
<span style="font-size:10px;"><strong>이메일 :</strong> aconcucu@cucucat.com<</span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:10px">
<span style="font-size:10px;"><strong>사업자 등록번호 :</strong> 333-22-55555</span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:10px">
<span style="font-size:10px;"><strong>통신판매업신고 :</strong> 제2010-서울강남-333호</span>
</td>
</tr>
</table>
</div>
<div id="menu"></div>
<div id="notis"></div>
</div>

