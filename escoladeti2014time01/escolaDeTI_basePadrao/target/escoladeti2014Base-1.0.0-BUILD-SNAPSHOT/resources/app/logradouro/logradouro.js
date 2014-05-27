var moduleLogradouro = angular.module('escoladeti.logradouro', ['ngRoute']);

moduleLogradouro.config(['$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider.
	        when('/cadastros/logradouro/listar', {
	            templateUrl: './pages/logradouro/listarLogradouro.html',
	            controller: 'LogradouroController'
	        }).
	        when('/cadastros/logradouro/editar/:objeto', {
	            templateUrl: './pages/logradouro/editarLogradouro.html',
	            controller: 'LogradouroController'
	        });
        $locationProvider.html5Mode(false);
    }]);

moduleLogradouro.controller('LogradouroController', ['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams, $location) {

        $scope.page = {pageNumber : 1};
        $scope.logradouroAtual = undefined;
        //$scope.usuarios = [];

        $scope.init = function() {
            $scope.loadLogradouros(1);
        };

        $scope.incluir = function() {
            window.location.href = "#cadastros/logradouro/editar/new";
        };

        $scope.initEditarLogradouro = function() {
            if ($routeParams.objeto === 'new') {
                $scope.logradouroAtual = {"nome" : "", id : "", tipo : ""};
            } else {                
                $scope.logradouroDadoId($routeParams.objeto);
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
                alert("Erro ao buscar Logradouros!");
            });
        };
*/

        $scope.remover = function(index) {
            var logradouro = $scope.page.list[index];
            if (confirm('Deseja excluir o logradouro ' + logradouro.nome + '?')) {
                $scope.removerServidor(logradouro);
            }
        };
        
        $scope.removerServidor = function(logradouro) {
            console.log(JSON.stringify(logradouro));
            $http({
                method: "DELETE",
                url: "./rest/logradouro/remover",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify(angular.copy(logradouro))
            }).success(function(data, status) {
                $scope.loadLogradouros($scope.page.pageNumber);
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao excluir logradouros!");
            });
        };    
        
        $scope.loadLogradouros = function(numeroPagina) {        	
            $http({
                method: "GET",
                url: "./rest/logradouro/listar/pag/" + numeroPagina,
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                console.log(JSON.stringify(data));
                $scope.page = data;
                console.log(JSON.stringify(status));                
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao buscar logradouros!");
            });
        };

        $scope.salvar = function() {
            $http({
                method: "POST",
                url: "./rest/logradouro/salvar",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify($scope.logradouroAtual)
            }).success(function(data, status) {
                window.location.href = "#cadastros/logradouro/listar";
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao salvar Logradouro!");
            });
        };      
        
        $scope.logradouroDadoId = function(id) {        	
        	$http({
        		method: "GET",
        		url: "./rest/logradouro/carregar/" + id,
        		headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
        	}).success(function(data, status) {
        		$scope.logradouroAtual = data;
        	}).error(function(data, status) {   
                        $("<div></div>")
        		.css({overflow : "auto"})
        		.html(data)
        		.dialog({
        			autoOpen: true,
        			title: 'Erro ao carregar logradouro ' + id,
        			width: 800,
        			height: 450,
        			modal: true
        		});
        	});
        };
        
    }
]);
