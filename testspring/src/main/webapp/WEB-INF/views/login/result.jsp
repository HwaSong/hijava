<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>
	전송 결과값<br>
	아이디 : ${userID }<br>
	이름 : ${name }<br>
	<hr>
	아이디 : ${info.userID }<br>
	이름 : ${info.name }<br>
</body>
</html>