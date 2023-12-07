<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>c1.jsp</title>
    <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<p><br/></p>
<div class="container">
    <h2>이곳은 c1.jsp파일입니다.</h2>
    <p>view자원을 관리하는 resources 학습</p>
    <hr/>
    <!-- include에 있는 것은 이미지가 나오지 않는다. -->
    <div><img src="/include/1.jpg" width="150px"/> (x)</div>
    <div><img src="/resources/2.jpg" width="150px"/> (x)</div>
    <div><img src="${ctp}/resources/2.jpg" width="150px"/> (o)</div> <!-- 안좋은 폴더관리 -->
    <div><img src="${ctp}/resources/images/3.jpg" width="150px"/> (o)</div>
    <div><img src="${ctp}/resources/images/temp/4.jpg" width="150px"/> (o)</div>
    <div><img src="${ctp}/images/5.jpg" width="150px"/> (o)</div>
    <div><img src="${ctp}/board/1.jpg" width="150px"/> (o)</div>
    <div><img src="${ctp}/board/2.jpg" width="150px"/> (o)</div>
    <div><img src="${ctp}/pds/4.jpg" width="150px"/> (o)</div>
    <div><img src="${ctp}/pds/5.jpg" width="150px"/> (o)</div>
    <div><img src="${ctp}/images/pds/5.jpg" width="150px"/> (o)</div>
    
</div>
<p><br/></p>
</body>
</html>