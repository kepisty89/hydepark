package web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import service.LoginInterface;

@RequestScoped
@Named
public class LoginBean {
	
	@Inject 
	LoginInterface loginManager;
	
	private boolean loggedIn = false;
	private String login;
	private String password;
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
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
	
	//ACTIONS.
	public String login() {
		if(login.isEmpty() || password.isEmpty()) {
			return "error";
		}
		else if(loginManager.login(login, password)) {
			loggedIn = true;
			return "success";
		}
		else {
			return "error";
		}
	}
	
}
