package les22018.dominio;

import java.util.List;

public class Frequencia {
	private List<HorasDebito> horasDebitos;
	private List<Funcionario> funcionarios;
	private List<AprovaExtraTreina> aprovaExtraTreinas;
	private List<HorasExtra> horasExtras;
	private EspelhoPontoMensal espelhoPontoMensal;
	
	public List<HorasDebito> getHorasDebitos() {
		return horasDebitos;
	}
	public void setHorasDebitos(List<HorasDebito> horasDebitos) {
		this.horasDebitos = horasDebitos;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public List<AprovaExtraTreina> getAprovaExtraTreinas() {
		return aprovaExtraTreinas;
	}
	public void setAprovaExtraTreinas(List<AprovaExtraTreina> aprovaExtraTreinas) {
		this.aprovaExtraTreinas = aprovaExtraTreinas;
	}
	public List<HorasExtra> getHorasExtras() {
		return horasExtras;
	}
	public void setHorasExtras(List<HorasExtra> horasExtras) {
		this.horasExtras = horasExtras;
	}
	public EspelhoPontoMensal getEspelhoPontoMensal() {
		return espelhoPontoMensal;
	}
	public void setEspelhoPontoMensal(EspelhoPontoMensal espelhoPontoMensal) {
		this.espelhoPontoMensal = espelhoPontoMensal;
	}
	
	
	
	

}
