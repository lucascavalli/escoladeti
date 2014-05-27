var moduleFaixaDeNumero = angular.module('escoladeti.faixaDeNumero', ['ngRoute']);

moduleFaixaDeNumero.config(['$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider.
	        when('/cadastros/faixadenumero/listar', {
	            templateUrl: './pages/faixadenumero/listarFaixaDeNumero.html',
	            controller: 'FaixaDeNumeroController'
	        }).
	        when('/cadastros/faixadenumero/editar/:objeto', {
	            templateUrl: './pages/faixadenumero/editarFaixaDeNumero.html',
	            controller: 'FaixaDeNumeroController'
	        });
        $locationProvider.html5Mode(false);
    }]);

moduleFaixaDeNumero.controller('FaixaDeNumeroController', ['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams, $location) {

        $scope.page = {pageNumber : 1};
        $scope.faixaDeNumeroAtual = undefined;
        //$scope.usuarios = [];

        $scope.init = function() {
            $scope.loadFaixas(1);
        };

        $scope.incluir = function() {
            window.location.href = "#cadastros/faixadenumero/editar/new";
        };

        $scope.initEditarFaixaDeNumero = function() {
            if ($routeParams.objeto === 'new') {
                $scope.faixaDeNumeroAtual = {numeroInicial : "",numeroFinal : "",cep : "", id : ""};
            } else {                
                $scope.faixaDeNumeroDadoId($routeParams.objeto);
            }
        };        
/*        
        $scope.loadAllLogradouros = function() {
            $http({
                method: "GET",
                url: "./rest/logradouro/todos",
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                $scope.logradouros = data;
            }).error(function(data, status) {
                alert("Erro ao buscar Faixas!");
            });
        };
*/

        $scope.remover = function(index) {
            var faixaDeNumero = $scope.page.list[index];
            if (confirm('Deseja excluir a faixa ' + faixaDeNumero.cep + '?')) {
                $scope.removerServidor(faixaDeNumero);
            }
        };
        
        $scope.removerServidor = function(faixaDeNumero) {
            console.log(JSON.stringify(faixaDeNumero));
            $http({
                method: "DELETE",
                url: "./rest/faixadenumero/remover",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify(angular.copy(faixaDeNumero))
            }).success(function(data, status) {
                $scope.loadFaixas($scope.page.pageNumber);
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao excluir faixas!");
            });
        };    
        
        $scope.loadFaixas = function(numeroPagina) {        	
            $http({
                method: "GET",
                url: "./rest/faixadenumero/listar/pag/" + numeroPagina,
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                console.log(JSON.stringify(data));
                $scope.page = data;
                console.log(JSON.stringify(status));                
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao buscar faixas!");
            });
        };

        $scope.salvar = function() {
            $http({
                method: "POST",
                url: "./rest/faixadenumero/salvar",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify($scope.faixaDeNumeroAtual)
            }).success(function(data, status) {
                window.location.href = "#cadastros/faixadenumero/listar";
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao salvar Faixa de Número!");
            });
        };      
        
        $scope.faixaDeNumeroDadoId = function(id) {        	
        	$http({
        		method: "GET",
        		url: "./rest/faixadenumero/carregar/" + id,
        		headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
        	}).success(function(data, status) {
        		$scope.faixaDeNumeroAtual = data;
        	}).error(function(data, status) {   
                        $("<div></div>")
        		.css({overflow : "auto"})
        		.html(data)
        		.dialog({
        			autoOpen: true,
        			title: 'Erro ao carregar faixa ' + id,
        			width: 800,
        			height: 450,
        			modal: true
        		});
        	});
        };
        
        $scope.loadAllLogradouros = function() {
            $http({
                method: "GET",
                url: "./rest/logradouro/todos",
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                $scope.logradouros = data;
            }).error(function(data, status) {
                alert("Erro ao buscar logradouros!");
            });
        };
        
        $scope.loadAllBairros = function() {
            $http({
                method: "GET",
                url: "./rest/bairro/todos",
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                $scope.bairros = data;
            }).error(function(data, status) {
                alert("Erro ao buscar bairros!");
            });
        };
        
    }
]);
