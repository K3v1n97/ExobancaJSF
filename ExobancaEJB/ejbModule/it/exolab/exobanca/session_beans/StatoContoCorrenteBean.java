package it.exolab.exobanca.session_beans;

import java.util.List;

import it.exolab.exobanca.cruds.StatoContoCorrenteCrud;
import it.exolab.exobanca.db_connection.SqlMapFactory;
import it.exolab.exobanca.interfaces.StatoContoCorrenteInterface;
import it.exolab.exobanca.mappers.StatoContoMapper;
import it.exolab.exobanca.models.StatoContoCorrente;

public class StatoContoCorrenteBean implements StatoContoCorrenteInterface{

	@Override
	public StatoContoCorrente insert(StatoContoCorrente statoContoCorrente) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Insert bean statoContoCorrente = " + statoContoCorrente);
			StatoContoMapper statoContoMapper = SqlMapFactory.instance().getMapper(StatoContoMapper.class);
			StatoContoCorrenteCrud statoContoCrud = new StatoContoCorrenteCrud();
			statoContoCorrente = statoContoCrud.insert(statoContoCorrente, statoContoMapper);
			SqlMapFactory.instance().commitSession();
			return statoContoCorrente;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public StatoContoCorrente update(StatoContoCorrente statoContoCorrente) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nell'update UtenteBean -> " + statoContoCorrente);
			StatoContoMapper statoContoMapper = SqlMapFactory.instance().getMapper(StatoContoMapper.class);
			StatoContoCorrenteCrud statoContoCrud = new StatoContoCorrenteCrud();
			statoContoCorrente = statoContoCrud.update(statoContoCorrente, statoContoMapper);
			SqlMapFactory.instance().commitSession();
			return statoContoCorrente;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public StatoContoCorrente findById(Integer idStatoContoCorrente) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("findById StatoContoCorrenteBean idStatoContoCorrente = " + idStatoContoCorrente);
			StatoContoMapper statoContoMapper = SqlMapFactory.instance().getMapper(StatoContoMapper.class);
			StatoContoCorrenteCrud statoContoCrud = new StatoContoCorrenteCrud();
			StatoContoCorrente statoContoCorrente = statoContoCrud.findById(idStatoContoCorrente, statoContoMapper);
			return statoContoCorrente;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public List<StatoContoCorrente> findAllStatiConti() {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("findAllUtenti StatoContoCorrenteBean");
			StatoContoMapper statoContoMapper = SqlMapFactory.instance().getMapper(StatoContoMapper.class);
			StatoContoCorrenteCrud statoContoCrud = new StatoContoCorrenteCrud();
			List<StatoContoCorrente> listaStatiConto = statoContoCrud.findAllContiCorrenti(statoContoMapper);
			return listaStatiConto;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				SqlMapFactory.instance().closeSession();
			}
		return null;
	}

}
