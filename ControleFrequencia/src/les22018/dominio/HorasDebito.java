package les22018.dominio;

import java.util.Date;

public class HorasDebito {
	private Date privateLimitePagamento;
	private long totalHoras;
	
	public Date getPrivateLimitePagamento() {
		return privateLimitePagamento;
	}
	public void setPrivateLimitePagamento(Date privateLimitePagamento) {
		this.privateLimitePagamento = privateLimitePagamento;
	}
	public long getTotalHoras() {
		return totalHoras;
	}
	public void setTotalHoras(long totalHoras) {
		this.totalHoras = totalHoras;
	}

}
