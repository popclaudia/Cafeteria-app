package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import javafx.application.Application;
import model.Angajat;
import model.Cofetarie;
import model.CofetariiSerializer;
import model.ConstructorRaport;
import model.Persistenta;
import model.PersistentaPrajituri;
import model.Prajitura;
import model.Raport;
import view.AngajatGUI;
import view.Charts;

public class ControllerAngajat {
	AngajatGUI agui;
	ArrayList<Cofetarie> cofetarii=new ArrayList<Cofetarie>();
	ArrayList<Prajitura> praji=new ArrayList<Prajitura>();
	CofetariiSerializer<Cofetarie> data= new CofetariiSerializer<Cofetarie>(Cofetarie.class);
	Angajat a = new Angajat("a",23,"b","c",data.deserialize().get(0));
	Persistenta persistenta=new PersistentaPrajituri();
	ConstructorRaport cr=new ConstructorRaport();
	public ControllerAngajat(AngajatGUI agui) {
		this.agui=agui;
		agui.setPrajituri(persistenta.getListaPrajituri());
		this.agui.viewListener(new ViewListener());
		this.agui.filterListener(new FilterListener());
		this.agui.searchListener(new SearchListener());
		this.agui.viewPListener(new ViewPListener());
		this.agui.addListener(new AddListener());
		this.agui.deleteListener(new DeleteListener());
		this.agui.updateListener(new UpdateListener());
		this.agui.saveListener(new SaveListener());
		this.agui.saveFileListener(new SaveFileListener());


	}


	class ViewListener implements ActionListener {
		String sc;
		Cofetarie cofe;
		public void actionPerformed(ActionEvent arg0) {			
			cofetarii=data.deserialize();
			sc=(String) agui.getCof();

			for(Cofetarie c:cofetarii)
				if((Cofetarie.getDenumire()+", "+c.getAdresa()).equals(sc)) {
					cofe=new Cofetarie(c.getAdresa(),c.getPrajituri());
				}

			tabelPrajituri(a.veziPrajituri(cofe));
		}
	}

	class FilterListener implements ActionListener {
		private  Exception exception = null;
		String criteriu;
		int min, max;
		String text="Date invalide!";
		public void actionPerformed(ActionEvent arg0) {			
			try {
				cofetarii=data.deserialize();
				criteriu=(String) agui.getCriteriu();
				min=Integer.parseInt(agui.getMin());
				max=Integer.parseInt(agui.getMax());
				if(criteriu.equals("Pret")&&( min<0 || max<0 ||max<min) )
					throw exception;
				if(criteriu.equals("Disponibilitate")&&( min<0 || max<0 ||max<min) )
					throw exception;
				if(criteriu.equals("Valabilitate")&&(agui.getMin().length()!=6||agui.getMax().length()!=6)) {
					text="Data trebuie sa fie de forma ZZLLAAAA!";
					throw exception;
				}
				tabelPrajituri(praji=a.filtreazaPrajituri(criteriu, min, max));
				
			}
			catch (Exception e) {
				agui.infoBox(text, "Filtrare");
			}
		}
	}

	class SearchListener implements ActionListener{
		String praji;
		String datePraji;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			praji=(String)agui.getPrajitura();
			datePraji=a.cautarePraji(praji);
			agui.setdatePrajitura(datePraji);

		}

	}

	class ViewPListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {		
			agui.setPrajituri(persistenta.getListaPrajituri());
			tabelPrajituri(persistenta.getPrajituri());
		}
	}


	class AddListener implements ActionListener {
		private Exception Exception = null;
		String nume,cofetarie,valabilitate;
		int pret,stoc;
		public void actionPerformed(ActionEvent arg0) {

			try {
				nume=agui.getD();
				cofetarie=(String) agui.getC();
				valabilitate=(String) agui.getV();;
				pret=Integer.parseInt(agui.getP());
				stoc=Integer.parseInt(agui.getS());

				if (nume.equals(""))
					throw Exception ;

				persistenta.adaugaPrajitura(nume,pret,cofetarie,stoc,valabilitate);
				agui.infoBox("Prajitura "+ nume +" a fost adaugat cu succes!", "Adaugare");
			}
			catch(Exception e) {
				agui.infoBox("Prajitura nu a putut fi adaugata! Datele introduse sunt invalide. Va rugam sa incercati din nou.", "Adaugare");

			}
		}

	}

	class DeleteListener implements ActionListener {
		int index;
		public void actionPerformed(ActionEvent arg0) {
			try {
				index=agui.getRow();
				persistenta.stergePrajitura(index);
				agui.infoBox("Prajitura a fost stearsa cu succes!", "Delete");
			}
			catch (Exception e) {
				agui.infoBox("Nu a fost selectata nicio prajitura!", "Delete");

			}

		}

	}

	class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {	
			agui.updatePrajitura();

		}

	}

	class SaveListener implements ActionListener {
		private Exception Exception = null;
		String nume, valabilitate;
		int pret,stoc;
		int index;
		public void actionPerformed(ActionEvent arg0) {

			try {
				nume=agui.getD();
				valabilitate=(String) agui.getV();;
				pret=Integer.parseInt(agui.getP());
				stoc=Integer.parseInt(agui.getS());

				if (nume.equals("")||pret==0)
					throw Exception ;
				index=agui.getRow();

				persistenta.modificaPrajitura(index, nume, pret, stoc, valabilitate);
				agui.infoBox("Prajitura "+ nume +" a fost actualizata cu succes!", "Update");
			}
			catch(Exception e) {
				agui.infoBox("Prajitura nu a putut fi actualizata! Datele introduse sunt invalide. Va rugam sa incercati din nou.", "Update");

			}
		}

	}

	public void tabelPrajituri(ArrayList<Prajitura> p) {
		int count = 0;
		Vector<String> header = new Vector<String>();
		Vector<Vector<Object>> content = new Vector<Vector<Object>>();
		header.add("Nr.");
		header.add("Denumire");
		header.add("Pret");
		header.add("Stoc");
		header.add("Valabilitate");
        Charts c=new Charts();
		for (Prajitura m : p) {
			count++;
			Vector<Object> vector = new Vector<Object>();
			vector.add(count);
			vector.add(m.getDenumire());
			vector.add(m.getPret());
			vector.add(m.getStoc());
			vector.add(m.getValabilitate().getDate() +"-"+m.getValabilitate().getMonth() +"-"+m.getValabilitate().getYear());
			content.add(vector);

		}
		agui.afisareLista(new DefaultTableModel(content, header));


	}

	class SaveFileListener implements ActionListener {
		String numeFisier;
		String formatFisier;
		public void actionPerformed(ActionEvent arg0) {	
			numeFisier=agui.getNumeFisier();
			formatFisier=agui.getFormat();
			Raport r= cr.CreareRaport(formatFisier, numeFisier, praji);

		}

	}


}
