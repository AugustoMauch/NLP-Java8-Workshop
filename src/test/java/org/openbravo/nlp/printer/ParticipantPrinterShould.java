package org.openbravo.nlp.printer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;
import org.openbravo.nlp.dataset.NavarraLanPartyStore;
import org.openbravo.nlp.model.Participant;

public class ParticipantPrinterShould extends NavarraLanPartyStore {

  @Test
  public void printParticipantWithEmail() throws IOException {
    Map<String, Participant> participants = getNavarraLanParty().getParticipants();
    Participant participant = participants.get("10");
    ParticipantPrinter printer = new ParticipantPrinter();

    String participantInfo = printer.printParticipantInfo(participant);

    assertEquals("Printed info is not correct",
        "ID: 10\n" + "Name: Augusto Mauch\n" + "Age: 34\n" + "Email: aumago84@gmail.com",
        participantInfo);
  }

  @Test
  public void printParticipantWithoutEmail() throws IOException {
    Map<String, Participant> participants = getNavarraLanParty().getParticipants();
    Participant participant = participants.get("30");
    ParticipantPrinter printer = new ParticipantPrinter();

    String participantInfo = printer.printParticipantInfo(participant);

    assertEquals("Printed info is not correct",
        "ID: 30\n" + "Name: Paul Sheldon\n" + "Age: 56\n" + "", participantInfo);
  }

}
