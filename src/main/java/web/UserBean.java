package web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import domain.Credential;
import service.UserInterface;

@RequestScoped
@Named
public class UserBean {
	
	@Inject
	UserInterface userManager;
	
	private String name;
	private String surname;
	private String login;
	private String password;
	private String newPassword;
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
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
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	//Actions
	public String createUser() {
		if(name.isEmpty() || surname.isEmpty() || login.isEmpty() || password.isEmpty()) {
			return "error";
		}
		else if (userManager.duplicate(login))
		{
			return "error";
		}
		else {
			userManager.createUser(login, password, name, surname);
			return "success";
		}
	}
	
	public String deleteUser() {
		if (userManager.deleteUser(login, password))
		{
			return "success";
		}
		else 
		{
			return "error";
		}
	}
	
	public String updateUser() {
		if (userManager.updateUser(login, password, newPassword, name, surname))
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}
	
	public String banUser() {
		userManager.banUser(login);
		
		return "success";
	}
	
	public String unBanUser() {
		userManager.unBanUser(login);
		
		return "success";
	}
	
	public String roleUser() {
		if(login.isEmpty() || password.isEmpty()) {
			return "error";
		}
		if(userManager.setRole(login, password, role)) {
			return "success";
		}
		else {
			return "error";
		}
	}
	
	public String getReset() {	//Reset bean.
		name = null;
		surname = null;
		login = null;
		password = null;
		newPassword = null;
		return null;
	}
	
	public List<Credential> getAllCredentials() {
		return userManager.readCredential();	//Zwróæ listê wszystkich u¿ytkowników.
	}
	
}
