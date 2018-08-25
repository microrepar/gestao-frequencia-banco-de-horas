package les22018.dominio;

public abstract class Ocorrencia {
	private double totalHoras;
	private double horasDSR;
	private double horasFeriado;
	private Periodo periodo;
	private Intervalo intervalo;
	private Decisor decisor;
	
	public double getTotalHoras() {
		return totalHoras;
	}
	public void setTotalHoras(double totalHoras) {
		this.totalHoras = totalHoras;
	}
	public double getHorasDSR() {
		return horasDSR;
	}
	public void setHorasDSR(double horasDSR) {
		this.horasDSR = horasDSR;
	}
	public double getHorasFeriado() {
		return horasFeriado;
	}
	public void setHorasFeriado(double horasFeriado) {
		this.horasFeriado = horasFeriado;
	}
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	

}
