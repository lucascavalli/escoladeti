var moduleEndereco = angular.module('escoladeti.endereco', ['ngRoute']);

moduleEndereco.config(['$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider.
	        when('/cadastros/endereco/listar', {
	            templateUrl: './pages/endereco/listarEndereco.html',
	            controller: 'EnderecoController'
	        }).
	        when('/cadastros/endereco/editar/:objeto', {
	            templateUrl: './pages/endereco/editarEndereco.html',
	            controller: 'EnderecoController'
	        });
        $locationProvider.html5Mode(false);
    }]);

moduleEndereco.controller('EnderecoController', ['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams, $location) {

        $scope.page = {pageNumber : 1};
        $scope.enderecoAtual = undefined;
        //$scope.usuarios = [];

        $scope.init = function() {
            $scope.loadEnderecos(1);
        };

        $scope.incluir = function() {
            window.location.href = "#cadastros/endereco/editar/new";
        };
/*
        $scope.initEditarEndereco = function() {
            if ($routeParams.objeto === 'new') {
                $scope.enderecoAtual = {"numero" : "", id : ""};
            } else {                
                $scope.enderecoDadoId($routeParams.objeto);
            }
        };
        
        verificar como vai fazer para o endereço (Usuario)
        
         **/
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
            var endereco = $scope.page.list[index];
            if (confirm('Deseja excluir o endereço ' + endereco.numero + '?')) {
                $scope.removerServidor(endereco);
            }
        };
        
        //referencia ao registro do endereco é o numero
        
        $scope.removerServidor = function(endereco) {
            console.log(JSON.stringify(endereco));
            $http({
                method: "DELETE",
                url: "./rest/endereco/remover",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify(angular.copy(endereco))
            }).success(function(data, status) {
                $scope.loadEnderecos($scope.page.pageNumber);
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao excluir endereço!");
            });
        };    
        
        $scope.loadEnderecos = function(numeroPagina) {        	
            $http({
                method: "GET",
                url: "./rest/endereco/listar/pag/" + numeroPagina,
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                console.log(JSON.stringify(data));
                $scope.page = data;
                console.log(JSON.stringify(status));                
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao buscar enderecos!");
            });
        };

        $scope.salvar = function() {
            $http({
                method: "POST",
                url: "./rest/endereco/salvar",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify($scope.enderecoAtual)
            }).success(function(data, status) {
                window.location.href = "#cadastros/endereco/listar";
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao salvar Endereço!");
            });
        };      
        
        $scope.enderecoDadoId = function(id) {        	
        	$http({
        		method: "GET",
        		url: "./rest/endereco/carregar/" + id,
        		headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
        	}).success(function(data, status) {
        		$scope.enderecoAtual = data;
                        console.log(JSON.stringify(data));
        	}).error(function(data, status) {   
                        $("<div></div>")
        		.css({overflow : "auto"})
        		.html(data)
        		.dialog({
        			autoOpen: true,
        			title: 'Erro ao carregar endereço ' + id,
        			width: 800,
        			height: 450,
        			modal: true
        		});
        	});
        };
        
    }
]);


