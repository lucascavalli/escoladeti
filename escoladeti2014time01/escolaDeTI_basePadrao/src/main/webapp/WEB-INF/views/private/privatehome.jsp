<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html xmlns:ng="http://angularjs.org" lang="pt">
    <head>
        <meta charset="UTF-8">
        <script type="text/javascript" src="./resources/js/angular.min.js"></script>
        <script type="text/javascript" src="./resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="./resources/js/jquery-ui.custom.min.js"></script>
        <script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>    
        <script type="text/javascript" src="./resources/js/angular-route.min.js"></script>
        <script type="text/javascript" src="./resources/app/disciplina/disciplina.js"></script>
        <script type="text/javascript" src="./resources/app/questaoObjetiva/questaoObjetiva.js"></script>
        <script type="text/javascript" src="./resources/app/uf/uf.js"></script>
        <script type="text/javascript" src="./resources/app/pais/pais.js"></script>
        <script type="text/javascript" src="./resources/app/usuario/usuario.js"></script>
        <script type="text/javascript" src="./resources/app/endereco/endereco.js"></script>
        <script type="text/javascript" src="./resources/app/logradouro/logradouro.js"></script> 
        <script type="text/javascript" src="./resources/app/faixadenumero/faixadenumero.js"></script>
        <script type="text/javascript" src="./resources/app/pessoa/pessoa.js"></script>
        <script type="text/javascript" src="./resources/app/app.js"></script>
        <link rel="stylesheet" href="./resources/css/bootstrap.min.css" >
        <link rel="stylesheet" href="./resources/css/time01.css" >
        


        <script type="text/javascript">
            //this is here to make plunkr work with AngularJS routing
            angular.element(document.getElementsByTagName('head')).append(angular.element('<base href="' + window.location.pathname + '" />'));
        </script>
        
        <title>Escola de TI - 2014 ©</title>

    </head>
    
    <body ng-app="escoladeti" ng-controller="MainController">
        <nav id="navbar-example" role="navigation" class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">

                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">            
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    
                    <a class="navbar-brand" href="#"><i class="glyphicon glyphicon-globe"></i></a>
                </div>

                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav">              
<!--
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Cadastros <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#/cadastros/disciplina/listar">Disciplinas</a></li>
                                <li><a href="#/cadastros/questaoObjetiva/listar">Questões Objetivas</a></li>
                                <li><a href="#/cadastros/uf/listar">Ufs</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Processos <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="Pedido/Novo">Pedido</a></li>
                            </ul>
                        </li>
-->
<!-- ------------------------- Início - Transição de Códigos do Front-End ------------------------- -->
                        <li class="dropdown">
                            <a  class="dropdown-toggle" data-toggle="dropdown">Cadastros <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#/cadastros/usuario/listar">Usuário</a></li>
                                <li><a href="#/cadastros/endereco/listar">Endereço</a></li>
                                <li><a href="#/cadastros/uf/listar">UF</a></li>
				<li><a href="#/cadastros/pais/listar">Pais</a></li>
                                <li><a href="#/cadastros/logradouro/listar">Logradouro</a></li>
                                <li><a href="#/cadastros/faixadenumero/listar">Faixa De Número</a></li>
                                <li><a href="#/cadastros/pessoa/listar">Pessoa</a></li>
                            </ul>
                        </li>
<!-- ------------------------- Fim - Transição de Códigos do Front-End ------------------------- -->                        
                    </ul>            
                    <ul class="nav navbar-nav navbar-right">              
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <!--<li><a href="/Configuracao/config"><i class="glyphicon glyphicon-cog"></i> Configurações</a></li>
                                <li><a tabindex="-1" href="/Sobre"><i class="glyphicon glyphicon-info-sign"></i> Sobre</a></li>                  
                                <li class="divider"></li>                  -->
                                <li><a tabindex="-1" href="./logout"><i class="glyphicon glyphicon-off"></i> Sair</a></li>                  
                            </ul>                
                        </li>
                    </ul>
                </div>

            </div>        
        </nav>

        <div class="container">
            <div ng-view></div>
        </div>
    </body>


</html>