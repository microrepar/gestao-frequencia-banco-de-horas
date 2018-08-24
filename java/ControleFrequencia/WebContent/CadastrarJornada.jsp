<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cadastrar Frequencia</title>

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
    <form name="FrequenciaForm" method="post" >
                <div class="row">
                    <div class="form-group col-md-2">
                        <label for="campo1">CargaHoraria</label>
                        <input type="text" class="form-control" name="txt_CargaHoraria" id="txt_CargaHoraria">
                    </div>
                    
                </div>
                <!-- area de campos do form -->
                <hr />
                <div id="actions" class="row">
                    <div class="col-md-12">
                        <a href="Menu.jsp" class="btn btn-primary">Voltar</a>
                        <button type="submit" class="btn btn-primary"  name="operacao" formaction="CadastrarJornada" value="SALVAR">Salvar</button>
                    </div>
                </div>
            </form>
        </div>    
</body>
</html>