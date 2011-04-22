package service;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import domain.Attachment;
import domain.FileType;
import domain.Lecture;
import domain.LectureDetail;
import domain.User;

@Stateless
public class LectureManager implements LectureInterface {
	
	@PersistenceContext
	EntityManager em;

	/* Interface methods */	
	@Override
	public boolean createLecture(String name, String description, Date startDate,
			long teacherId) {
		
		//create new LECTURE object depending on data
		Lecture lecture = new Lecture(name, description);

		//find teacher by id
		User teacher = (User) em.createQuery(
				"from User where id=?1"
				)
				.setParameter(1, teacherId)
				.getSingleResult();
						
		//we should first add lecture to DB without detail	
		em.persist(lecture);
		
		Lecture savedLecture = em.find(Lecture.class, lecture.getId());
				
		//create new LECTUREDETAIL object depending on saved lecture
		LectureDetail lectureDetail = new LectureDetail(startDate, teacher, savedLecture);		
		em.persist(lectureDetail);		
		
		//add lectureDetail to lecture
		savedLecture.getLectureDetail().add(lectureDetail);
		//set lectureDetail
		savedLecture.setLectureDetail(savedLecture.getLectureDetail());
		
		em.merge(savedLecture);			
		
		return false;
	}

	@Override
	public Lecture getLecture(long id) {		
		Lecture lecture = em.find(Lecture.class, id); 
		return lecture;
	}
	
	@Override
	public LectureDetail getLectureDetail(long id) {
		LectureDetail lectureDetail = em.find(LectureDetail.class, id);
		return lectureDetail;
	}

	@Override
	public boolean updateLecture(String name, String description, Date startDate,
			long teacherId) {
		// TODO [Daniel]
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Lecture> getAllLectures() {
		//LectureDetails will change, but Lectures wont,
		//so we get Lectures instead of LectureDetails		
		return em.createNamedQuery("lecture.all").getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<LectureDetail> getAllLecturesDetails() {
		return em.createNamedQuery("lecturedetail.all").getResultList();
	}

	@Override
	public boolean deleteLecture(long id) {
		if(id == 0) {
			return false;
		}
		Lecture lectureToDelete = getLecture(id);
		em.remove(lectureToDelete);
		return true;
	}
	
	@Override
	public boolean deleteLectureDetail(long id) {
		if(id == 0) {
			return false;
		}
		LectureDetail lectureDetailToDelete = getLectureDetail(id);
		em.remove(lectureDetailToDelete);
		return true;
	}

	@Override
	public boolean deleteAttachment(long lectureId, long id) {		
		Attachment attachment = em.find(Attachment.class, id);		
		em.remove(attachment);					
		
		return true;
	}

	@Override
	public boolean addAttachment(long lectureId, String name, FileType type) {
		Lecture lecture = em.find(Lecture.class, lectureId);
		
		//create new attachment from data
		Attachment attachment = new Attachment();
		//TODO: will attachment id be set automatically? 
		attachment.setName(name);
		attachment.setType(type);
		
		//get actual attachment list and add new attachment
		List<Attachment> attachmentList = lecture.getAttachment();
		attachmentList.add(attachment);
		
		lecture.setAttachment(attachmentList);
		
		//add attachments to lecture
		em.merge(lecture);
				
		return true;
	}
		
	/* Additional methods */	
	public int getLectureDetailRank(long detailId){
		LectureDetail lectureDetail = em.find(LectureDetail.class, detailId);		
		return lectureDetail.getRate();
	}	
	
	public void setLectureDetailRank(long detailId, int rate){
		LectureDetail lectureDetail = em.find(LectureDetail.class, detailId);		
		lectureDetail.setRate(rate);		
		em.merge(lectureDetail);			
	}
	
	@SuppressWarnings("unchecked")
	public List<Lecture> readLectures() {
		return em.createNamedQuery("lecture.all").getResultList();	//Zwróæ listê wszystkich u¿ytkowników.
	}
		

}
