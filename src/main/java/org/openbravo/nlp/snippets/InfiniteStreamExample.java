package org.openbravo.nlp.snippets;

import java.util.stream.Stream;

public class InfiniteStreamExample {

  public static void main(String[] args) {

    Stream<Integer> allNumbers = Stream.iterate(0, n -> n + 1);
    allNumbers.filter(number -> number % 2 == 1) //
        .limit(5) //
        .forEach(System.out::println);

    // 1 3 5 7 9

  }
}
