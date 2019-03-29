<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	    

<c:set var="xxx" value="${orderAllDone}" />
<c:set var="gCode" value="${xxx[0].gCode}" />
<c:set var="gName" value="${xxx[0].gName}" />
<c:set var="gPrice" value="${xxx[0].gPrice}" />
<c:set var="gImage" value="${xxx[0].gImage}" />
<c:set var="gAmount" value="${xxx[0].gAmount}" />
<c:set var="userid" value="${xxx[0].userid}" />
<c:set var="username" value="${logindto.username}" />
<c:set var="post" value="${logindto.post}" />
<c:set var="addr1" value="${logindto.addr1}" />
<c:set var="addr2" value="${logindto.addr2}" />
<c:set var="phone" value="${logindto.phone}" />
<c:set var="email1" value="${logindto.email1}" />
<c:set var="email2" value="${logindto.email2}" />
<%-- <c:set var="payMethod" value="${xxx[0].payMethod}" /> --%>

<table width="750px" cellspacing="0" cellpadding="0" align="center">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td><h2>주문완료</h2></td>
	</tr>

	<tr>
		<td height="20">
	</tr>

	<tr>
		<td align="center"><b>주문해주셔서 감사합니다.</b></td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center"><b>${userid}</b> 님의 주문이
			안전하게 처리되었습니다.</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	<tr>
		<td class="td_default"><b>상품 및 배송정보</b>
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td>
			<table width="100%" border="1" style="border-collapse: collapse" bordercolor="#fffb8b" align="center">
				<tr>
					<td class="td_default" width="150" height="35" bgcolor="#fffb8b"> 받으시는 분</td>
					<td class="td_default" height="35" align="left">&nbsp;&nbsp;&nbsp;${username}</td>
				</tr>
				<tr>
					<td class="td_default" height="35" bgcolor="#fffb8b"> 주소</td>
					<td class="td_default" height="35" align="left">&nbsp;&nbsp; (${post})&nbsp;&nbsp;
						${addr1}<br>&nbsp;&nbsp;&nbsp;${addr2}
					</td>
				</tr>
				
				<tr>
					<td class="td_default" height="35" bgcolor="#fffb8b"> 휴대전화</td>
					<td class="td_default" height="35" align="left">&nbsp;&nbsp; ${phone}</td>
				</tr>
			</table>
	</tr>
	</td>

	<tr>
		<td height="20">
	</tr>

	<tr>
		<td>
			<table width="100%" border="1" style="border-collapse: collapse"
				bordercolor="#fffb8b">
				<tr>
					<td width="250" class="td_default" height="35" align="center" bgcolor="#fffb8b"><strong>상품명</strong></td>
					<td width="100" class="td_default" height="35" align="center" bgcolor="#fffb8b"><strong>판매가</strong></td>
					<td class="td_default" width="50" height="35" align="center" bgcolor="#fffb8b"><strong>수량</strong></td>
					<td class="td_default" width="100" height="35" align="center" bgcolor="#fffb8b"><strong>합계</strong></td>
				</tr>

 		
   <!--  변수 선언 -->
    <c:set var="totalSum" value="2500" />
	<c:forEach var="xxx" items="${orderAllDone}" varStatus="status">
    <!-- 누적 -->
		<c:set var="totalSum" value="${totalSum + xxx.gPrice * xxx.gAmount }" />		
				<tr>
					<td height="35" class="td_default">
						<span class="a_default">${xxx.gName} </span>
					</td>
					<td height="35" class="td_default" align="center">
						<span  id = "price1">${xxx.gPrice}</span>원
					</td>
					<td height="35" class="td_default" align="center">
						<span id = "num1">${xxx.gAmount}</span>권
					</td>
					<td height="35" class="td_default" align="center">
						<span>${xxx.gPrice * xxx.gAmount}</span>원
					</td>
				</tr>
			
		
</c:forEach>
			</table>
		</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	<tr>
		<td class="td_default"><b>결제정보</b></td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td>
			<table width="70%" border="1" style="border-collapse: collapse"
				bordercolor="#fffb8b" align="center">
				<tr>
					<td class="td_default" width="150" height="35" bgcolor="#fffb8b"> 결제금액</td>
					<td class="td_default" height="35" align = 'right'> 
					<input type = 'text' id = 'total' value = '${totalSum}' readonly>원
					</td>
				</tr>
				<tr>
					<td class="td_default" width="150" height="35" bgcolor="#fffb8b"> 결제수단</td>
					<td class="td_default" height="35" align = 'right'> 
					<span>${payMethod}</span>
					</td>
				</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	

	<tr>
		<td height="20">
	</tr>

	<tr>
		<td class="td_default" align="center"><a class="a_default"
			href="/cat/m/orderListDetail">주문조회 페이지로 이동</a></td>
	</tr>

	<tr>
		<td height="30">
	</tr>

</table>
