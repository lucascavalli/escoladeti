var modulePessoa = angular.module('escoladeti.pessoa', ['ngRoute']);

modulePessoa.config(['$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider.
	        when('/cadastros/pessoa/listar', {
	            templateUrl: './pages/pessoa/listarPessoa.html',
	            controller: 'PessoaController'
	        }).
	        when('/cadastros/pessoa/editar/:objeto', {
	            templateUrl: './pages/pessoa/editarPessoa.html',
	            controller: 'PessoaController'
	        });
        $locationProvider.html5Mode(false);
    }]);

modulePessoa.controller('PessoaController', ['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams, $location) {

        $scope.page = {pageNumber : 1};
        $scope.pessoaAtual = undefined;
        //$scope.usuarios = [];

        $scope.init = function() {
            $scope.loadPessoa(1);
        };

        $scope.incluir = function() {
            window.location.href = "#cadastros/pessoa/editar/new";
        };

        $scope.initEditarPessoa = function() {
            if ($routeParams.objeto === 'new') {
                $scope.pessoaAtual = {"nome" : "", id : ""};
            } else {                
                $scope.pessoaDadoId($routeParams.objeto);
            }
        };        
/*        
        $scope.loadAllUsuarios = function() {
            $http({
                method: "GET",
                url: "./rest/usuario/todos",
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                $scope.usuarios = data;
            }).error(function(data, status) {
                alert("Erro ao buscar Usuarios!");
            });
        };
*/

        $scope.remover = function(index) {
            var pessoa = $scope.page.list[index];
            if (confirm('Deseja excluir a pessoa ' + pessoa.nome + '?')) {
                $scope.removerServidor(pessoa);
            }
        };
        
        $scope.removerServidor = function(pessoa) {
            console.log(JSON.stringify(pessoa));
            $http({
                method: "DELETE",
                url: "./rest/pessoa/remover",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify(angular.copy(pessoa))
            }).success(function(data, status) {
                $scope.loadPessoas($scope.page.pageNumber);
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao excluir pessoas!");
            });
        };    
        
        $scope.loadPessoas = function(numeroPagina) {        	
            $http({
                method: "GET",
                url: "./rest/pessoa/listar/pag/" + numeroPagina,
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                console.log(JSON.stringify(data));
                $scope.page = data;
                console.log(JSON.stringify(status));                
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao buscar pessoas!");
            });
        };

        $scope.salvar = function() {
            $http({
                method: "POST",
                url: "./rest/pessoa/salvar",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify($scope.pessoaAtual)
            }).success(function(data, status) {
                window.location.href = "#cadastros/pessoa/listar";
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao salvar Pessoa!");
            });
        };      
        
        $scope.converterAtivo = function(ativo) {
            if (ativo) {
                return "Ativado";
            }else{
                return "Desativado";
            }                
        };      
        
        $scope.pessoaDadoId = function(id) {        	
        	$http({
        		method: "GET",
        		url: "./rest/pessoa/carregar/" + id,
        		headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
        	}).success(function(data, status) {
        		$scope.pessoaAtual = data;
        	}).error(function(data, status) {   
                        $("<div></div>")
        		.css({overflow : "auto"})
        		.html(data)
        		.dialog({
        			autoOpen: true,
        			title: 'Erro ao carregar pessoa ' + id,
        			width: 800,
        			height: 450,
        			modal: true
        		});
        	});
        };
        
    }
]);
