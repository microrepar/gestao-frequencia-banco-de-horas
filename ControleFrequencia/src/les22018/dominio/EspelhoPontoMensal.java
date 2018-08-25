package les22018.dominio;

import java.util.List;

public class EspelhoPontoMensal {
	private String mesReferencia;
	private int ano;
	private List<EspelhoPontoDiario> espelhoPontoDiarios;
	
	public String getMesReferencia() {
		return mesReferencia;
	}
	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public List<EspelhoPontoDiario> getEspelhoPontoDiarios() {
		return espelhoPontoDiarios;
	}
	public void setEspelhoPontoDiarios(List<EspelhoPontoDiario> espelhoPontoDiarios) {
		this.espelhoPontoDiarios = espelhoPontoDiarios;
	}
	
	

}
