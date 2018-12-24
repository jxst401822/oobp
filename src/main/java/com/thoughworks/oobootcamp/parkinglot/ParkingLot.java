package com.thoughworks.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

  private int space;

  private List<Car> cars = new ArrayList<>();

  public ParkingLot(int space) {
    this.space = space;
  }

  public Ticket park(Car car) {
    if (cars.size() >= space){
      throw new ParkIsFullException("the park is no available space!");
    }
    cars.add(car);
    return new Ticket();
  }

  public int pickCar(Ticket ticket) {
    return 0;
  }
}
