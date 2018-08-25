package les22018.web.controle.vh;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import les22018.core.aplicacao.Resultado;
import les22018.dominio.EntidadeDominio;

public interface IViewHelper {
    public EntidadeDominio getEntidade(HttpServletRequest request);
    public void setView(Resultado resultado,HttpServletRequest request,HttpServletResponse response);

}
