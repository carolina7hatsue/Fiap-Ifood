<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurantes</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<div class="site-wrapper">
		<div class="site-wrapper-inner">
			<div class="container">
				<%@ include file="menu.jsp"%>

				<div class="inner-cover">
					<h1 class="cover-heading">Restaurantes</h1>
					<c:if test="${not empty msg }">
						<div class="alert alert-success">${msg}</div>
					</c:if>
					<c:if test="${not empty erro }">
						<div class="alert alert-danger">${erro}</div>
					</c:if>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>