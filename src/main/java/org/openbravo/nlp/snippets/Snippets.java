package org.openbravo.nlp.snippets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.openbravo.nlp.model.Activity;
import org.openbravo.nlp.model.DifficultyDegree;
import org.openbravo.nlp.model.Participant;

/**
 * Hello world!
 *
 */
public class Snippets {

  @SuppressWarnings("unused")
  public static void main(String[] args) {

    Function<Activity, DifficultyDegree> getDifficulty = (Activity activity) -> activity
        .getDifficulty();

    BiFunction<Participant, Activity, Boolean> hasJoinedActivity = (participant,
        activity) -> participant.getActivities().contains(activity);

    Supplier<Participant> participantRandomizer = () -> getRandomParticipant();

    Consumer<Participant> participantPrinter = participant -> {
      System.out.println("Name: " + participant.getName());
      System.out.println("Age: " + participant.getAge());
      System.out.println("Email: " + participant.getEmail());
    };

    participantRandomizer.getClass();

    List<Activity> activities = new ArrayList<>();
    List<Participant> participants = new ArrayList<>();

    Optional<Activity> anyHardActivity = activities.stream() //
        .filter(activity -> DifficultyDegree.HARD.equals(activity)) //
        .findFirst();

    boolean anyShortActivity = activities.stream()
        .anyMatch(activity -> activity.getDuration() < 60);

    boolean allParticipantsFromPamplona = participants.stream()
        .allMatch(participant -> participant.getCity().equals("Pamplona"));

    participants.stream() //
        .filter(participant -> participant.getActivities().isEmpty()) //
        .forEach(participant -> sendReminderEmail(participant));

    List<String> cities = participants.stream() //
        .map(Participant::getCity) //
        .distinct() //
        .collect(Collectors.toList());

    Map<String, List<Participant>> groupedByCity = participants.stream()
        .collect(Collectors.groupingBy(Participant::getCity));

  }

  private static Object sendReminderEmail(Participant participant) {
    // TODO Auto-generated method stub
    return null;
  }

  private static Participant getRandomParticipant() {
    return null;
  }

}
