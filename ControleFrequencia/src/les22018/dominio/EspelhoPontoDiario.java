package les22018.dominio;

import java.util.Date;
import java.util.List;

public class EspelhoPontoDiario {
	private Date data;
	private List<Ocorrencia> ocorrencias;
	private List<Ponto> pontos;
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}
	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	public List<Ponto> getPontos() {
		return pontos;
	}
	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}
	
	
	

}
