package it.exolab.exobanca.mappers;

import java.util.List;

import it.exolab.exobanca.models.Ruolo;

public interface RuoloMapper {
	
	void insert(Ruolo ruolo);
	
	void update(Ruolo ruolo);

	List<Ruolo> findAll();
	
	Ruolo findById(Integer idRuolo);

}
