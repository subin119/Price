<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="margin:0 auto; width: 400px;">
	<h1>상품 등록</h1>
	<hr/>
	<c:url var="doWrite" value="/doWrite" />
	<form:form	commandName="productVO"
				method="post"
				action="${doWrite}">
		<label for="productName">상품명</label>
		<input type="text" id="productName" name="productName"/><br/>
		<form:errors path="productName" /><br/>
	
		<label for="price">가격</label>
		<input type="text" id="price" name="price" style="margin-left: 16px;"/><br/>
		<form:errors path="price" /><br/>
		
		<label for="content" style="vertical-align: top;">상품설명</label>
		<textarea rows="10px" cols="30px" id="content" name="content"></textarea><br/>
		<form:errors path="content" /><br/>
		
		<input type="submit" value="상품등록" style="margin-left: 230px; background-color: #997F1A; color: #fff;"/>
	</form:form>
</body>
</html>