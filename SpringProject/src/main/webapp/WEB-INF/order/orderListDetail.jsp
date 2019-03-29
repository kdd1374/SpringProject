<%@page import="com.dto.CartDTO"%>
<%@page import="com.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		
		$(".delBtn").on("click", function() {
			var gCode = $(this).attr("data-xxx");
			var d =$(this);
			$.ajax({
				url : '/cat/m/doneDel',
				type : 'get',
				dataType : 'text',
				data : {
					gCode : gCode
				},
				success : function(data, status, xhr) {
					alert(gCode+"가 삭제되었습니다.")
					if(data=='orderListDetail'){
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
		$("#delAllDone").on("click", function() {
			if($(".check").is(":checked")==false){
				alert("삭제 할 상품을 선택해 주세요");
				return false;
			}else{
				alert("선택한 상품이 삭제 되었습니다.");
			}
			$("form").attr("action", "/cat/m/doneDelAll");
			$("form").submit();// trigger
		});

	});
</script>
<table width="850px" cellspacing="0" cellpadding="0" border="0" align="center" style="margin-left: auto; margin-right: auto;">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>주문내역</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr height="41">
		<td class="td_default" align="center" bgcolor="#fffb8b"><strong>전체선택</strong>
		<input type="checkbox" name="allCheck" id="allCheck"> </td>
		<td class="td_default" align="center" bgcolor="#fffb8b"><strong>상품번호</strong></td>
		<td class="td_default" align="center" colspan="2" bgcolor="#fffb8b"><strong>상품정보</strong></td>
		<td class="td_default" align="center" bgcolor="#fffb8b"><strong>판매가</strong></td>
		<td bgcolor="#fffb8b"></td>
	</tr>

	<tr>
		<td height="7">
	</tr>


	<form name="myForm">


<c:forEach var="x"  items="${doneList}" varStatus="status">

	<tr>
		<td class="td_default" width="80">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. --> <input
			type="checkbox" name="check" id="check81" class="check"
			value="${x.gCode}"> 
		</td>
		<td class="td_default" width="80" name="td_default" value="${x.gCode}">${x.gCode}</td>
		<td class="td_default" width="80"><a href="GoodsRetrieveServlet?gCode=${x.gCode}"><img
			src="/cat/images/${x.gCategory}/${x.gImage}.jpg" border="0" align="center"
			width="80" /></a></td>
		<td class="td_default" width="300" style='padding-left: 30px'><a href="GoodsRetrieveServlet?gCode=${x.gCode}">${x.gName}
	    </a></td>
		<td class="td_default" align="center" width="110">${x.gPrice}</td>
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
			<a class="a_black" href="#" id="delAllDone"> 선택한 상품 삭제 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="/cat/goodsList/gCategory/rice/${1}"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>
