package model;

public class FabricaUtilizator {
	
	public Utilizator obtineUtilizator(String rol,String nume,int varsta,String post,Cofetarie cofetari) {
		
		if(rol.equals("Administrator"))
			return new Administrator(nume,varsta,rol);
		else if(rol.equals("Angajat"))
			return new Angajat(nume,varsta,rol,post,cofetari);
		return null;
		
	}

}
