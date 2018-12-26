package com.thoughworks.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ParkingBoyTest {

  @Test
  void shouldReturnTicketWhenParkingBoyParkCarGivenSingleParkingLotHasRemainingSpace() {
    ParkingBoy parkingBoy = new ParkingBoy(newArrayList(new ParkingLot(2)));

    assertNotNull(parkingBoy.parkCar(new Car()));
  }

  @Test
  void shouldReturnTicketWhenParkingBoyParkCarGivenNo2ParkingLotHasRemainingSpace() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    firstParkingLot.parkCar(new Car());
    ParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot, new ParkingLot(2)));

    assertNotNull(parkingBoy.parkCar(new Car()));
  }

  @Test
  void shouldParkCarInFirstParkingLotWhenParkingBoyParkCarGivenAllParkingLotsHaveRemainingSpace() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);
    ParkingLot thirdParkingLot = new ParkingLot(1);
    ParkingBoy parkingBoy = new ParkingBoy(
        newArrayList(firstParkingLot, secondParkingLot, thirdParkingLot));

    assertEquals(firstParkingLot, parkingBoy.getCurrentParkingLot());
  }

  @Test
  void shouldReturnCarWhenParkingBoyParkCarGivenValidTicket() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    Ticket ticket = firstParkingLot.parkCar(new Car());
    ParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot));

    assertNotNull(parkingBoy.pickCar(ticket));
  }

  @Test
  void shouldReturnNullWhenParkingBoyParkCarGivenNoTicket() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    firstParkingLot.parkCar(new Car());
    ParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot));

    assertNull(parkingBoy.pickCar(null));
  }

  @Test
  void shouldReturnNullWhenParkingBoyParkCarGivenInvalidTicket() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    firstParkingLot.parkCar(new Car());
    ParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot));

    assertNull(parkingBoy.pickCar(new Ticket()));
  }


}
