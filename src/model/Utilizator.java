package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Utilizator implements Serializable{
	private String nume;
	private int varsta;
	private String rol;
	
	public Utilizator(String nume, int varsta, String rol) {
		super();
		this.nume = nume;
		this.varsta = varsta;
		this.rol = rol;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public ArrayList<Prajitura> veziPrajituri(Cofetarie c1) {
		return null;
		
	}

	public ArrayList<Prajitura> filtreazaPrajituri(String string, int i, int j) {
		return null;
		
	}

	public String cautarePraji(String string) {
		return null;
		
	}
	public String getPostOcupat() {
		return null;
	}

	public void setPostOcupat(String postOcupat) {
		 
	}

	public String getCofetarie() {
		return null;
	}

	public void setCofetarie(Cofetarie cofetarie) {
		 
	}
	

}
