package org.openbravo.nlp.finder;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openbravo.nlp.dataset.NavarraLanPartyStore;
import org.openbravo.nlp.model.Activity;
import org.openbravo.nlp.model.NavarraLanParty;

public class ActivityFinderShould extends NavarraLanPartyStore {

  @Test
  public void getTop3HardActivities() throws IOException {
    NavarraLanParty nlp = getNavarraLanParty();
    List<Activity> activities = new ArrayList<Activity>(nlp.getActivities().values());
    ActivityFinder activityFinder = new ActivityFinder();

    List<String> top3HardActivitiesNames = activityFinder
        .getTop3HardActivitiesFromLongToShort(activities);

    assertEquals("3 activities should be returned", 3, top3HardActivitiesNames.size());
    assertEquals("Activity Name", "Desarrollo de videojuegos", top3HardActivitiesNames.get(0));
    assertEquals("Activity Name", "Un dron, Navarbot y hazlo", top3HardActivitiesNames.get(1));
    assertEquals("Activity Name", "Monitorización en casa y en la empresa",
        top3HardActivitiesNames.get(2));
  }

}
