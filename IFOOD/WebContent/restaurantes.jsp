<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
				
				<table class="table table-striped">
					<tr>
					<th>Nome</th>
					<th>Valor do Pedido Mínimo</th>
					<th></th>	
				</tr>
				<c:forEach items="${restaurantes }" var="r">
				<tr>
					<td>${r.name}</td>
					<td>${p.valorMin}</td>
					<td>
					
					<!-- ALTERAR codigo entre os comentarios -->
						<c:url value="produto" var="link">
							<c:param name="acao" value="abrir-form-edicao"/>
							<c:param name="codigo" value="${r.codigo }"/>
						</c:url>
					<!-- ALTERAR codigo entre os comentários -->
					
						<a href="${link}" class="btn btn-primary btn-xs">Editar</a>
						<button type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#excluirModal" onclick="codigoExcluir.value = ${p.codigo}">
  							Excluir
						</button>
					</td>
				</tr>
			</c:forEach>
				</table>
				
			</div>
		</div>

	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>