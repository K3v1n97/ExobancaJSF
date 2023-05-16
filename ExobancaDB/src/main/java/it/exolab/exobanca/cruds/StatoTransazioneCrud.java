package it.exolab.exobanca.cruds;

import java.util.List;

import it.exolab.exobanca.mappers.StatoTransazioneMapper;
import it.exolab.exobanca.models.StatoTransazione;

public class StatoTransazioneCrud {

	public StatoTransazione insert(StatoTransazione statoTransazione, StatoTransazioneMapper statoTransazioneMapper) {
		
		System.out.println("Sono nell'insert di StatoTransazioneCrud -> " + statoTransazione);
		statoTransazioneMapper.insert(statoTransazione);
		return statoTransazione;
		
	}

	public StatoTransazione update(StatoTransazione statoTransazione, StatoTransazioneMapper statoTransazioneMapper) {
		
		System.out.println("Sono nell'update di StatoTransazioneCrud -> " + statoTransazione);
		statoTransazioneMapper.update(statoTransazione);
		return statoTransazione;
	}

	public List<StatoTransazione> findAll(StatoTransazioneMapper statoTransazioneMapper) {
		
		System.out.println("Sono nel findAllStatiTransazione di StatoTransazioneCrud");
		List<StatoTransazione> listaStatiTransazione = statoTransazioneMapper.findAll();
		return listaStatiTransazione;
	}

	public StatoTransazione findById(Integer idStatoTransazsione, StatoTransazioneMapper statoTransazioneMapper) {
		
		System.out.println("Sono nel findById di StatoTransazioneCrud -> " + idStatoTransazsione);
		StatoTransazione statoTransazione = statoTransazioneMapper.findById(idStatoTransazsione);
		return statoTransazione;
	}

}
