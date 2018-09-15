package org.openbravo.nlp.finder;

import java.util.ArrayList;
import java.util.List;

import org.openbravo.nlp.model.Participant;

public class ParticipantFinder {

  public List<Participant> getYoungerThan18(List<Participant> participants) {
    List<Participant> minors = new ArrayList<>();
    for (Participant participant : participants) {
      if (participant.getAge() < 18) {
        minors.add(participant);
      }
    }
    return minors;
  }

  public List<Participant> getParticipantsWithNoActivities(List<Participant> participants) {
    List<Participant> inactiveParticipants = new ArrayList<>();
    for (Participant participant : participants) {
      if (participant.getActivities().isEmpty()) {
        inactiveParticipants.add(participant);
      }
    }
    return inactiveParticipants;
  }
}
