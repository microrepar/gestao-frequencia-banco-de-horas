package les22018.web.controle.vh;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import les22018.core.aplicacao.Resultado;
import les22018.dominio.EntidadeDominio;
import les22018.dominio.Funcionario;


public class FuncionarioViewHelper implements IViewHelper{

	Funcionario funcionario = new Funcionario();
	
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
        //obtém nome da operação 
        String operacao = request.getParameter("operacao");
        //caso botão apertado foi o de value = SALVAR' ou value = 'ALTERAR'
        if (operacao.equals("SALVAR")) {
            //recebe valor de idPeça no campo Codigo da Peca
        	
            String nmFuncionario = request.getParameter("txt_NomeFuncionario");
            //recebe valor de descrição da peça no campo Descrição da Peça
            String nmMatricula = request.getParameter("txt_Matricula");
            //recebe valor de descrição da peça no campo Descrição da Peça
            String nmPisPasep = request.getParameter("txt_PIS_PASEP");
            //recebe valor de descrição da peça no campo Descrição da Peça
            String nmCargo = request.getParameter("txt_Cargo");
            //recebe valor de descrição da peça no campo Descrição da Peça
            
            
            //formatando dados de entrada obtido do formulário
            if (nmFuncionario != null && !nmFuncionario.trim().equals("")) {
            	funcionario.setNome(nmFuncionario);
            }
            if (nmMatricula != null && !nmMatricula.trim().equals("")) {
            	funcionario.setMatricula(Long.parseLong(nmMatricula));
            }
            if (nmPisPasep != null && !nmPisPasep.trim().equals("")) {
            	funcionario.setPisPasep(nmPisPasep);
            }
            if (nmCargo != null && !nmCargo.trim().equals("")) {
            	funcionario.setCargo(nmCargo);
            }
            //caso botão apertado foi o de 'value = PESQUISAR'
        } else if (operacao.equals("CONSULTAR")) {
            //recebendo valor de pesquisa
            //recebendo valor de pesquisa
            String valor = request.getParameter("Valor");
            funcionario.setCargo(valor);
            
        /*} else if (operacao.equals("EXCLUIR")) {
            String idPeca = request.getParameter("nmIdPeca");
            peca.setId(idPeca);
        }else if (operacao.equals("SALVAR")) {
        */
        }//else if
        return funcionario;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {

        //obtém nome da operação de acordo com o 'value' do botão que foi apertado 
        String operacao = request.getParameter("operacao");
        //recupera mensagem criada na fachada com texto de sucesso ou falha nas regras de negocio ou acesso ao DAO
        String msg = resultado.getMsg();
        //envia mensagem para o request
        request.setAttribute("msg", msg);
        //caso botão apertado foi o de 'value = SALVAR'
        if (operacao.equals("SALVAR")) {
            List<String> itensFuncionario = new java.util.ArrayList<>();
            List<List<String>> listaFuncionarios = new java.util.ArrayList<>();
            response.setContentType("text/html;charset=UTF-8");
            itensFuncionario = new java.util.ArrayList<>();
            //Peca peca = (Peca) resultado.getEntidades().get(i);
            if (!resultado.getEntidades().isEmpty()) {
                Funcionario funcionario = (Funcionario) resultado.getEntidades().get(0);
                //criando lista de itens Peça para enviar na view
                itensFuncionario.add(funcionario.getNome());
                itensFuncionario.add(Long.toString(funcionario.getMatricula()));
                itensFuncionario.add(funcionario.getPisPasep());
                itensFuncionario.add(funcionario.getCargo());
                request.setAttribute("itensFuncionario", itensFuncionario);
            }
            try {
                //redireciona para a pagina CadastrarPeca
                request.getRequestDispatcher("CadastrarFuncionario.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(FuncionarioViewHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
            //caso botão apertado foi o de 'value = PESQUISAR'
            
            //caso botão apertado foi o de 'value = PESQUISAR'
        } else if (operacao.equals("CONSULTAR")) {
            List<String> itensFuncionario;
            List<List<String>> listaFuncionarios = new java.util.ArrayList<>();
            int i;
            request.getSession().setAttribute("resultado", resultado);
            //caso a leitura no banco de dados não tenha encontrado nenhum dado
            System.out.println("funcionando setview Funcionarios");

            if (resultado.getEntidades().isEmpty()) {
                request.setAttribute("listaFuncionarios", listaFuncionarios);
                try {
                    request.getRequestDispatcher("MenuFuncionario.jsp").forward(request, response);
                } catch (ServletException | IOException ex) {
                    Logger.getLogger(FuncionarioViewHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
                //caso a leitura no banco de dados tenha encontrado dados com sucesso
                
                //caso a leitura no banco de dados tenha encontrado dados com sucesso
            } else {
                for (i = 0; i < resultado.getEntidades().size(); i++) {
                    itensFuncionario = new java.util.ArrayList<>();
                    //Peca peca = (Peca) resultado.getEntidades().get(i);
                    
                    Funcionario funcionario = (Funcionario) resultado.getEntidades().get(i);
                    //criando lista de itens Peça para enviar na view
                    itensFuncionario.add(funcionario.getNome());
                    itensFuncionario.add(Long.toString(funcionario.getMatricula()));
                    itensFuncionario.add(funcionario.getPisPasep());
                    itensFuncionario.add(funcionario.getCargo());
                    System.out.println(funcionario.getNome());
                    System.out.println(funcionario.getPisPasep());
                    System.out.println(funcionario.getCargo());
                    System.out.println(funcionario.getMatricula());
                    listaFuncionarios.add(itensFuncionario);
                }
                
                request.setAttribute("listaFuncionarios", listaFuncionarios);
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    //enviando dados lidos do banco de dados para o request
                    try {
                        request.getRequestDispatcher("MenuFuncionario.jsp").forward(request, response);
                    } catch (ServletException ex) {
                        Logger.getLogger(FuncionarioViewHelper.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(FuncionarioViewHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//else
        } else if (operacao.equals("EXCLUIR")) {
            
        } else if (operacao.equals("ALTERAR")) {
            
        }//else if

	}

}
