package com.thoughworks.oobootcamp.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;

public class ParkingManagerTest {

  @Test
  void should_return_ticket_when_parking_manager_parking_car_given_one_available_space_parking_lot() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingManager parkingManager = new ParkingManager();
    parkingManager.assignParkingLots(newArrayList(parkingLot));
    Car myCar = new Car();
    Ticket ticket = parkingManager.parkCar(myCar);

    Assertions.assertNotNull(ticket);
    Assertions.assertSame(myCar, parkingLot.pickCar(ticket));
  }

  @Test
  void should_return_ticket_when_parking_manager_parking_car_given_two_available_space_parking_lot() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);
    ParkingManager parkingManager = new ParkingManager();
    parkingManager.assignParkingLots(newArrayList(firstParkingLot, secondParkingLot));
    Car myCar = new Car();
    Ticket ticket = parkingManager.parkCar(myCar);

    Assertions.assertNotNull(ticket);
    Assertions.assertSame(myCar, firstParkingLot.pickCar(ticket));
  }

  @Test
  void should_return_ticket_when_request_parking_manager_parking_car_given_one_parking_boy_has_one_available_space_parking_lot() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot));
    ParkingManager parkingManager = new ParkingManager(newArrayList(parkingBoy));
    Car myCar = new Car();
    Ticket ticket = parkingManager.parkCar(myCar);

    Assertions.assertNotNull(ticket);
    Assertions.assertSame(myCar, firstParkingLot.pickCar(ticket));
  }

  @Test
  void should_return_ticket_when_request_parking_manager_parking_car_given_two_parking_boy_both_has_one_available_space_parking_lot() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);
    BaseParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot));
    BaseParkingBoy smartParkingBoy = new SmartParkingBoy(newArrayList(secondParkingLot));
    ParkingManager parkingManager = new ParkingManager(newArrayList(smartParkingBoy, parkingBoy));
    Car myCar = new Car();
    Ticket ticket = parkingManager.parkCar(myCar);

    Assertions.assertNotNull(ticket);
    Assertions.assertSame(myCar, secondParkingLot.pickCar(ticket));
  }

}
