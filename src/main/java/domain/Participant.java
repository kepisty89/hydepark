package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.NamedQuery;
import javax.persistence.Id;

@Entity
//@NamedQuery(name="user.all", query="from User")
public class Participant {
	private long id;
	private long userId;
	private long lectureId;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getLectureId() {
		return lectureId;
	}
	public void setLectureId(long lectureId) {
		this.lectureId = lectureId;
	}
}
