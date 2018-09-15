package org.openbravo.nlp.model;

import java.util.Map;

public class NavarraLanParty {

  private Map<String, Participant> participants;
  private Map<String, Activity> activities;

  public NavarraLanParty(Map<String, Participant> participants, Map<String, Activity> activities) {
    this.participants = participants;
    this.activities = activities;
  }

  public Map<String, Participant> getParticipants() {
    return participants;
  }

  public Map<String, Activity> getActivities() {
    return activities;
  }

}
