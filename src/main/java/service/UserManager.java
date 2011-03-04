package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Credential;
import domain.Participant;
import domain.Role;
import domain.User;

@Stateless
public class UserManager implements UserInterface {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public boolean createUser(String login, String password, String name,
			String surname) {
		User user = new User();
		Credential credential = new Credential();
		List<Participant> participant = new ArrayList<Participant>();
		Role role = Role.USER;
		
		user.setName(name);
		user.setSurname(surname);
		credential.setLogin(login);
		credential.setPassword(password);
		credential.setRole(role);
		credential.setRank(0);
		credential.setBanned(false);
		user.setCredential(credential);
		user.setParticipant(participant);
		user.setRole(role);
		
		em.persist(user);
		em.persist(credential);

		return true;
	}

	@Override
	public User getUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(String login) {
		User user = em.find(User.class, findUserId(login)); //Znajdü uøytkownika o danym id.
		
		em.remove(user);	//UsuÒ uøytkownika z bazy.
		
		return true;
	}

	@Override
	public boolean updateUser(String login, String password, String name,
			String surname) {
		User user = em.find(User.class, findUserId(login));	//Znajdü uøytkownika o danym id.
		Credential credential = em.find(Credential.class, findUserId(login));
		
		if(password != "") {
			credential.setPassword(password);
		}
		if(name != "") {	
			user.setName(name);
		}
		if(surname != "") {
			user.setSurname(surname);
		}
		
		em.merge(user);	
		em.merge(credential);
		return false;
	}

	@Override
	public void setRole(long id, Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void banUser(String login) {
		Credential credential = em.find(Credential.class, findUserId(login));
		
		credential.setBanned(true);
		
		return ;
	}

	@Override
	public void unBanUser(String login) {
		Credential credential = em.find(Credential.class, findUserId(login));
		
		credential.setBanned(false);
		
		return ;
	}
	
	public long findUserId(String name) {	//Na podstawie nazwy uøytkownika znajdü jego id.
		List<User> listOfUsers = getAllUsers();
		Iterator<User> it = listOfUsers.iterator();
		while(it.hasNext()) {
			User val = it.next();
			if(val.getName().contentEquals(name)) {
				return val.getId();
			}
		}
		return -1;
	}

}
