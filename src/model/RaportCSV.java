package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

public class RaportCSV extends Raport {

ArrayList<Prajitura> prajituri= new ArrayList<Prajitura>();
ArrayList<String[]> praji= new ArrayList<String[]>();

	
	public void adaugaPrajitura(Prajitura prajitura) {
		prajituri.add(prajitura);
	}
	
	public void genereazaFisier(String filePath) {
		for(Prajitura p:prajituri)
			praji.add(new String[] {p.getDenumire(),String.valueOf(p.getPret()), String.valueOf(p.getStoc()), p.getValabilitate().getDate() +"-"+p.getValabilitate().getMonth() +"-"+p.getValabilitate().getYear()});
		File file = new File(filePath+".csv"); 
		
		try { 
	        FileWriter outputfile = new FileWriter(file); 
	  
	        CSVWriter writer = new CSVWriter(outputfile); 
	  
	
	        String[] header = { "Denumire", "Pret", "Stoc" , "Valabilitate"}; 
	        writer.writeNext(header); 
	  
	        writer.writeAll(praji);
	        
	        writer.close();  
	    } 
	    catch (IOException e) { 
	        // TODO Auto-generated catch block 
	        e.printStackTrace(); 
	    } 
		
	}

}
