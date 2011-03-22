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

	public boolean deleteUser(String login, String password) {
		long userId = findUserCredentialId(login);
		Credential credential = em.find(Credential.class, userId);
		User user = em.find(User.class, userId);
		if (credential.getPassword().contentEquals(password))
		{
			em.remove(user);
			em.remove(credential);
			return true;
		}
		else 
		{
			return false;
		}
	}

	@Override
	public boolean updateUser(String login, String password, String newPassword, String name,
			String surname) {
		long userId = findUserCredentialId(login);
		User user = em.find(User.class, userId);	
		Credential credential = em.find(Credential.class, userId);
		
		if (credential.getPassword().contentEquals(password))
		{
			if(newPassword != "") {
				credential.setPassword(newPassword);
			}
			if(name != "") {	
				user.setName(name);
			}
			if(surname != "") {
				user.setSurname(surname);
			}
			em.merge(user);	
			em.merge(credential);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public User getUser(long id) {
		return em.find(User.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return (List<User>) em.createNamedQuery("user.all").getResultList();
	}

	@Override
	public void setRole(long id, Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void banUser(String login) {
		Credential credential = em.find(Credential.class, findUserCredentialId(login));
		
		credential.setBanned(true);
		
		return ;
	}

	@Override
	public void unBanUser(String login) {
		Credential credential = em.find(Credential.class, findUserCredentialId(login));
		
		credential.setBanned(false);
		
		return ;
	}
	
	public long findUserId(String login) {	//Find user id using his login
		List<User> listOfUsers = getAllUsers();
		Iterator<User> it = listOfUsers.iterator();
		while(it.hasNext()) {
			User val = it.next();
			if(val.getName().contentEquals(login)) {
				return val.getId();
			}
		}
		return -1;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Credential> readCredential() {
		return em.createNamedQuery("credential.all").getResultList();	//Zwróæ listê wszystkich u¿ytkowników.
	}
	
	public long findUserCredentialId(String login)
	{
		List<Credential> listOfUsersCredentials = readCredential();
		Iterator<Credential> it = listOfUsersCredentials.iterator();
		while(it.hasNext()) {
			Credential val = it.next();
			if(val.getLogin().contentEquals(login)) {
				return val.getId();
			}
		}
		return -1;
	}
	
	public boolean duplicate(String login) {	//SprawdŸ, czy nie zasz³a próba stworzenia u¿ytkownika, który ju¿ istnieje.
		List<Credential> listOfUsers = readCredential();
		Iterator<Credential> it = listOfUsers.iterator();
		while(it.hasNext()) {
			Credential val = it.next();
			if(val.getLogin().contentEquals(login)) {
				return true;
			}
		}
		return false;
	}

}
