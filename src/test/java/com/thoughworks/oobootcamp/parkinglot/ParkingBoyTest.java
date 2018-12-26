package com.thoughworks.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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


}
