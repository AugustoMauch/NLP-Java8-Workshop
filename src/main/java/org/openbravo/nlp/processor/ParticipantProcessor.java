package org.openbravo.nlp.processor;

import java.util.List;

import org.openbravo.nlp.model.Participant;

public class ParticipantProcessor {

  public void showParticipantNamesInScreen(List<Participant> participants) {
    doGenericActionOnParticipants(participants, new ParticipantAction() {
      @Override
      public void doAction(Participant participant) {
        showInScreen(participant);
      }
    });
  }

  public void sendEmailToParticipants(List<Participant> participants) {
    doGenericActionOnParticipants(participants, new ParticipantAction() {
      @Override
      public void doAction(Participant participant) {
        sendWelcomeEmail(participant);
      }
    });
  }

  public void doGenericActionOnParticipants(List<Participant> participants,
      ParticipantAction action) {
    for (Participant participant : participants) {
      action.doAction(participant);
    }
  }

  private interface ParticipantAction {
    public void doAction(Participant p);
  }

  private static void showInScreen(Participant participant) {
    // shows info about a participant in the main screen
  }

  private static void sendWelcomeEmail(Participant participant) {
    // sends a welcome email to a participant
  }

}
