package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import domain.Lecture;

@Entity
@NamedQueries({@NamedQuery(name="lecturedetail.all", query="from LectureDetail order by startDate"),
			   @NamedQuery(name="lectureDetail.byUser", query="from LectureDetail WHERE teacher.id = :uid")})
public class LectureDetail {
	private long id;
	private Date startDate;
	private User teacher;
	private int rate;
	private int limit;
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
	@ManyToOne(fetch=FetchType.EAGER)
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
	@ManyToOne(fetch=FetchType.EAGER)	
	public Lecture getLecture() {
		return lecture;
	}
	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public LectureDetail() {
		super();
	}
	public LectureDetail(Date startDate, User teacher, Lecture lecture) {
		super();
		this.startDate = startDate;
		this.teacher = teacher;
		this.lecture = lecture;
		this.rate = 1;
		this.limit = 50;
	}
	
	
}
