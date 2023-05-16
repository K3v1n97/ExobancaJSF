package it.exolab.exobanca.models;

import java.util.Objects;

public class Ruolo {
	
	private Integer idRuolo;
	private String descrizione;
	
	public Ruolo() {
		
	}

	public Integer getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRuolo, descrizione);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ruolo other = (Ruolo) obj;
		return Objects.equals(idRuolo, other.idRuolo) && Objects.equals(descrizione, other.descrizione);
	}

	@Override
	public String toString() {
		return "Ruolo [idRuolo=" + idRuolo + ", ruolo=" + descrizione + "]";
	}

}
