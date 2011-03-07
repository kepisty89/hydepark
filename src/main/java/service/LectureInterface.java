package service;

import java.util.Date;
import java.util.List;
import domain.FileType;
import domain.Lecture;

public interface LectureInterface {
	boolean createLecture(String name, String description, Date date, long teacherId);
	Lecture getLecture(long id);
	boolean updateLecture(String name, String description, Date date, long teacherId);
	List<Lecture> getAllLectures();
	boolean deleteLecture(long id);
	boolean deleteAttachment(long lectureId, long id);
	boolean addAttachment(long lectureId, String name, FileType type);
}
