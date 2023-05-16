package it.exolab.exobanca.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.exobanca.models.Transazione;

@Local
public interface TransazioneInterface {
	
	Transazione insert(Transazione transazione);
	
	Transazione update(Transazione transazione);

	void delete(Transazione transazione);
	
	Transazione findById(Integer idTransazione);
	
	List<Transazione> findAllTransazioni();
	
	List<Transazione> findByMittente(String ibanContoMittente);
	
	List<Transazione> findByDestinatario(String ibanContoDestinatario);
	
	List<Transazione> findByStatoTransazione(Integer idStatoTransazione);
	
	List<Transazione> findByTipoTransazione(Integer idTipoTransazione);
	
}
