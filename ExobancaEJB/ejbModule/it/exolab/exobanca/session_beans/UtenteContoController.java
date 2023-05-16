package it.exolab.exobanca.session_beans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import it.exolab.exobanca.cruds.UtenteContoCrud;
import it.exolab.exobanca.db_connection.SqlMapFactory;
import it.exolab.exobanca.interfaces.UtenteContoInterface;
import it.exolab.exobanca.mappers.UtenteContoMapper;
import it.exolab.exobanca.models.UtenteConto;

@Stateless(name="UtenteContoInterface")
@Local
public class UtenteContoController implements UtenteContoInterface{

	@Override
	public UtenteConto insert(UtenteConto utenteConto) {
	
		try {
			System.out.println("Insert bean utenteConto = " + utenteConto);
			UtenteContoMapper utenteContoMapper = SqlMapFactory.instance().getMapper(UtenteContoMapper.class);
			UtenteContoCrud utenteContoCrud = new UtenteContoCrud();
			utenteConto = utenteContoCrud.insert(utenteConto, utenteContoMapper);
			SqlMapFactory.instance().commitSession();
			return utenteConto;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
		return null;
	}

}
