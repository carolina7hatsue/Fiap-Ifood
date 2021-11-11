<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/style.css">
<script src="resources/js/lib/jquery.min.js"></script>
<script src="resources/js/lib/bootstrap.bundle.min.js"></script>
<script src="resources/js/script.js"></script>
<title>Ifood</title>
<%@ include file="header.jsp"%>
</head>
<body data-spy="scroll" data-target=".site-nav" data-offset="55">


	<article id="page-action" class="page-section text-center py-5">

		<header class="page-section-header container">
			<div class="row justify-content-center">
				<div class="col-11 col-sm-10 col-md-8">
					<br />
				</div>
			</div>
		</header>
		<section class="container container-categorie"
			style="margin-bottom: 50px;">
			<div class="card" style="width: 18rem;">
				<img class="img-food" src="resources/images/restaurant-post.png"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Cadastrar restaurante</h5>
					<p class="card-text">Cadastre um restaurante preenchendo um
						formulário</p>
					<a class="btn btn-primary btn-action" class="nav-link"
						href="cadastro?acao=abrir-form-cadastro"
						class="btn btn-primary btn-action"><svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16">
              <path
								d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z" />
            </svg></a>
				</div>
			</div>
			<div class="card" style="width: 18rem;">
				<img class="img-food" src="resources/images/restaurant-list.png"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Visualizar restaurantes</h5>
					<p class="card-text">Veja a lista de restaurantes cadastrados</p>
					<a class="btn btn-primary btn-action" href="cadastro?acao=listar"><svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
              <path
								d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z" />
              <path
								d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z" />
            </svg></a>
				</div>
			</div>
		</section>
	</article>

	<%@ include file="footer.jsp"%>
</body>
</html>