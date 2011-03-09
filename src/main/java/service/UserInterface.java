package service;

import java.util.List;
import domain.Role;
import domain.User;

public interface UserInterface {
	public boolean createUser(String login, String password, String name, String surname);
	public User getUser(long id);
	public List<User> getAllUsers();
	public boolean deleteUser(String login);
	public boolean updateUser(String login, String password, String name, String surname);
	public void setRole(long id, Role role);
	public void banUser(String login);
	public void unBanUser(String login);
}
