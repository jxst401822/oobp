package com.thoughworks.oobootcamp.parkinglot;

public interface Parkingable {

  Ticket parkCar(Car car);

  boolean hasAvailableSpace();
}
