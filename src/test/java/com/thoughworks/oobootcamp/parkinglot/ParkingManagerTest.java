package com.thoughworks.oobootcamp.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;

public class ParkingManagerTest {

  @Test
  void should_return_ticket_when_parking_manager_parking_car_given_one_available_space_parking_lot() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingManager parkingManager = new ParkingManager(newArrayList(parkingLot));
    Car myCar = new Car();
    Ticket ticket = parkingManager.parkCar(myCar);

    Assertions.assertNotNull(ticket);
    Assertions.assertSame(myCar, parkingLot.pickCar(ticket));
  }
}
