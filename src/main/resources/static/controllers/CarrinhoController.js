angular.module('produtoApp', []).controller('CarrinhoController', function ($scope, $http) {
    $scope.novoItem = false;
    $scope.listaProduto = [];
    $scope.msg = "";
    $scope.produto = {
        id: 0,
        nome: "",
        descricao: "",
        informacao: "",
        aba: 0,
        preco: 0.0,
        ativo: true
    }
    $scope.carrinhoproduto = {
        id: 0,
        idProduto:0,
        idCarrinho:0,
        quantidade:0,
        finalizado: false   
    }
    $scope.cliente = {
        id: 1,
        cpf: 12345678901,
        email:'email@email.com.br',
        nome: 'cliente unico por enquanto',
        ativo: true
    }
    $scope.carrinho = {
        id: 1,
        idCliente: 1
    }
    $scope.valorCarrinho = 0.0;
    $scope.bucarValorCarrinho = function(){
            $http({
                method: 'POST',
                url: '/api/carrinhoproduto/valor/',
                data: $scope.carrinho
            }).then(function (response) {                
                $scope.valorCarrinho = response.data;
                console.log($scope.valorCarrinho);
            }, function (response) {                
                $scope.listarProduto();
                console.log('Erro: ' + response)
            });
    };
    $scope.bucarValorCarrinho();
    $scope.listarProduto = function () {
        $http.get("/api/carrinhoproduto/")
            .then(function (response) {
                $scope.listaProduto = response.data;
                $scope.novoItem = false;
            });
    }
    $scope.removerProduto = function (id) {
        let url = '/api/carrinhoproduto/' + id;
        $http({
          method: "DELETE",
          url: url
        }).then(function (response) {
          $scope.listarProduto();
          $scope.atualizarValor();
        }, function (response) {
          $scope.listarProduto();
          $scope.atualizarValor();
          console.log('Erro: ' + response)
        });
      }
    $scope.adicionarCarrinho = function () {
        var itemLocal = $scope.carrinho;
        let url = '/api/carrinho/';
        let tipo = "POST";
        if ($scope.carrinho.id > 0) {
            tipo = "PUT";
        }
        $http({
            method: tipo,
            url: url,
            data: $scope.carrinho
        }).then(function (response) {
            $scope.listarProduto();
        }, function (response) {
            $scope.listarProduto();
            console.log('Erro: ' + response)
        });
    }
    $scope.adicionarCliente = function () {
        let url = '/api/cliente/';
        let tipo = "POST";
        if ($scope.cliente.id > 0) {
            tipo = "PUT";
        }
        $http({
            method: tipo,
            url: url,
            data: $scope.cliente
        }).then(function (response) {
            $scope.listarProduto();
        }, function (response) {
            $scope.listarProduto();
            console.log('Erro: ' + response)
        });
    }
    $scope.adicionarProduto = function (produto) {
        
        let url = '/api/carrinhoproduto/';
        let tipo = "POST";
        $scope.carrinhoproduto.idProduto = produto.id;
        $scope.carrinhoproduto.idCliente = 1;
        $scope.carrinhoproduto.idCarrinho = 1;
        $scope.carrinhoproduto.quantidade = 1;
        $scope.carrinhoproduto.finalizado = false;
        $scope.carrinhoproduto.id = 0;
        console.log($scope.carrinho);
        $http({
            method: tipo,
            url: url,
            data: $scope.carrinhoproduto
        }).then(function (response) {
            $scope.atualizarValor();
        }, function (response) {
            $scope.atualizarValor();
            console.log('Erro: ' + response)
        });
    }
    $scope.atualizarValor = function(){
        $scope.bucarValorCarrinho();        
    }
    $scope.finalizar = function(){
        alert('Em desenvolvimento');
    }
    $scope.adicionarCliente();
    $scope.adicionarCarrinho();
    $scope.listarProduto();
});