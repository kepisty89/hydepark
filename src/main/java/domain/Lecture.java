package domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="lecture.all", query="from Lecture")
public class Lecture {
	private long id;
	private String name;
	private String description;	
	private List<LectureDetail> lectureDetail;	
	private List<Attachment> attachment;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@OneToMany//Not sure about this "mapped by", "fetch", "cascade" thing. [Daniel] 
	public List<LectureDetail> getLectureDetail() {
		return lectureDetail;
	}
	public void setLectureDetail(List<LectureDetail> lectureDetail) {
		this.lectureDetail = lectureDetail;
	}
	@OneToMany//Not sure about this "mapped by", "fetch", "cascade" thing. [Daniel]
	public List<Attachment> getAttachment() {
		return attachment;
	}
	public void setAttachment(List<Attachment> attachment) {
		this.attachment = attachment;
	}
	public Lecture(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Lecture() {
		super();
	}
}
