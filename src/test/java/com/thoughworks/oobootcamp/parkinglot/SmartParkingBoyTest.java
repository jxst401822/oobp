package com.thoughworks.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {

  @Test
  void should_return_ticket_when_smart_boy_parking_car_given_two_same_available_space_parking_lots() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(
        newArrayList(firstParkingLot, secondParkingLot));
    Car myCar = new Car();
    Ticket ticket = smartParkingBoy.parkCar(myCar);
    assertNotNull(ticket);
    assertSame(myCar, firstParkingLot.pickCar(ticket));
  }

  @Test
  void should_return_ticket_when_smart_boy_parking_car_given_the_first_lot_has_more_available_space() {
    ParkingLot firstParkingLot = new ParkingLot(2);
    ParkingLot secondParkingLot = new ParkingLot(1);
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(
        newArrayList(firstParkingLot, secondParkingLot));
    Car myCar = new Car();
    Ticket ticket = smartParkingBoy.parkCar(myCar);
    assertNotNull(ticket);
    assertSame(myCar, firstParkingLot.pickCar(ticket));
  }

  @Test
  void should_return_ticket_when_smart_boy_parking_car_given_the_second_lot_has_more_available_space() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(2);
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(
        newArrayList(firstParkingLot, secondParkingLot));
    Car myCar = new Car();
    Ticket ticket = smartParkingBoy.parkCar(myCar);
    assertNotNull(ticket);
    assertSame(myCar, secondParkingLot.pickCar(ticket));
  }

  @Test
  void should_throw_exception_when_smart_boy_parking_car_given_no_space_parking_lots() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);
    firstParkingLot.parkCar(new Car());
    secondParkingLot.parkCar(new Car());
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(
        newArrayList(firstParkingLot, secondParkingLot));
    Car myCar = new Car();
    assertThrows(NoSpaceException.class, () -> smartParkingBoy.parkCar(myCar));
  }


}
