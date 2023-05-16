package it.exolab.exobanca.cruds;

import java.util.List;

import it.exolab.exobanca.mappers.TransazioneMapper;
import it.exolab.exobanca.models.Transazione;

public class TransazioneCrud {
	
	public Transazione insert(Transazione transazione, TransazioneMapper transazioneMapper) {
		
		System.out.println("Sono nel metodo insert di TransazioneCrud -> " + transazione);
		transazioneMapper.insert(transazione);
		return transazione;
	}
	
	public Transazione update(Transazione transazione, TransazioneMapper transazioneMapper) {
		
		System.out.println("Sono nel metodo update di TransazioneCrud -> " + transazione);
		transazioneMapper.update(transazione);
		return transazione;
	}
	
	public void delete(Transazione transazione, TransazioneMapper transazioneMapper) {
		
		System.out.println("Sono nel metodo delete di TransazioneCrud -> " + transazione);
		transazioneMapper.delete(transazione);
	}
	
	public Transazione findById(Integer idTransazione, TransazioneMapper transazioneMapper) {
		
		System.out.println("Sono nel metodo findById di TransazioneCrud -> " + idTransazione);
		Transazione transazione = transazioneMapper.findById(idTransazione);
		return transazione;
	}
	
	public List<Transazione> findAllTransazioni(TransazioneMapper transazioneMapper) {
		
		System.out.println("Sono nel metodo findAllTransazioni di TransazioneCrud");
		List<Transazione> listaTransazioni = transazioneMapper.findAllTransazioni();
		return listaTransazioni;
	}
	
	public List<Transazione> findByMittente(String ibanContoMittente, TransazioneMapper transazioneMapper) {
		
		System.out.println("Sono nel metodo findByMittente di TransazioneCrud -> " + ibanContoMittente);
		List<Transazione> listaTransazioniMittente = transazioneMapper.findByMittente(ibanContoMittente);
		return listaTransazioniMittente;
	}
	
	public List<Transazione> findByDestinatario(String ibanContoDestinatario, TransazioneMapper transazioneMapper) {
		
		System.out.println("Sono nel metodo findByDestinatario di TransazioneCrud -> " + ibanContoDestinatario);
		List<Transazione> listaTransazioniDestinatario = transazioneMapper.findByDestinatario(ibanContoDestinatario);
		return listaTransazioniDestinatario;
	}
	
	public List<Transazione> findByStatoTransazione(Integer idStatoTransazione, TransazioneMapper transazioneMapper) {
		
		System.out.println("Sono nel metodo findByStatoTransazione di TransazioneCrud -> " + idStatoTransazione);
		List<Transazione> listaTransazioniStato = transazioneMapper.findByStatoTransazione(idStatoTransazione);
		return listaTransazioniStato;
	}
	
	public List<Transazione> findByTipoTransazione(Integer idTipoTransazione, TransazioneMapper transazioneMapper) {
		
		System.out.println("Sono nel metodo findByTipoTransazione di TransazioneCrud -> " + idTipoTransazione);
		List<Transazione> listaTransazioniTipo = transazioneMapper.findByTipoTransazione(idTipoTransazione);
		return listaTransazioniTipo;
	}

}
