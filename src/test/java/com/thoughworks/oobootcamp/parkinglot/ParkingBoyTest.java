package com.thoughworks.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingBoyTest {

  @Test
  void shouldReturnTicketWhenParkingBoyParkCarGivenSingleParkingLotHasRemainingSpace() {
    ParkingBoy parkingBoy = new ParkingBoy(newArrayList(new ParkingLot(2)));

    assertNotNull(parkingBoy.parkCar(new Car()));
  }

  @Test
  void shouldReturnTicketWhenParkingBoyParkCarGivenSecondParkingLotHasRemainingSpace() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(2);
    ParkingLot thirdParkingLot = new ParkingLot(3);
    ParkingLot fourthParkingLot = new ParkingLot(4);
    ParkingLot fifthParkingLot = new ParkingLot(5);
    firstParkingLot.parkCar(new Car());
    ParkingBoy parkingBoy = new ParkingBoy(
        newArrayList(firstParkingLot, secondParkingLot, thirdParkingLot, fourthParkingLot,
            fifthParkingLot));
    Car myCar = new Car();

    Ticket ticket = parkingBoy.parkCar(myCar);

    assertEquals(myCar, secondParkingLot.pickCar(ticket));
  }

  @Test
  void shouldReturnCarWhenParkingBoyParkCarGivenValidTicket() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    Ticket ticket = firstParkingLot.parkCar(new Car());
    ParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot));

    assertNotNull(parkingBoy.pickCar(ticket));
  }

  @Test
  void shouldThrowExceptionWhenParkingBoyParkCarGivenNoTicket() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    firstParkingLot.parkCar(new Car());
    ParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot));

    assertThrows(InvalidTicketException.class, () -> parkingBoy.pickCar(null));
  }

  @Test
  void shouldThrowExceptionWhenParkingBoyParkCarGivenInvalidTicket() {
    ParkingLot firstParkingLot = new ParkingLot(1);
    firstParkingLot.parkCar(new Car());
    ParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot));

    assertThrows(InvalidTicketException.class, () -> parkingBoy.pickCar(new Ticket()));
  }


}
