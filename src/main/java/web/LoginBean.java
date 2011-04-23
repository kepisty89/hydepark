package web;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import service.LoginInterface;

@ApplicationScoped
@Named
public class LoginBean {

	@Inject 
	LoginInterface loginManager;
	
	private boolean loggedIn = false;
	private long id;
	private String login;
	private String password;
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
		if(password.isEmpty()) {
			return "error";
		}
		else if(loginManager.login(id, password)) {
			loggedIn = true;
			login = loginManager.convertIdToLogin(id);
			return "success";
		}
		else {
			return "error";
		}
	}
	
	public String logout() {
		id = 0;
		login = null;
		password = null;
		loggedIn = false;
		return "success";
	}
		
}
