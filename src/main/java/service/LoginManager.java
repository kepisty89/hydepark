package service;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import service.LoginInterface;
import domain.Credential;

@Stateful
public class LoginManager implements LoginInterface {
		
	@PersistenceContext
	EntityManager em;
	
	@Override
	public boolean login(long id, String password) {
		Credential credential = em.find(Credential.class, id);
		if(credential.getPassword().contentEquals(password)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String convertIdToLogin(long id) {
		Credential credential = em.find(Credential.class, id);
		return credential.getLogin();
	}
	
}