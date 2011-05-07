package service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Credential;
import domain.Role;

@Stateless
public class LoginManager implements LoginInterface {
		
	@PersistenceContext
	EntityManager em;
	
	@Override
	public boolean login(long id, String password) {
		Credential credential = em.find(Credential.class, id);
		if(credential.getPassword().contentEquals(password) && !credential.isBanned()) {
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

	@Override
	public Role convertIdToRole(long id) {
		Credential credential = em.find(Credential.class, id);
		return credential.getRole();
	}
	
	
}