package les22018.dominio;

import java.util.Date;
import java.util.Vector;

public class Jornada extends EntidadeDominio {
	private double cargaHoraria;
	private String turno;
	private boolean escala;
	private Vector<Boolean> marcacoesPontos;
	private Vector<Double> periodoIntervalo;
	private Date dataValidadeInicial;
	private Date dataValidadeFinal;	
	
	public double getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public boolean isEscala() {
		return escala;
	}
	public void setEscala(boolean escala) {
		this.escala = escala;
	}
	public Vector<Boolean> getMarcacoesPontos() {
		return marcacoesPontos;
	}
	public void setMarcacoesPontos(Vector<Boolean> marcacoesPontos) {
		this.marcacoesPontos = marcacoesPontos;
	}
	public Vector<Double> getPeriodoIntervalo() {
		return periodoIntervalo;
	}
	public void setPeriodoIntervalo(Vector<Double> periodoIntervalo) {
		this.periodoIntervalo = periodoIntervalo;
	}
	public Date getDataValidadeInicial() {
		return dataValidadeInicial;
	}
	public void setDataValidadeInicial(Date dataValidadeInicial) {
		this.dataValidadeInicial = dataValidadeInicial;
	}
	public Date getDataValidadeFinal() {
		return dataValidadeFinal;
	}
	public void setDataValidadeFinal(Date dataValidadeFinal) {
		this.dataValidadeFinal = dataValidadeFinal;
	}
	
	
}
