<%@page import="java.util.List"%>
<%@page import="com.dto.MemberDTO"%>
<%@page import="com.dto.CartDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		console.log("ready");
		$("#same").on("click",function(){
			console.log("same");
			if(this.checked){
				$("#orderName").val($("#mname").val());
				$("#sample4_postcode").val($("#mpost").val());
				$("#sample4_roadAddress").val($("#maddress1").val());
				$("#sample4_jibunAddress").val($("#maddress2").val());
				$("#phone").val($("#mphone").val());
			}else{
				$("#orderName").val("");
				$("#sample4_postcode").val("");
				$("#sample4_roadAddress").val("");
				$("#sample4_jibunAddress").val("");
				$("#phone").val("");
			}
		});
		$("form").on("submit",function(){
			var name = $("#orderName").val();
			var post = $("#sample4_postcode").val();
			var addr1 = $("#sample4_roadAddress").val();
			var addr2 = $("#sample4_jibunAddress").val();
			var phone = $("#phone").val();
			if(name.length == 0){
				alert("이름를 입력해주세요");
				$("#orderName").focus();
				return false;
			}else if(post.length == 0 || addr1.length ==0){
				alert("배송주소를 입력해주세요");
				$("#sample4_postcode").focus();
				return false;
			}else if(addr2.length ==0){
				alert("상세주소를 입력해주세요");
				$("#sample4_jibunAddress").focus();
				return false;
			}else if(name.length == 0){
				alert("휴대전화를 입력해주세요");
				$("#phone").focus();
				return false;
			}
		});
	});
</script>



<form name="myForm" method="GET"  action="/cat/m/cartOrderAllDone">
<input type="hidden" name="username" value="${logindto.username}">
<input type="hidden" name="userid" value="${logindto.userid}">
    
	<table width="850px" cellspacing="0" cellpadding="0" border="0" align="center" style="margin-left: auto; margin-right: auto;">

		<tr>
			<td height="30">
		</tr>

		<tr>
			<td><b>주문상품 확인</b></td>
		</tr>

		<tr>
			<td height="15">
		</tr>

		<tr>
			<td height="5">
		</tr>

		<tr>
			<td>
				<table width="850px" cellspacing="0" cellpadding="0">
					<tr height="41">
						<td class="td_default" align="center" bgcolor="#fffb8b"><strong>주문번호</strong></td>
						<td class="td_default" align="center" colspan="2" bgcolor="#fffb8b"><strong>상품정보</strong></td>
						<td class="td_default" align="center" bgcolor="#fffb8b"><strong>판매가</strong></td>
						<td class="td_default" align="center" colspan="2" bgcolor="#fffb8b"><strong>수량</strong></td>

					</tr>
<!--  변수 선언 -->					
<c:set var="totalSum" value="0" />					
			<c:forEach var="xxx" items="${cartList}" varStatus="status">		
			
<!-- 누적 -->
		<c:set var="totalSum" value="${totalSum + xxx.gPrice * xxx.gAmount }" />					
<input type="hidden" name="gCode" value="${xxx.gCode}">
<input type="hidden" name="gPrice" value="${xxx.gPrice}">
<input type="hidden" name="gAmount" value="${xxx.gAmount}">
<input type="hidden" name="gImage" value="${xxx.gImage}">
<input type="hidden" name="gCategory" value="${xxx.gCategory}">
<input type="hidden" name="gName" value="${xxx.gName}">

					<tr>
						<td class="td_default" width="80">${xxx.gCode}</td>
						<td class="td_default" width="80"><img
							src="/cat/images/${xxx.gCategory }/${xxx.gImage}.jpg" border="0" align="center"
							width="80" /></td>
						<td class="td_default" width="300" style='padding-left: 30px'>
						${xxx.gName}
							<br></td>
						<td class="td_default" align="center" width="110">
						<fmt:formatNumber value="${xxx.gPrice}" type="currency" />
						
						</td>
						<td class="td_default" align="center" width="90">${xxx.gAmount}</td>

					</tr>
                </c:forEach>
					<tr>
						<td height="30"></td>
						<td class="td_default" align="right">총 결제 금액 :</td>
						<td class="td_default" align='right'>
						<fmt:formatNumber value="${totalSum}" type="currency" />원</td>
					</tr>
				</table>
		<tr>
			<td>
				<hr size="1" color="CCCCCC">
			</td>
		</tr>

		</td>
		</tr>
		<!--  고객 정보 시작-->
		<tr>
			<td height="30">
		</tr>

		<tr>
			<td><b>고객 정보</b></td>
		</tr>

		<tr>
			<td height="15">
		</tr>


		<tr>
			<td>
				<table width="70%" cellspacing="0" cellpadding="0" border="1"
					style="border-collapse: collapse" bordercolor="#fffb8b" align="center">
					<tr>
						<td width="125" height="35" class="td_default" bgcolor="#fffb8b">
							이 름
						</td>
						<td height="35" class="td_default" align="left">&nbsp;&nbsp;<input
							class="input_default" type="text" id="mname" size="20"
							maxlength="20" value="${logindto.username}" readonly></input></td>
					</tr>
					<tr>
						<td height="35" class="td_default" bgcolor="#fffb8b">우편번호</td>
						<td height="35" class="td_default" align="left">&nbsp;&nbsp;<input
							class="input_default" type="text" id="mpost" value="${logindto.post}" readonly></input></td>
					</tr>
					<tr>
						<td height="35" class="td_default" bgcolor="#fffb8b">주 소</td>
						<td height="35" class="td_default" align="left">&nbsp;&nbsp;<input
							class="input_default" type="text" id="maddress1" size="50"
							maxlength="200" value="${logindto.addr1}" readonly></input><br> 
							&nbsp;&nbsp;<input class="input_default" type="text" id="maddress2" size="50"
							maxlength="200" value="${logindto.addr2}" readonly></input></td>
					</tr>

					<tr>
						<td height="35" class="td_default" bgcolor="#fffb8b">휴대전화</td>
						<td height="35" class="td_default" align="left">&nbsp;&nbsp;<input
							class="input_default" type="text" id="mphone" value="${logindto.phone}" readonly></input>

						</td>
					</tr>
				</table>
			</td>
		</tr>
		<!--  고객 정보 끝-->
		<tr>
			<td class="td_default"><input type="checkbox" name="same"
				id="same"> 배송지가 동일할 경우 선택하세요.</td>
		</tr>
		<!--  배송지 정보 시작-->
		<tr>
			<td height="30">
		</tr>

		<tr>
			<td><b>배송지 정보</b></td>
		</tr>

		<tr>
			<td height="15">
		</tr>


		<tr>
			<td>
				<table width="70%" cellspacing="0" cellpadding="0" border="1"
					style="border-collapse: collapse" bordercolor="#fffb8b" align="center">
					<tr>
						<td width="125" height="35" class="td_default" bgcolor="#fffb8b">이 름</td>
						<td height="35" class="td_default" align="left">&nbsp;&nbsp;<input
							class="input_default" type="text" id="orderName" name="orderName"
							size="20" maxlength="20" value=""></input></td>
					</tr>
					<tr>
						<td height="35" class="td_default" bgcolor="#fffb8b">우편번호</td>
						<td height="35" class="td_default" align="left">&nbsp;
							<!-- 다음주소 시작--> 
								<input type="text" name="post" id="sample4_postcode" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br></td>
</tr>
<tr>
<td height="35" class="td_default" bgcolor="#fffb8b">주소</td>
<td height="35" class="td_default" align="left">&nbsp;
<input type="text" name="addr1" id="sample4_roadAddress" placeholder="도로명주소">
<input type="text" name="addr2" id="sample4_jibunAddress" placeholder="지번주소">
<span id="guide" style="color:#999"></span>
<br>
							 <!-- 다음주소 끝 -->
						</td>
					</tr>

					<tr>
						<td height="35" class="td_default" bgcolor="#fffb8b">휴대전화</td>
						<td height="35" class="td_default" align="left">&nbsp;&nbsp;<input
							class="input_default" type="text" id="phone" name="phone" value=""></input></td>
					</tr>
				</table>
			</td>
		</tr>
		<!--  배송지 정보 끝-->

		<tr>
			<td height="30">
		</tr>
		<tr>
			<td><b>결제수단</b></td>
		</tr>

		<tr>
			<td height="7">
		</tr>
		<tr>
			<td>
				<table width="100%" cellspacing="0" cellpadding="0" border="0"
					style="border-collapse: collapse" bordercolor="#CCCCCC">
					<tr>
						<td width="125" height="35" class="td_default"><input
							type="radio" name="payMethod" value="신용카드" checked>신용카드</input> <input
							type="radio" name="payMethod" value="계좌이체">계좌이체</input> <input
							type="radio" name="payMethod" value="무통장 입금">무통장 입금</input></td>

					</tr>

				</table>
			</td>
		</tr>

		<tr>
			<td height="15">
		</tr>


		<tr>
			<td class="td_default" align="center"><input type='button'
				value='취소' onclick="javascript:history.back()">
				<input type='submit' value='결제하기'></td>
		</tr>
        <tr>
			<td height="30">
		</tr>

	</table>

</form>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>
