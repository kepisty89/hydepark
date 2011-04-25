package web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import service.UserInterface;
import domain.Credential;

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
			return "/panel/error";
		}
		else if (userManager.duplicate(login))
		{
			return "/panel/error";
		}
		else {
			userManager.createUser(login, password, name, surname);
			return "/panel/success";
		}
	}
	
	public String deleteUserForUser() {
		if (userManager.deleteUserForUser(login, password))
		{
			return "/panel/success";
		}
		else 
		{
			return "/panel/error";
		}
	}
	
	public String deleteUserForAdmin() {
		if (userManager.deleteUserForAdmin(login))
		{
			return "/panel/success";
		}
		else 
		{
			return "/panel/error";
		}
	}
	
	public String updateUserForUser() {
		if (userManager.updateUserForUser(login, password, newPassword, name, surname))
		{
			return "/panel/success";
		}
		else
		{
			return "/panel/error";
		}
	}
	
	public String updateUserForAdmin() {
		if (userManager.updateUserForAdmin(login, newPassword, name, surname))
		{
			return "/panel/success";
		}
		else
		{
			return "/panel/error";
		}
	}
	
	public String banUser() {
		if(userManager.banUser(login)) {
			return "/panel/success";
		}
		else {
			return "/panel/error";
		}
	}
	
	public String unBanUser() {
		if(userManager.unBanUser(login)) {
			return "/panel/success";
		}
		else {
			return "/panel/error";
		}
	}
	
	public String roleUser() {
		if(login.isEmpty() || password.isEmpty()) {
			return "/panel/error";
		}
		if(userManager.setRole(login, password, role)) {
			return "/panel/success";
		}
		else {
			return "/panel/error";
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
		return userManager.readCredential();
	}
	
	public List<Credential> getAllTeachers() {
		return userManager.readTeacherCredential();
	}
	
}
