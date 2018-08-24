<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>Menu</title>
 
   <link href="css/bootstrap.min.css" rel="stylesheet">
   <link href="css/style.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Home.html">Home</a>
                <a class="navbar-brand" href="MenuPeca.jsp">Menu</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    
                    <li><a href="#">Opções</a></li>
                    <li><a href="#">Perfil</a></li>
                    <li><a href="#">Ajuda</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div id="main" class="container-fluid">
        <div id="main" class="container-fluid">
            <div id="top" class="row">
                <div class="col-md-3">
                    <h2>Menu Jornada</h2>
                </div>

                <div class="col-md-6">
                    <form name="ProcurarPecas" method="post">
                        <div class="input-group h2">
                            <input type="text" class="form-control" name="Valor" id="txt_IdJornada" 
                                   placeholder="Jornada" value="">
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-primary" 
                                        formaction="ConsultarJornada" name="operacao" value="CONSULTAR">
                                    Consultar
                                </button>
                            </span>
                        </div>
                    </form>
                </div>

                <div class="col-md-3">
                    <a href="CadastrarJornada.jsp" class="btn btn-primary pull-right h2">Adicionar Jornada</a>
                </div>
            </div> <!-- /#top -->
            <hr />
            <div id="list" class="row">
                <form name="Resultados" method="post">
                    <div class="table-responsive col-md-12">
                        <table id="tabela_ResultadosPecas" class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th width="100px" text-align="center">ID Jornada</th>
                                    <th width="200px" text-align="center">cargaHoraria</th>
                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="itemPecas" items="${listaPecas}">
                                    <c:if test="${not empty itemPecas}">
                                        
                                    <tr onclick="myFunctionName(this)">
                                        <td name="txt_idPeca" id="idPeca">${itemPecas[0]}</td>
                                        <td id="nmPeca">${itemPecas[1]}</td>
                                        <td id="tamanho">${itemPecas[2]}</td>
                                        <td id="peso">${itemPecas[3]}</td>
                                        <td id="material">${itemPecas[4]}</td>
                                        <td id="qtdeEstoque">${itemPecas[5]}</td>
                                <input type="hidden" id="myInputPeca" name="nmIdPeca" value="">

                                <td class="actions">
                                    <button type="submit" class="btn btn-success btn-xs" 
                                            formaction="View.jsp">Visualizar</button>
                                    <button type="submit" class="btn btn-warning btn-xs" 
                                            formaction="Alterar.jsp">Alterar</button>
                                    <button type="submit" class="btn btn-danger btn-xs"
                                            name="operacao" formaction="Excluir"
                                            value="EXCLUIR">Excluir</button>
                                </td>
                                </tr>
                            </c:if>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </form>
            </div> <!-- /#list -->

        </div>  <!-- /#main -->
</body>
</html>