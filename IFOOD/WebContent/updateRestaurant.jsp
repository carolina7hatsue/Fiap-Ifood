<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Edição - JSPs</title>
            <%@ include file="header.jsp" %>			
		</head>

        <body>
            <div class="site-wrapper">
                <div class="site-wrapper-inner">
                    <div class="container">
                        <%@ include file="menu.jsp" %>

                            <div class="inner-cover">
                                <h1>Edição Restaurante</h1>
                                <c:if test="${not empty msg }">
                                    <div class="alert alert-success">${msg}</div>
                                </c:if>
                                <c:if test="${not empty erro }">
                                    <div class="alert alert-danger">${erro}</div>
                                </c:if>

                                <form action="cadastro" method="post">
                                	<input type="hidden" value="editar" name="acao">
                                	<input type="hidden" value="${restaurant.idRestaurant}" name="codigo">
                                	<input type="hidden" value="${restaurant.address}" name="codigoEndereco">
                                	
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

                                    <!--  Restaurant -->
                                    <div class="tab-content" id="myTabContent">
                                        <div class="tab-pane fade show active" id="home" role="tabpanel"
                                            aria-labelledby="home-tab">
                                            <input type="hidden" value="cadastrar" name="acao">
                                            <div class="form-group">
                                                <label for="id-nome">Nome</label> 
                                                <input type="text" name="nome" id="id-nome" class="form-control" value="${restaurant.name}">
                                            </div>
                                            <div class="form-group">
                                                <label for="id-valor">Valor Mínimo</label> 
                                                <input type="text" name="valor" id="id-valor" class="form-control" value="${restaurant.minPrice}">
                                            </div>     
                                            
                                            <div class="form-group">
                                                <label for="id-valor">CNPJ</label> 
                                                <input type="text" name="valor" id="id-valor" class="form-control" value="${restaurant.cNPJ}">
                                            </div>  
                                                        
                                        </div>

                                        <div class="tab-pane fade" id="perfil" role="tabpanel"
                                            aria-labelledby="profile-tab">
                                            <input type="hidden" value="cadastrar" name="acao">

											<div class="form-group">
                                                <label for="id-valor">Rua</label> 
                                                <input type="text" name="rua" id="id-valor" class="form-control" value="${address.street}">
                                            </div>
                                                <div class="form-group">
                                                    <label for="formGroupExampleInput2">Número</label>
                                                    <input name="numero" type="text" class="form-control" id="numero"
                                                        placeholder="Digite o Número" value="${address.number}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="formGroupExampleInput2">Cep</label>
                                                    <input name="cep" type="text" class="form-control" id="cep"
                                                        placeholder="Digite o Cep" value="${address.cEP}">
                                                </div>
                                            </div>
                                            <div style="display: flex;justify-content: space-between;">
                                                <div class="form-group">
                                                    <label for="formGroupExampleInput">Bairro</label>
                                                    <input name="bairro" type="text" class="form-control" id="bairro"
                                                        placeholder="Digite o Bairro" value="${address.district}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="formGroupExampleInput2">Cidade</label>
                                                    <input name="cidade" type="text" class="form-control" id="cidade"
                                                        placeholder="Digite a Cidade" value="${address.city}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="formGroupExampleInput2">Estado</label>
                                                    <input name="estado" type="text" class="form-control" id="estado"
                                                        placeholder="Digite o Estado" value="${address.state}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="formGroupExampleInput2">País</label>
                                                    <input name="pais" type="text" class="form-control" id="pais"
                                                        placeholder="Digite o País" value="${address.country}">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="formGroupExampleInput2">Complemento</label>
                                                <input name="complemento" type="text" class="form-control"
                                                    id="complemento" placeholder="Digite o Complemento" value="${address.complement}">
                                            </div>
                                        </div>


                                        <div class="tab-pane fade" id="contato" role="tabpanel"
                                            aria-labelledby="contact-tab">
                                            
											<select class="form-select" aria-label="Default select example">
											  <option selected>Open this select menu</option>
											  <option value="1">One</option>
											  <option value="2">Two</option>
											  <option value="3">Three</option>
											</select>
										</div>
                                    </div>
                                    <input type="submit" value="Salvar" class="btn btn-primary">
                                    <a href="cadastro?acao=listar" class="btn btn-danger">Cancelar</a>
                                </form>
                            </div>
                    </div>
                </div>
            </div>
            <%@ include file="footer.jsp" %>
        </body>

        </html>