package it.exolab.exobanca.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.exobanca.models.Utente;

@Local
public interface UtenteInterface {
	
	Utente insert(Utente utente);
	
	Utente update(Utente utente);
	
	void delete(Utente utente);
	
	Utente findById(Integer idUtente);
	
	List<Utente> findAllUtenti();
	
	Utente findByEmailPassword(Utente utente);
	
	Utente findByEmail(String email);

}
