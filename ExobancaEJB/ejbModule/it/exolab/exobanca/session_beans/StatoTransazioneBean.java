package it.exolab.exobanca.session_beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.exobanca.cruds.StatoTransazioneCrud;
import it.exolab.exobanca.db_connection.SqlMapFactory;
import it.exolab.exobanca.interfaces.StatoTransazioneInterface;
import it.exolab.exobanca.mappers.StatoTransazioneMapper;
import it.exolab.exobanca.models.StatoTransazione;

@Stateless(name="StatoTransazioneInterface")
@LocalBean
public class StatoTransazioneBean implements StatoTransazioneInterface {

	@Override
	public StatoTransazione insert(StatoTransazione statoTransazione) {
		
		try {
			SqlMapFactory.instance().openSession(); // apriamo la sessione del sessionBean(lo attiviamo) 
													// tramite la classe singleton al db specificato
													// nel file xml datasource.xml
			System.out.println("Sono nel metodo insert di StatoTransazioneBean -> " + statoTransazione);
			// in questa maniera, ogni volta che si richiamerà una richiesta da lato client di un servizio rest
			// a questo bean locale(metodo) si attiverà la connessione all'interfaccia mapper Local che 
			// residenti nel container ejb
			StatoTransazioneMapper statoTransazioneMapper = SqlMapFactory.instance().getMapper(StatoTransazioneMapper.class);
			StatoTransazioneCrud statoTransazioneCrud = new StatoTransazioneCrud();
			statoTransazione = statoTransazioneCrud.insert(statoTransazione, statoTransazioneMapper);
			SqlMapFactory.instance().commitSession();
			return statoTransazione;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public StatoTransazione update(StatoTransazione statoTransazione) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel metodo update di StatoTransazioneBean -> " + statoTransazione);
			StatoTransazioneMapper statoTransazioneMapper = SqlMapFactory.instance().getMapper(StatoTransazioneMapper.class);
			StatoTransazioneCrud statoTransazioneCrud = new StatoTransazioneCrud();
			statoTransazione = statoTransazioneCrud.update(statoTransazione, statoTransazioneMapper);
			SqlMapFactory.instance().commitSession();
			return statoTransazione;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public StatoTransazione findById(Integer idStatoTransazione) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel metodo findById di STatoTransazioneBean -> " + idStatoTransazione);
			StatoTransazioneMapper statoTransazioneMapper = SqlMapFactory.instance().getMapper(StatoTransazioneMapper.class);
			StatoTransazioneCrud statoTransazioneCrud = new StatoTransazioneCrud();
			StatoTransazione statoTransazione = statoTransazioneCrud.findById(idStatoTransazione, statoTransazioneMapper);
			return statoTransazione;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public List<StatoTransazione> findAll() {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel findAll di StatoTransazioneBean");
			StatoTransazioneMapper statoTransazioneMapper = SqlMapFactory.instance().getMapper(StatoTransazioneMapper.class);
			StatoTransazioneCrud statoTransazioneCrud = new StatoTransazioneCrud();
			List<StatoTransazione> listaStatiTransazione = statoTransazioneCrud.findAll(statoTransazioneMapper);
			return listaStatiTransazione;
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

}
