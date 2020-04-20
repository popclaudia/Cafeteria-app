package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class PersistentaPrajituri extends Persistenta {

	ArrayList<Prajitura> parray=new ArrayList<Prajitura>();
	CofetariiSerializer<Prajitura> pdata= new CofetariiSerializer<Prajitura>(Prajitura.class);

	ArrayList<Cofetarie> carray=new ArrayList<Cofetarie>();
	CofetariiSerializer<Cofetarie> cdata= new CofetariiSerializer<Cofetarie>(Cofetarie.class);
	Prajitura p=new Prajitura();
	LantDeCofetarii lc; 

	public String[] getListaPrajituri(){
		int i=0;
		parray=pdata.deserialize();
		String[] s=new String[parray.size()];
		for (Prajitura pr:parray) {
			s[i]=pr.getDenumire();
			i++;
		}
		return s;
	}

	public ArrayList<Prajitura> getPrajituri() {
		parray=pdata.deserialize();
		return parray;
	}

	public void adaugaPrajitura(String nume, int pret, String cofetarie, int stoc, String valabilitate) {
		ArrayList<Prajitura> pparray=new ArrayList<Prajitura>();
		ArrayList<Cofetarie> ccarray=new ArrayList<Cofetarie>();
		ccarray=cdata.deserialize();
		Set<Prajitura> setP = new LinkedHashSet<Prajitura>();
		Set<Prajitura> setPC= new LinkedHashSet<Prajitura>();
		ArrayList<Prajitura> prajiC = new ArrayList<Prajitura>();
		Date data;
		int z,l,a;
		z=Integer.parseInt(valabilitate.substring(0, 2));
		l=Integer.parseInt(valabilitate.substring(3, 5));
		a=Integer.parseInt(valabilitate.substring(6, 10));
		data=new Date(a,l,z);
		int i=0;
		for(Cofetarie c:ccarray) {
			i++;
			if((Cofetarie.getDenumire()+", "+c.getAdresa()).equals(cofetarie)) {
				i--;
				break;
			}
		}
		p.setDenumire(nume);
		p.setPret(pret);
		p.setStoc(stoc);
		p.setValabilitate(data);

		setPC.addAll(ccarray.get(i).getPrajituri());
		setPC.add(p);
		prajiC.addAll(setPC);
		ccarray.get(i).setPrajituri(prajiC);

		for(Cofetarie c: ccarray)
			setP.addAll(c.getPrajituri());
		pparray.addAll(setP);
		pdata.serialize(pparray);	
		cdata.serialize(ccarray);
		lc.getInstance(carray,parray);

	}
	public void stergePrajitura(int index) {
		parray=pdata.deserialize();

		carray=cdata.deserialize();
		for(Cofetarie c: carray)
			c.getPrajituri().remove(parray.get(index-1));

		parray.remove(index-1);
		pdata.serialize(parray);
		cdata.serialize(carray);
		lc.getInstance(carray,parray);
	}

	public void modificaPrajitura(int index, String nume, int pret, int stoc, String valabilitate) {
		parray=pdata.deserialize();
		carray=cdata.deserialize();
		Date data;
		int z,l,a;
		z=Integer.parseInt(valabilitate.substring(0, 2));
		l=Integer.parseInt(valabilitate.substring(3, 5));
		a=Integer.parseInt(valabilitate.substring(6, 10));
		data=new Date(a,l,z);
		for(Cofetarie c: carray) 
			if(c.getPrajituri().contains(parray.get(index-1)))
			{c.getPrajituri().remove(parray.get(index-1));
			c.getPrajituri().add(new Prajitura(nume,1,pret,stoc,data));
			}

		parray.get(index-1).setDenumire(nume);
		parray.get(index-1).setPret(pret);
		parray.get(index-1).setStoc(stoc);
		parray.get(index-1).setValabilitate(data);;
		pdata.serialize(parray);
		cdata.serialize(carray);
		lc.getInstance(carray,parray);
	}

}
