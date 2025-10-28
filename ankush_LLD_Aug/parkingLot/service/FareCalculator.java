package designpatterns.ankush_LLD_Aug.parkingLot.service;

import designpatterns.ankush_LLD_Aug.parkingLot.models.Ticket;

public class FareCalculator {
    private final FareStrategy fareStrategy;
    public FareCalculator(FareStrategy fareStrategy){
        this.fareStrategy = fareStrategy;
    }
    public int calculate(Ticket ticket){
       return fareStrategy.calculateFare(ticket);
    }
}
