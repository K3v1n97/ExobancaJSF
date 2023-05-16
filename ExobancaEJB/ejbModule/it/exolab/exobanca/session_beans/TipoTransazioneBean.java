package it.exolab.exobanca.session_beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.exobanca.cruds.TipoTransazioneCrud;
import it.exolab.exobanca.db_connection.SqlMapFactory;
import it.exolab.exobanca.interfaces.TipoTransazioneInterface;
import it.exolab.exobanca.mappers.TipoTransazioneMapper;
import it.exolab.exobanca.models.TipoTransazione;

@Stateless(name="TipoTransazioneInterface")
@LocalBean
public class TipoTransazioneBean implements TipoTransazioneInterface{

	@Override
	public TipoTransazione insert(TipoTransazione tipoTransazione) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Insert bean tipoTransazione = " + tipoTransazione);
			TipoTransazioneMapper tipoTransazioneMapper = SqlMapFactory.instance().getMapper(TipoTransazioneMapper.class);
			TipoTransazioneCrud tipoTransazioneCrud = new TipoTransazioneCrud();
			tipoTransazione = tipoTransazioneCrud.insert(tipoTransazione, tipoTransazioneMapper);
			SqlMapFactory.instance().commitSession();
			return tipoTransazione;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public TipoTransazione update(TipoTransazione tipoTransazione) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Update bean tipoTransazione = " + tipoTransazione);
			TipoTransazioneMapper tipoTransazioneMapper = SqlMapFactory.instance().getMapper(TipoTransazioneMapper.class);
			TipoTransazioneCrud tipoTransazioneCrud = new TipoTransazioneCrud();
			tipoTransazione = tipoTransazioneCrud.update(tipoTransazione, tipoTransazioneMapper);
			SqlMapFactory.instance().commitSession();
			return tipoTransazione;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public TipoTransazione findById(Integer idTipoTransazione) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("FindById bean tipoTransazione = " + idTipoTransazione);
			TipoTransazioneMapper tipoTransazioneMapper = SqlMapFactory.instance().getMapper(TipoTransazioneMapper.class);
			TipoTransazioneCrud tipoTransazioneCrud = new TipoTransazioneCrud();
			TipoTransazione tipoTransazione = tipoTransazioneCrud.findById(idTipoTransazione, tipoTransazioneMapper);
			return tipoTransazione;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public List<TipoTransazione> findAll() {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("FindAll bean tipoTransazione");
			TipoTransazioneMapper tipoTransazioneMapper = SqlMapFactory.instance().getMapper(TipoTransazioneMapper.class);
			TipoTransazioneCrud tipoTransazioneCrud = new TipoTransazioneCrud();
			List<TipoTransazione> listaTipiTransazione = tipoTransazioneCrud.findAll(tipoTransazioneMapper);
			return listaTipiTransazione;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

}
