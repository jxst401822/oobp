package com.thoughworks.oobootcamp.parkinglot;

public class ParkIsFullException extends RuntimeException {

  public ParkIsFullException(String message) {
    super(message);
  }
}
