package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.NamedQuery;
import javax.persistence.Id;

@Entity
//@NamedQuery
public class Attachment {
	private long id;
	private String name;
	private FileType type;
	
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
	public FileType getType() {
		return type;
	}
	public void setType(FileType type) {
		this.type = type;
	}
}
