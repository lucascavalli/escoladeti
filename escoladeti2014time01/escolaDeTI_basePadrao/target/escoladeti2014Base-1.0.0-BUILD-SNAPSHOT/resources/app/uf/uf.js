var moduleUF = angular.module('escoladeti.uf', ['ngRoute']);

moduleUF.config(['$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider.
	        when('/cadastros/uf/listar', {
	            templateUrl: './pages/uf/listarUF.html',
	            controller: 'UfController'
	        }).
	        when('/cadastros/uf/editar/:objeto', {
	            templateUrl: './pages/uf/editarUF.html',
	            controller: 'UfController'
	        });
        $locationProvider.html5Mode(false);
    }]);

moduleUF.controller('UfController', ['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams, $location) {

        $scope.page = {pageNumber : 1};
        $scope.ufAtual = undefined;
        $scope.ufs = [];

        $scope.init = function() {
            $scope.loadUfs(1);
        };

        $scope.incluir = function() {
            window.location.href = "#cadastros/uf/editar/new";
        };
        
        $scope.loadAllUfs = function() {
            $http({
                method: "GET",
                url: "./rest/uf/todas",
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                $scope.ufs = data;
            }).error(function(data, status) {
                alert("Erro ao buscar Ufs!");
            });
        };
        
        $scope.initEditarUf = function() {
            if ($routeParams.objeto === 'new') {
                $scope.ufAtual = {"nome" : "", id : ""};
            } else {                
                $scope.UfDadoId($routeParams.objeto);
            }
        };

        $scope.loadUfs = function(numeroPagina) {        	
            $http({
                method: "GET",
                url: "./rest/uf/listar/pag/" + numeroPagina,
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                $scope.page = data;
            }).error(function(data, status) {
                $("<div></div>")
                	.css({overflow : "auto"})
                	.html(data)
                	.dialog({
	                    autoOpen: true,
	                    title: 'Erro ao carregar as questões',
	                    width: 800,
	                    height: 450,
	                    modal: true
                });
            });
        };

        $scope.salvar = function() {
        	$http({
                method: "POST",
                url: "./rest/uf/salvar",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify($scope.ufAtual)
            }).success(function(data, status) {
                window.location.href = "#cadastros/uf/listar";
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao salvar UF!");
            });
        }  
        
        $scope.ufDadoId = function(id) {        	
        	$http({
        		method: "GET",
        		url: "./rest/uf/carregar/" + id,
        		headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
        	}).success(function(data, status) {
        		$scope.ufAtual = data;
        	}).error(function(data, status) {
        		$("<div></div>")
        		.css({overflow : "auto"})
        		.html(data)
        		.dialog({
        			autoOpen: true,
        			title: 'Erro ao carregar uf ' + id,
        			width: 800,
        			height: 450,
        			modal: true
        		});
        	});
        };
        
    }
]);
