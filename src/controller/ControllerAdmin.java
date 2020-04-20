package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import model.Cofetarie;
import model.CofetariiSerializer;
import model.ContUtilizator;
import model.FabricaUtilizator;
import model.Persistenta;
import model.PersistentaContUtilizator;
import model.Utilizator;
import view.AdministratorGUI;

public class ControllerAdmin {
	AdministratorGUI agui;
	ArrayList<ContUtilizator> users=new ArrayList<ContUtilizator>();
	CofetariiSerializer<ContUtilizator> data= new CofetariiSerializer<ContUtilizator>(ContUtilizator.class);
	Persistenta persistenta=new PersistentaContUtilizator();
	public ControllerAdmin(AdministratorGUI agui) {
		this.agui=agui;
		this.agui.viewListener(new ViewListener());
		this.agui.addListener(new AddListener());
		this.agui.deleteListener(new DeleteListener());
		this.agui.updateListener(new UpdateListener());
		this.agui.saveListener(new SaveListener());

	}

	class ViewListener implements ActionListener {
		int count = 0;
		public void actionPerformed(ActionEvent arg0) {			
			tabel(count);	
		}

	}

	class AddListener implements ActionListener {
		private Exception Exception = null;
		String nume,rol,post,username,pass;
		int varsta;
		String cofetarie;
		Cofetarie cofetari;
		ArrayList<Cofetarie> co=new ArrayList<Cofetarie>();
		CofetariiSerializer<Cofetarie> datac= new CofetariiSerializer<Cofetarie>(Cofetarie.class);
		Utilizator u;
		FabricaUtilizator fu= new FabricaUtilizator();;
		ContUtilizator cu;
		public void actionPerformed(ActionEvent arg0) {

			try {
				nume=agui.getN();
				username=agui.getU();
				pass=agui.getPar();
				cofetarie=(String) agui.getCof();
				rol=(String) agui.getRol();
				post=(String) agui.getPost();
				varsta=Integer.parseInt(agui.getV());


				if (nume.equals("")||username.equals("")||pass.equals("")||agui.getV().equals("")||varsta<18)
					throw Exception ;

				co=datac.deserialize();
				for(Cofetarie c:co)
					if((Cofetarie.getDenumire()+", "+c.getAdresa()).equals(cofetarie)) {
						cofetari=new Cofetarie(c.getAdresa(),c.getPrajituri());
						
					}

				persistenta.adaugaUtilizator(rol,nume,varsta,post,cofetari,username,pass);
				agui.infoBox("Utilizatorul "+ nume +" a fost adaugat cu succes!", "Adaugare");
			}
			catch(Exception e) {
				agui.infoBox("Utilizatorul nu a putut fi adaugat! Datele introduse sunt invalide. Va rugam sa incercati din nou.", "Adaugare");

			}
		}

	}

	class DeleteListener implements ActionListener {
		int index;
		public void actionPerformed(ActionEvent arg0) {
			try {
				index=agui.getRow();
				persistenta.stergeUtilizator(index);
				agui.infoBox("Utilizatorul a fost sters cu succes!", "Delete");
			}
			catch (Exception e) {
				agui.infoBox("Nu a fost selectat niciun angajat!", "Delete");

			}

		}

	}

	class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {	
			agui.updateAngajat();

		}

	}

	public void tabel(int count) {
		users=data.deserialize();
		Vector<String> header = new Vector<String>();
		Vector<Vector<Object>> content = new Vector<Vector<Object>>();
		count = 0;
		header.add("Nr.");
		header.add("Nume");
		header.add("Varsta");
		header.add("Rol");
		header.add("Post ocupat");
		header.add("Cofetarie");
		header.add("Username");
		header.add("Parola");
		for (ContUtilizator m : users) {
			count++;
			Vector<Object> vector = new Vector<Object>();
			vector.add(count);
			vector.add(m.getUser().getNume());
			vector.add(m.getUser().getVarsta());
			vector.add(m.getUser().getRol());
			vector.add(m.getUser().getPostOcupat());
			vector.add(m.getUser().getCofetarie());
			vector.add(m.getUsername());
			vector.add(m.getParola());
			content.add(vector);

		}
		agui.afisareLista(new DefaultTableModel(content, header));


	}

	class SaveListener implements ActionListener {
		private Exception Exception = null;
		String nume,rol,post;
		int varsta;
		String cofetarie;
		Cofetarie cofetari;
		ArrayList<Cofetarie> co=new ArrayList<Cofetarie>();
		CofetariiSerializer<Cofetarie> datac= new CofetariiSerializer<Cofetarie>(Cofetarie.class);
		Utilizator u;
		FabricaUtilizator fu= new FabricaUtilizator();
		ContUtilizator cu;
		int index;
		public void actionPerformed(ActionEvent arg0) {

			try {
				nume=agui.getN1();
				cofetarie=(String) agui.getCof1();
				rol=(String) agui.getRol1();
				post=(String) agui.getPost1();
				varsta=Integer.parseInt(agui.getV1());

				if (nume.equals("")||agui.getV1().equals("")||varsta<18)
					throw Exception ;
				index=agui.getRow();
				co=datac.deserialize();
				for(Cofetarie c:co)
					if((Cofetarie.getDenumire()+", "+c.getAdresa()).equals(cofetarie)) {
						cofetari=new Cofetarie(c.getAdresa(),c.getPrajituri());
						System.out.println(c.getAdresa());
					}

				persistenta.modificaUtilizator(index, rol,nume,varsta,post,cofetari);
				agui.infoBox("Utilizatorul "+ nume +" a fost actualizat cu succes!", "Update");
			}
			catch(Exception e) {
				agui.infoBox("Utilizatorul nu a putut fi adaugat! Datele introduse sunt invalide. Va rugam sa incercati din nou.", "Update");

			}
		}

	}

}
