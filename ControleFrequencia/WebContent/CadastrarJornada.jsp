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
<h1>Frequencia</h1>
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