package model;

import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;



public class RaportXML extends Raport {

ArrayList<Prajitura> prajituri= new ArrayList<Prajitura>();
	
	public void adaugaPrajitura(Prajitura prajitura) {
		prajituri.add(prajitura);
	}
	public void genereazaFisier(String n) {

		FileOutputStream os;
		try {
			os = new FileOutputStream(n+".xml");
			XMLEncoder encoder = new XMLEncoder(os);
			
			for( Prajitura p: prajituri)
			    encoder.writeObject(p);    

			encoder.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
	}

}
