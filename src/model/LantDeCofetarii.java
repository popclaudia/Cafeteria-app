package model;

import java.util.ArrayList;

public class LantDeCofetarii {
	private final String denumire="Sweet Crown";
	private ArrayList<Cofetarie> cofetarii= new ArrayList<Cofetarie>();
	private ArrayList<Prajitura>ap = new ArrayList<Prajitura>();
	
	private static LantDeCofetarii singleInstance = null;
	
	public LantDeCofetarii( ArrayList<Cofetarie> cofetarii, ArrayList<Prajitura>ap) {
		this.cofetarii=cofetarii;
		this.ap=ap;
	}
	
	 public static LantDeCofetarii getInstance( ArrayList<Cofetarie> cofetarii, ArrayList<Prajitura>ap) 
	    { 
	        if (singleInstance == null) 
	            singleInstance = new LantDeCofetarii(cofetarii,ap); 
	  
	        return singleInstance; 
	    }
	 

	public String getDenumire() {
		return denumire;
	}

	public ArrayList<Cofetarie> getCofetarii() {
		return cofetarii;
	}

	public void setCofetarii(ArrayList<Cofetarie> cofetarii) {
		this.cofetarii = cofetarii;
	}

	public void setPraji(ArrayList<Prajitura> p) {
		this.ap=p;
		
	}
	public ArrayList<Prajitura> getPraji() {
		return this.ap;
		
	}
}
