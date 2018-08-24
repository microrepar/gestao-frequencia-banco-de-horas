package les22018.web.controle.command;

import les22018.core.aplicacao.Resultado;
import les22018.core.impl.controle.Fachada;
import les22018.dominio.EntidadeDominio;

public class ExcluirCommand implements ICommand{
	Fachada fachada = new Fachada();
    Resultado resultado = new Resultado();
	public Resultado executar(EntidadeDominio entidade) {
		//TODO Auto-generated method stub
    	resultado = fachada.excluir(entidade);
        return resultado;
	}
    		
	

}
