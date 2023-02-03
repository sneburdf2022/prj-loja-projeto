angular.module('produtoApp', []).controller('ProdutoController', function ($scope, $http) {
  $scope.novoItem = false;
  $scope.listaProduto = [];
  $scope.msg = "";
  $scope.produto = {
    id : 0,
    nome : "",
    descricao : "",
    informacao : "",
    aba: 0,
    preco : 0.0,
    ativo : true
  }
  $scope.listarProduto = function () {
    $http.get("/api/produto/")
      .then(function (response) {
        console.log(response.data);
        $scope.listaProduto = response.data;
        $scope.novoItem = false;
      });
  }
  $scope.limparAlerta = function () {
    $scope.msg = "";
    document.querySelector("#alerta").innerHTML = "";
    document.querySelector("#alerta").classList.remove('alert-danger');
    document.querySelector("#alerta").classList.remove('alert-success');
  }
  $scope.editarProduto = function (x) {
    $scope.produto = x;
   
  }
  $scope.cadastrarNovo = function(){
    $scope.novoItem = true;
  }
  
  $scope.gravarProduto = function () {
    var itemLocal = $scope.produto;
    $scope.limparAlerta();
    let alerta = document.querySelector("#alerta");
      $scope.msg = "";

      let url = '/api/produto/';
      let tipo = "POST";
      if ($scope.produto.id > 0) {
        tipo = "PUT";
      }
      $http({
        method: tipo,
        url: url,
        data: $scope.produto
      }).then(function (response) {
        $scope.limparForm();
        $scope.listarProduto();
      }, function (response) {
        $scope.listarProduto();
        console.log('Erro: ' + response)
      });
      if (itemLocal.id > 0) {
        alerta.innerHTML = "Novo produto adicionado!";
      } else {
        alerta.innerHTML = "Pergunta atualzada!";        
      }
      alerta.classList.remove("alert-danger");
      alerta.classList.add("alert-success");
    

  }
  $scope.limparForm = function () {
    $scope.produto = null;
    $scope.limparAlerta();
  }
  $scope.removerProduto = function (id) {
    let url = '/api/produto/' + id;
    $http({
      method: "DELETE",
      url: url
    }).then(function (response) {
      $scope.listarProduto();
    }, function (response) {
      $scope.listarProduto();
      console.log('Erro: ' + response)
    });
  }
  $scope.listarProduto();
});