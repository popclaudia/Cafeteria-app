package model;

import java.util.ArrayList;

public class Persistenta {
	protected String numeFisier;

	public String getNumeFisier() {
		return numeFisier;
	}

	public void setNumeFisier(String numeFisier) {
		this.numeFisier = numeFisier;
	}

	public void adaugaUtilizator(String rol,String nume,int varsta,String post,Cofetarie cofetari, String username, String pass) {
		// TODO Auto-generated method stub

	}

	public void stergeUtilizator(int i) {


	}

	public void modificaUtilizator(int i, String rol,String nume,int varsta,String post,Cofetarie cofetari) {


	}

	public String[] getListaPrajituri() {
		return null;
	}

	public ArrayList<Prajitura> getPrajituri() {
		// TODO Auto-generated method stub
		return null;
	}

	public void adaugaPrajitura(String nume, int pret, String cofetarie, int stoc, String valabilitate) {
		// TODO Auto-generated method stub
		
	}

	public void stergePrajitura(int index) {
		// TODO Auto-generated method stub
		
	}

	public void modificaPrajitura(int index, String nume, int pret, int stoc, String valabilitate) {
		// TODO Auto-generated method stub
		
	}



}
