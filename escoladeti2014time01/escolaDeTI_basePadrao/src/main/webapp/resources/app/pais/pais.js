var modulePais = angular.module('escoladeti.pais', ['ngRoute']);

modulePais.config(['$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider.
	        when('/cadastros/pais/listar', {
	            templateUrl: './pages/pais/listarPais.html',
	            controller: 'PaisController'
	        }).
	        when('/cadastros/pais/editar/:objeto', {
	            templateUrl: './pages/pais/editarPais.html',
	            controller: 'PaisController'
	        });
        $locationProvider.html5Mode(false);
    }]);

modulePais.controller('PaisController', ['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams, $location) {

        $scope.page = {pageNumber : 1};
        $scope.paisAtual = undefined;
        //$scope.usuarios = [];

        $scope.init = function() {
            $scope.loadPais(1);
        };

        $scope.incluir = function() {
            window.location.href = "#cadastros/pais/editar/new";
        };

        $scope.initEditarPais = function() {
            if ($routeParams.objeto === 'new') {
                $scope.paisAtual = {"nome" : "", id : ""};
            } else {                
                $scope.paisDadoId($routeParams.objeto);
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
            var pais = $scope.page.list[index];
            if (confirm('Deseja excluir o pais ' + pais.nome + '?')) {
                $scope.removerServidor(pais);
            }
        };
        
        $scope.removerServidor = function(pais) {
            console.log(JSON.stringify(pais));
            $http({
                method: "DELETE",
                url: "./rest/pais/remover",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify(angular.copy(pais))
            }).success(function(data, status) {
                $scope.loadPais($scope.page.pageNumber);
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao excluir pais!");
            });
        };    
        
        $scope.loadPais = function(numeroPagina) {        	
            $http({
                method: "GET",
                url: "./rest/pais/listar/pag/" + numeroPagina,
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                console.log(JSON.stringify(data));
                $scope.page = data;
                console.log(JSON.stringify(status));                
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao buscar pais!");
            });
        };

        $scope.salvar = function() {
            $http({
                method: "POST",
                url: "./rest/pais/salvar",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify($scope.paisAtual)
            }).success(function(data, status) {
                window.location.href = "#cadastros/pais/listar";
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao salvar Pais!");
            });
        };      
        
        $scope.paisDadoId = function(id) {        	
        	$http({
        		method: "GET",
        		url: "./rest/pais/carregar/" + id,
        		headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
        	}).success(function(data, status) {
        		$scope.paisAtual = data;
                        console.log(JSON.stringify(data));
        	}).error(function(data, status) {   
                        $("<div></div>")
        		.css({overflow : "auto"})
        		.html(data)
        		.dialog({
        			autoOpen: true,
        			title: 'Erro ao carregar pais ' + id,
        			width: 800,
        			height: 450,
        			modal: true
        		});
        	});
        };
        
    }
]);


