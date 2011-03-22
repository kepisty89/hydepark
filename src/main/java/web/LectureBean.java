package web;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import domain.Attachment;
import domain.FileType;
import service.LectureInterface;

@RequestScoped
@Named
public class LectureBean {
	
	@Inject
	LectureInterface lectureManager;
		
	private String name;
	private String description;	
	private long teacherId;
	private Date startDate;	
	private List<Attachment> attachment;
	
		
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
			return "error";
		}
		else {
			lectureManager.createLecture(name, description, startDate, teacherId);			
			return "home";
		}
	}
	
	public String deleteLecture(long id) {
		lectureManager.deleteLecture(id);
		return "home";
	}
	
	public String updateLecture(long id) {
		lectureManager.updateLecture(name, description, startDate, id);		
		return "home";
	}
	
	public String addAttachment(long lectureId, FileType AttachmentType){
		lectureManager.addAttachment(lectureId, name, AttachmentType);
		return "home";
	}
	
	
}
