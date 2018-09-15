package org.openbravo.nlp.snippets;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openbravo.nlp.model.Participant;

public class FirstStreamExample {
  public List<String> getNamesOfForeignParticipantsFromYoungToOld(List<Participant> participants) {

    return participants.stream() //
        .filter(FirstStreamExample::isForeignParticipant) //
        .sorted(Comparator.comparing(Participant::getAge)) //
        .map(Participant::getName) //
        .collect(Collectors.toList());

  }

  private static boolean isForeignParticipant(Participant participant) {
    return !"Pamplona".equals(participant.getCity());
  }
}
