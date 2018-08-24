package les22018.dominio;

public class Jornada extends EntidadeDominio {
	private double cargaHoraria;
	private String turno;
	private boolean escala;
	
	
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
	
	
}
