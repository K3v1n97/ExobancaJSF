package it.exolab.exobanca.models;

import java.util.Objects;

public class TipoTransazione {
	
	private Integer idTipoTransazione;
	private String descrizioneTipoTransazione;
	
	public TipoTransazione() {}

	public Integer getIdTipoTransazione() {
		return idTipoTransazione;
	}

	public void setIdTipoTransazione(Integer idTipoTransazione) {
		this.idTipoTransazione = idTipoTransazione;
	}

	public String getDescrizioneTipoTransazione() {
		return descrizioneTipoTransazione;
	}

	public void setDescrizioneTipoTransazione(String descrizioneTipoTransazione) {
		this.descrizioneTipoTransazione = descrizioneTipoTransazione;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descrizioneTipoTransazione, idTipoTransazione);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoTransazione other = (TipoTransazione) obj;
		return Objects.equals(descrizioneTipoTransazione, other.descrizioneTipoTransazione)
				&& Objects.equals(idTipoTransazione, other.idTipoTransazione);
	}

	@Override
	public String toString() {
		return "TipoTransazione [idTipoTransazione=" + idTipoTransazione + ", descrizioneTipoTransazione="
				+ descrizioneTipoTransazione + "]";
	}
	
}
