<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<title>Edição - JSPs</title>
<%@ include file="header.jsp" %>			
</head>
<body>
<div class="container">
	<h1>Edição Restaurante</h1>
                         <form action="cadastro" method="post">
                         	<input type="hidden" value="editar" name="acao">
                         	<input type="hidden" value="${restaurantes.idRestaurant}" name="codigo">
                         	<input type="hidden" value="${restaurantes.address.idAddress}" name="codigoEndereco">
                         	
                             <ul class="nav nav-tabs" id="myTab" role="tablist">
                                 <li class="nav-item"><a class="nav-link active" id="home-tab" data-toggle="tab"
                                         href="#home" role="tab" aria-controls="home"
                                         aria-selected="true">Restaurante</a></li>
                                 <li class="nav-item"><a class="nav-link" id="profile-tab" data-toggle="tab"
                                         href="#perfil" role="tab" aria-controls="profile"
                                         aria-selected="false">Endereço</a></li>
                                 <li class="nav-item"><a class="nav-link" id="contact-tab" data-toggle="tab"
                                         href="#contato" role="tab" aria-controls="contact"
                                         aria-selected="false">Categoria</a></li>
                             </ul>

                             <!--  Restaurante -->
                             <div class="tab-content" id="myTabContent">
                                 <div class="tab-pane fade show active" id="home" role="tabpanel"
                                     aria-labelledby="home-tab">
                                     <div class="form-group">
                                         <label for="id-nome">Nome</label> 
                                         <input type="text" name="nome" id="id-nome" class="form-control" value="${restaurantes.name}">
                                     </div>
                                     <div class="form-group">
                                         <label for="id-valor">Valor Mínimo</label> 
                                         <input type="text" name="valor" id="id-valor" class="form-control" value="${restaurantes.minPrice}">
                                     </div>     
                                     
                                     <div class="form-group">
                                         <label for="id-valor">CNPJ</label> 
                                         <input type="text" name="valor" id="id-valor" class="form-control" value="${restaurantes.CNPJ}">
                                     </div>            
                                 </div>
							<!-- Endereço -->
                                 <div class="tab-pane fade" id="perfil" role="tabpanel"
                                     aria-labelledby="profile-tab">
									<div class="form-group">
                                         <label for="id-valor">Rua</label> 
                                         <input type="text" name="rua" id="id-valor" class="form-control" value="${endereco.street}">
                                     </div>
                                         <div class="form-group">
                                             <label for="formGroupExampleInput2">Número</label>
                                             <input name="numero" type="text" class="form-control" id="numero"
                                                 placeholder="Digite o Número" value="${endereco.number}">
                                         </div>
                                         <div class="form-group">
                                             <label for="formGroupExampleInput2">Cep</label>
                                             <input name="cep" type="text" class="form-control" id="cep"
                                                 placeholder="Digite o Cep" value="${endereco.cEP}">
                                         </div>
                                     </div>
                                     <div style="display: flex;justify-content: space-between;">
                                         <div class="form-group">
                                             <label for="formGroupExampleInput">Bairro</label>
                                             <input name="bairro" type="text" class="form-control" id="bairro"
                                                 placeholder="Digite o Bairro" value="${endereco.district}">
                                         </div>
                                         <div class="form-group">
                                             <label for="formGroupExampleInput2">Cidade</label>
                                             <input name="cidade" type="text" class="form-control" id="cidade"
                                                 placeholder="Digite a Cidade" value="${endereco.city}">
                                         </div>
                                         <div class="form-group">
                                             <label for="formGroupExampleInput2">Estado</label>
                                             <input name="estado" type="text" class="form-control" id="estado"
                                                 placeholder="Digite o Estado" value="${endereco.state}">
                                         </div>
                                         <div class="form-group">
                                             <label for="formGroupExampleInput2">País</label>
                                             <input name="pais" type="text" class="form-control" id="pais"
                                                 placeholder="Digite o País" value="${endereco.country}">
                                         </div>
                                     </div>
                                     <div class="form-group">
                                         <label for="formGroupExampleInput2">Complemento</label>
                                         <input name="complemento" type="text" class="form-control"
                                             id="complemento" placeholder="Digite o Complemento" value="${endereco.complement}">
                                     </div>
                                 </div>
			

                    <div class="tab-pane fade" id="contato" role="tabpanel" aria-labelledby="contact-tab">
                    <!-- MODIFICAR SELECT-->            
					<select class="form-select" aria-label="Default select example">
					<option value="0">Selecione</option>
					<c:forEach items="${categorias}" var="c">
						<c:if test="${c.idCategory == restaurant.category.idCategory}">
							<option value="${c.idCategory}" selected>${c.name}</option>
						</c:if>
						<c:if test="${c.idCategory != restaurant.category.idCategory}">
							<option value="${c.idCategory}">${c.name }</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<input type="submit" value="Salvar" class="btn btn-primary">
			<a href="cadastro?acao=listar" class="btn btn-danger">Cancelar</a>
		</form>
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>