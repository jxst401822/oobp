package com.thoughworks.oobootcamp.parkinglot;

import java.util.ArrayList;

public class ParkingManager {


  private ArrayList<ParkingLot> parkingLots;
  private ParkingBoy parkingBoy;

  public ParkingManager(ArrayList<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public ParkingManager(ParkingBoy parkingBoy) {

    this.parkingBoy = parkingBoy;
  }

  public Ticket parkCar(Car myCar) {
    if (parkingLots == null) {
      return parkingBoy.parkCar(myCar);
    }
    return parkingLots.get(0).parkCar(myCar);
  }
}
