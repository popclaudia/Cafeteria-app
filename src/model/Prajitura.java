package model;

import java.io.Serializable;
import java.util.Date;

public class Prajitura implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1532298612957597510L;
	private String denumire;
	private int cod=1;
	private int pret;
	private int stoc;
	private Date valabilitate;
	
	public Prajitura(String denumire, int cod, int pret, int stoc, Date valabilitate) {
		super();
		this.denumire = denumire;
		this.cod = cod;
		this.pret = pret;
		this.stoc = stoc;
		this.valabilitate = valabilitate;
	}

	public Prajitura() {
		
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getPret() {
		return pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}

	public int getStoc() {
		return stoc;
	}

	public void setStoc(int stoc) {
		this.stoc = stoc;
	}

	public Date getValabilitate() {
		return valabilitate;
	}

	public void setValabilitate(Date valabilitate) {
		this.valabilitate = valabilitate;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod;
		result = prime * result + ((denumire == null) ? 0 : denumire.hashCode());
		result = prime * result + pret;
		result = prime * result + stoc;
		result = prime * result + ((valabilitate == null) ? 0 : valabilitate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prajitura other = (Prajitura) obj;
		if (cod != other.cod)
			return false;
		if (denumire == null) {
			if (other.denumire != null)
				return false;
		} else if (!denumire.equals(other.denumire))
			return false;
		if (pret != other.pret)
			return false;
		if (stoc != other.stoc)
			return false;
		if (valabilitate == null) {
			if (other.valabilitate != null)
				return false;
		} else if (!valabilitate.equals(other.valabilitate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prajitura [denumire=" + denumire + ", cod=" + cod + ", pret=" + pret + ", stoc=" + stoc
				+ ", valabilitate=" + valabilitate + "]";
	}
	
	
	

}
