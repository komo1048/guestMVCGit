<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="root" value="${pageContext.request.contextPath }"/>

<title>방명록 쓰기</title>
<link href="${root}/css/guest/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${root}/javascript/guest/script.js"></script>
</head>
<body>
	<%--<h3>${root}</h3> --%>

	<div align="center">
		<form class="form_style" action="${root}/guest/writeOK.do" method="post">
			<div class="title">
				<label>이름</label>
				<input type="text" name="name" size="12"/>&nbsp;&nbsp;&nbsp;&nbsp;
				
				<label>비밀번호</label>
				<input type="password" name="password"/>
			</div>
			
			<div class="content">
				<textarea rows="5" cols="55" name="message"></textarea>
			</div>
			
			<div class="title" style="text-align:right;" >
				<input type="submit" value="확인"/>
				<input type="reset" value="취소"/>
			</div>
		</form>

	<c:if test="${guestList.size()>0}">
		<c:forEach var="guestDto" items="${guestList}">		
			
			<div class="form_style" style="height:130px;">
				<div class="disp" style="border-width:1px;">
					${guestDto.name} &nbsp;
					<fmt:formatDate value="${guestDto.writeDate}" pattern="yyyy-MM-dd"/>&nbsp;&nbsp;&nbsp;
					
					<a href="javascript:updateCheck('${root}', ${guestDto.num})">수정</a>
					<a href="javascript:deleteCheck('${root}', ${guestDto.num})" >삭제</a>
				</div>
				
				<div class="disp-content">${guestDto.message}</div>
			</div><br/>		
		</c:forEach>
	</c:if>


	</div>
</body>
</html>











