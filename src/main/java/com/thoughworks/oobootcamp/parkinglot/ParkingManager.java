package com.thoughworks.oobootcamp.parkinglot;

import java.util.ArrayList;

public class ParkingManager {


  private ArrayList<ParkingLot> parkingLots;
  private ArrayList<BaseParkingBoy> parkingBoys;

  public ParkingManager(ArrayList<BaseParkingBoy> parkingBoys) {
    this.parkingBoys = parkingBoys;
  }

  public ParkingManager() {

  }

  public void assignParkingLots(ArrayList<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public Ticket parkCar(Car myCar) {
    if (parkingLots == null) {
      return parkingBoys.stream().findFirst().orElseThrow(NoParkingBoysException::new)
          .parkCar(myCar);
    }
    return parkingLots.get(0).parkCar(myCar);
  }
}
