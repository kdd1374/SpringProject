<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
</script>

<span style="font-size:15px; margin-bottom:30px;"><b><a href="cat/goodsList/gCategory/${category}/${curpage}">${category}</a></b></span>
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
<center>
<table width="750px" cellspacing="0" cellpadding="0" style="margin-top:50px;">
<tr>
<c:forEach var="i" items="${goodsList}" varStatus="status">
 <td align="center" valign="top">
 <table>
 <tr>
 <td><a href="/cat/goodsRetrieve/${i.gCode}"><img src="/cat/images/${i.gCategory}/${i.gImage}.jpg" width="178px" height="185px"></a></td>
 </tr>
 <tr>
 <td align="left" width="178px" height="65px" valign="top"><span style="font-size:12px;">${i.gName}</span></td>
 </tr>
 <tr>
<td align="left"><span style="font-size:12px; color:#f0e928"><hr style="margin:0;">${i.gPrice}원</span><br></td>
 </table>
 </td>
 <c:if test="${status.count%4==0}">
<tr>
<td height="10">
</tr>
</c:if>
 </c:forEach>
 </tr>
 <tr>
 <td colspan="4" align="center">
 <c:forEach var="i" begin="1" end="${goodsTotal}">
 <c:choose>
 <c:when test="${i == curpage}">
 <span style="font-size:12px;"><b>${i}</b>&nbsp;&nbsp;&nbsp;</span>
 </c:when>
 <c:otherwise>
 <span style="font-size:12px;"><b>[ <a href="/cat/goodsList/gCategory/${category}/${i}">${i}</a> ]</b>&nbsp;&nbsp;&nbsp;</span>
 </c:otherwise>
 </c:choose>
 </c:forEach>
 </td>
 </tr>
</table>
</center>
