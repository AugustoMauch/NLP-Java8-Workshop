package org.openbravo.nlp.processor;

import java.util.List;

import org.openbravo.nlp.model.Activity;

public class ActivityProcessor {

  public int getDurationOfActivities(List<Activity> activities) {
    int suma = 0;
    for (Activity activity : activities) {
      suma += activity.getDuration();
    }
    return suma;
  }

}
