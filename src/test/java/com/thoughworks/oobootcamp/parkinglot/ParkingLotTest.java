package com.thoughworks.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingLotTest {

  @Test
  void shouldReturnTicketWhenParkingGivenHas1AvailableSpace() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car car = new Car();

    Ticket ticket = parkingLot.park(car);

    assertNotNull(ticket);
  }

}
