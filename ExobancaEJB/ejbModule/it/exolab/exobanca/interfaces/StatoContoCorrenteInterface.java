package it.exolab.exobanca.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.exobanca.models.StatoContoCorrente;

@Local
public interface StatoContoCorrenteInterface {
	
	StatoContoCorrente insert(StatoContoCorrente statoContoCorrente);
	
	StatoContoCorrente update(StatoContoCorrente statoContoCorrente);
	
	StatoContoCorrente findById(Integer idStatoContoCorrente);
	
	List<StatoContoCorrente> findAllStatiConti();
	
}
