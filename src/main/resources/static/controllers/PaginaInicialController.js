angular.module('produtoApp', []).controller('PgInicioController', function ($scope, $http) {
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
        ativo: true,
        imagem: 0
    }
    $scope.carrinhoproduto = {
        id: 0,
        idProduto:0,
        idCarrinho:0,
        quantidade:0,
        finalizado: false ,
        nome: ""  ,
        valor: 0,
        imagem: 0
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
    $scope.valorCarrinho = 0;
    $scope.adicionarProduto = function (produto) {
        
        let url = '/api/carrinhoproduto/';
        let tipo = "POST";
        $scope.carrinhoproduto.idProduto = produto.id;
        $scope.carrinhoproduto.idCliente = 1;
        $scope.carrinhoproduto.idCarrinho = 1;
        $scope.carrinhoproduto.quantidade = 1;
        $scope.carrinhoproduto.finalizado = false;
        $scope.carrinhoproduto.id = 0;
        $scope.carrinhoproduto.nome = produto.nome;
        $scope.carrinhoproduto.valor= produto.preco;
        $scope.carrinhoproduto.imagem= produto.imagem;
        $http({
            method: tipo,
            url: url,
            data: $scope.carrinhoproduto
        }).then(function (response) { 
            $scope.bucarValorCarrinho();           
        }, function (response) {
            console.log('Erro: ' + response)
        })
    }
    $scope.bucarValorCarrinho = function(){
            $http({
                method: 'POST',
                url: '/api/carrinhoproduto/valor/',
                data: $scope.carrinho
            }).then(function (response) {
                $scope.valorCarrinho = response.data;                
            }, function (response) {                
                console.log('Erro: ' + response)
            });
    }
    
    $scope.listarProduto = function () {
        $http.get("/api/produto/")
            .then(function (response) {
                $scope.listaProduto = response.data;
                $scope.novoItem = false;
            });
    }
    $scope.bucarValorCarrinho();
    $scope.adicionarCarrinho = function () {        
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
        }, function (response) {
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
            console.log(response);
            $scope.listarProduto();
        }, function (response) {
            $scope.listarProduto();
            console.log('Erro: ' + response)
        })
    }
    
    $scope.adicionarCliente();
    $scope.adicionarCarrinho();
    $scope.listarProduto();
});