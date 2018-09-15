package org.openbravo.nlp.snippets;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LazyEvaluation {

  public static void lazyTest() {

    List<String> names = Arrays.asList("Javier", "Amaya", "Oscar", "Antonio", "Carlos", "Alvaro");

    List<String> someNames = names.stream() //
        .map(nombre -> nombre.toUpperCase()) //
        .limit(2) //
        .collect(Collectors.toList());

    // Mapping Javier, Mapping Amaya

    someNames.toString();

  }

  public static void main(String[] args) {
    lazyTest();
  }

}