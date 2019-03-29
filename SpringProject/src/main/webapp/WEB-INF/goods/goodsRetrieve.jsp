<%@page import="com.dto.MemberDTO"%>
<%@page import="com.dto.GoodsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   String mesgcart = (String)session.getAttribute("mesgcart");
  if(mesgcart!=null){
%>    
   <script>
     alert('<%=mesgcart %>');
   </script>
<%
  }
  session.removeAttribute("mesgcart");
%>    
<%
	MemberDTO dto = (MemberDTO) session.getAttribute("logindto");
%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#up").on("click", function(e) {
			e.preventDefault();
			var gAmount = $("#gAmount").val();
			gAmount++;
			$("#gAmount").val(gAmount);
		});

		$("#down").on("click", function(e) {
			e.preventDefault();
			var gAmount = $("#gAmount").val();
			gAmount--;
			if (gAmount <= 0) {
				gAmount = 1;
				alert("최소 주문수량은 1개입니다.");
			}
			$("#gAmount").val(gAmount);
		});

		 $("#cart").on("click",function(){
			   $("form").attr("action","/cat/m/goodsCart");
			   
		   });
		 
		 $("#favor").on("click",function(){
			   $("form").attr("action","/cat/m/favorAdd");
			   
		   });
		 
	});
</script>
<style>
</style>
<div id="member">

	<form name="/cat/m/favorAdd" method="GET" action="#">
		<input type="hidden" name="gImage" value="${goodsRetrieve.gImage}">
		<input type="hidden" name="gCode" value="${goodsRetrieve.gCode}">
		<input type="hidden" name="gName" value="${goodsRetrieve.gName}">
		<input type="hidden" name="gPrice" value="${goodsRetrieve.gPrice}">
		<input type="hidden" name="gCategory" value="${goodsRetrieve.gCategory}">
		<input type="hidden" name="userid" value="${logindto.userid}">
		<span style="font-size: 15px; margin-bottom: 30px;"><b>${category}</b></span>

		
<span style="font-size:15px; margin-bottom:30px;"><b><a href="/cat/goodsList/gCategory/${goodsRetrieve.gCategory}/${1}">${goodsRetrieve.gCategory}</a></b></span>
<table width="750px" cellspacing="0" cellpadding="0" style="margin-top:30px;" align="center" >
<tr>
<td align="center" width="60px"><span style="font-size:12px;"><a href="/cat/goodsList/gCategory/rice/${1}">사료</a></span></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="/cat/goodsList/gCategory/snack/${1}">간식</a></span></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="/cat/goodsList/gCategory/tower/${1}">캣타워</a></span></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="/cat/goodsList/gCategory/scratcher/${1}">스크래쳐</a></span></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="/cat/goodsList/gCategory/send/${1}">모래</a></span></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="/cat/goodsList/gCategory/toy/${1}">장난감</a></span></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="/cat/goodsList/gCategory/healthy/${1}">건강영양제</a></span></td>
</tr>
<tr>
<td colspan="7"><hr></td>
</tr>
</table>
		<table width="1200px" cellspacing="0" cellpadding="0"
			style="margin-top: 20px;" align="center">
			<tr>
				<td height="30" >
			</tr>
			<tr>
				<td align="center">
					<table align="center" width="750px" cellspacing="0" cellpadding="0"
						 style='margin:0'>
						<tr>
							<td height="20px" colspan="3" align="center">
							 <img src="/cat/images/goodsbar.gif">
							</td>
						</tr>
						<tr>
							<td height="20px">
							</td>
						</tr>
						<tr>
							<td height="30px" valign="top" style="font-size:14px;" colspan="3">
							<b>${goodsRetrieve.gName}</b></td>
						</tr>
						<tr>
							<td height="20px" valign="top" style="font-size:14px;" colspan="3"></td>
						</tr>
							
						<tr>
							<td rowspan="8" width="300px"><img
								src="/cat/images/${goodsRetrieve.gCategory}/${goodsRetrieve.gImage}.jpg"
								border="0" align="center" width="250" /></td>
						</tr>
						<tr>
							<td class="td_title" width="60px" style="font-size:12px;">원산지</td>
							<td class="td_red" colspan="2" style='padding-left: 30px; font-size:12px;'>
								${goodsRetrieve.gCountry}</td>
						</tr>
						<tr>
							<td class="td_title" width="60px" style="font-size:12px;">제조회사</td>
							<td class="td_red" colspan="2" style='padding-left: 30px; font-size:12px;'>
								${goodsRetrieve.gCompany}</td>
						</tr>
						<tr>
							<td class="td_title"width="60px" style="font-size:12px;">유통기한</td>
							<td class="td_red" colspan="2" style='padding-left: 30px; font-size:12px;'>
								<c:choose>
								 <c:when test="${empty goodsRetrieve.gDate}">
								 <span style="color:red;">유통기한이 없는 제품입니다.</span></td>
								 </c:when>
								 <c:otherwise>
								 ${goodsRetrieve.gDate}</td>
								 </c:otherwise>
								</c:choose>
						</tr>
						<tr>
							<td class="td_title"width="60px" style="font-size:12px;">금액</td>
							<td class="td_red" colspan="2" style='padding-left: 30px; font-size:12px;'>
								${goodsRetrieve.gPrice} 원</td>
						</tr>
						<tr>
							<td height="100px" colspan="2px">
							</td>
						</tr>
						<tr>
							<td colspan="2" align="right"><font color="#2e56a9" size="2"
								style='padding-left: 30px'><b> 배송료 : 2500원</b> </font> <font
								size="2">(도서 산간지역 별도 배송비 추가)</font></td>
						</tr>

						<tr>
							<td class="td_title" align="right" colspan="2" style="font-size:12px;">주문수량&nbsp;
							<input type="text" name="gAmount" value="${goodsRetrieve.gAmount}" id="gAmount" style="text-align: right; height: 18px" size="3"> 
							<img src="/cat/images/up.PNG" id="up"> <img src="/cat/images/down.PNG" id="down"></td>
						</tr>
				</table>

			</td>
		</tr>
	</table>

	<br> <button id="buy">구매</button>
	&nbsp;&nbsp;
	<button id="favor">위시 리스트</button>&nbsp;&nbsp;
	<button id="cart">장바구니</button><br><br>
	<img src="/cat/images/goodsbar.gif">
</form>
    