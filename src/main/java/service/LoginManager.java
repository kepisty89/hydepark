package service;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import service.LoginInterface;
import domain.Credential;
import service.UserManager;

@Stateful
public class LoginManager implements LoginInterface {

	@PersistenceContext
	EntityManager em;
	
	UserManager um = new UserManager();
	
	@Override
	public boolean login(String login, String password) {
		
		long userId = um.findUserCredentialId(login);
		Credential credential = em.find(Credential.class, userId);
		
		if(credential.getPassword() == password) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}
	
}