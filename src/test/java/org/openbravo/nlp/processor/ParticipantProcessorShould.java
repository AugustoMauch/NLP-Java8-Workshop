package org.openbravo.nlp.processor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openbravo.nlp.dataset.NavarraLanPartyStore;
import org.openbravo.nlp.model.Participant;
import org.openbravo.nlp.snippets.FirstStreamExample;

public class ParticipantProcessorShould extends NavarraLanPartyStore {

  @Test
  public void printNamesOfForeignParticipants() throws IOException {
    List<Participant> participants = new ArrayList<Participant>(
        getNavarraLanParty().getParticipants().values());
    FirstStreamExample processor = new FirstStreamExample();

    List<String> names = processor.getNamesOfForeignParticipantsFromYoungToOld(participants);

    assertEquals("There should be two foreign participants", 2, names.size());
    assertEquals("Youngest one should be Kaladin", "Kaladin Stormblessed", names.get(0));
    assertEquals("Oldest one should be Augusto", "Augusto Mauch", names.get(1));

  }
}
