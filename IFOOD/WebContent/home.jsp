<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home - JSPs</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%-- 	<div class="site-wrapper">
		<div class="site-wrapper-inner">
	    	<div class="container">
			<%@ include file="menu.jsp" %>
	        	<div class="inner-cover">
		           <h1 class="cover-heading">Nome do Trabalho</h1>
		           <p class="lead">O objetivo do trabalho e uma introdução?? Ou não precisa?</p>
		           <p class="lead">Nome Membro do Grupo RM XXXXX</p>
		           <p class="lead">Nome Membro do Grupo RM XXXXX</p>
		           <p class="lead">Nome Membro do Grupo RM XXXXX</p>
		           <p class="lead">Nome Membro do Grupo RM XXXXX</p>
		         </div>
	    	</div>
		</div>
	</div> 
--%>
	
<!-- Layout Guilherme -->  
	<article id="page-action" class="page-section text-center py-5">

	<header class="page-section-header container">
	<div class="row justify-content-center">
		<div class="col-11 col-sm-10 col-md-8">
			<h2 class="page-section-title">Actions</h2>
			<br />
		</div>
	</div>
	</header> <section class="layout-multicolumn container">

	<div class="row justify-content-center family-sans text-uppercase">

		<section class="mb-5 col-10 col-md-6 col-lg-4 col-xl-3"> <a
			data-toggle="modal" data-target="#site-modal"
			data-highres="images/monster01.svg" href="#"> <img
			class="layout-image" src="images/restaurant-post.png"
			alt="post_restaurant">
		</a>
		<h5 class="layout-title pt-2">Restaurant</h5>

		</section>

		<section class="mb-5 col-10 col-md-6 col-lg-4 col-xl-3"> <a
			data-toggle="modal" data-target="#site-modal"
			data-highres="images/monster02.svg" href="#"> <img
			class="layout-image" src="images/categorie.png"
			alt="Monster Image 02">
		</a>
		<h5 class="layout-title pt-2">Categories</h5>
		</section>

		<section class="mb-5 col-10 col-md-6 col-lg-4 col-xl-3"> <a
			data-toggle="modal" data-target="#site-modal"
			data-highres="images/monster03.svg" href="#"> <img
			class="layout-image" src="images/info.png" alt="Monster Image 03">
		</a>
		<h5 class="layout-title pt-2">Info</h5>
		</section>

	</div>

	</section> 
</article>
<!-- Layout Guilherme -->  

	<%@ include file="footer.jsp" %>
</body>
</html>