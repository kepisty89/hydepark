package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.NamedQuery;
import domain.Lecture;

@Entity
public class LectureDetail {
	private long id;
	private Date startDate;
	private User teacher;
	private int rate;
	private Lecture lecture;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@ManyToOne
	public User getTeacher() {
		return teacher;
	}
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@ManyToOne//Not sure about this "mapped by", "fetch", "cascade" thing. [Daniel]
	public Lecture getLecture() {
		return lecture;
	}
	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	
	public LectureDetail() {
		super();
	}
	public LectureDetail(Date startDate, User teacher, Lecture lecture) {
		super();
		this.startDate = startDate;
		this.teacher = teacher;
		this.lecture = lecture;
	}
	
	
}