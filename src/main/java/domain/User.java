package domain;

import java.util.List;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="user.all", query="from User")
public class User {
	//Pola w bazie danych.
	private long id;	//Id Usera.
	private String name;	//Imie.
	private String surname;	//Nazwisko.
	private Credential credential;	//Obiekt z tabeli Credential zawierajacy login, haslo, etc.
	private List<Participant> participant;	//Lista obiektow z tabeli Participant, zawierajaca spis wykladow, na ktore uzytkownik jest zapisany.
	private Role role;	//Rola uzytkownika.
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@OneToOne//(mappedBy="user", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	public Credential getCredential() {
		return credential;
	}
	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	@OneToMany//(mappedBy="user", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	public List<Participant> getParticipant() {
		return participant;
	}
	public void setParticipant(List<Participant> participant) {
		this.participant = participant;
	}
	@Enumerated
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
