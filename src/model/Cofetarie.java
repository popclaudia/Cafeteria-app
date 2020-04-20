package model;

import java.io.Serializable;
import java.util.ArrayList;


public class Cofetarie implements Serializable{
	private static String denumire="Sweet Crown";
	private String Adresa;
	private ArrayList<Prajitura> prajituri=new ArrayList<Prajitura>();
;
	
	public Cofetarie(String adresa, ArrayList<Prajitura> prajituri) {
		super();
		Adresa = adresa;
		this.prajituri = prajituri;
	}

	public static String getDenumire() {
		return denumire;
	}

	public static void setDenumire(String denumire) {
		Cofetarie.denumire = denumire;
	}

	public String getAdresa() {
		return Adresa;
	}

	public void setAdresa(String adresa) {
		Adresa = adresa;
	}

	public ArrayList<Prajitura> getPrajituri() {
		return prajituri;
	}

	public void setPrajituri(ArrayList<Prajitura> prajituri) {
		this.prajituri = prajituri;
	}
	
	

}
