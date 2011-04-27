package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
//import javax.persistence.NamedQuery;
import javax.persistence.Id;
import domain.User;
import domain.LectureDetail;

@Entity
@NamedQueries({
		@NamedQuery(name = "participant.all", query="SELECT p FROM Participant p GROUP BY p.user"),
		@NamedQuery(name = "participant.byLectureDetail", query="SELECT p FROM Participant p WHERE p.lectureDetail = :LectureDetail"),
		@NamedQuery(name = "participant.byUser", query="SELECT p.lectureDetail FROM Participant p WHERE p.user.id = :uid")})
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
	public Participant(User user, LectureDetail lectureDetail) {
		super();
		this.user = user;
		this.lectureDetail = lectureDetail;
	}
	
	public Participant() {
		super();
	}
}
