package it.exolab.exobanca.cruds;

import java.util.List;

import it.exolab.exobanca.mappers.TipoTransazioneMapper;
import it.exolab.exobanca.models.TipoTransazione;

public class TipoTransazioneCrud {
	
	public TipoTransazione insert(TipoTransazione tipoTransazione, TipoTransazioneMapper tipoTransazioneMapper) {
		
		System.out.println("Sono nel crud insert tipoTransazione -> " + tipoTransazione);
		tipoTransazioneMapper.insert(tipoTransazione);
		return tipoTransazione;
	}
	
	public TipoTransazione update(TipoTransazione tipoTransazione, TipoTransazioneMapper tipoTransazioneMapper) {
		
		System.out.println("Sono nel crud update tipoTransazione = " + tipoTransazione);
		tipoTransazioneMapper.update(tipoTransazione);
		return tipoTransazione;
	}
	
	public List<TipoTransazione> findAll(TipoTransazioneMapper tipoTransazioneMapper) {
		System.out.println("Sono nel findAll() TipoTransazioneCrud");
		List<TipoTransazione> listaTipiTransazione = tipoTransazioneMapper.findAll();
		return listaTipiTransazione;
	}
	
	public TipoTransazione findById(Integer idTipoTransazione, TipoTransazioneMapper tipoTransazioneMapper) {
		
		System.out.println("Sono nel findById di tipoTransazioneMapper -> " + idTipoTransazione);
		TipoTransazione tipoTransazione = tipoTransazioneMapper.findById(idTipoTransazione);
		return tipoTransazione;
	}

}
