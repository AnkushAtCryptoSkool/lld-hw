package designpatterns.ankush_LLD_Aug.parkingLot.service;

import designpatterns.ankush_LLD_Aug.parkingLot.models.Ticket;

public class DefaultFareStrategy implements FareStrategy{
    @Override
    public int calculateFare(Ticket ticket) {
        switch (ticket.getVehicle().getType()){
            case "CAR" :
                System.out.println("Car parking rate : Rs 200");
                return 200;
            case "BIKE" :
                System.out.println("Bike parking rate : Rs 100");
                return 100;
            case "TRUCK" :
                System.out.println("Truck parking rate : Rs 400");
                return 400;
            default:
                System.out.println("No rate calculated as vehicle type undefined");
               throw new RuntimeException("Fare not calculated as vehicle type is not valid");
        }
    }
}
