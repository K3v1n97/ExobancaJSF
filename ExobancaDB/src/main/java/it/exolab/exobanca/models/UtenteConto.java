package it.exolab.exobanca.models;

public class UtenteConto {
	
	private Integer idUtenteConto;
	private Integer idIntestatario;
	private Integer idContoCorrente;
	
	public UtenteConto() {
		
	}
	
	public Integer getIdUtenteConto() {
		return idUtenteConto;
	}
	public void setIdUtenteConto(Integer idUtenteConto) {
		this.idUtenteConto = idUtenteConto;
	}
	public Integer getIdIntestatario() {
		return idIntestatario;
	}
	public void setIdIntestatario(Integer idIntestatario) {
		this.idIntestatario = idIntestatario;
	}
	public Integer getIdContoCorrente() {
		return idContoCorrente;
	}
	public void setIdContoCorrente(Integer idContoCorrente) {
		this.idContoCorrente = idContoCorrente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idContoCorrente == null) ? 0 : idContoCorrente.hashCode());
		result = prime * result + ((idIntestatario == null) ? 0 : idIntestatario.hashCode());
		result = prime * result + ((idUtenteConto == null) ? 0 : idUtenteConto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtenteConto other = (UtenteConto) obj;
		if (idContoCorrente == null) {
			if (other.idContoCorrente != null)
				return false;
		} else if (!idContoCorrente.equals(other.idContoCorrente))
			return false;
		if (idIntestatario == null) {
			if (other.idIntestatario != null)
				return false;
		} else if (!idIntestatario.equals(other.idIntestatario))
			return false;
		if (idUtenteConto == null) {
			if (other.idUtenteConto != null)
				return false;
		} else if (!idUtenteConto.equals(other.idUtenteConto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UtenteConto [idUtenteConto=" + idUtenteConto + ", idIntestatario=" + idIntestatario
				+ ", idContoCorrente=" + idContoCorrente + "]";
	}
	
}
