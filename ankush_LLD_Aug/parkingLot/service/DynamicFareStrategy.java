package designpatterns.ankush_LLD_Aug.parkingLot.service;

import designpatterns.ankush_LLD_Aug.parkingLot.models.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class DynamicFareStrategy implements FareStrategy{
    @Override
    public int calculateFare(Ticket ticket) {
         Duration duration = Duration.between(LocalDateTime.now(),ticket.getEntryTime());
         long diff = duration.toHours() == 0 ? 1 : duration.toHours();

        switch (ticket.getVehicle().getType()){
            case "CAR" :
                System.out.println("Car parking rate : Rs" + diff * 100);
                return (int) (diff * 100);
            case "BIKE" :
                System.out.println("Bike parking rate : Rs" + diff * 50);
                return (int) (diff * 50);
            case "TRUCK" :
                System.out.println("Truck parking rate : Rs" + diff * 200);
                return (int) (diff * 200);
            default:
                System.out.println("No rate calculated as vehicle type undefined");
                throw new RuntimeException("Fare not calculated as vehicle type is not valid");
        }
    }
}
