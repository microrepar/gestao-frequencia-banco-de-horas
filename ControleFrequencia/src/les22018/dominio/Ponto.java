package les22018.dominio;

import java.util.Date;

public class Ponto {
	private Date dataHora;
	private String pis;
	private long matricula;
	private Relogio relogio;
	
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getPis() {
		return pis;
	}
	public void setPis(String pis) {
		this.pis = pis;
	}
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	public Relogio getRelogio() {
		return relogio;
	}
	public void setRelogio(Relogio relogio) {
		this.relogio = relogio;
	}
	
	
}
