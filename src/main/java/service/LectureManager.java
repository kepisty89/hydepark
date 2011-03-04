package service;

import java.util.Date;
import java.util.List;

import domain.FileType;
import domain.Lecture;

public class LectureManager implements LectureInterface {

	@Override
	public boolean createLecture(String name, String description, Date date,
			long teacherId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Lecture getLecture(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateLecture(String name, String description, Date date,
			long teacherId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Lecture> getAllLectures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteLecture(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAttachment(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAttachment(String name, FileType type) {
		// TODO Auto-generated method stub
		return false;
	}

}
