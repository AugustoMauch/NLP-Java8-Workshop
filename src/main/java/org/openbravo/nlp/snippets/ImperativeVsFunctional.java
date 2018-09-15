package org.openbravo.nlp.snippets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImperativeVsFunctional {

  public static void imperativeVsFunctional() {

    List<String> names = Arrays.asList("Javier", "Amaya", "Oscar", "Antonio", "Carlos", "Alvaro");

    // imperativo
    List<String> namesA = new ArrayList<>();
    for (String name : names) {
      if (name.startsWith("A")) {
        namesA.add(name);
      }
    }
    Collections.sort(namesA);
    for (String nombre : namesA) {
      System.out.println(nombre);
    }
    System.out.println();

    // funcional
    System.out.println("Funcional");
    names.stream() //
        .filter(name -> name.startsWith("A")) //
        .sorted().forEach(name -> System.out.println(name));
  }

  public static void main(String[] args) {
    imperativeVsFunctional();
  }

}
