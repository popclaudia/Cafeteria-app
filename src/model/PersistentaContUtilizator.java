package model;

import java.util.ArrayList;

public class PersistentaContUtilizator extends Persistenta {
	
	ArrayList<ContUtilizator> users=new ArrayList<ContUtilizator>();
	CofetariiSerializer<ContUtilizator> data= new CofetariiSerializer<ContUtilizator>(ContUtilizator.class);
	

	public void adaugaUtilizator(String rol,String nume,int varsta,String post,Cofetarie cofetari, String username, String pass) {
		
		users=data.deserialize();
		Utilizator u;
		FabricaUtilizator fu= new FabricaUtilizator();
		ContUtilizator cu;
		
		u=fu.obtineUtilizator(rol,nume,varsta,post,cofetari);
		cu=new ContUtilizator(u,username,pass);
		users.add(cu);
		data.serialize(users);
	}
	
	public void stergeUtilizator(int i) {	
		users=data.deserialize();
		users.remove(i-1);
		data.serialize(users);	
		
	}
	
	
	public void modificaUtilizator(int i, String rol,String nume,int varsta,String post,Cofetarie cofetarie) {
		users=data.deserialize();
		users.get(i-1).getUser().setNume(nume);
		users.get(i-1).getUser().setVarsta(varsta);
		users.get(i-1).getUser().setPostOcupat(post);
		users.get(i-1).getUser().setRol(rol);
		users.get(i-1).getUser().setCofetarie(cofetarie);
		data.serialize(users);
		
	}
}
