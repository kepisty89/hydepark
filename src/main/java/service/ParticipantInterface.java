package service;

import java.util.List;

import domain.LectureDetail;
import domain.Participant;
import domain.User;

public interface ParticipantInterface {
	void addParticipant(User user, LectureDetail lecDet);
	void deleteParticipant(Participant participant);
	List<User> getParticipants(LectureDetail lecDet);
	List<Participant> getAllParticipants();
	void setLectureRank(int rank);
}
