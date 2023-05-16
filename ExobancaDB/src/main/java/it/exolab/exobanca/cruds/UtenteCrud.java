package it.exolab.exobanca.cruds;

import java.util.List;

import it.exolab.exobanca.mappers.UtenteMapper;
import it.exolab.exobanca.models.Utente;

public class UtenteCrud {
	
	public Utente insert(Utente utente, UtenteMapper utenteMapper) {
		
		System.out.println("Sono nel crud insert utente -> " + utente);
		utenteMapper.insert(utente);
		return utente;
	}
	
	public Utente update(Utente utente, UtenteMapper utenteMapper) {
		
		System.out.println("Sono nel crud update utente = " + utente);
		utenteMapper.update(utente);
		return utente;
	}
	
	public void delete(Utente utente, UtenteMapper utenteMapper) {
		
		System.out.println("Delete in UtenteCrud dove idUtente  = " + utente);
		utenteMapper.delete(utente);
		
	}
	
	public Utente findById(Integer idUtente, UtenteMapper utenteMapper) {
		
		System.out.println("Sono nel crud findById utente -> " + idUtente);
		Utente utente = utenteMapper.findById(idUtente);
		return utente;
	}
	
	// Questo progetto � collegato e comunica con il mapper corrispettivo
	public List<Utente> findAllUtenti(UtenteMapper utenteMapper) {
		System.out.println("Sono nel findAll() UtenteCrud");
		List<Utente> listaUtenti = utenteMapper.findAllUtenti();
		return listaUtenti;
	}
	
	public Utente findByEmailPassword(Utente utente, UtenteMapper utenteMapper) {
		System.out.println("Sono nel findByEmailPassword() di UtenteCrud di " + utente);
		utente = utenteMapper.findByEmailPassword(utente.getEmail(), utente.getPassword());
		return utente;
	}
	
	public Utente findByEmail(String email, UtenteMapper utenteMapper) {
		System.out.println("Sono nel findByEmail() di UtenteCrud, email -> " + email);
		Utente utente = utenteMapper.findByEmail(email);
		return utente;
	}

}
