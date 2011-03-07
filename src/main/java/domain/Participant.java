package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
//import javax.persistence.NamedQuery;
import javax.persistence.Id;
import domain.User;
import domain.LectureDetail;

@Entity
public class Participant {
	private long id;
	private User user;
	private LectureDetail lectureDetail;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@ManyToOne//Not sure about this "mapped by", "fetch", "cascade" thing. [Daniel]
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne//Not sure about this "mapped by", "fetch", "cascade" thing. [Daniel]
	public LectureDetail getLectureDetail() {
		return lectureDetail;
	}
	public void setLectureDetail(LectureDetail lectureDetail) {
		this.lectureDetail = lectureDetail;
	}
}
