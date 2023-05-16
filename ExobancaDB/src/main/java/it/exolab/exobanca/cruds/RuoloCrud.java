package it.exolab.exobanca.cruds;

import java.util.List;

import it.exolab.exobanca.mappers.RuoloMapper;
import it.exolab.exobanca.models.Ruolo;

public class RuoloCrud {
	
	public Ruolo insert(Ruolo ruolo, RuoloMapper ruoloMapper) {
		
		System.out.println("Sono nel crud insert ruolo -> " + ruolo);
		ruoloMapper.insert(ruolo);
		return ruolo;
	}
	
	public Ruolo update(Ruolo ruolo, RuoloMapper ruoloMapper) {
		
		System.out.println("Sono nel crud update ruolo = " + ruolo);
		ruoloMapper.update(ruolo);
		return ruolo;
	}
	
	public List<Ruolo> findAll(RuoloMapper ruoloMapper) {
		System.out.println("Sono nel findAll() RuoloCrud");
		List<Ruolo> listaRuoli = ruoloMapper.findAll();
		return listaRuoli;
	}
	
	public Ruolo findById(Integer idRuolo, RuoloMapper ruoloMapper) {
		
		System.out.println("Sono nel findById di ruolo -> " + idRuolo);
		Ruolo ruolo = ruoloMapper.findById(idRuolo);
		return ruolo;
	}

}
