package service;

import java.util.List;

import domain.Participant;
import domain.User;

public interface ParticipantInterface {
	void addParticipant(long userId, long lectureId);
	void deleteParticipant(Participant participant);
	List<User> getParticipants(long lectureId);
	List<Participant> getAllParticipants();
	void setLectureRank(int rank);
}
