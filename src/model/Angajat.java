package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Angajat extends Utilizator implements Serializable {
	private String postOcupat;
	private Cofetarie cofetarie;

	public Angajat( String nume, int varsta, String rol, String post, Cofetarie cofetarie) {
		super(nume, varsta, rol);
		this.postOcupat = post;
		this.cofetarie = cofetarie;

	}

	public String getPostOcupat() {
		return postOcupat;
	}

	public void setPostOcupat(String postOcupat) {
		this.postOcupat = postOcupat;
	}

	public String getCofetarie() {
		return  cofetarie.getAdresa();
	}

	public void setCofetarie(Cofetarie cofetarie) {
		this.cofetarie = cofetarie;
	}


	public ArrayList<Prajitura> veziPrajituri(Cofetarie c) {
		ArrayList<Prajitura> prajiCofetarie = new ArrayList<Prajitura>();
		System.out.println("Henlo");
		for (Prajitura p : c.getPrajituri()) {
			prajiCofetarie.add(p);
			System.out.println(p);

		}
		return c.getPrajituri();

	}

	@SuppressWarnings("deprecation")
	public ArrayList<Prajitura> filtreazaPrajituri(String criteriu, int min, int max) {

		ArrayList<Prajitura> toatePrajiturile = new ArrayList<Prajitura>();
		CofetariiSerializer<Prajitura>  cof = new CofetariiSerializer<Prajitura> (Prajitura.class);
		toatePrajiturile = cof.deserialize();
		ArrayList<Prajitura> prajiCofetarie = new ArrayList<Prajitura>();

		for (Prajitura p : toatePrajiturile) {
			if (criteriu.equals("Disponibilitate")) {
				if (p.getStoc() >= min && p.getStoc() <= max) {
					prajiCofetarie.add(p);
					System.out.println(p);
				} }
			else 
				if (criteriu.equals("Pret")) {
					if (p.getPret() >= min && p.getPret() <= max) {
						prajiCofetarie.add(p);
						System.out.println(p);
					} }
				else
					if (criteriu.equals("Valabilitate")) {
						long ms, m1, m2;
						ms = p.getValabilitate().getTime();
						Date d1;
						Date d2;
						d1 = new Date(min % 10000, min / 10000 % 100, min / 1000000 % 100);
						d2 = new Date(max % 10000, max / 10000 % 100, max / 1000000 % 100);
						m1 = d1.getTime();
						m2 = d2.getTime();
						if (ms >= m1 && ms <= m2) {
							prajiCofetarie.add(p);
							System.out.println(p);
						}
					} else
						System.out.println("Eroare");
		}

		return prajiCofetarie;

	}

	public String cautarePraji(String nume) {

		ArrayList<Prajitura> toatePrajiturile = new ArrayList<Prajitura>();
		CofetariiSerializer<Prajitura> cof = new CofetariiSerializer<Prajitura>(Prajitura.class);
		toatePrajiturile = cof.deserialize();
		String pr = new String("Nu exista prajitura cautata");

		for (Prajitura p : toatePrajiturile)
			if (p.getDenumire().equals(nume)) {
				pr = "Denumire: "+p.getDenumire() + " \n" +"Pret: "+ p.getPret() + " lei \n" + "Disponibilitate: "+p.getStoc() + " bucati\n" + "Data de expirare: " + p.getValabilitate().getDate() +"."+p.getValabilitate().getMonth() +"."+p.getValabilitate().getYear();
				System.out.println(pr);
				return pr;
			}
		System.out.println(pr);
		return pr;

	}
}