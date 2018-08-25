package les22018.web.controle.command;

import les22018.core.aplicacao.Resultado;
import les22018.core.impl.controle.Fachada;
import les22018.dominio.EntidadeDominio;

public class SalvarCommand implements ICommand{

	Fachada fachada = new Fachada();
    Resultado resultado = new Resultado();
    
	
	@Override
	public Resultado executar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		//chama fachada para salvar e retorna msg e/ou valores do banco de dados
        resultado = fachada.salvar(entidade);
        return resultado;
	}

}
