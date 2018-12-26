package com.thoughworks.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyTest {

  @Test
  void shouldReturnTicketWhenParkCarGivenOneCarPickedFromFullParkingLot() {
    ParkingLot parkingLot = new ParkingLot(2);
    parkingLot.parkCar(new Car());
    Ticket ticket = parkingLot.parkCar(new Car());
    parkingLot.pickCar(ticket);

    assertNotNull(parkingLot.parkCar(new Car()));
  }

  @Test
  void shouldReturnTicketWhenParkingBoyParkCarGivenSingleParkingLotHasRemainingSpace() {
    ParkingLot parkingLot = new ParkingLot(2);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

    assertNotNull(parkingBoy.parkCar(new Car()));
  }
}
