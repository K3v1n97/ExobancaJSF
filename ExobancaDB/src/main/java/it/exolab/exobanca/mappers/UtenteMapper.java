package it.exolab.exobanca.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import it.exolab.exobanca.models.Utente;

public interface UtenteMapper {
	
	void insert(Utente utente);
	
	void update(Utente utente);
	
	void delete(Utente utente);
	
	Utente findById(Integer idUtente);
	
	List<Utente> findAllUtenti();
	
	Utente findByEmailPassword(@Param("email") String email, @Param("password") String password);
	
	Utente findByEmail(String email);

}
