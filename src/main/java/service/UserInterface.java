package service;

import java.util.List;

import domain.Credential;
import domain.User;

public interface UserInterface {
	public boolean createUser(String login, String password, String name, String surname);
	public User getUser(long id);
	public List<User> getAllUsers();
	public boolean deleteUser(String login, String password);
	public boolean updateUser(String login, String password, String newPassword, String name, String surname);
	public boolean banUser(String login);
	public boolean unBanUser(String login);
	public boolean duplicate(String name);
	public List<Credential> readCredential();
	public boolean setRole(String login, String password, String role);
}
