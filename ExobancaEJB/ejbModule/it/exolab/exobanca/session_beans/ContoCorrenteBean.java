package it.exolab.exobanca.session_beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.exobanca.cruds.ContoCorrenteCrud;
import it.exolab.exobanca.cruds.UtenteContoCrud;
import it.exolab.exobanca.db_connection.SqlMapFactory;
import it.exolab.exobanca.interfaces.ContoCorrenteInterface;
import it.exolab.exobanca.mappers.ContoCorrenteMapper;
import it.exolab.exobanca.mappers.UtenteContoMapper;
import it.exolab.exobanca.models.ContoCorrente;
import it.exolab.exobanca.models.Utente;
import it.exolab.exobanca.models.UtenteConto;

@Stateless(name="ContoCorrenteInterface")
@LocalBean
public class ContoCorrenteBean implements ContoCorrenteInterface{

	@Override
	public ContoCorrente insert(ContoCorrente contoCorrente) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Insert bean contoCorrente = " + contoCorrente);
			ContoCorrenteMapper contoCorrenteMapper = SqlMapFactory.instance().getMapper(ContoCorrenteMapper.class);
			UtenteContoMapper utenteContoMapper = SqlMapFactory.instance().getMapper(UtenteContoMapper.class);
			ContoCorrenteCrud contoCorrenteCrud = new ContoCorrenteCrud();
			UtenteContoCrud utenteContoCrud = new UtenteContoCrud();
			contoCorrente.setSaldoContabile(0.0);
			contoCorrente.setSaldoDisponibile(50.0);
			contoCorrente.setIdStatoContoCorrente(2);
			contoCorrente = contoCorrenteCrud.insert(contoCorrente, contoCorrenteMapper);
			for (Utente u : contoCorrente.getListaIntestatari()) {
				UtenteConto utenteConto = new UtenteConto();
				System.out.println(u);
				utenteConto.setIdIntestatario(u.getIdUtente());
				utenteConto.setIdContoCorrente(contoCorrente.getIdContoCorrente());
				System.out.println(contoCorrente.getIdContoCorrente());
				utenteConto = utenteContoCrud.insert(utenteConto, utenteContoMapper);
			}
			SqlMapFactory.instance().commitSession();
			return contoCorrente;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public ContoCorrente update(ContoCorrente contoCorrente) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nell'update ContoCorrenteBean -> " + contoCorrente);
			ContoCorrenteMapper contoCorrenteMapper = SqlMapFactory.instance().getMapper(ContoCorrenteMapper.class);
			ContoCorrenteCrud contoCorrenteCrud = new ContoCorrenteCrud();
			contoCorrenteCrud.update(contoCorrente, contoCorrenteMapper);
			SqlMapFactory.instance().commitSession();
			return contoCorrente;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public void delete(ContoCorrente contoCorrente) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel delete di ContoCorrenteBean -> " + contoCorrente);
			ContoCorrenteMapper contoCorrenteMapper = SqlMapFactory.instance().getMapper(ContoCorrenteMapper.class);
			ContoCorrenteCrud contoCorrenteCrud = new ContoCorrenteCrud();
			contoCorrenteCrud.delete(contoCorrente, contoCorrenteMapper);
			SqlMapFactory.instance().commitSession();
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		
	}

	@Override
	public ContoCorrente findById(ContoCorrente contoCorrente) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("findById ContoCorrenteBean idContoCorrente = " + contoCorrente.getIdContoCorrente());
			ContoCorrenteMapper contoCorrenteMapper = SqlMapFactory.instance().getMapper(ContoCorrenteMapper.class);
			ContoCorrenteCrud contoCorrenteCrud = new ContoCorrenteCrud();
			ContoCorrente contoCorrenteTrovato = contoCorrenteCrud.findById(contoCorrente, contoCorrenteMapper);
			return contoCorrenteTrovato;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public List<ContoCorrente> findAllConti() {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("findAll ContoCorrenteBean");
			ContoCorrenteMapper contoCorrenteMapper = SqlMapFactory.instance().getMapper(ContoCorrenteMapper.class);
			ContoCorrenteCrud contoCorrenteCrud = new ContoCorrenteCrud();
			List<ContoCorrente> listaContiCorrenti = contoCorrenteCrud.findAll(contoCorrenteMapper);
			return listaContiCorrenti;
			} catch (Exception e) {
				e.printStackTrace();
				SqlMapFactory.instance().rollbackSession();
			} finally {
				SqlMapFactory.instance().closeSession();
			}
		return null;
	}

	@Override
	public ContoCorrente findByIban(String ibanContoCorrente) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel findByIban() di ContoCorrenteBean -> " + ibanContoCorrente);
			ContoCorrenteMapper contoCorrenteMapper = SqlMapFactory.instance().getMapper(ContoCorrenteMapper.class);			
			ContoCorrenteCrud contoCorrenteCrud = new ContoCorrenteCrud();
			ContoCorrente contoCorrenteTrovato = contoCorrenteCrud.findByIban(ibanContoCorrente, contoCorrenteMapper);
			return contoCorrenteTrovato;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public List<ContoCorrente> findAllByUtente(Integer idUtente) {
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel findAllByUtente() di ContoCorrenteBean -> " + idUtente);
			ContoCorrenteMapper contoCorrenteMapper = SqlMapFactory.instance().getMapper(ContoCorrenteMapper.class);
			ContoCorrenteCrud contoCorrenteCrud = new ContoCorrenteCrud();
			List<ContoCorrente> listaContiUtente = contoCorrenteCrud.findAllByUtente(idUtente, contoCorrenteMapper);
			return listaContiUtente;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

}
