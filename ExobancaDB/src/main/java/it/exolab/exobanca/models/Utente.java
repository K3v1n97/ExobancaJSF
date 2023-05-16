package it.exolab.exobanca.models;

import java.util.List;
import java.util.Objects;

public class Utente {
	
	private Integer idUtente;
	private String email;
	private String password;
	private String nome;
	private String cognome;
	private String dataDiNascita;
	private Integer idRuolo;
	private Ruolo ruolo;
	
	private List<ContoCorrente> listaContiUtente;
	
	public Utente() {
		
	}

	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Integer getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public List<ContoCorrente> getListaContiUtente() {
		return listaContiUtente;
	}

	public void setListaContiUtente(List<ContoCorrente> listaContiUtente) {
		this.listaContiUtente = listaContiUtente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, dataDiNascita, email, idUtente, nome, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(dataDiNascita, other.dataDiNascita)
				&& Objects.equals(email, other.email) && Objects.equals(idUtente, other.idUtente)
				&& Objects.equals(nome, other.nome) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", email=" + email + ", password=" + password + ", nome=" + nome
				+ ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita + ", ruolo=" + idRuolo + "]";
	}

}
