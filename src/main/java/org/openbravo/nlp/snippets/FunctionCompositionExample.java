package org.openbravo.nlp.snippets;

import java.util.List;
import java.util.function.Function;

import org.openbravo.nlp.model.Activity;
import org.openbravo.nlp.model.Participant;

public class FunctionCompositionExample {

  private Function<Participant, List<Activity>> getActivitiesFunction = participant -> participant
      .getActivities();

  private Function<List<Activity>, String> stringifyActivitiesFunction = activities -> {
    StringBuilder printableActivities = new StringBuilder();
    for (Activity activity : activities) {
      printableActivities.append(activity.toString());
      printableActivities.append("\n");
    }
    return printableActivities.toString();
  };

  public List<Activity> getActivities(Participant participant) {
    return getActivitiesFunction.apply(participant);
  }

  public String printActivities(List<Activity> activities) {
    return stringifyActivitiesFunction.apply(activities);
  }

}
