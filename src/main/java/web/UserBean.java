package web;

//import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

//import domain.Credential;
//import domain.Participant;
//import domain.Role;

import service.UserInterface;

@RequestScoped
@Named
public class UserBean {
	
	@Inject
	UserInterface userManager;
	
	private String name;	//Imie.
	private String surname;	//Nazwisko.
	private String login;	//Login.
	private String password;	//Haslo.
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//AKCJE
	public String createUser() {
		if(name.isEmpty() || surname.isEmpty() || login.isEmpty() || password.isEmpty()) {
			return "error";
		}
		else {
			userManager.createUser(login, password, name, surname);
			return "home";
		}
	}
	
	public String deleteUser() {
		userManager.deleteUser(login);

		return "home";
	}
	
	public String updateUser() {
		userManager.updateUser(login, password, name, surname);
		
		return "home";
	}
	
	public String banUser() {
		userManager.banUser(login);
		
		return "home";
	}
	
	public String unBanUser() {
		userManager.unBanUser(login);
		
		return "home";
	}
	
}
