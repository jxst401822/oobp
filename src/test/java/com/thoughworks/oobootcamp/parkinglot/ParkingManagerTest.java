package com.thoughworks.oobootcamp.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;

public class ParkingManagerTest {

  @Test
  void should_return_ticket_when_parking_manager_parking_car_given_one_available_space_parking_lot() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingManager parkingManager = new ParkingManager();
    parkingManager.assignParkingableList(newArrayList(parkingLot));
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
    parkingManager.assignParkingableList(newArrayList(firstParkingLot, secondParkingLot));
    Car myCar = new Car();

    Ticket ticket = parkingManager.parkCar(myCar);

    Assertions.assertNotNull(ticket);
    Assertions.assertSame(myCar, firstParkingLot.pickCar(ticket));
  }

  @Test
  void should_return_ticket_when_request_parking_manager_parking_car_given_one_parking_boy_has_one_available_space_parking_lot() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot));
    ParkingManager parkingManager = new ParkingManager();
    parkingManager.assignParkingableList(newArrayList(parkingBoy));
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
    ParkingManager parkingManager = new ParkingManager();
    parkingManager.assignParkingableList(newArrayList(smartParkingBoy, parkingBoy));
    Car myCar = new Car();

    Ticket ticket = parkingManager.parkCar(myCar);

    Assertions.assertNotNull(ticket);
    Assertions.assertSame(myCar, secondParkingLot.pickCar(ticket));
  }

  @Test
  void should_return_ticket_when_request_parking_manager_parking_car_given_manager_and_parking_boy_both_has_one_available_space_parking_lot() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    Parkingable secondParkingLot = new ParkingLot(1);
    Parkingable parkingBoy = new ParkingBoy(newArrayList(firstParkingLot));
    ParkingManager parkingManager = new ParkingManager();
    parkingManager.assignParkingableList(newArrayList(secondParkingLot, parkingBoy));
    Car myCar = new Car();

    Ticket ticket = parkingManager.parkCar(myCar);

    Assertions.assertNotNull(ticket);
    Assertions.assertSame(myCar, firstParkingLot.pickCar(ticket));
  }

  @Test
  void should_return_ticket_when_request_parking_manager_parking_car_given_manager_and_parking_boy_has_one_no_space_and_has_one_available_parking_lot() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    Parkingable secondParkingLot = new ParkingLot(1);
    Parkingable parkingBoy = new ParkingBoy(newArrayList(firstParkingLot));
    parkingBoy.parkCar(new Car());
    ParkingManager parkingManager = new ParkingManager();
    parkingManager.assignParkingableList(newArrayList(secondParkingLot, parkingBoy));
    Car myCar = new Car();

    Ticket ticket = parkingManager.parkCar(myCar);

    Assertions.assertNotNull(ticket);
    Assertions.assertSame(myCar, secondParkingLot.pickCar(ticket));
  }

  @Test
  void should_throw_exception_when_request_parking_manager_parking_car_given_manager_and_parking_boy_both_has_one_no_space_parking_lots() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    Parkingable secondParkingLot = new ParkingLot(1);
    Parkingable parkingBoy = new ParkingBoy(newArrayList(firstParkingLot));
    parkingBoy.parkCar(new Car());
    secondParkingLot.parkCar(new Car());
    ParkingManager parkingManager = new ParkingManager();
    parkingManager.assignParkingableList(newArrayList(secondParkingLot, parkingBoy));
    Car myCar = new Car();

    Assertions.assertThrows(NoSpaceException.class,()->parkingManager.parkCar(myCar));
  }

}
