package it.exolab.exobanca.jsf.beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import it.exolab.exobanca.interfaces.UtenteInterface;
import it.exolab.exobanca.models.Utente;

import java.io.Serializable;

@Named
@SessionScoped
public class UtenteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// INJECTION
	@EJB
	private UtenteInterface utenteInterface;
	
	@Inject
	private ContoCorrenteBean contoCorrenteBean;
	
	// ATTRIBUTI UTENTE
	private Utente utente;
	private Utente nuovoUtente;
	private Utente utenteCointestatario;
	
	// BOOLEANI UTENTE
	private boolean login = true;
	private boolean register = false;

	// METODI GETTER/SETTER
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	public Utente getUtenteCointestatario() {
		return utenteCointestatario;
	}

	public void setUtenteCointestatario(Utente utenteCointestatario) {
		this.utenteCointestatario = utenteCointestatario;
	}

	public ContoCorrenteBean getContoCorrenteBean() {
		return contoCorrenteBean;
	}

	public void setContoCorrenteBean(ContoCorrenteBean contoCorrenteBean) {
		this.contoCorrenteBean = contoCorrenteBean;
	}

	public Utente getNuovoUtente() {
		return nuovoUtente;
	}

	public void setNuovoUtente(Utente nuovoUtente) {
		this.nuovoUtente = nuovoUtente;
	}
	
	// SETTER/GETTER BOOLEANI
	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public boolean isRegister() {
		return register;
	}

	public void setRegister(boolean register) {
		this.register = register;
	}
	
	// METODI BOOLEANI
	public void switchLoginRegister() {
		utente = new Utente();
		login = login ? false : true;
		System.out.println("login = " + login);
		register = register ? false : true;
		System.out.println("register = " + register);
	}

	// METODO POST CONSTRUCT
	@PostConstruct
	public void init() {
		System.out.println("Sono nell'init() di UtenteBean");
		System.out.println("login = " + login);
		System.out.println("register = " + register);
		nuovoUtente = new Utente();
		utente = new Utente();
	}
	
	// METODI FUNZIONALI
	public String doLogin() {
		
		System.out.println("Sono nel doLogin() ");
		try {
			utente = utenteInterface.findByEmailPassword(utente);
			if(null != utente) {
				if(utente.getIdRuolo() == 1) {
					System.out.println("Reindirizzo alla home Admin");
					System.out.println("Admin -> " + utente);
					return "/homeAdmin.xhtml?faces-redirect=true";
				} else if(utente.getIdRuolo() == 2) {
					System.out.println("Reindirizzo alla home Utente");
					System.out.println("Utente -> " + utente);
					return "/homeUtente.xhtml?faces-redirect=true";
				} else {
					System.out.println("è successo qualcosa di inaspettato");
				}
				System.out.println("UtenteTrovato!");
			} else {
				System.out.println("Utente inesistente!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String doRegister() {
		
		System.out.println("Sono nel doRegister()");
		try {
			nuovoUtente = utenteInterface.insert(nuovoUtente);
			System.out.println("Utente inserito -> " + nuovoUtente);
			utente = nuovoUtente;
			return doLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String doLogout() {
		System.out.println("Sono nel doLogin() ");
		utente = new Utente();
		contoCorrenteBean.init();
		return "/login.xhtml?faces-redirect=true";
	}
	
	public Utente findByEmail() {
		System.out.println("Sono nel findByEmail()");
		try {
			utenteCointestatario = utenteInterface.findByEmail(utenteCointestatario.getEmail());
			System.out.println("Utente cointestatario -> " + utenteCointestatario);
			return utenteCointestatario;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
