package service;

public interface LoginInterface {
	public boolean login(long id, String password);
	public String convertIdToLogin(long id);
}
