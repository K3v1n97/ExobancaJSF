package it.exolab.exobanca.interfaces;

import javax.ejb.Local;

import it.exolab.exobanca.models.UtenteConto;

@Local
public interface UtenteContoInterface {
	
	UtenteConto insert(UtenteConto utenteConto);

}
