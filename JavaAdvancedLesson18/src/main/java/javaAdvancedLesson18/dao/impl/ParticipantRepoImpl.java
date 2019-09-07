package javaAdvancedLesson18.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import javaAdvancedLesson18.dao.ParticipantRepo;
import javaAdvancedLesson18.domain.Level;
import javaAdvancedLesson18.domain.Participant;

@Repository
public class ParticipantRepoImpl implements ParticipantRepo {

	private List<Participant> participants = new ArrayList<>();

	@PostConstruct
	public void init() {
		Participant participant1 = new Participant();
		participant1.setId(1);
		participant1.setName("participant1");
		participant1.setEmail("participant1@gmail.com");
		participant1.setLevel(Level.L1);
		participant1.setPrimarySkill("participant1 skill");

		Participant participant2 = new Participant();
		participant2.setId(2);
		participant2.setName("participant2");
		participant2.setEmail("participant2@gmail.com");
		participant2.setLevel(Level.L2);
		participant2.setPrimarySkill("participant2 skill");

		Participant participant3 = new Participant();
		participant3.setId(3);
		participant3.setName("participant3");
		participant3.setEmail("participant3@gmail.com");
		participant3.setLevel(Level.L3);
		participant3.setPrimarySkill("participant3 skill");

		participants.add(participant1);
		participants.add(participant2);
		participants.add(participant3);
	}

	@Override
	public void create(Participant participant) {
		if (participant.getId() == null)
			participant.setId(participants.size() + 1);
		participants.add(participant);
	}

	@Override
	public Participant readById(Integer id) {
		return participants.stream().filter(participant -> participant.getId() == id).findAny().orElse(null);
	}

	@Override
	public void update(Participant participant) {
		Participant participantFromList = participants.stream().filter(x -> x.getId() == participant.getId()).findAny()
				.get();
		participants.set(participants.indexOf(participantFromList), participant);
	}

	@Override
	public void delete(Integer id) {
		participants.remove(participants.stream().filter(x -> x.getId() == id).findFirst().get());
		for (int i = 0; i < participants.size(); i++)
			participants.get(i).setId(i + 1);
	}

	@Override
	public List<Participant> readAll() {
		return participants;
	}
}
