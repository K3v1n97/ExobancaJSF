package it.exolab.exobanca.mappers;

import java.util.List;

import it.exolab.exobanca.models.StatoContoCorrente;

public interface StatoContoMapper {
	
	void insert(StatoContoCorrente statoContoCorrente);
	
	void update(StatoContoCorrente statoContoCorrente);
	
	StatoContoCorrente findById(Integer idStatoContoCorrente);
	
	List<StatoContoCorrente> findAllContiCorrenti();


}
