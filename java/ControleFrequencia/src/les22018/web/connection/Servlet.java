package les22018.web.connection;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import les22018.core.aplicacao.Resultado;
import les22018.dominio.EntidadeDominio;
import les22018.web.controle.command.ConsultarCommand;
import les22018.web.controle.command.ICommand;
import les22018.web.controle.command.SalvarCommand;
import les22018.web.controle.vh.FrequenciaViewHelper;
import les22018.web.controle.vh.IViewHelper;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Map<String, IViewHelper> vhs;
	private static Map<String, ICommand> commands;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		vhs = new HashMap<String, IViewHelper>();
		
		  vhs.put("/ControleFrequencia/CadastrarJornada", new FrequenciaViewHelper());
		  vhs.put("/ControleFrequencia/ConsultarJornada", new FrequenciaViewHelper());
		  /*
		 * vhs.put("/TrabalhoPecasES3/CadastrarPedido", new PedidoViewHelper());
		 * vhs.put("/TrabalhoPecasES3/PesquisarPeca", new PecaViewHelper());
		 * vhs.put("/TrabalhoPecasES3/PesquisarPedido", new PedidoViewHelper());
		 * vhs.put("/TrabalhoPecasES3/ExcluirPeca", new PecaViewHelper());
		 * vhs.put("/TrabalhoPecasES3/ExcluirPedido", new PedidoViewHelper());
		 * vhs.put("/TrabalhoPecasES3/AlterarPeca", new PecaViewHelper());
		 * vhs.put("/TrabalhoPecasES3/AlterarPedido", new PedidoViewHelper());
		 */
		// mapeando 'operação' com instância para Command
		commands = new HashMap<String, ICommand>();
		commands.put("SALVAR", new SalvarCommand());
		commands.put("CONSULTAR", new ConsultarCommand());
		/*
		 * commands.put("SALVAR", new SalvarCommand()); commands.put("PESQUISAR", new
		 * PesquisarCommand()); commands.put("EXCLUIR", new ExcluirCommand());
		 * commands.put("ALTERAR", new AlterarCommand());
		 */
	}

	

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//      try {

		// obtém nome do identificar do recurso (URI)
		String uri = request.getRequestURI();
		System.out.println("uri: "+uri);
		// cria instância de view helper de acordo com recurso de origem
		IViewHelper vh = vhs.get(uri);
		// obtém nome da operação de acordo com o 'value' do botão que foi apertado
		String operacao = request.getParameter("operacao");
		System.out.println("operacao: "+operacao);
		// cria instância de tipo de command de acordo com identicação da operação
		ICommand command = commands.get(operacao);
		// recebe objeto da entidade domínio instanciada na chamada da view helper
		System.out.println("teste antes de vh");
		EntidadeDominio entidade = vh.getEntidade(request);
		// recebe mensagens e /ou lista de entidades de acordo com execução do tipo de
		// command
		System.out.println("teste depois de vh e antes de command");
		Resultado resultado = command.executar(entidade);
		// chama view helper para ajustar o tipo de dados a serem exibidos na view
		//vh.setView(resultado, request, response);
//processRequest
//     request.getRequestDispatcher(page).forward(request, response);
//} catch (DatabaseException he) {
//		 throw new ServletException(he);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
		// TODO Auto-generated method stub
		// doGet(request, response);
	}

}
