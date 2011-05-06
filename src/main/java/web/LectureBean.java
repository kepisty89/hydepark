package web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import service.LectureInterface;
import domain.Attachment;
import domain.Credential;
import domain.FileType;
import domain.Lecture;
import domain.LectureDetail;
import domain.User;

@RequestScoped
@Named
public class LectureBean {
	
	@Inject
	LectureInterface lectureManager;
	
	private long id;
	private String name;
	private String description;	
	private long teacherId;
	private User teacher;
	private Date startDate = new Date(); //sets the current date - for test purpose	
	private List<Attachment> attachment =
			Arrays.asList(new Attachment()); //sets attachments - fore test purpose;

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}		

	public List<Attachment> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<Attachment> attachment) {
		this.attachment = attachment;
	}
	
	
	//Actions
	public String createLecture() {
		if(name.isEmpty() || description.isEmpty()) {
			return "/panel/error";
		}
		else {
			lectureManager.createLecture(name, description, startDate, teacherId);			
			return "/panel/success";
		}
	}
	
	public String deleteLecture() {
		if(lectureManager.deleteLecture(id)) {
			return "/panel/success";
		}
		else {
			return "/panel/error";
		}
	}
	
	public String deleteLectureDetail() {
		if(lectureManager.deleteLectureDetail(id)) {
			return "/panel/success";
		}
		else {
			return "/panel/error";
		}
	}
	
	public String updateLecture() {
		if(lectureManager.updateLecture(id, name, description)) {
			return "/panel/success";		
		}
		else {
			return "/panel/error";
		}
	}
	
	public String updateLectureDetail() {
		if(lectureManager.updateLectureDetail(id, startDate, teacherId)) {
			return "/panel/success";
		}
		else {
			return "/panel/error";
		}
	}
	
	public String addAttachment(long lectureId, FileType AttachmentType){
		lectureManager.addAttachment(lectureId, name, AttachmentType);
		return "/panel/success";
	}
	
	public List<Lecture> getAllLecture() {
		return lectureManager.getAllLectures();
	}
	
	public List<LectureDetail> getAllLectureDetail() {
		return lectureManager.getAllLecturesDetails();
	}
	
	public List<Credential> getAllTeachersIds() {
		return lectureManager.getAllTeachersIds();
	}
}
