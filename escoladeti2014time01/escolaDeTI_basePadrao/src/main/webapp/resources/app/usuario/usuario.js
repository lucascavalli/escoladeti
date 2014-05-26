var moduleUsuario = angular.module('escoladeti.usuario', ['ngRoute']);

moduleUsuario.config(['$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider.
	        when('/cadastros/usuario/listar', {
	            templateUrl: './pages/usuario/listarUsuario.html',
	            controller: 'UsuarioController'
	        }).
	        when('/cadastros/usuario/editar/:objeto', {
	            templateUrl: './pages/usuario/editarUsuario.html',
	            controller: 'UsuarioController'
	        });
        $locationProvider.html5Mode(false);
    }]);

moduleUsuario.controller('UsuarioController', ['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams, $location) {

        $scope.page = {pageNumber : 1};
        $scope.usuarioAtual = undefined;
        //$scope.usuarios = [];

        $scope.init = function() {
            $scope.loadUsuarios(1);
        };

        $scope.incluir = function() {
            window.location.href = "#cadastros/usuario/editar/new";
        };

        $scope.initEditarUsuario = function() {
            if ($routeParams.objeto === 'new') {
                $scope.usuarioAtual = {"login" : "", id : ""};
            } else {                
                $scope.usuarioDadoId($routeParams.objeto);
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
            var usuario = $scope.page.list[index];
            if (confirm('Deseja excluir o usuário ' + usuario.login + '?')) {
                $scope.removerServidor(usuario);
            }
        };
        
        $scope.removerServidor = function(usuario) {
            console.log(JSON.stringify(usuario));
            $http({
                method: "DELETE",
                url: "./rest/usuario/remover",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify(angular.copy(usuario))
            }).success(function(data, status) {
                $scope.loadUsuarios($scope.page.pageNumber);
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao excluir usuários!");
            });
        };    
        
        $scope.loadUsuarios = function(numeroPagina) {        	
            $http({
                method: "GET",
                url: "./rest/usuario/listar/pag/" + numeroPagina,
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                console.log(JSON.stringify(data));
                $scope.page = data;
                console.log(JSON.stringify(status));                
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao buscar usuarios!");
            });
        };

        $scope.salvar = function() {
            $http({
                method: "POST",
                url: "./rest/usuario/salvar",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify($scope.usuarioAtual)
            }).success(function(data, status) {
                window.location.href = "#cadastros/usuario/listar";
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao salvar Usuário!");
            });
        };      
        
        $scope.converterAtivo = function(ativo) {
            if (ativo) {
                return "Ativado";
            }else{
                return "Desativado";
            }                
        };      
        
        $scope.usuarioDadoId = function(id) {        	
        	$http({
        		method: "GET",
        		url: "./rest/usuario/carregar/" + id,
        		headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
        	}).success(function(data, status) {
        		$scope.usuarioAtual = data;
        	}).error(function(data, status) {   
                        $("<div></div>")
        		.css({overflow : "auto"})
        		.html(data)
        		.dialog({
        			autoOpen: true,
        			title: 'Erro ao carregar usuario ' + id,
        			width: 800,
        			height: 450,
        			modal: true
        		});
        	});
        };
        
    }
]);
