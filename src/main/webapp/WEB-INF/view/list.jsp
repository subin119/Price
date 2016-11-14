<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>        
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js" />"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#deleteBtn").click(function() {
			if(confirm("\"${productVO.productName}\"를 정말 삭제하시겠습니까?")) {
				location.href="<c:url value='/delete/${productVO.productId}'/>"
			}
		})
	});
</script>
</head>
<body style="margin:0 auto; width: 700px;">
	<c:choose>
		<c:when test="${not empty productList.productList}">
		<div style="width: 650px;">
		<h1>Product</h1>
		<hr/>
		</div>
		<table style="font-size: 18px; padding: 10px;">
			<tr style="text-align: center;">
				<td>상품번호</td>
				<td style="padding-left: 70px;">상품명</td>
				<td style="padding-left: 70px;">상품가격</td>
				<td style="padding-left: 70px;">등록일</td>
			</tr>
			<c:forEach items="${productList.productList}" var="product">
				<tr style="text-align: center;">
					<c:set var="number" value="${fn:split(product.productId,'-')[2]}" />
					<fmt:parseNumber var="number" type="number" value="${number}"/>
					<td >${number}</td>
					<td style="padding-left: 70px;">
						<a href="<c:url value="/detail/${product.productId}"/>" style="text-decoration: none;">${product.productName}</a>
					</td> 
					<td style="padding-left: 70px;">${product.price}</td> 
					<td style="padding-left: 70px;">${product.createdDate}</td>
				</tr>
			</c:forEach>
			</table><br/>
			
			<form id="searchForm" name="searchForm">
				<div id="page" style="text-align: center;">${page}</div><br/>
				<div id="select">
					<select id="searchType" name="searchType" style="font-size: 13px;">
						<option value="1" ${productSearchVO.searchType eq 1 ? "selected" : ""}>상품명</option>
						<option value="2" ${productSearchVO.searchType eq 2 ? "selected" : ""}>가격</option>
						<%-- <option value="4" ${productSearchVO.searchType eq 3 ? "selected" : ""}>높은가격순</option>
						<option value="5" ${productSearchVO.searchType eq 4 ? "selected" : ""}>낮은가격순</option> --%>
					</select>
					<input type="text" id="searchKeyword" name="searchKeyword" value="${productSearchVO.searchKeyword}"/>
					<input type="button" id="searchBtn" value="검색" onclick="movePage(0)" style="background-color: #7DB20B; color: #fff;"/><br/><br/>
					
					<input type="text" id="minNumber" name="minNumber" value="${productSearchVO.minNumber}"/> ~ 
					<input type="text" id="maxNumber" name="maxNumber" value="${productSearchVO.maxNumber}"/> 
					<input type="button" id="searchBtn" value="가격검색" onclick="movePage(0)" style="background-color: #7DB20B; color: #fff;"/><br/><br/>
				
					
					<input type="radio" id="order" name="order" value="desc" ${productSearchVO.order eq 'desc' ? "checked" : ""}>높은가격순
					<input type="radio" id="order" name="order" value="asc" ${productSearchVO.order eq 'asc' ? "checked" : ""}>낮은가격순
					<input type="radio" id="order" name="order" value="new" ${productSearchVO.order eq 'new' ? "checked" : ""}>최신등록순
					
					<input	type="button" value="초기화"
							onclick="location.href='<c:url value="/product"/>'"
							style="background-color: #F00429; color: #fff;"/>
				</div>
				
				<%-- <input	type="button" value="높은가격순"
						onclick="location.href='<c:url value="/highPrice"/>' " style="margin-left: 300px;"/>
				<input	type="button" value="낮은가격순"
						onclick="location.href='<c:url value="/lowPrice"/>' "/> --%>
				
			</form><br/><br/>
			
			<input	type="button" value="상품 등록"
					onclick="location.href='<c:url value="/write"/>' "
					style="background-color: #997F1A; color: #fff;"/>
			
		</c:when>
		<c:when test="${not empty productVO}">
			<h2>${productVO.productName}</h2><hr/>
			상품설명 : ${productVO.content}<br/><br/>
			가격 : ${productVO.price}<br/><br/>
			
			<input	type="button" value="목록보기"
					onclick="location.href='<c:url value="/product"/>'"
					style="background-color: #7DB20B; color: #fff;"/>
			<input	type="button" value="수정하기"
					onclick="location.href='<c:url value="/modify/${productVO.productId}"/>'"
					style="background-color: #7DB20B; color: #fff;"/>
			<input	type="button" value="삭제하기" id="deleteBtn" 
					style="background-color: #F00429; color: #fff;"/>
		</c:when>
		<c:otherwise>
			등록된 상품이 없습니다.
			<input	type="button" value="상품 등록"
					onclick="location.href='<c:url value="/write"/>' "/>
			<input	type="button" value="목록보기"
					onclick="location.href='<c:url value="/product"/>'"/>
		</c:otherwise>
	</c:choose>
</body>
</html>