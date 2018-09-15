package org.openbravo.nlp.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openbravo.nlp.model.Activity;
import org.openbravo.nlp.model.DifficultyDegree;
import org.openbravo.nlp.model.NavarraLanParty;
import org.openbravo.nlp.model.Participant;

public class DataLoader {

  private final static String NLP_DATASET_PATH = "/home/openbravo/workspaces/eclipse/nlp-workshop/nlp-java8-workshop/src/test/resources/nlp_data.json";

  public NavarraLanParty loadNavarraLanParty() throws IOException {
    String content = new String(Files.readAllBytes(Paths.get(NLP_DATASET_PATH)));
    JSONObject json = new JSONObject(content);
    Map<String, Activity> activityMap = readActivities(json.getJSONArray("activities"));
    Map<String, Participant> participants = readParticipants(json.getJSONArray("participants"),
        activityMap);
    return new NavarraLanParty(participants, activityMap);
  }

  private Map<String, Activity> readActivities(JSONArray array) {
    return StreamSupport.stream(array.spliterator(), false) //
        .map(json -> jsonToActivity((JSONObject) json)) //
        .collect(Collectors.toMap(activity -> activity.getTitle(), activity -> activity));
  }

  private Map<String, Participant> readParticipants(JSONArray array,
      Map<String, Activity> activityMap) {
    return StreamSupport.stream(array.spliterator(), false) //
        .map(json -> jsonToParticipant((JSONObject) json, activityMap)) //
        .collect(Collectors.toMap(participant -> participant.getId(), participant -> participant));
  }

  private Activity jsonToActivity(JSONObject json) {
    return new Activity(json.getString("host"), //
        json.getString("title"), //
        json.getInt("duration"), //
        DifficultyDegree.valueOf(json.getString("difficulty").toUpperCase()));
  }

  private Participant jsonToParticipant(JSONObject json, Map<String, Activity> activityMap) {
    JSONArray array = json.getJSONArray("activities");

    List<Activity> activities = StreamSupport.stream(array.spliterator(), false) //
        .map(activityMap::get).collect(Collectors.toList());

    String email = json.has("email") ? json.getString("email") : null;

    return new Participant(json.getString("id"), //
        json.getString("name"), //
        json.getInt("age"), //
        email, //
        json.getString("city"), //
        activities);
  }
}
