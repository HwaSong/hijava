<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
      name='viewport'>
<title>main</title>
<link href="${contextPath}/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- jQuery 3.4.1 -->
<script src="${contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script src="${contextPath}/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
</head>
<%@include file="include/header.jsp" %>

<body class="skin-blue sidebar-mini">
   <!-- Content Wrapper. Contains page content -->
   <div class="content-wrapper">

      <section class="content">
         <div>${contextPath }  <br> 
             전달 받은 내용 출력 : ${name}
         </div>
         <div>
         	<a href="${contextPath}/login/loginForm">로그인 하기</a>
         </div>
      </section>
   </div>
   
 <%@include file="include/footer.jsp" %>
	
	
	
</body>
</html>