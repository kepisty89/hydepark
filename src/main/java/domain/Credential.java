package domain;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToOne;

@Entity
//@NamedQuery(name="user.all", query="from User")
public class Credential {
	private long id;	//Id Usera. (Takie samo jak w tabeli User.)
	private String login;	//Login.
	private String password;	//Haslo.
	private Role role;	//Rola uzytkownika.
	private int rank;	//Ocena uzytkownika. (Tylko nauczyciele.)
	private boolean isBanned;	//Czy uzytkownik jest zbanowany?
	//private User user;	//Jaki to uzytkownik?
	
	@Id
	@GeneratedValue
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public boolean isBanned() {
		return isBanned;
	}
	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}
//	@OneToOne//(fetch=FetchType.LAZY)
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}	
}
