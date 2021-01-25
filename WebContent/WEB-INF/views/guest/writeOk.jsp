<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>

</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}"/>
	<c:set var="check" value="${check}"/>
	<c:if test="${check>0 }">
		<script type="text/javascript">
			alert("방명록 작성되었습니다.");
			location.href="${root}/guest/write.do";
		</script>
	</c:if>	
	
	<c:if test="${check==0 }">
		<script type="text/javascript">
			alert("방명록이 작성되지 않았습니다.");
			location.href="${root}/guest/write.do";
		</script>
	</c:if>
</body>
</html>