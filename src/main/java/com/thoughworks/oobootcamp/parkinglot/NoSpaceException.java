package com.thoughworks.oobootcamp.parkinglot;

public class NoSpaceException extends RuntimeException {

  public NoSpaceException(String message) {
    super(message);
  }
}
