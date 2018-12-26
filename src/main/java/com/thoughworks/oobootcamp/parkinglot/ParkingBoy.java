package com.thoughworks.oobootcamp.parkinglot;

import java.util.List;

public class ParkingBoy {

  private List<ParkingLot> parkingLots;

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public Ticket parkCar(Car car) {
    return parkingLots.stream().filter(ParkingLot::hasAvailableSpace).findFirst()
        .orElseThrow(NoSpaceException::new).parkCar(car);
  }

  public Car pickCar(Ticket ticket) {
    return parkingLots.stream().filter(data -> data.hasParkedCar(ticket)).findAny()
        .orElseThrow(InvalidTicketException::new).pickCar(ticket);
  }

}
