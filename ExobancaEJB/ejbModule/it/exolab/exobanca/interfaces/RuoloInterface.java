package it.exolab.exobanca.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.exobanca.models.Ruolo;

@Local
public interface RuoloInterface {
	
	Ruolo insert(Ruolo ruolo);
	
	Ruolo update(Ruolo ruolo);
	
	Ruolo findById(Integer idRuolo);
	
	List<Ruolo> findAll();

}
