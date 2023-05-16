package it.exolab.exobanca.jsf.beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import it.exolab.exobanca.interfaces.ContoCorrenteInterface;
import it.exolab.exobanca.models.ContoCorrente;
import it.exolab.exobanca.models.Utente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ContoCorrenteBean implements Serializable {

	private static final long serialVersionUID = -2056403838857144580L;
	
	// INJECTION
	@EJB
	private ContoCorrenteInterface contoCorrenteInterface;
	
	@Inject
	private UtenteBean utenteBean;
	
	//ATTRIBUTI CONTO CORRENTE
	private ContoCorrente contoCorrente;
	private ContoCorrente nuovoContoCorrente;
	private List<ContoCorrente> listaContiUtente;
	private List<Utente> listaIntestatari;
	
	// ATTRIBUTI BOOLEANI CONTO CORRENTE
	private boolean viewContiUtente = false;
	private boolean viewNewConto = false;
	private boolean contoCointestato = false;

	// METODI GETTER/SETTER
	public ContoCorrente getContoCorrente() {
		return contoCorrente;
	}

	public void setContoCorrente(ContoCorrente contoCorrente) {
		this.contoCorrente = contoCorrente;
	}

	public ContoCorrente getNuovoContoCorrente() {
		return nuovoContoCorrente;
	}

	public void setNuovoContoCorrente(ContoCorrente nuovoContoCorrente) {
		this.nuovoContoCorrente = nuovoContoCorrente;
	}

	public List<ContoCorrente> getListaContiUtente() {
		return listaContiUtente;
	}

	public void setListaContiUtente(List<ContoCorrente> listaContiUtente) {
		this.listaContiUtente = listaContiUtente;
	}

	public List<Utente> getListaIntestatari() {
		return listaIntestatari;
	}

	public void setListaIntestatari(List<Utente> listaIntestatari) {
		this.listaIntestatari = listaIntestatari;
	}
	
	// GETTER/SETTER VALORI BOOLEANI
	public boolean isViewContiUtente() {
		return viewContiUtente;
	}

	public void setViewContiUtente(boolean viewContiUtente) {
		this.viewContiUtente = viewContiUtente;
	}

	public boolean isViewNewConto() {
		return viewNewConto;
	}

	public void setViewNewConto(boolean viewNewConto) {
		this.viewNewConto = viewNewConto;
	}

	public boolean isContoCointestato() {
		return contoCointestato;
	}

	public void setContoCointestato(boolean contoCointestato) {
		this.contoCointestato = contoCointestato;
	}

	// METODO POST CONSTRUCT
	@PostConstruct
	public void init() {
		System.out.println("Sono nell'init() di ContoCorrenteBean");
		contoCorrente = new ContoCorrente();
		listaIntestatari = new ArrayList<Utente>();
		listaContiUtente = loadListaContiUtente();
	}
	
	// METODI FUNZIONALI
	public List<ContoCorrente> loadListaContiUtente() {
		System.out.println("Sono nel metodo getListaContiUtente()");
		try {
			listaContiUtente = contoCorrenteInterface.findAllByUtente(utenteBean.getUtente().getIdUtente());
			return listaContiUtente;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Qualcosa è andato storto!");
		}
		return null;
	}
	
	public void reloadListaContiUtente() {
		listaContiUtente = loadListaContiUtente();
	}
	
	public ContoCorrente insertNewConto() {
		System.out.println("Sono nell'insertNewConto() di contoCorrenteBean");
		try {
			listaIntestatari.add(utenteBean.getUtente());
			contoCorrente.setListaIntestatari(listaIntestatari);
			contoCorrente = contoCorrenteInterface.insert(contoCorrente);
			nuovoContoCorrente = new ContoCorrente();
			nuovoContoCorrente = contoCorrente;
			System.out.println("vecchio conto = " + contoCorrente);
			System.out.println("Nuovo conto = " + nuovoContoCorrente);
			return nuovoContoCorrente;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Qualcosa è andato storto!");
		}
		return null;
	}
	
	// METODI MODIFICA VALORE BOOLEANI
	public void showListaContiUtente() {
		viewContiUtente = viewContiUtente ? false : true;
	}
	
	public void showDialogNewConto() {
		viewNewConto = viewNewConto ? false : true;
	}
	
	public void showContoCointestato() {
		contoCointestato = contoCointestato ? false : true;
	}
}
