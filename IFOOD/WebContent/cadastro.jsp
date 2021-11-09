<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Cadastro - JSPs</title>
            <%@ include file="header.jsp" %>			
		</head>

        <body>
            <div class="site-wrapper">
                <div class="site-wrapper-inner">
                    <div class="container">
                        <%@ include file="menu.jsp" %>

                            <div class="inner-cover">
                                <h1>Cadastro de Produto</h1>
                                <c:if test="${not empty msg }">
                                    <div class="alert alert-success">${msg}</div>
                                </c:if>
                                <c:if test="${not empty erro }">
                                    <div class="alert alert-danger">${erro}</div>
                                </c:if>

                                <form action="cadastro" method="post">
                                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                                        <li class="nav-item"><a class="nav-link active" id="home-tab" data-toggle="tab"
                                                href="#home" role="tab" aria-controls="home"
                                                aria-selected="true">Restaurante</a></li>
                                        <li class="nav-item"><a class="nav-link" id="profile-tab" data-toggle="tab"
                                                href="#perfil" role="tab" aria-controls="profile"
                                                aria-selected="false">Endere�o</a></li>
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
                                                <label for="id-nome">Nome</label> <input type="text" name="nome"
                                                    id="id-nome" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="id-valor">Valor M�nimo</label> <input type="text"
                                                    name="valor" id="id-valor" class="form-control">
                                            </div>
                                             <div class="form-group">
                                                <label for="id-valor">Rua</label> <input type="text"
                                                    name="rua" id="id-valor" class="form-control">
                                            </div>
                                            
                                        </div>

                                        <div class="tab-pane fade" id="perfil" role="tabpanel"
                                            aria-labelledby="profile-tab">
                                            <input type="hidden" value="cadastrar" name="acao">

                                            <div style="display: flex;justify-content: space-between;">
                                                <div class="form-group">
                                                    <label for="formGroupExampleInput">Logradouro</label>
                                                    <input name="logradouro" type="text" class="form-control"
                                                        id="logradouro" placeholder="Digite o Logradouro">
                                                </div>
                                                <div class="form-group">
                                                    <label for="formGroupExampleInput2">N�mero</label>
                                                    <input name="numero" type="text" class="form-control" id="numero"
                                                        placeholder="Digite o N�mero">
                                                </div>
                                                <div class="form-group">
                                                    <label for="formGroupExampleInput2">Cep</label>
                                                    <input name="cep" type="text" class="form-control" id="cep"
                                                        placeholder="Digite o Cep">
                                                </div>
                                            </div>
                                            <div style="display: flex;justify-content: space-between;">
                                                <div class="form-group">
                                                    <label for="formGroupExampleInput">Bairro</label>
                                                    <input name="bairro" type="text" class="form-control" id="bairro"
                                                        placeholder="Digite o Bairro">
                                                </div>
                                                <div class="form-group">
                                                    <label for="formGroupExampleInput2">Cidade</label>
                                                    <input name="cidade" type="text" class="form-control" id="cidade"
                                                        placeholder="Digite a Cidade">
                                                </div>
                                                <div class="form-group">
                                                    <label for="formGroupExampleInput2">Estado</label>
                                                    <input name="estado" type="text" class="form-control" id="estado"
                                                        placeholder="Digite o Estado">
                                                </div>
                                                <div class="form-group">
                                                    <label for="formGroupExampleInput2">Pa�s</label>
                                                    <input name="pais" type="text" class="form-control" id="pais"
                                                        placeholder="Digite o Pa�s">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="formGroupExampleInput2">Complemento</label>
                                                <input name="complemento" type="text" class="form-control"
                                                    id="complemento" placeholder="Digite o Complemento">
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
                                </form>
                            </div>
                    </div>
                </div>

            </div>
            <%@ include file="footer.jsp" %>
        </body>

        </html>