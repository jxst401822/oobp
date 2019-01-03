package com.thoughworks.oobootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Parkingable {

  private final int space;

  private Map<Ticket, Car> cars = new HashMap<>();

  public ParkingLot(int space) {
    this.space = space;
  }

  @Override
  public Ticket parkCar(Car car) {
    if (cars.size() >= space) {
      throw new NoSpaceException();
    }
    Ticket ticket = new Ticket();
    cars.put(ticket, car);
    return ticket;
  }

  public Car pickCar(Ticket ticket) {
    Car car = cars.remove(ticket);
    if (car == null) {
      throw new InvalidTicketException();
    }
    return car;
  }

  @Override
  public boolean hasAvailableSpace() {
    return cars.size() < space;
  }

  public int getAvailableSpace() {
    return space - cars.size();
  }

  public boolean hasParkedCar(Ticket ticket) {
    return cars.containsKey(ticket);
  }
}
