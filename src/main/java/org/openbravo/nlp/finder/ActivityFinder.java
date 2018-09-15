package org.openbravo.nlp.finder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openbravo.nlp.model.Activity;
import org.openbravo.nlp.model.DifficultyDegree;

public class ActivityFinder {

  /**
   * Data una lista de actividades: Quedarse con las difíciles, Ordenarlas por duración de mayor a
   * menor, Devolver una lista con los 3 primeros nombres
   */
  public List<String> getTop3HardActivitiesFromLongToShort(List<Activity> activities) {

    List<Activity> hardActivities = new ArrayList<>();
    for (Activity activity : activities) {
      if (DifficultyDegree.HARD.equals(activity.getDifficulty())) {
        hardActivities.add(activity);
      }
    }

    Collections.sort(hardActivities, new Comparator<Activity>() {
      @Override
      public int compare(Activity a1, Activity a2) {
        return a2.getDuration().compareTo(a1.getDuration());
      }
    });

    List<String> names = new ArrayList<>();
    for (Activity activity : hardActivities) {
      names.add(activity.getTitle());
      if (names.size() == 3) {
        break;
      }
    }

    return names;
  }

}
