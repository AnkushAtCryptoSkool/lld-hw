package designpatterns.ankush_LLD_Aug.parkingLot.service;

import designpatterns.ankush_LLD_Aug.parkingLot.models.Ticket;

public interface FareStrategy {
    public int calculateFare(Ticket ticket);
}
