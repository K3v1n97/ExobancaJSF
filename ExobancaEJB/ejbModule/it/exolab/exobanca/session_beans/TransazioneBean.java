package it.exolab.exobanca.session_beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.exobanca.cruds.TransazioneCrud;
import it.exolab.exobanca.db_connection.SqlMapFactory;
import it.exolab.exobanca.interfaces.TransazioneInterface;
import it.exolab.exobanca.mappers.TransazioneMapper;
import it.exolab.exobanca.models.Transazione;

@Stateless(name="TransazioneInterface")
@LocalBean
public class TransazioneBean implements TransazioneInterface {

	@Override
	public Transazione insert(Transazione transazione) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel metodo insert di TransazioneBean -> " + transazione);
			TransazioneMapper transazioneMapper = SqlMapFactory.instance().getMapper(TransazioneMapper.class);
			TransazioneCrud transazioneCrud = new TransazioneCrud();
			transazione = transazioneCrud.insert(transazione, transazioneMapper);
			SqlMapFactory.instance().commitSession();
			return transazione;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public Transazione update(Transazione transazione) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel metodo update di TransazioneBean -> " + transazione);
			TransazioneMapper transazioneMapper = SqlMapFactory.instance().getMapper(TransazioneMapper.class);
			TransazioneCrud transazioneCrud = new TransazioneCrud();
			transazione = transazioneCrud.update(transazione, transazioneMapper);
			SqlMapFactory.instance().commitSession();
			return transazione;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public void delete(Transazione transazione) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel metodo delete di TransazioneBean -> " + transazione);
			TransazioneMapper transazioneMapper = SqlMapFactory.instance().getMapper(TransazioneMapper.class);
			TransazioneCrud transazioneCrud = new TransazioneCrud();
			transazioneCrud.delete(transazione, transazioneMapper);
			SqlMapFactory.instance().commitSession();
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		
	}

	@Override
	public Transazione findById(Integer idTransazione) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel metodo findById di TransazioneBean -> " + idTransazione);
			TransazioneMapper transazioneMapper = SqlMapFactory.instance().getMapper(TransazioneMapper.class);
			TransazioneCrud transazioneCrud = new TransazioneCrud();
			Transazione transazioneTrovata = transazioneCrud.findById(idTransazione, transazioneMapper);
			return transazioneTrovata;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public List<Transazione> findAllTransazioni() {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel metodo findAllTransazioni di TransazioneBean");
			TransazioneMapper transazioneMapper = SqlMapFactory.instance().getMapper(TransazioneMapper.class);
			TransazioneCrud transazioneCrud = new TransazioneCrud();
			List<Transazione> listaTransazioni = transazioneCrud.findAllTransazioni(transazioneMapper);
			return listaTransazioni;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public List<Transazione> findByMittente(String ibanContoMittente) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel metodo findByMittente di TransazioneBean: ibanMittente -> " + ibanContoMittente);
			TransazioneMapper transazioneMapper = SqlMapFactory.instance().getMapper(TransazioneMapper.class);
			TransazioneCrud transazioneCrud = new TransazioneCrud();
			List<Transazione> listaTransazioniMittente = transazioneCrud.findByMittente(ibanContoMittente, transazioneMapper);
			return listaTransazioniMittente;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public List<Transazione> findByDestinatario(String ibanContoDestinatario) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel metodo findByDestinatario di TransazioneBean: ibanDestinatario -> " + ibanContoDestinatario);
			TransazioneMapper transazioneMapper = SqlMapFactory.instance().getMapper(TransazioneMapper.class);
			TransazioneCrud transazioneCrud = new TransazioneCrud();
			List<Transazione> listaTransaioniDestinatario = transazioneCrud.findByDestinatario(ibanContoDestinatario, transazioneMapper);
			return listaTransaioniDestinatario;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public List<Transazione> findByStatoTransazione(Integer idStatoTransazione) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel metodo findByStatoTransazione di TransazioneBean: idStatoTransazione -> " + idStatoTransazione);
			TransazioneMapper transazioneMapper = SqlMapFactory.instance().getMapper(TransazioneMapper.class);
			TransazioneCrud transazioneCrud = new TransazioneCrud();
			List<Transazione> listaTransazioniByStato = transazioneCrud.findByStatoTransazione(idStatoTransazione, transazioneMapper);
			return listaTransazioniByStato;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public List<Transazione> findByTipoTransazione(Integer idTipoTransazione) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel metodo findByTipoTransazione di TransazioneBean: idTipoTransazione -> " + idTipoTransazione);
			TransazioneMapper transazioneMapper = SqlMapFactory.instance().getMapper(TransazioneMapper.class);
			TransazioneCrud transazioneCrud = new TransazioneCrud();
			List<Transazione> listaTransazioniByTipo = transazioneCrud.findByTipoTransazione(idTipoTransazione, transazioneMapper);
			return listaTransazioniByTipo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

}
