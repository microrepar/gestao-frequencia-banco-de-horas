<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cadastrar Funcionario</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
</head>
<body>
<div id="main" class="container-fluid">

            <h3 class="page-header">Cadastrar Funcionario</h3>

            <form name="pedidoForm" method="post">
                <div class="row">

                    <div class="form-group col-md-4">
                        <label for="exampleInputEmail1">Nome</label>
                        <input type="text" class="form-control" name="txt_NomeFuncionario" value="">
                    </div>
                </div>

				<div class="row">
                    <div class="form-group col-md-4">
                        <label for="exampleInputEmail1">Matricula</label>
                        <input type="text" class="form-control" name="txt_Matricula" value="">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="exampleInputEmail1">PIS/PASEP</label>
                        <input type="text" class="form-control" name="txt_PIS_PASEP" value="">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="exampleInputEmail1">cargo</label>
                        <input type="text" class="form-control" name="txt_Cargo" value="">
                    </div>
                </div>
                                <hr />

                <div class="row">
                    <div class="col-md-12">
                        <a href="Menu.jsp" class="btn btn-primary">Voltar</a>
                        <button type="submit" class="btn btn-primary" name="operacao" formaction="CadastrarFuncionario" value="SALVAR">Salvar</button>
                    </div>
                </div>

            </form>
        </div>
          <script>
            var mensagem = '${msg}';
            if (mensagem.length !== 0) {
                if(mensagem==="Dados salvos no Banco de Dados")
                alert(mensagem + "\n\nNome do Funcionario: "+'${itensFuncionario[0]}'
                    +"\nMatricula: "+'${itensFuncionario[1]}'
                    +"\nPIS/PASEP: "+'${itensFuncionario[2]}'
                    +"\nCargo: "+'${itensFuncionario[3]}');
                else
                    alert(mensagem)
            }
        </script>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>         
      
</body>
</html>