package org.openbravo.nlp.model;

import java.util.List;

public class Participant {

  private String id;
  private String name;
  private int age;
  private String email;
  private String ciudad;
  private List<Activity> activities;

  public Participant(String id, String name, int edad, String email, String ciudad,
      List<Activity> activities) {
    this.id = id;
    this.name = name;
    this.age = edad;
    this.email = email;
    this.ciudad = ciudad;
    this.activities = activities;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  // el email no es obligatorio, puede ser nulo
  public String getEmail() {
    return email;
  }

  public String getCity() {
    return ciudad;
  }

  public List<Activity> getActivities() {
    return activities;
  }

}
