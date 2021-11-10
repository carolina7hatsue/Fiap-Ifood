<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="resources/css/style.css">
	<script src="resources/js/lib/jquery.min.js"></script>
    <script src="resources/js/lib/bootstrap.bundle.min.js"></script>
    <script src="resources/js/script.js"></script>
    <title>Ifood</title>
<%@ include file="header.jsp" %>
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
    <section class="container container-categorie" style="margin-bottom: 50px;">
      <div class="card" style="width: 18rem;">
        <img class="img-food" src="resources/images/restaurant-post.png" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">Cadastrar restaurante</h5>
          <p class="card-text">Cadastre um restaurante preenchendo um formulário</p>
          <a data-toggle="modal" data-target="#site-modal" data-highres="resources/images/restaurant-post.png" href="#"
            class="btn btn-primary btn-action"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
              fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16">
              <path
                d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z" />
            </svg></a>
        </div>
      </div>
      <div class="card" style="width: 18rem;">
        <img class="img-food" src="resources/images/restaurant-list.png" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">Visualizar restaurantes</h5>
          <p class="card-text">Veja a lista de restaurantes cadastrados</p>
          <a class="btn btn-primary btn-action" href="cadastro?acao=listar"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
              fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
              <path
                d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z" />
              <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z" />
            </svg></a>
        </div>
      </div>
      <div class="card" style="width: 18rem;">
        <img class="img-food" src="resources/images/categorie.png" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">Visualizar Categorias</h5>
          <p class="card-text">Veja a lista de categorias existentes cadastradas</p>
          <a class="btn btn-primary btn-action"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
              fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
              <path
                d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z" />
              <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z" />
            </svg></a>
        </div>
      </div>
    </section>
  </article>


  <article id="site-modal" class="modal fade">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div style="width: 100%;height: 85px;padding:10px;display: flex;">
          <img style="width: 50px;" class="img-food" src="resources/images/restaurant-post.png" class="card-img-top" alt="...">
          <h4 class="sub-title-food" style="align-self: flex-end;margin-left: 20px;">Cadastro de Restaurante</h4>
        </div>
        <hr style="width: 100%;">
        <form class="form-restaurant">
          <div style="display: flex;margin-bottom: 10px;">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" style="color: #ffc107;" fill="currentColor"
              class="bi bi-shop" viewBox="0 0 16 16">
              <path
                d="M2.97 1.35A1 1 0 0 1 3.73 1h8.54a1 1 0 0 1 .76.35l2.609 3.044A1.5 1.5 0 0 1 16 5.37v.255a2.375 2.375 0 0 1-4.25 1.458A2.371 2.371 0 0 1 9.875 8 2.37 2.37 0 0 1 8 7.083 2.37 2.37 0 0 1 6.125 8a2.37 2.37 0 0 1-1.875-.917A2.375 2.375 0 0 1 0 5.625V5.37a1.5 1.5 0 0 1 .361-.976l2.61-3.045zm1.78 4.275a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 1 0 2.75 0V5.37a.5.5 0 0 0-.12-.325L12.27 2H3.73L1.12 5.045A.5.5 0 0 0 1 5.37v.255a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0zM1.5 8.5A.5.5 0 0 1 2 9v6h1v-5a1 1 0 0 1 1-1h3a1 1 0 0 1 1 1v5h6V9a.5.5 0 0 1 1 0v6h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V9a.5.5 0 0 1 .5-.5zM4 15h3v-5H4v5zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-3zm3 0h-2v3h2v-3z" />
            </svg>
            <h5 style="margin-left: 12px;" class="sub-title-food">Detalhes</h5>
          </div>
          <div class="form-row">
            <div class="col-md-4 mb-3">
              <label for="validationServer01">Nome</label>
              <input type="text" class="form-control is-valid" id="validationName" placeholder="Nome"
                value="Burger King" required>
              <div class="valid-feedback">
                Tudo certo!
              </div>
            </div>
            <div class="col-md-4 mb-3">
              <label for="validationServer01">Valor min. do pedido</label>
              <input type="text" class="form-control is-valid" id="validationValueMin"
                placeholder="Digite um valor minimo de pedido" value="R$20,00" required>
              <div class="valid-feedback">
                Tudo certo!
              </div>
            </div>
          </div>
          <hr style="width: 100%;">
          <div style="display: flex;margin-top: 20px;margin-bottom: 10px;">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" style="color: #ffc107;" fill="currentColor"
              class="bi bi-map" viewBox="0 0 16 16">
              <path fill-rule="evenodd"
                d="M15.817.113A.5.5 0 0 1 16 .5v14a.5.5 0 0 1-.402.49l-5 1a.502.502 0 0 1-.196 0L5.5 15.01l-4.902.98A.5.5 0 0 1 0 15.5v-14a.5.5 0 0 1 .402-.49l5-1a.5.5 0 0 1 .196 0L10.5.99l4.902-.98a.5.5 0 0 1 .415.103zM10 1.91l-4-.8v12.98l4 .8V1.91zm1 12.98 4-.8V1.11l-4 .8v12.98zm-6-.8V1.11l-4 .8v12.98l4-.8z" />
            </svg>
            <h5 style="margin-left: 12px;" class="sub-title-food">Endereço</h5>
          </div>
          <div class="form-row">
            <div class="col-md-4 mb-3">
              <label for="validationServer01">Logradouro</label>
              <input type="text" class="form-control is-valid" id="validationLogradouro" placeholder="Logradouro"
                value="Avenida Paulista" required>
              <div class="valid-feedback">
                Tudo certo!
              </div>
            </div>
            <div class="col-md-4 mb-3">
              <label for="validationServer02">Bairro</label>
              <input type="text" class="form-control is-valid" id="validationBairro" placeholder="Bairro"
                value="Avenida Paulista" required>
              <div class="valid-feedback">
                Tudo certo!
              </div>
            </div>
            <div class="col-md-4 mb-3">
              <label for="validationServerUsername">Número</label>
              <div class="input-group">
                <input type="text" class="form-control is-invalid" id="validationServerNumero" placeholder="Número"
                  aria-describedby="inputGroupPrepend3" required>
                <div class="invalid-feedback">
                  Por favor, digite um número.
                </div>
              </div>
            </div>
          </div>
          <div class="form-row">
            <div class="col-md-6 mb-3">
              <label for="validationServer03">Cidade</label>
              <input type="text" class="form-control is-invalid" id="validationServer03" placeholder="Cidade" required>
              <div class="invalid-feedback">
                Por favor, informe uma cidade válida.
              </div>
            </div>
            <div class="col-md-3 mb-3">
              <label for="validationServer04">Estado</label>
              <input type="text" class="form-control is-invalid" id="validationServer04" placeholder="Estado" required>
              <div class="invalid-feedback">
                Por favor, informe um estado válido.
              </div>
            </div>
            <div class="col-md-3 mb-3">
              <label for="validationServer05">CEP</label>
              <input type="text" class="form-control is-invalid" id="validationServer05" placeholder="CEP" required>
              <div class="invalid-feedback">
                Por favor, informe um CEP válido.
              </div>
            </div>
          </div>
          <hr style="width: 100%;">
          <div style="text-align: -webkit-right;">
            <button class="btn btn-primary btn-action-cancel" data-toggle="modal" data-target="#site-modal"
              data-highres="resources/images/restaurant-post.png" href="#">Cancelar</button>
            <button class="btn btn-primary btn-action" type="submit">Cadastrar</button>
          </div>
        </form>

      </div>
    </div>
  </article>


<%@ include file="footer.jsp" %>
</body>
</html>