package les22018.dominio;

import java.util.List;

public class Funcionario extends EntidadeDominio{
	private String nome;
	private long matricula;
	private String pisPasep;
	private String cargo;
	private boolean rescindido;
	private List<Jornada> jornadas;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public boolean isRescindido() {
		return rescindido;
	}
	public void setRescindido(boolean rescindido) {
		this.rescindido = rescindido;
	}
	public List<Jornada> getJornadas() {
		return jornadas;
	}
	public void setJornadas(List<Jornada> jornadas) {
		this.jornadas = jornadas;
	}
	public String getPisPasep() {
		return pisPasep;
	}
	public void setPisPasep(String pisPasep) {
		this.pisPasep = pisPasep;
	}

	
}
