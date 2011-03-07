package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.LectureDetail;
import domain.Participant;
import domain.User;

public class ParticipantManager implements ParticipantInterface {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void addParticipant(User user, LectureDetail lecDet) {
		Participant p = new Participant(user, lecDet);
		em.persist(p);
	}

	@Override
	public void deleteParticipant(Participant participant) {
		em.remove(em.find(Participant.class, participant.getId()));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getParticipants(LectureDetail lecDet) {
		return em.createNamedQuery("participant.byLectureDetail").setParameter("LectureDetail", lecDet).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Participant> getAllParticipants() {
		return em.createNamedQuery("participant.all").getResultList();
	}

	@Override
	public void setLectureRank(int rank) {
		// TODO Auto-generated method stub
		
	}

}
