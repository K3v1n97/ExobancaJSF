package it.exolab.exobanca.mappers;

import java.util.List;

import it.exolab.exobanca.models.TipoTransazione;

public interface TipoTransazioneMapper {
	
	void insert(TipoTransazione tipoTransazione);
	
	void update(TipoTransazione tipoTransazione);
	
	List<TipoTransazione> findAll();
	
	TipoTransazione findById(Integer idTipoTransazione);

}
