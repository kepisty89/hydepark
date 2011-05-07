package service;

import java.util.Date;
import java.util.List;

import domain.Credential;
import domain.FileType;
import domain.Lecture;
import domain.LectureDetail;

public interface LectureInterface {
	boolean createLecture(String name, String description, Date date, long teacherId, int limit);
	Lecture getLecture(long id);
	LectureDetail getLectureDetail(long id);
	boolean updateLecture(long lectureId, String name, String description);
	boolean updateLectureDetail(long lectureId, Date startDate, long teacherId);
	List<Lecture> getAllLectures();
	List<LectureDetail> getAllLecturesDetails();
	List<Credential> getAllTeachersCredentials();
	boolean deleteLecture(long id);
	boolean deleteLectureDetail(long id);
	boolean deleteAttachment(long lectureId, long id);
	boolean addAttachment(long lectureId, String name, FileType type);
	public List<LectureDetail> userLectureDetails(long uid);
	public List<LectureDetail> getUserLectures(long uid);
}
