package org.openbravo.nlp.snippets;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample {

  public static void testParallelStream() {

    List<String> names = Arrays.asList("Javier", "Amaya", "Oscar", "Antonio", "Carlos", "Alvaro");

    names.stream() //
        .map(name -> slowMapping(name)) //
        .collect(Collectors.toList());

  }

  private static String slowMapping(String nombre) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Mapping name " + nombre);
    return nombre.toUpperCase();
  }

  public static void main(String[] args) {
    long tBeginning = System.currentTimeMillis();
    testParallelStream();
    System.out.println("Time elapsed (ms): " + (System.currentTimeMillis() - tBeginning));
  }

}
