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
<table>
<tr>
<td>
<span style="font-size:12px;"><span style="font-size:12px;"><strong>오시는 길</strong></span></span>&nbsp;&nbsp;

</td>
</tr>
<tr>
<td>
<a href="/cat/map"><img src="/cat/images/map.png" width="170" height="120"></a>
</td>
</tr>
<tr height="7">
</tr>
<tr>
<td align="left" style="line-height:12px">
<span style="font-size:12px;"><strong>고양이용품점 고양이네</strong> </span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>대표이사 : 고양이</strong> </span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>주소 :</strong> 서울 강남구 강남대로00길 00 00빌딩 4층</span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>지번 :</strong> 서울 강남구 역삼동 000-0 00빌딩 4층 </span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>전화 :</strong> 02-000-0000 </span>
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
<span style="font-size:12px;"><strong>예금주 :</strong> 고양이네 </span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>Acon은행 :</strong> 000-000000-00000</span>
</td>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>Bcon은행 :</strong> 00000-000000-000</span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:12px">
<span style="font-size:12px;"><strong>Ccon은행 :</strong> 0000-00000-0000</span>
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
<span style="font-size:10px;"><strong>이메일 :</strong> 000000@cucucat.com<</span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:10px">
<span style="font-size:10px;"><strong>사업자 등록번호 :</strong> 000-00-00000</span>
</td>
</tr>
<tr>
<td align="left"  style="line-height:10px">
<span style="font-size:10px;"><strong>통신판매업신고 :</strong> 제0000-서울강남-000호</span>
</td>
</tr>
</table>
</div>
<div id="menu"></div>
<div id="notis"></div>
</div>

