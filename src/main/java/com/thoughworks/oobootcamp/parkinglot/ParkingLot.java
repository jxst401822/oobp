package com.thoughworks.oobootcamp.parkinglot;

public class ParkingLot {

  private int space;

  public ParkingLot(int space) {
    this.space = space;
  }

  public Ticket park(Car car) {
    return new Ticket();
  }

}
