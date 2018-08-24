package les22018.core.impl.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import les22018.core.aplicacao.Resultado;
import les22018.core.impl.dao.DAO;
import les22018.core.impl.dao.IDAO;
import les22018.dominio.EntidadeDominio;
import les22018.dominio.Jornada;
import les22018.core.impl.negocio.IStrategy;

public class Fachada implements IFachada {

	private Map<String, Map<String, List<IStrategy>>> rns;
	// private Map<String, List<IStrategy>> rns;
	private Map<String, IDAO> daos;
	Resultado resultado = new Resultado();

	public Fachada() {
		// cria lista de estrategies operações de Jornada
		List<IStrategy> rnsJornadaSalvar = new ArrayList<>();
		List<IStrategy> rnsJornadaConsultar = new ArrayList<>();

		// mapeando classes com lista de estrategies
		Map<String, List<IStrategy>> rnsJornada = new HashMap<>();

		// inserindo mapa de regras de negocios de acordo com suas operações
		rnsJornada.put("SALVAR", rnsJornadaSalvar);
		rnsJornada.put("CONSULTAR", rnsJornadaConsultar);

		// rns = new HashMap<String, List<IStrategy>>();
		rns = new HashMap<String, Map<String, List<IStrategy>>>();
		rns.put(Jornada.class.getName(), rnsJornada);

		// instanciando DAOs
		IDAO dao = new DAO();

		// mapeando classes com DAOs
		daos = new HashMap<String, IDAO>();
		daos.put(Jornada.class.getName(), dao);
	}

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		// identificando nome da classe
		String nmClass = entidade.getClass().getName();
		// executando validações de regras de negocio
		String msg = executarRegras(entidade, "SALVAR");
		// chamando DAO em caso de todas as validações atendidas
		if (msg.isEmpty()) {
			IDAO dao = daos.get(nmClass);
			dao.salvar(entidade);
			resultado.setMsg("Dados salvos no Banco de Dados");
			List<EntidadeDominio> entidades = new ArrayList<>();
			entidades.add(entidade);
			resultado.setEntidades(entidades);
			// retornando msg de falha de validação sem poder acessar o DAO
		} else {
			resultado.setMsg(msg.toString());
		}
		return resultado;

	}

	/*
	 * @Override public Resultado alterar(EntidadeDominio entidade) { // TODO
	 * Auto-generated method stub // identificando nome da classe String nmClass =
	 * entidade.getClass().getName();
	 * 
	 * //executando validações de regras de negocio String msg =
	 * executarRegras(entidade, "ALTERAR");
	 * 
	 * //chamando DAO em caso de todas as validações atendidas if (msg.isEmpty()) {
	 * IDAO dao = daos.get(nmClass); dao.alterar(entidade);
	 * resultado.setMsg("Dados alterados"); } else {
	 * resultado.setMsg(msg.toString()); } return resultado; }
	 * 
	 * @Override public Resultado excluir(EntidadeDominio entidade) { // TODO
	 * Auto-generated method stub // identificando nome da classe String nmClass =
	 * entidade.getClass().getName(); //executando validações de regras de negocio
	 * String msg = executarRegras(entidade, "EXCLUIR"); if (msg.isEmpty()) { IDAO
	 * dao = daos.get(nmClass); dao.excluir(entidade);
	 * resultado.setMsg("Dados excluidos"); } else {
	 * resultado.setMsg(msg.toString()); } return resultado; }
	 */
	
	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub 
		// identificando nome da classe 
		String nmClass = entidade.getClass().getName(); 
		// instanciando DAO de acordo com a classe
		IDAO dao = daos.get(nmClass); 
		//executando validações de regras de negocio
		String msg = executarRegras(entidade, "CONSULTAR"); 
		if (msg.isEmpty()) { 
			if (dao.consultar(entidade).isEmpty()) { 
				//caso dados não foram encontrados
				resultado.setMsg("dados nao encontrados"); 
			}else { 
				//caso dados foram encontrados 
				resultado.setMsg("pesquisa feita com sucesso"); 
			}
			resultado.setEntidades(dao.consultar(entidade)); 
		}else {
			resultado.setMsg(msg.toString()); 
		} 
		return resultado;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String executarRegras(EntidadeDominio entidade, String operacao) {
		// identificando nome da classe
		String nmClasse = entidade.getClass().getName();
		// para construção de String de mensagens
		StringBuilder msg = new StringBuilder();
		// mapeando classes com lista de estrategies
		Map<String, List<IStrategy>> regrasOperacao = rns.get(nmClasse);
		// caso tenha regras de negocio associada à classe
		if (!regrasOperacao.isEmpty()) {
			List<IStrategy> regras = regrasOperacao.get(operacao);
			// caso tenha regras de negocio associada à operação da classe
			if (!regras.isEmpty()) {
				for (IStrategy s : regras) {
					// checando mensagens de regras de negocio
					String m = s.processar(entidade);
					if (!m.isEmpty()) {
						// adicionando mensagens na StringBuilder
						msg.append(m);
					}
				}
			}
		}
		if (msg.length() > 0) {
			return msg.toString();
		} else {
			return "";
		}
	}


}
