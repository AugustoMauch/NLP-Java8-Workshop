package org.openbravo.nlp.printer;

import org.openbravo.nlp.model.Participant;

public class ParticipantPrinter {

  public String printParticipantInfo(Participant participant) {
    StringBuilder builder = new StringBuilder();

    builder.append("ID: " + participant.getId() + "\n");
    builder.append("Name: " + participant.getName() + "\n");
    builder.append("Age: " + participant.getAge() + "\n");
    if (participant.getEmail() != null) {
      builder.append("Email: " + participant.getEmail().toLowerCase());
    }

    return builder.toString();
  }

}
