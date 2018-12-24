package com.thoughworks.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingLotTest {

  @Test
  void shouldReturnTicketWhenParkingGivenHas1AvailableSpace() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car car = new Car();

    Ticket ticket = parkingLot.park(car);

    assertNotNull(ticket);
  }

  @Test
  void shouldThrowExceptionWhenParkingGivenNoAvailableSpace() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car car = new Car();
    parkingLot.park(car);

    assertThrows(ParkIsFullException.class, () -> parkingLot.park(car));
  }

  @Test
  void shouldReturn0WhenPickCarGivenValidTicket() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car car = new Car();
    Ticket ticket = parkingLot.park(car);

    assertEquals(0, parkingLot.pickCar(ticket));
  }




}
