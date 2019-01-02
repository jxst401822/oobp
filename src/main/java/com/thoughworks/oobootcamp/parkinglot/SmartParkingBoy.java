package com.thoughworks.oobootcamp.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends BaseParkingBoy {

  public SmartParkingBoy(List<ParkingLot> parkingLots) {
    setParkingLots(parkingLots);
  }

  @Override
  public Ticket parkCar(Car car) {
    return getParkingLots().stream().max(Comparator.comparing(ParkingLot::getAvailableSpace))
        .orElseThrow(NoSpaceException::new).parkCar(car);
  }

}
