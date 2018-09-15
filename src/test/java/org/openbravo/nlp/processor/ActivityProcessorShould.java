package org.openbravo.nlp.processor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openbravo.nlp.dataset.NavarraLanPartyStore;
import org.openbravo.nlp.model.Activity;

public class ActivityProcessorShould extends NavarraLanPartyStore {

  @Test
  public void sumDurationOfAllActivities() throws IOException {
    List<Activity> activities = new ArrayList<Activity>(
        getNavarraLanParty().getActivities().values());
    ActivityProcessor processor = new ActivityProcessor();

    int duration = processor.getDurationOfActivities(activities);

    assertEquals("Total duration should be ", 780, duration);

  }

}
