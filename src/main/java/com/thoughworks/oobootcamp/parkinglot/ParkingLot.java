package com.thoughworks.oobootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

  private int space;

  private Map<Ticket, Car> cars = new HashMap<>();

  public ParkingLot(int space) {
    this.space = space;
  }

  public Ticket park(Car car) {
    if (cars.size() >= space) {
      throw new ParkIsFullException("the park is no available space!");
    }
    Ticket ticket = new Ticket();
    cars.put(ticket, car);
    return ticket;
  }

  public Car pickCar(Ticket ticket) {
    Car car = cars.get(ticket);
    if (car == null) {
      throw new InvalidTicketException();
    }
    return car;
  }
}
