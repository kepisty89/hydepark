package web;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import service.LectureInterface;
import domain.Lecture;
import domain.LectureDetail;
import domain.User;

@ViewScoped
@Named
public class LectureDetailBean {
	private long id;
	private Date startDate;
	private User teacher;
	private int rate;
	private Lecture lecture;
	private int limit;
	
	private LectureDetail lectureDetail;
	private List<LectureDetail> allLectureDetails;
	private List<LectureDetail> userLectureDetails;
	private LectureDetail selectedLecture;
	private List<LectureDetail> userParticipates;
	
	public List<LectureDetail> getUserParticipates() {
		userParticipates = Ilecture.getUserLectures(LoginBean.getCurrentUID());
		return userParticipates;
	}

	public void setUserParticipates(List<LectureDetail> userParticipates) {
		this.userParticipates = userParticipates;
	}

	@Inject
	private LectureInterface Ilecture;
	
	public int sort(Object obj1, Object obj2) {
	    String s1 = (String) obj1;
	    String s2 = (String) obj2;
	    
	    return s1.compareTo(s2);
	}

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

	public LectureDetail getLectureDetail() {
		return lectureDetail;
	}

	public void setLectureDetail(LectureDetail lectureDetail) {
		this.lectureDetail = lectureDetail;
	}

	public List<LectureDetail> getAllLectureDetails() {
		allLectureDetails = Ilecture.getAllLecturesDetails();
		return allLectureDetails;
	}

	public void setAllLectureDetails(List<LectureDetail> allLectureDetails) {
		this.allLectureDetails = allLectureDetails;
	}

	public LectureDetail getSelectedLecture() {
		return selectedLecture;
	}

	public void setSelectedLecture(LectureDetail selectedLecture) {
		this.selectedLecture = selectedLecture;
	}

	public List<LectureDetail> getUserLectureDetails() {
		userLectureDetails = Ilecture.userLectureDetails(LoginBean.getCurrentUID());
		return userLectureDetails;
	}

	public void setUserLectureDetails(List<LectureDetail> userLectureDetails) {
		this.userLectureDetails = userLectureDetails;
	}
	
}
