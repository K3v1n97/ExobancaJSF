package it.exolab.exobanca.session_beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.exobanca.cruds.UtenteCrud;
import it.exolab.exobanca.db_connection.SqlMapFactory;
import it.exolab.exobanca.interfaces.UtenteInterface;
import it.exolab.exobanca.mappers.UtenteMapper;
import it.exolab.exobanca.models.Utente;

@Stateless(name="UtenteInterface")
@LocalBean
public class UtenteBean implements UtenteInterface{

	@Override
	public Utente insert(Utente utente) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Insert bean utente = " + utente);
			UtenteMapper utenteMapper = SqlMapFactory.instance().getMapper(UtenteMapper.class);
			UtenteCrud utenteCrud = new UtenteCrud();
			utente.setIdRuolo(2);
			utente = utenteCrud.insert(utente, utenteMapper);
			SqlMapFactory.instance().commitSession();
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}
	
	@Override
	public Utente update(Utente utente) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nell'update UtenteBean -> " + utente);
			UtenteMapper utenteMapper = SqlMapFactory.instance().getMapper(UtenteMapper.class);
			UtenteCrud utenteCrud = new UtenteCrud();
			utenteCrud.update(utente, utenteMapper);
			SqlMapFactory.instance().commitSession();
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public void delete(Utente utente) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel delete di UtenteBean -> " + utente);
			UtenteMapper utenteMapper = SqlMapFactory.instance().getMapper(UtenteMapper.class);
			UtenteCrud utenteCrud = new UtenteCrud();
			utenteCrud.delete(utente, utenteMapper);
			SqlMapFactory.instance().commitSession();
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	
	@Override
	public Utente findById(Integer idUtente) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("findById UtenteBean idUtente = " + idUtente);
			UtenteMapper utenteMapper = SqlMapFactory.instance().getMapper(UtenteMapper.class);
			UtenteCrud utenteCrud = new UtenteCrud();
			Utente utente = utenteCrud.findById(idUtente, utenteMapper);
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}
	
	@Override
	public List<Utente> findAllUtenti() {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("findAllUtenti UtenteBean");
			UtenteMapper utenteMapper = SqlMapFactory.instance().getMapper(UtenteMapper.class);
		
			UtenteCrud utenteCrud = new UtenteCrud();
			List<Utente> listaUtenti = utenteCrud.findAllUtenti(utenteMapper);
			return listaUtenti;
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				SqlMapFactory.instance().closeSession();
			}
		return null;
	}

	@Override
	public Utente findByEmailPassword(Utente utente) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel findByEmailPassword() di UtenteBean -> " + utente);
			UtenteMapper utenteMapper = SqlMapFactory.instance().getMapper(UtenteMapper.class);
			
			UtenteCrud utenteCrud = new UtenteCrud();
			utente = utenteCrud.findByEmailPassword(utente, utenteMapper);
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

	@Override
	public Utente findByEmail(String email) {
		
		try {
			SqlMapFactory.instance().openSession();
			System.out.println("Sono nel findByEmail() di UtenteBean, email -> " + email);
			UtenteMapper utenteMapper = SqlMapFactory.instance().getMapper(UtenteMapper.class);
			UtenteCrud utenteCrud = new UtenteCrud();
			Utente utente = utenteCrud.findByEmail(email, utenteMapper);
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

}
