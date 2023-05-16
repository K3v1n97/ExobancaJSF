package it.exolab.exobanca.cruds;

import java.util.List;

import it.exolab.exobanca.mappers.StatoContoMapper;
import it.exolab.exobanca.models.StatoContoCorrente;

public class StatoContoCorrenteCrud {

	public StatoContoCorrente insert(StatoContoCorrente statoContoCorrente, StatoContoMapper statoContoMapper) {
		
		System.out.println("Sono nel crud insert StatoContoCorrenteCrud -> " + statoContoCorrente);
		statoContoMapper.insert(statoContoCorrente);
		return statoContoCorrente;
	}

	public StatoContoCorrente update(StatoContoCorrente statoContoCorrente, StatoContoMapper statoContoMapper) {
		
		System.out.println("Sono nel crud update StatoContoCorrenteCrud = " + statoContoCorrente);
		statoContoMapper.update(statoContoCorrente);
		return statoContoCorrente;
		
	}

	public StatoContoCorrente findById(Integer idStatoContoCorrente, StatoContoMapper statoContoMapper) {
		System.out.println("Sono nel crud findById StatoContoCorrenteCrud -> " + idStatoContoCorrente);
		StatoContoCorrente statoContoCorrente = statoContoMapper.findById(idStatoContoCorrente);
		return statoContoCorrente;
	}

	public List<StatoContoCorrente> findAllContiCorrenti(StatoContoMapper statoContoMapper) {
		
		System.out.println("Sono nel findAll() StatoContoCorrenteCrud");
		List<StatoContoCorrente> listaStati = statoContoMapper.findAllContiCorrenti();
		return listaStati;
	}

}
