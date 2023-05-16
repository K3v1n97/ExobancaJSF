package it.exolab.exobanca.cruds;

import java.util.List;

import it.exolab.exobanca.mappers.ContoCorrenteMapper;
import it.exolab.exobanca.models.ContoCorrente;

public class ContoCorrenteCrud {

	public ContoCorrente insert(ContoCorrente contoCorrente, ContoCorrenteMapper contoCorrenteMapper) {
		
		System.out.println("Sono nel crud insert contoCorrente -> " + contoCorrente);
		contoCorrenteMapper.insert(contoCorrente);
		return contoCorrente;
	}

	public ContoCorrente update(ContoCorrente contoCorrente, ContoCorrenteMapper contoCorrenteMapper) {
		
		System.out.println("Sono nel crud update contoCorrente -> " + contoCorrente);
		contoCorrenteMapper.update(contoCorrente);
		return contoCorrente;
	}

	public void delete(ContoCorrente contoCorrente, ContoCorrenteMapper contoCorrenteMapper) {

		System.out.println("Sono nel crud delete contoCorrente -> " + contoCorrente);
		contoCorrenteMapper.delete(contoCorrente);
	}

	public ContoCorrente findById(ContoCorrente contoCorrente, ContoCorrenteMapper contoCorrenteMapper) {

		System.out.println("Sono nel crud findById contoCorrente -> " + contoCorrente);
		contoCorrente = contoCorrenteMapper.findById(contoCorrente.getIdContoCorrente());
		return contoCorrente;
	}

	public List<ContoCorrente> findAll(ContoCorrenteMapper contoCorrenteMapper) {
		
		System.out.println("Sono nel crud findAll contoCorrente");
		List<ContoCorrente> listaContiCorrenti = contoCorrenteMapper.findAll();
		return listaContiCorrenti;
	}
	
	public List<ContoCorrente> findAllByUtente(Integer idUtente, ContoCorrenteMapper contoCorrenteMapper) {
		
		System.out.println("Sono nel crud findAllByUtente contoCorrente: id intestatario = " + idUtente);
		List<ContoCorrente> listaContiUtente = contoCorrenteMapper.findAllByUtente(idUtente);
		return listaContiUtente;
	}

	public ContoCorrente findByIban(String ibanContoCorrente, ContoCorrenteMapper contoCorrenteMapper) {
		
		System.out.println("Sono nel crud findByIban contoCorrente -> " + ibanContoCorrente);
		ContoCorrente contoCorrenteTrovato = contoCorrenteMapper.findByIban(ibanContoCorrente);
		return contoCorrenteTrovato;
	}

}
