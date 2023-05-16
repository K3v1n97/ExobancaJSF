package it.exolab.exobanca.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import it.exolab.exobanca.models.ContoCorrente;

public interface ContoCorrenteMapper {
	
	void insert(ContoCorrente contoCorrente);
	
	void update(ContoCorrente contoCorrente);
	
	void delete(ContoCorrente contoCorrente);
	
	ContoCorrente findById(Integer idContoCorrente);
	
	List<ContoCorrente> findAll();
	
	ContoCorrente findByIban(@Param("ibanContoCorrente") String ibanConto);
	
	List<ContoCorrente> findAllByUtente(Integer idUtente);

}
