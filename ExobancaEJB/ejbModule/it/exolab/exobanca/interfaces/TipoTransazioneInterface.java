package it.exolab.exobanca.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.exobanca.models.TipoTransazione;

@Local
public interface TipoTransazioneInterface {
	
	TipoTransazione insert(TipoTransazione tipoTransazione);
	
	TipoTransazione update(TipoTransazione tipoTransazione);
	
	TipoTransazione findById(Integer idTipoTransazione);
	
	List<TipoTransazione> findAll();

}
