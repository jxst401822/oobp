package com.thoughworks.oobootcamp.parkinglot;

import java.util.List;
import java.util.Optional;

public class ParkingBoy {

  private List<ParkingLot> parkingLots;

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public Ticket parkCar(Car car) {
    Optional<ParkingLot> parkingLot = parkingLots.stream().filter(ParkingLot::hasAvailableSpace)
        .findFirst();
    return parkingLot.map(data -> data.parkCar(car)).orElse(null);
  }
}
