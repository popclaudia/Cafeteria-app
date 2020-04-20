package model;

import java.util.ArrayList;

public class ConstructorRaport {

	
	public Raport CreareRaport(String format,String numeFisier, ArrayList<Prajitura> prajituri) {
		Raport r=null;
		if (format.equals(".csv"))
			 r = new RaportCSV();
		if (format.equals(".json"))
			r = new RaportJSON();
		if (format.equals(".xml"))
			r = new RaportXML();
		
        for (Prajitura p : prajituri)
            r.adaugaPrajitura(p); 
        
        r.genereazaFisier(numeFisier);
        
        return r; 
	}
	
}
