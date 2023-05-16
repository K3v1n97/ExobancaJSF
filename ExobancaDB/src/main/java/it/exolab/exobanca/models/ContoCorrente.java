package it.exolab.exobanca.models;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ContoCorrente {
	
	Random random = new Random();
	
	private Integer idContoCorrente; // auto_generato
	private String ibanContoCorrente; // auto_generato lato java
	private Double saldoContabile;
	private Double saldoDisponibile;
	private Integer idStatoContoCorrente;
	private StatoContoCorrente statoContoCorrente;
	
	private List<Utente> listaIntestatari;
	
	private static int CIN_EUR = 1;	
	
	public ContoCorrente() {
		
		ibanContoCorrente = generateIBAN();

	}

	public Integer getIdContoCorrente() {
		return idContoCorrente;
	}
	
	public void setIdContoCorrente(Integer idContoCorrente) {
		this.idContoCorrente = idContoCorrente;
	}
	
	public String getIbanContoCorrente() {
		return ibanContoCorrente;
	}

	public void setIbanContoCorrente(String ibanContoCorrente) {
		this.ibanContoCorrente = ibanContoCorrente;
	}

	public Double getSaldoContabile() {
		return saldoContabile;
	}

	public void setSaldoContabile(Double saldoContabile) {
		this.saldoContabile = saldoContabile;
	}

	public Double getSaldoDisponibile() {
		return saldoDisponibile;
	}

	public void setSaldoDisponibile(Double saldoDisponibile) {
		this.saldoDisponibile = saldoDisponibile;
	}
	
	public Integer getIdStatoContoCorrente() {
		return idStatoContoCorrente;
	}

	public void setIdStatoContoCorrente(Integer idStatoContoCorrente) {
		this.idStatoContoCorrente = idStatoContoCorrente;
	}

	public StatoContoCorrente getStatoContoCorrente() {
		return statoContoCorrente;
	}
	
	public void setStatoContoCorrente(StatoContoCorrente statoContoCorrente) {
		this.statoContoCorrente = statoContoCorrente;
	}
	
	public List<Utente> getListaIntestatari() {
		return listaIntestatari;
	}

	public void setListaIntestatari(List<Utente> listaIntestatari) {
		this.listaIntestatari = listaIntestatari;
	}

	private char getCIN() {
		
		int randomAlpha = 0;
		int max = 90;
		int min = 65;
		
		randomAlpha = random.nextInt((max - min) + 1)  + min;
		
		char alpha = (char) randomAlpha;

		return alpha;
	}
	
	private String getABI() {
		
		String ABIString = "";
				
		int ABI = random.nextInt(100000) + 1;
		if(ABI < 10) {
			ABIString = "0000" + ABI;
		} else if(ABI < 100) {
			ABIString = "000" + ABI;
		} else if(ABI < 1000) {
			ABIString = "00" + ABI;
		} else if(ABI < 10000) {
			ABIString = "0" + ABI;
		} else {
			ABIString = String.valueOf(ABI);
		}
		
		return ABIString;
	}
	
	private String getCAB() {
		
		String CABString = "";
		
		int CAB = random.nextInt(100000) + 1;
		if(CAB < 10) {
			CABString = "0000" + CAB;
		} else if(CAB < 100) {
			CABString = "000" + CAB;
		} else if(CAB < 1000) {
			CABString = "00" + CAB;
		} else if(CAB < 10000) {
			CABString = "0" + CAB;
		} else {
			CABString = String.valueOf(CAB);
		}
		
		return CABString;
		
	}
	
	private String getCC() {
		
		String CCString = "";
		
		int CC = random.nextInt(1000000000) + 1;
		if(CC < 10) {
			CCString = "00" + "000000000" + CC;
		} else if(CC < 100) {
			CCString = "00" + "00000000" + CC;
		} else if(CC < 1000) {
			CCString = "00" + "0000000" + CC;
		} else if(CC < 10000) {
			CCString = "00" + "000000" + CC;
		} else if(CC < 100000) {
			CCString = "00" + "00000" + CC;
		} else if(CC < 1000000) {
			CCString = "00" + "0000" + CC;
		} else if(CC < 10000000) {
			CCString = "00" + "000" + CC;
		} else if(CC < 100000000) {
			CCString = "00" + "00" + CC;
		} else if(CC < 1000000000) {
			CCString = "00" + "0" + CC;
		} else {
			CCString = "00" + String.valueOf(CC);
		}
		
		return CCString;
		
	}
	
	private String generateIBAN() {	
		
		String IBAN = "";
		
		if(CIN_EUR < 10) {
			IBAN = "IT0" + CIN_EUR + getCIN() + getABI() + getCAB() + getCC();
		} else {
			IBAN = "IT" + CIN_EUR + getCIN() + getABI() + getCAB() + getCC(); 
		}
		CIN_EUR++;
		
		return IBAN;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(ibanContoCorrente, idStatoContoCorrente, saldoContabile, saldoDisponibile, statoContoCorrente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContoCorrente other = (ContoCorrente) obj;
		return Objects.equals(ibanContoCorrente, other.ibanContoCorrente)
				&& Objects.equals(idStatoContoCorrente, other.idStatoContoCorrente)
				&& Objects.equals(saldoContabile, other.saldoContabile)
				&& Objects.equals(saldoDisponibile, other.saldoDisponibile)
				&& Objects.equals(statoContoCorrente, other.statoContoCorrente);
	}

	@Override
	public String toString() {
		return "ContoCorrente [idContoCorrente=" + idContoCorrente + ", ibanContoCorrente=" + ibanContoCorrente + ", saldoContabile="
				+ saldoContabile + ", saldoDisponibile=" + saldoDisponibile + ", statoContoCorrente="
				+ idStatoContoCorrente + "]";
	}

}
