package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.CofetariiSerializer;
import model.ContUtilizator;
import view.AdministratorGUI;
import view.AngajatGUI;
import view.LogInForm;

public class ControllerLogIn {

	LogInForm login;
	String username, pass;
	ArrayList<ContUtilizator> u=new ArrayList<ContUtilizator>();
	CofetariiSerializer<ContUtilizator> us=new CofetariiSerializer<ContUtilizator>(ContUtilizator.class);


	public ControllerLogIn(LogInForm log) {
		this.login=log;
		this.login.loginListener(new LoginListener());
	}

	class LoginListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Henlo from controller");
			username=login.getuser();
			pass=login.getpass();
			u=us.deserialize();
			boolean b=false;
			AngajatGUI ang;
			AdministratorGUI admin;
			for (ContUtilizator i:u) {
				if (i.getUsername().equals(username)&&i.getParola().equals(pass)) {
					b=true;
					if(i.getUser().getClass().getSimpleName().equals("Angajat")){
						ang=new AngajatGUI();
						ControllerAngajat ca=new ControllerAngajat(ang);
						login.setVisible(false);
					}
					else if(i.getUser().getClass().getSimpleName().equals("Administrator")){
					admin=new AdministratorGUI();
					ControllerAdmin ca=new ControllerAdmin(admin);
					login.setVisible(false);
					}
					break;

				}
			}
			if (!b)
			{login.showMessage();
			System.out.println("Henlo from controller else");

			}




		}
	}




}
