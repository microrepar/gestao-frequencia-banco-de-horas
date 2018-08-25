package les22018.core.impl.dao;

import java.util.List;

import les22018.dominio.EntidadeDominio;

public interface IDAO {
	public void salvar(EntidadeDominio entidade);
	public void alterar(EntidadeDominio entidade);
	public List<EntidadeDominio> consultar(EntidadeDominio entidade);
	public void excluir(EntidadeDominio entidade);
}
