<%@page import="com.dto.CartDTO"%>
<%@page import="com.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		//수정버튼
		$(".updateBtn").on("click", function() {
			var gCode = $(this).attr("data-xxx");
			var gAmount = $("#cartAmount" + gCode).val();
			var gPrice = $(this).attr("data-price");
			var d =$(this);
			$.ajax({
				url : '/cat/m/cartUpdate',
				type : 'get',
				dataType : 'text',
				data : {
					gCode : gCode,
					gAmount : gAmount
				},
				success : function(data, status, xhr) {
					var sum = gAmount * gPrice;
					$("#sum" + gCode).text(sum);
					alert(gCode+"가 수정되었습니다.")
					if(data=='cartUpdate'){
		        		  d.parents().filter("tr").redirect();
		        			} 
				},
				error : function(xhr, status, error) {

				}
			});//end ajaxgkgk

		});

		$(".delBtn").on("click", function() {
			var gCode = $(this).attr("data-xxx");
			var d =$(this);
			$.ajax({
				url : '/cat/m/cartDel',
				type : 'get',
				dataType : 'text',
				data : {
					gCode : gCode
				},
				success : function(data, status, xhr) {
					alert(gCode+"가 삭제되었습니다.")
					if(data=='cartDel'){
		        		  d.parents().filter("tr").remove();  	
		        			}
				},
				error : function(xhr, status, error) {

				}
			});//end ajax

		});

		//전체선택
		$("#allCheck").on("click", function(e) {
			var result = this.checked;
			$(".check").each(function(idx, data) {
				this.checked = result;
			});
		});

		//전체cart 삭제
		$("#cartDelAll").on("click", function() {
			if($(".check").is(":checked")==false){
				alert("삭제 할 상품을 선택해 주세요");
				return false;
			}else{
				alert("선택한 상품이 삭제 되었습니다.");
			}
			$("form").attr("action", "/cat/m/cartDelAll");
			$("form").submit();// trigger
		});
		

		//주문버튼
		$(".orderBtn").on("click", function() {
			var gCode = $(this).attr("data-xxx");
			location.href = "/cat/m/cartOrderConfirm?gCode=" + gCode +"&userid=${logindto.userid}";
		});
		//전체주문버튼
		$("#orderAllConfirm").on("click", function() {
			if($(".check").is(":checked")==false){
				alert("주문 할 상품을 선택해 주세요");
				return false;
			}
			$("form").attr("action","/cat/m/cartOrderAllConfirm");
			$("form").submit();//trigger
		});
	});
</script>

<table width="850px" cellspacing="0" cellpadding="0" border="0" align="center" style="margin-left: auto; margin-right: auto;">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>장바구니</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>


	<tr>
		<td height="7">
	</tr>

	<tr height="41">
		<th class="td_default" align="center" bgcolor="#fffb8b">전체선택<br>
		<input type="checkbox" name="allCheck" id="allCheck" checked="checked"></th>
		<th class="td_default" align="center" bgcolor="#fffb8b">상품번호</th>
		<th class="td_default" align="center" colspan="2" bgcolor="#fffb8b">상품정보</th>
		<th class="td_default" align="center" bgcolor="#fffb8b">판매가</th>
		<th class="td_default" align="center" colspan="2" bgcolor="#fffb8b">수량</th>
		<th class="td_default" align="center" bgcolor="#fffb8b">합계</th>
		<th bgcolor="#fffb8b" colspan="2"></th>
	</tr>

	<tr>
		<td height="7">
	</tr>



	<form name="myForm">


<c:forEach var="x" items="${cartList}" varStatus="status">
<input type="hidden" name="username" value="${x.username}">
<input type="hidden" name="post" value="${x.post}">
<input type="hidden" name="email1" value="${x.email1}">
<input type="hidden" name="email2" value="${x.email2}">
<input type="hidden" name="phone" value="${x.phone}">
<input type="hidden" name="payMethod" value="${x.payMethod}">
<input type="hidden" name="orderday" value="${x.orderday}">
<input type="hidden" name="userid" value="${x.userid}">

	<tr>
		<td class="td_default" width="100">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. --> <input
			type="checkbox" name="check" id="check81" class="check"
			value="${x.gCode}" checked="checked">
		</td>
		<td class="td_default" width="80" name="td_default" value="${x.gCode}">${x.gCode}</td>
		<td class="td_default" width="80"><img
			src="/cat/images/etc.gif" border="0" align="center"
			width="80" /></td>
		<td class="td_default" width="300" style='padding-left: 30px'>${x.gName}
	    </td>
		<td class="td_default" align="center" width="110">${x.gPrice}</td>
		<td class="td_default" align="center" width="90"><input
			class="input_default" type="text" name="cartAmount"
			id="cartAmount${x.gCode}" style="text-align: right" maxlength="3"
			size="2" value="${x.gAmount}"></input></td>
		<td><input type="button" value="수정" class="updateBtn"
			data-xxx="${x.gCode}" data-price="${x.gPrice}"></td>
		<td class="td_default" align="center" width="80"
			style='padding-left: 5px'><span id="sum${x.gCode}">${x.gPrice*x.gAmount}
		</span></td>
		<td><input type="button" value="주문" class="orderBtn" data-xxx="${x.gCode}"></td>
		<td class="td_default" align="center" width="30"
			style='padding-left: 10px'><input type="button" value="삭제"
			id="xx${status.count}" class="delBtn" data-xxx="${x.gCode}"></td>
		<td height="10"></td>
	</tr>

</c:forEach>

	</form>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5">
		    <a class="a_black" id="orderAllConfirm" href="#"> 선택한 상품 주문 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="#" id="cartDelAll"> 선택한 상품 삭제 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="/cat/goodsList/gCategory/rice/1"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>
