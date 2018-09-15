package org.openbravo.nlp.model;

public class Activity {

  private String host;
  private String title;
  private int duration;
  private DifficultyDegree difficulty;

  public Activity(String host, String title, int duration, DifficultyDegree difficulty) {
    this.host = host;
    this.title = title;
    this.duration = duration;
    this.difficulty = difficulty;
  }

  public String getHost() {
    return host;
  }

  public String getTitle() {
    return title;
  }

  public Integer getDuration() {
    return duration;
  }

  public DifficultyDegree getDifficulty() {
    return difficulty;
  }

  @Override
  public String toString() {
    return host + ": " + title + ", " + duration + " minutes, difficulty: " + difficulty;
  }

}
