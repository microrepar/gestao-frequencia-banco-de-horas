package les22018.web.controle.vh;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import les22018.core.aplicacao.Resultado;
import les22018.dominio.EntidadeDominio;
import les22018.dominio.Jornada;

public class FrequenciaViewHelper implements IViewHelper{

	Jornada jornada = new Jornada();
	
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
        //obtém nome da operação 
        String operacao = request.getParameter("operacao");
        //caso botão apertado foi o de value = SALVAR' ou value = 'ALTERAR'
        if (operacao.equals("SALVAR")) {
            //recebe valor de idPeça no campo Codigo da Peca
            String dCargaHoraria = request.getParameter("txt_CargaHoraria");
            //recebe valor de descrição da peça no campo Descrição da Peça
            System.out.println("texto cargaHoraria = "+ dCargaHoraria);
            
            //formatando dados de entrada obtido do formulário
            if (dCargaHoraria != null && !dCargaHoraria.trim().equals("")) {
            	System.out.println("entrou em condições para setCArgaHoraria");
            	jornada.setCargaHoraria(Double.parseDouble(dCargaHoraria));
            }
            System.out.println("cargaHoraria = "+ jornada.getCargaHoraria());
            //caso botão apertado foi o de 'value = PESQUISAR'
        } else if (operacao.equals("CONSULTAR")) {
            //recebendo valor de pesquisa
            //recebendo valor de pesquisa
            String valor = request.getParameter("Valor");
            jornada.setId(Integer.parseInt(valor));
            System.out.println("valor de id: "+jornada.getId());
        /*} else if (operacao.equals("EXCLUIR")) {
            String idPeca = request.getParameter("nmIdPeca");
            peca.setId(idPeca);
        }else if (operacao.equals("SALVAR")) {
        */
        }//else if
        return jornada;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
