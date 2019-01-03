package com.thoughworks.oobootcamp.parkinglot;

import java.util.ArrayList;

public class ParkingManager {

  private ArrayList<Parkingable> parkingables;

  public Ticket parkCar(Car myCar) {
    return parkingables.stream().filter(e -> e.hasAvailableSpace() && (e instanceof BaseParkingBoy))
        .findFirst().orElse(parkingables.stream().filter(Parkingable::hasAvailableSpace).findFirst()
            .orElseThrow(NoSpaceException::new)).parkCar(myCar);
  }

  public void assignParkingableList(ArrayList<Parkingable> parkingables) {
    this.parkingables = parkingables;
  }

  public Car pickCar(Ticket ticket) {
    return parkingables.stream().filter(e -> e.hasParkedCar(ticket)).findAny()
        .orElseThrow(InvalidTicketException::new).pickCar(ticket);
  }
}
