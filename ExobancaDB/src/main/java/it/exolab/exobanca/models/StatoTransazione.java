package it.exolab.exobanca.models;

import java.util.Objects;

public class StatoTransazione {
	
	private Integer idStatoTransazione;
	private String descrizioneStatoTransazione;
	
	public StatoTransazione() {}

	public Integer getIdStatoTransazione() {
		return idStatoTransazione;
	}

	public void setIdStatoTransazione(Integer idStatoTransazione) {
		this.idStatoTransazione = idStatoTransazione;
	}

	public String getDescrizioneStatoTransazione() {
		return descrizioneStatoTransazione;
	}

	public void setDescrizioneStatoTransazione(String descrizioneStatoTransazione) {
		this.descrizioneStatoTransazione = descrizioneStatoTransazione;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descrizioneStatoTransazione, idStatoTransazione);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatoTransazione other = (StatoTransazione) obj;
		return Objects.equals(descrizioneStatoTransazione, other.descrizioneStatoTransazione)
				&& Objects.equals(idStatoTransazione, other.idStatoTransazione);
	}

	@Override
	public String toString() {
		return "StatoTransazione [idStatoTransazione=" + idStatoTransazione + ", descrizioneStatoTransazione="
				+ descrizioneStatoTransazione + "]";
	}
	
}
