<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<title>Edição - JSPs</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<div class="container">
		<h1>Edição Restaurante</h1>
		<form class="form-restaurant" action="cadastro" method="post">
			<input type="hidden" value="editar" name="acao"> <input
				type="hidden" value="${restaurantes.idRestaurant}" name="codigo">
			<input type="hidden" value="${restaurantes.address.idAddress}"
				name="codigoEndereco">

			<div style="display: flex; margin-bottom: 10px;">
				<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
					style="color: #ffc107;" fill="currentColor" class="bi bi-shop"
					viewBox="0 0 16 16">
              <path
						d="M2.97 1.35A1 1 0 0 1 3.73 1h8.54a1 1 0 0 1 .76.35l2.609 3.044A1.5 1.5 0 0 1 16 5.37v.255a2.375 2.375 0 0 1-4.25 1.458A2.371 2.371 0 0 1 9.875 8 2.37 2.37 0 0 1 8 7.083 2.37 2.37 0 0 1 6.125 8a2.37 2.37 0 0 1-1.875-.917A2.375 2.375 0 0 1 0 5.625V5.37a1.5 1.5 0 0 1 .361-.976l2.61-3.045zm1.78 4.275a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 1 0 2.75 0V5.37a.5.5 0 0 0-.12-.325L12.27 2H3.73L1.12 5.045A.5.5 0 0 0 1 5.37v.255a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0zM1.5 8.5A.5.5 0 0 1 2 9v6h1v-5a1 1 0 0 1 1-1h3a1 1 0 0 1 1 1v5h6V9a.5.5 0 0 1 1 0v6h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V9a.5.5 0 0 1 .5-.5zM4 15h3v-5H4v5zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-3zm3 0h-2v3h2v-3z" />
            </svg>
				<h5 style="margin-left: 12px;" class="sub-title-food">Detalhes</h5>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Nome</label> <input type="text"
						class="form-control" value="${restaurantes.name}" id="id-nome"
						name="nome" placeholder="Nome" required>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Cnpj</label> <input type="text"
						class="form-control" value="${restaurantes.CNPJ}" id="id-cnpj"
						name="cnpj" placeholder="Digite o CNPJ" required>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Valor min. do pedido</label> <input
						type="text" class="form-control" value="${restaurantes.minPrice}"
						id="id-valor" name="valor"
						placeholder="Digite um valor minimo de pedido" required>
				</div>
			</div>
			<hr style="width: 100%;">
			<div style="display: flex; margin-top: 20px; margin-bottom: 10px;">
				<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
					style="color: #ffc107;" fill="currentColor" class="bi bi-map"
					viewBox="0 0 16 16">
              <path fill-rule="evenodd"
						d="M15.817.113A.5.5 0 0 1 16 .5v14a.5.5 0 0 1-.402.49l-5 1a.502.502 0 0 1-.196 0L5.5 15.01l-4.902.98A.5.5 0 0 1 0 15.5v-14a.5.5 0 0 1 .402-.49l5-1a.5.5 0 0 1 .196 0L10.5.99l4.902-.98a.5.5 0 0 1 .415.103zM10 1.91l-4-.8v12.98l4 .8V1.91zm1 12.98 4-.8V1.11l-4 .8v12.98zm-6-.8V1.11l-4 .8v12.98l4-.8z" />
            </svg>
				<h5 style="margin-left: 12px;" class="sub-title-food">Endereço</h5>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Logradouro</label> <input
						type="text" class="form-control" id="id-rua"
						value="${endereco.street}" name="rua" placeholder="Logradouro"
						required>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationServer02">Bairro</label> <input type="text"
						class="form-control" id="id-bairro" value="${endereco.district}"
						name="bairro" placeholder="Bairro" required>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationServerUsername">Número</label>
					<div class="input-group">
						<input type="text" class="form-control" id="id-numero"
							value="${endereco.number}" name="numero" placeholder="Número"
							aria-describedby="inputGroupPrepend3" required>
					</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationServerUsername">País</label>
					<div class="input-group">
						<input type="text" class="form-control" id="id-pais"
							value="${endereco.country}" name="pais" placeholder="País"
							aria-describedby="inputGroupPrepend3" required>
					</div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="validationServer03">Cidade</label> <input type="text"
						class="form-control" id="id-cidade" value="${endereco.city}"
						name="cidade" placeholder="Cidade" required>
				</div>
				<div class="col-md-3 mb-3">
					<label for="validationServer04">Estado</label> <input type="text"
						class="form-control" id="id-estado" value="${endereco.state}"
						name="estado" placeholder="Estado" required>
				</div>
				<div class="col-md-3 mb-3">
					<label for="validationServer05">CEP</label> <input type="text"
						class="form-control" id="id-cep" value="${endereco.CEP}"
						name="cep" placeholder="CEP" required>
				</div>
			</div>

			<div class="col-md-3 mb-3">
				<label for="validationServer04">Complemento</label> <input
					type="text" class="form-control" id="id-complemento"
					value="${endereco.complement}" name="complemento"
					placeholder="Complemento" required>
			</div>

			<hr style="width: 100%;">
			<!-- Categorias -->
			<div style="display: flex; margin-bottom: 10px;">
				<svg xmlns="http://www.w3.org/2000/svg" style="color: #ffc107;"
					width="24" height="24" fill="currentColor" class="bi bi-list-ul"
					viewBox="0 0 16 16">
  							<path fill-rule="evenodd"
						d="M5 11.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm-3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2z" />
						</svg>
				<h5 style="margin-left: 12px;" class="sub-title-food">Categorias</h5>
			</div>
			<select name="categoria" id="id-categoria" class="form-control">
				<c:forEach items="${categorias}" var="c">
					<c:if test="${c.idCategory == restaurant.category.idCategory}">
						<option value="${c.idCategory}" selected>${c.name}</option>
					</c:if>
					<c:if test="${c.idCategory != restaurant.category.idCategory}">
						<option value="${c.idCategory}">${c.name }</option>
					</c:if>
				</c:forEach>
			</select>

			<hr style="width: 100%;">
			<div style="text-align: -webkit-right;">
				<input type="submit" value="Salvar" class="btn btn-primary">
				<a href="cadastro?acao=listar" class="btn btn-danger">Cancelar</a>
			</div>
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
<script>
				document.getElementById('id-cnpj').addEventListener('input', function (e) {
				    var x = e.target.value.replace(/\D/g, '').match(/(\d{0,2})(\d{0,3})(\d{0,3})(\d{0,4})(\d{0,2})/);
				    e.target.value = !x[2] ? x[1] : x[1] + '.' + x[2] + '.' + x[3] + '/' + x[4] + (x[5] ? '-' + x[5] : '');
				  });	
				
				document.getElementById('id-valor').addEventListener('input', function (e) {
				    var elemento = document.getElementById('id-valor');
			        var valor = elemento.value;

			        valor = valor + '';
			        valor = parseInt(valor.replace(/[\D]+/g, ''));
			        valor = valor + '';
			        valor = valor.replace(/([0-9]{2})$/g, ",$1");

			        if (valor.length > 6) {
			            valor = valor.replace(/([0-9]{3}),([0-9]{2}$)/g, ".$1,$2");
			        }
				    e.target.value = valor;
				  });	
				
				}
 			</script>	
</html>