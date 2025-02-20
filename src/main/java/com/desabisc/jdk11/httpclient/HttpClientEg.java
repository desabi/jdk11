package com.desabisc.jdk11.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class HttpClientEg {
  // using a mock rest api created in soapui
  public static void main(String[] args) {
    example();
  }

  static void example() {
    try {
      // Create Httpclient
      HttpClient httpClient = HttpClient.newHttpClient();

      // Build HttpRequest
      HttpRequest httpRequest = HttpRequest.newBuilder()
          .uri(URI.create("http://localhost:8080/product/5"))
          .GET()
          .build();

      // Send a request and get response
      HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

      if (httpResponse.statusCode() == 200) {
        String responseBody = httpResponse.body();
        log.info("Response Body:\n{}", responseBody);
      } else {
        log.info("Status Code: {}", httpResponse.statusCode());
      }
    } catch (Exception exception) {
      log.error("Exception is: {}",exception.getMessage());
    }
  }
}
