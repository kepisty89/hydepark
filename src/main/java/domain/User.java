package domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="user.all", query="from User")
public class User {
	private long id;
	private String name;
	private String surname;
	private Credential credential;
	private List<Participant> participant;
	private Role role;
	
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
	@OneToOne//Not sure about this "mapped by", "fetch", "cascade" thing. [Daniel]
	public Credential getCredential() {
		return credential;
	}
	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	@OneToMany//Not sure about this "mapped by", "fetch", "cascade" thing. [Daniel]
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
