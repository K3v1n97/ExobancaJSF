package it.exolab.exobanca.session_beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.exobanca.cruds.RuoloCrud;
import it.exolab.exobanca.db_connection.SqlMapFactory;
import it.exolab.exobanca.interfaces.RuoloInterface;
import it.exolab.exobanca.mappers.RuoloMapper;
import it.exolab.exobanca.models.Ruolo;

@Stateless(name="RuoloInterface")
@LocalBean
public class RuoloBean implements RuoloInterface{

	@Override
	public Ruolo insert(Ruolo ruolo) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Insert bean ruolo = " + ruolo);
			RuoloMapper ruoloMapper = SqlMapFactory.instance().getMapper(RuoloMapper.class);
			RuoloCrud ruoloCrud = new RuoloCrud();
			ruolo = ruoloCrud.insert(ruolo, ruoloMapper);
			SqlMapFactory.instance().commitSession();
			return ruolo;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public Ruolo update(Ruolo ruolo) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nell'update RuoloBean -> " + ruolo);
			RuoloMapper ruoloMapper = SqlMapFactory.instance().getMapper(RuoloMapper.class);
			RuoloCrud ruoloCrud = new RuoloCrud();
			ruolo = ruoloCrud.update(ruolo, ruoloMapper);
			SqlMapFactory.instance().commitSession();
			return ruolo;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public Ruolo findById(Integer idRuolo) {
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("findById RuoloBean idRuolo = " + idRuolo);
			RuoloMapper ruoloMapper = SqlMapFactory.instance().getMapper(RuoloMapper.class);
			RuoloCrud ruoloCrud = new RuoloCrud();
			Ruolo ruolo = ruoloCrud.findById(idRuolo, ruoloMapper);
			return ruolo;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public List<Ruolo> findAll() {
		
		try {
			SqlMapFactory.instance().openSession();
			RuoloMapper ruoloMapper = SqlMapFactory.instance().getMapper(RuoloMapper.class);
			RuoloCrud ruoloCrud = new RuoloCrud();
			List<Ruolo> listaRuoli = ruoloCrud.findAll(ruoloMapper);
			return listaRuoli;
		
			} catch (Exception e) {
				e.printStackTrace();
				SqlMapFactory.instance().rollbackSession();
			} finally {
				SqlMapFactory.instance().closeSession();
			}
		return null;
	}

}
