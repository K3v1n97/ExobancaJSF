package it.exolab.exobanca.models;

import java.util.Objects;

public class StatoContoCorrente {
	
	private Integer idStatoContoCorrente;
	private String descrizioneStatoConto;
	
	public StatoContoCorrente() {
		
	}

	public Integer getIdStatoContoCorrente() {
		return idStatoContoCorrente;
	}

	public void setIdStatoContoCorrente(Integer idStatoContoCorrente) {
		this.idStatoContoCorrente = idStatoContoCorrente;
	}

	public String getDescrizione() {
		return descrizioneStatoConto;
	}

	public void setDescrizione(String descrizioneStatoConto) {
		this.descrizioneStatoConto = descrizioneStatoConto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStatoContoCorrente, descrizioneStatoConto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatoContoCorrente other = (StatoContoCorrente) obj;
		return Objects.equals(idStatoContoCorrente, other.idStatoContoCorrente)
				&& Objects.equals(descrizioneStatoConto, other.descrizioneStatoConto);
	}

	@Override
	public String toString() {
		return "StatoContoCorrente [idStatoContoCorrente=" + idStatoContoCorrente + ", statoContoCorrente="
				+ descrizioneStatoConto + "]";
	}
	
}
