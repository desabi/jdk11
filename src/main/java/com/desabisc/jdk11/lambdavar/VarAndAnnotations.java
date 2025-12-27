package com.desabisc.jdk11.lambdavar;

import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VarAndAnnotations {

  public static void main(String[] args) {
    annotationEg();
    varEg();
    streamVarEg();
    parallelProcessingEg();
  }

  /**
   * You may want to add annotations to lambda parameters, such as marking a parameter as @NonNull
   * for validation purposes. This is useful in frameworks that require strict validation of
   * inputs.
   */
  static void annotationEg() {
    log.info("********** annotation eg **********");
    List<String> names = List.of("Alibe", "Bob", "Charlie");

    // Using var to add an annotation in the lambda expression
    // The var keyword is necessary here because it allows you to add the annotation while still
    // using type inference.
    names.forEach((@NonNull var name) -> {
      log.info("Name: {}", name);
    });
  }

  // Custom @NonNull annotation for illustration
  @interface NonNull {

  }

  /**
   * Imagine you're processing a list of Map.Entry objects. You want to infer the types of the
   * lambda parameters without explicitly stating them.
   */
  static void varEg() {
    log.info("********** var eg **********");
    Map<Integer, String> users = Map.of(1, "Alice", 2, "Bob", 3, "Charlie");

    // Using var in lambda to infer parameter types
    // var is used to infer the types of id (which is an Integer) and name (which is a String)
    // in the lambda expression.
    // This eliminates the need to write the types explicitly ((Integer id, String name)),
    // keeping the code concise and readable.
    users.forEach((var id, var name) -> {
      log.info("User ID: {}, Name: {}", id, name);
    });
  }

  /**
   * Use Case: You might be working with a collection of data and want to process it using Stream
   * and var for parameter type inference.
   */
  static void streamVarEg() {
    log.info("********** stream eg **********");
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);

    // Using var in lambda expression for type inference
    numbers.stream()
        .map((var currentNumber) -> currentNumber * 2) // doubles each number
        .forEach((var result) -> log.info("Result: {}", result));
  }

  /**
   * Use Case: Suppose you are processing data in parallel using the parallelStream() method and
   * want to keep the lambda expression clean and concise using var.
   */
  static void parallelProcessingEg() {
    log.info("********** parallel processing eg **********");
    List<String> fruits = List.of("apple", "banana", "cherry", "date", "elderberry");

    // Using var with parallel stream processing
    //
    fruits.parallelStream()
        .filter((var currentFruit) -> currentFruit.length() > 5)
        .forEach((var filteredFruit) -> log.info("Filtered fruit: {}", filteredFruit));
  }
}
