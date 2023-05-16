package it.exolab.exobanca.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.exobanca.models.StatoTransazione;

// con l'annotation @Local della libreria javax.ejb andiamo a specificare
// una connessione con un server locale, ovvero i dati non si trovano in un deposito
// remoto (esterno) alla macchina, ma sono interni alla macchina che effettua le 
// chiamate al db
@Local
public interface StatoTransazioneInterface {

	StatoTransazione insert(StatoTransazione statoTransazione);
	
	StatoTransazione update(StatoTransazione statoTransazione);

	StatoTransazione findById(Integer idStatoTransazione);
	
	List<StatoTransazione> findAll();

}
