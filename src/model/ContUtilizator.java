package model;

import java.io.Serializable;

public class ContUtilizator implements Serializable {


	private String username;
	private String parola;
	private Utilizator user;
	
	public ContUtilizator(Utilizator user, String username, String parola) {
		super();
		this.setUser(user);
		this.username = username;
		this.parola = parola;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}

	public Utilizator getUser() {
		return user;
	}

	public void setUser(Utilizator user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "ContUtilizator [username=" + username + ", parola=" + parola + ", user=" + user.getNume() + "cofetarie="+ user.getCofetarie()+ "]";
	}
}
