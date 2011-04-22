package service;

import java.util.Date;
import java.util.List;
import domain.FileType;
import domain.Lecture;
import domain.LectureDetail;

public interface LectureInterface {
	boolean createLecture(String name, String description, Date date, long teacherId);
	Lecture getLecture(long id);
	LectureDetail getLectureDetail(long id);
	boolean updateLecture(String name, String description, Date date, long teacherId);
	List<Lecture> getAllLectures();
	List<LectureDetail> getAllLecturesDetails();
	boolean deleteLecture(long id);
	boolean deleteLectureDetail(long id);
	boolean deleteAttachment(long lectureId, long id);
	boolean addAttachment(long lectureId, String name, FileType type);
}
