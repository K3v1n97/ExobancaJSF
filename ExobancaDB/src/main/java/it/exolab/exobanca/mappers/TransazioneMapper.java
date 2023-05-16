package it.exolab.exobanca.mappers;

import java.util.List;

import javax.ws.rs.PathParam;

import it.exolab.exobanca.models.Transazione;

public interface TransazioneMapper {
	
	void insert(Transazione transazione);
	
	void update(Transazione transazione);

	void delete(Transazione transazione);

	Transazione findById(Integer idTransazione);

	List<Transazione> findAllTransazioni();
	
	List<Transazione> findByMittente(@PathParam("ibanContoMittente") String ibanContoMittente);
	
	List<Transazione> findByDestinatario(@PathParam("ibanContoDestinatario") String ibanContoDestinatario);
	
	List<Transazione> findByStatoTransazione(@PathParam("idStatoTransazione") Integer idStatoTransazione);
	
	List<Transazione> findByTipoTransazione(@PathParam("idTipoTransazione") Integer idTipoTransazione);
	
	Transazione effettuaBonifico(Transazione transazione);

}
