package it.exolab.exobanca.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.exobanca.models.ContoCorrente;

@Local
public interface ContoCorrenteInterface {
	
	ContoCorrente insert(ContoCorrente contoCorrente);
	
	ContoCorrente update(ContoCorrente contoCorrente);
	
	void delete(ContoCorrente contoCorrente);
	
	ContoCorrente findById(ContoCorrente contoCorrente);
	
	List<ContoCorrente> findAllConti();
	
	ContoCorrente findByIban(String ibanContoCorrente);
	
	List<ContoCorrente> findAllByUtente(Integer idUtente);

}
