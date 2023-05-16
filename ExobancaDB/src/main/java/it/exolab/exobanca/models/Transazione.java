package it.exolab.exobanca.models;

import java.util.Objects;

public class Transazione {
	
	private ContoCorrente contoMittente;
	private ContoCorrente contoDestinatario;
	
	private Integer idTransazione;
	private Integer idContoMittente;
	private Integer idContoDestinatario;
	private Double importo;
	private String dataTransazione;
	private Integer idTipoTransazione;
	private Integer idStatoTransazione;
	
	private TipoTransazione tipoTransazione;
	private StatoTransazione statoTransazione;
	
	public Transazione() {

	}

	public Integer getIdTransazione() {
		return idTransazione;
	}

	public void setIdTransazione(Integer idTransazione) {
		this.idTransazione = idTransazione;
	}

	public Integer getIdContoMittente() {
		return idContoMittente;
	}

	public void setIdContoMittente(Integer idContoMittente) {
		this.idContoMittente = idContoMittente;
	}

	public Integer getIdContoDestinatario() {
		return idContoDestinatario;
	}

	public void setIdContoDestinatario(Integer idContoDestinatario) {
		this.idContoDestinatario = idContoDestinatario;
	}

	public Integer getIdTipoTransazione() {
		return idTipoTransazione;
	}

	public void setIdTipoTransazione(Integer idTipoTransazione) {
		this.idTipoTransazione = idTipoTransazione;
	}

	public Integer getIdStatoTransazione() {
		return idStatoTransazione;
	}

	public void setIdStatoTransazione(Integer idStatoTransazione) {
		this.idStatoTransazione = idStatoTransazione;
	}

	public ContoCorrente getContoMittente() {
		return contoMittente;
	}

	public void setContoMittente(ContoCorrente contoMittente) {
		this.contoMittente = contoMittente;
	}

	public ContoCorrente getContoDestinatario() {
		return contoDestinatario;
	}

	public void setContoDestinatario(ContoCorrente contoDestinatario) {
		this.contoDestinatario = contoDestinatario;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public String getDataTransazione() {
		return dataTransazione;
	}

	public void setDataTransazione(String dataTransazione) {
		this.dataTransazione = dataTransazione;
	}

	public TipoTransazione getTipoTransazione() {
		return tipoTransazione;
	}

	public void setTipoTransazione(TipoTransazione tipoTransazione) {
		this.tipoTransazione = tipoTransazione;
	}

	public StatoTransazione getStatoTransazione() {
		return statoTransazione;
	}

	public void setStatoTransazione(StatoTransazione statoTransazione) {
		this.statoTransazione = statoTransazione;
	}
	
	public Transazione effettuaBonifico(Transazione bonifico) {
		
		bonifico = new Transazione();
		bonifico.idTipoTransazione = 3;
		bonifico.idStatoTransazione = 4;
		if(bonifico.getContoMittente().getSaldoDisponibile() >= bonifico.getImporto()) {
			bonifico.getContoMittente().setSaldoDisponibile(bonifico.getContoMittente().getSaldoDisponibile() - bonifico.getImporto());
			bonifico.getContoDestinatario().setSaldoDisponibile(bonifico.getContoDestinatario().getSaldoDisponibile() + bonifico.getImporto());
			return bonifico;
		}
		return null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contoDestinatario, contoMittente, dataTransazione, idContoDestinatario, idContoMittente,
				idStatoTransazione, idTipoTransazione, idTransazione, importo, statoTransazione, tipoTransazione);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transazione other = (Transazione) obj;
		return Objects.equals(contoDestinatario, other.contoDestinatario)
				&& Objects.equals(contoMittente, other.contoMittente)
				&& Objects.equals(dataTransazione, other.dataTransazione)
				&& Objects.equals(idContoDestinatario, other.idContoDestinatario)
				&& Objects.equals(idContoMittente, other.idContoMittente)
				&& Objects.equals(idStatoTransazione, other.idStatoTransazione)
				&& Objects.equals(idTipoTransazione, other.idTipoTransazione)
				&& Objects.equals(idTransazione, other.idTransazione) && Objects.equals(importo, other.importo)
				&& Objects.equals(statoTransazione, other.statoTransazione)
				&& Objects.equals(tipoTransazione, other.tipoTransazione);
	}

	@Override
	public String toString() {
		return "Transazione [contoMittente=" + contoMittente + ", contoDestinatario=" + contoDestinatario
				+ ", idTransazione=" + idTransazione + ", idContoMittente=" + idContoMittente + ", ibanContoMittente=" + contoMittente.getIbanContoCorrente() + ", idContoDestinatario="
				+ idContoDestinatario + ", importo=" + importo + ", dataTransazione=" + dataTransazione
				+ ", idTipoTransazione=" + idTipoTransazione + ", idStatoTransazione=" + idStatoTransazione
				+ ", tipoTransazione=" + tipoTransazione + ", statoTransazione=" + statoTransazione + "]";
	}

}
