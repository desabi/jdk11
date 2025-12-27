package com.desabisc.jdk11.stringmethods;

import lombok.extern.slf4j.Slf4j;

/**
 * The new String methods introduced in Java 11, these methods are:
 * <p>
 * isBlank() lines() strip(), stripLeading(), stripTrailing() repeat(int n)
 */
@Slf4j
public class NewStringMethods {

  public static void main(String[] args) {
    isBlankEg();
    linesEg();
    stripEg();
  }

  /**
   * Use Case: In web applications, you often need to validate user input. If a user submits a form
   * with only whitespace characters, you'd want to consider the input as "blank."
   */
  static void isBlankEg() {
    log.info("*************** isBlank() method **********");
    String userInput1 = "   ";
    String userInput2 = "Java";

    if (userInput1.isBlank()) {
      log.info("User input 1 is blank");
    } else {
      log.info("User input 1 is valid: {}", userInput1);
    }

    if (userInput2.isBlank()) {
      log.info("User input 2 is blank");
    } else {
      log.info("User input 2 is valid");
    }
  }

  /**
   * You might need to process a multi-line string, such as reading the content of a log file or
   * user input from a text area. The lines() method helps convert a multi-line String into a Stream
   * of individual lines for easier processing.
   */
  static void linesEg() {
    log.info("*************** lines() method **********");
    String multiLineText = "Java 11\nintroduced new\nstring methods.";
    log.info("Processing lines:");
    multiLineText.lines().forEach(line -> log.info("> {}", line));
  }

  /**
   * When dealing with data from external sources (such as APIs or files), extra whitespace might be
   * present. strip() (and its variants) help clean up this whitespace. Unlike trim(), which only
   * removes ASCII space (0x20), strip() handles Unicode whitespace characters as well.
   */
  static void stripEg() {
    log.info("*************** strip() method **********");
    String textWithSpaces = "   Hello, Java 11!  ";
    String textWithUnicodeWhitespace = "\u2000Hello, World!\u2000"; // Unicode whitespace

    log.info("Original text: [{}]", textWithSpaces);
    log.info("strip(): [{}]", textWithSpaces.strip());
    log.info("stripLeading(): [{}]", textWithSpaces.stripLeading());
    log.info("stripTrailing(): [{}]", textWithSpaces.stripTrailing());

    log.info("\nOriginal text with Unicode whitespace: [{}]", textWithUnicodeWhitespace);
    log.info("strip(): [{}]", textWithUnicodeWhitespace.strip());
  }

  static void repeatEg() {
    log.info("*************** repeat() method **********");
    String header = "Header";
    String separator = "-".repeat(10); // repeat '_' 10 times

    log.info(separator);
    log.info(header);
    log.info(separator);

    // Example for generating dynamic padding
    String starRating = "*".repeat(5); // 5-star rating
    log.info("Rating: {}", starRating);

  }
}
