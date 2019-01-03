package com.thoughworks.oobootcamp.parkinglot;

import java.util.List;

public abstract class BaseParkingBoy implements Parkingable {

  private List<ParkingLot> parkingLots;

  public List<ParkingLot> getParkingLots() {
    return parkingLots;
  }

  public void setParkingLots(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  @Override
  public abstract Ticket parkCar(Car car);

  @Override
  public boolean hasAvailableSpace() {
    return parkingLots.stream().anyMatch(ParkingLot::hasAvailableSpace);
  }

  @Override
  public Car pickCar(Ticket ticket) {
    return parkingLots.stream().filter(data -> data.hasParkedCar(ticket)).findAny()
        .orElseThrow(InvalidTicketException::new).pickCar(ticket);
  }
}
