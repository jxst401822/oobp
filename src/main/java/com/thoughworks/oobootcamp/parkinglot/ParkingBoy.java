package com.thoughworks.oobootcamp.parkinglot;

import java.util.List;

public class ParkingBoy extends BaseParkingBoy {


  public ParkingBoy(List<ParkingLot> parkingLots) {
    setParkingLots(parkingLots);
  }

  @Override
  public Ticket parkCar(Car car) {
    return getParkingLots().stream().filter(ParkingLot::hasAvailableSpace).findFirst()
        .orElseThrow(NoSpaceException::new).parkCar(car);
  }

}
