package com.thoughworks.oobootcamp.parkinglot;

import java.util.List;

public abstract class BaseParkingBoy {

  private List<ParkingLot> parkingLots;

  public List<ParkingLot> getParkingLots() {
    return parkingLots;
  }

  public void setParkingLots(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public abstract Ticket parkCar(Car car);

  public Car pickCar(Ticket ticket) {
    return parkingLots.stream().filter(data -> data.hasParkedCar(ticket)).findAny()
        .orElseThrow(InvalidTicketException::new).pickCar(ticket);
  }
}
