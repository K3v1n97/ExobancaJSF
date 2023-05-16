package it.exolab.exobanca.mappers;

import java.util.List;

import it.exolab.exobanca.models.StatoTransazione;

public interface StatoTransazioneMapper {
	
	void insert(StatoTransazione statoTransazione);
	
	void update(StatoTransazione statoTransazione);
	
	List<StatoTransazione> findAll();
	
	StatoTransazione findById(Integer idStatoTransazsione);

}
