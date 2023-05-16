package it.exolab.exobanca.cruds;

import it.exolab.exobanca.mappers.UtenteContoMapper;
import it.exolab.exobanca.models.UtenteConto;

public class UtenteContoCrud {
	
	public UtenteConto insert(UtenteConto utenteConto, UtenteContoMapper utenteContoMapper) {
		
		System.out.println("Sono nel crud insert utenteConto -> " + utenteConto);
		utenteContoMapper.insert(utenteConto);
		return utenteConto;
		
	}

}
