package org.openbravo.nlp.processor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.openbravo.nlp.dataset.NavarraLanPartyStore;
import org.openbravo.nlp.model.Activity;
import org.openbravo.nlp.model.Participant;
import org.openbravo.nlp.snippets.FunctionCompositionExample;

public class FunctionCompositionShould extends NavarraLanPartyStore {

  @Test
  public void getActivitiesOfParticipant() throws IOException {
    Map<String, Participant> participants = getNavarraLanParty().getParticipants();
    Participant participant = participants.get("10");
    FunctionCompositionExample processor = new FunctionCompositionExample();

    List<Activity> activities = processor.getActivities(participant);

    assertEquals("Participant should have one activity", 1, activities.size());
    assertEquals("Its activity should be Java 8", "Introducción a Java 8",
        activities.get(0).getTitle());
  }

  @Test
  public void printActivities() throws IOException {
    List<Activity> activities = new ArrayList<Activity>(
        getNavarraLanParty().getActivities().values());
    FunctionCompositionExample processor = new FunctionCompositionExample();

    String stringifiedActivities = processor.printActivities(activities);

    assertEquals("Activities not properly stringified",
        "Mikel Izal: ¿Dónde están mis Bitcoins?, 60 minutes, difficulty: HARD\n"
            + "Pablo Alonso Lorente: Welcome to the Circus!, 45 minutes, difficulty: MEDIUM\n"
            + "Andriy Brukhovetskyy: Herramientas open source en la lucha contra el malware, 45 minutes, difficulty: EASY\n"
            + "Augusto Mauch: Introducción a Java 8, 120 minutes, difficulty: MEDIUM\n"
            + "Jose Javier Ripa: Monitorización en casa y en la empresa, 105 minutes, difficulty: HARD\n"
            + "Alvaro Buldain: Un dron, Navarbot y hazlo, 120 minutes, difficulty: HARD\n"
            + "Chema Alonso: Tus datos mueven el mundo... y tú sin saberlo, 45 minutes, difficulty: MEDIUM\n"
            + "Iñaki Ayucar: Desarrollo de videojuegos, 240 minutes, difficulty: HARD\n",
        stringifiedActivities);
  }
}
