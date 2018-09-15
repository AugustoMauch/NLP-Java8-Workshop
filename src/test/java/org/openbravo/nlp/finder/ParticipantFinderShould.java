package org.openbravo.nlp.finder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openbravo.nlp.dataset.NavarraLanPartyStore;
import org.openbravo.nlp.model.NavarraLanParty;
import org.openbravo.nlp.model.Participant;

public class ParticipantFinderShould extends NavarraLanPartyStore {

  @Test
  public void getMinorParticipants() throws IOException {
    NavarraLanParty nlp = getNavarraLanParty();
    List<Participant> participants = new ArrayList<Participant>(nlp.getParticipants().values());
    ParticipantFinder participantFinder = new ParticipantFinder();

    List<Participant> youngerThan18 = participantFinder.getYoungerThan18(participants);

    assertTrue("There should be one minor", youngerThan18.size() == 1);
    assertEquals("His name is Alcestes", youngerThan18.get(0).getName(), "Alcestes");
  }

  @Test
  public void getInactiveParticipants() throws IOException {
    NavarraLanParty nlp = getNavarraLanParty();
    List<Participant> participants = new ArrayList<Participant>(nlp.getParticipants().values());
    ParticipantFinder participantFinder = new ParticipantFinder();

    List<Participant> inactiveParticipants = participantFinder
        .getParticipantsWithNoActivities(participants);

    assertEquals("There should be two inactive participant", 2, inactiveParticipants.size());
  }

}
