package com.desabisc.jdk11.files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;

/**
 * Java 11 introduced new methods to make file reading and writing simpler. Now you can directly
 * read and write to files with String content using Files.readString() and Files.writeString().
 */
@Slf4j
public class ReadWriteString {
  public static void main(String[] args) {
    readStringEg();
    writeStringEg();
  }

  //@SneakyThrows
  static void readStringEg() {
    log.info("********** readString() eg **********" );
    Path filePath = Paths.get("src/main/java/com/desabisc/jdk11/files/myfile.txt");
    try {
      String content = Files.readString(filePath);
      log.info("File content: {}", content);
    } catch (Exception e) {
      log.error("Exception reading file: {}", e.getMessage());
    }
  }

  static void writeStringEg() {
    log.info("********** writeString() eg **********" );

    String newContent = "Hello, Java 11!";
    Path filePath = Paths.get("src/main/java/com/desabisc/jdk11/files/myfile.txt");

    try {
      Files.writeString(filePath, newContent);
    } catch (Exception e) {
      log.error("Exception writing in file: {}", e.getMessage());
    }
  }
}
