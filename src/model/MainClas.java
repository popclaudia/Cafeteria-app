package model;



import controller.ControllerAdmin;
import controller.ControllerAngajat;
import controller.ControllerLogIn;
import view.AdministratorGUI;
import view.AngajatGUI;
import view.LogInForm;

public class MainClas {


	public static void main(String[] args) {
		
		//AngajatGUI login=new AngajatGUI();
		//ControllerAngajat c=new ControllerAngajat(login);
		//AdministratorGUI loginn=new AdministratorGUI();
		//ControllerAdmin cc=new ControllerAdmin(loginn);
		
		LogInForm l=new LogInForm();
		ControllerLogIn ll=new ControllerLogIn(l);
		
	}

}
