package service;

import domain.Role;

public interface LoginInterface {
	public boolean login(long id, String password);
	public String convertIdToLogin(long id);
	public Role convertIdToRole(long id);
}
