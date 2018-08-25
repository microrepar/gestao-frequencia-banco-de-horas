package les22018.web.controle.command;


import les22018.core.aplicacao.Resultado;
import les22018.dominio.EntidadeDominio;

public interface ICommand {
	public Resultado executar(EntidadeDominio entidade);
}
