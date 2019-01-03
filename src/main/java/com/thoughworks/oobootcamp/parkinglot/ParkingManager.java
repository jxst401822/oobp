package com.thoughworks.oobootcamp.parkinglot;

import java.util.ArrayList;

public class ParkingManager {


  private ArrayList<ParkingLot> parkingLots;

  public ParkingManager(ArrayList<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public Ticket parkCar(Car myCar) {
    return parkingLots.get(0).parkCar(myCar);
  }
}
