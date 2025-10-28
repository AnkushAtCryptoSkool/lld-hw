package designpatterns.ankush_LLD_Aug.parkingLot.service;

import designpatterns.ankush_LLD_Aug.parkingLot.models.ParkingLevel;
import designpatterns.ankush_LLD_Aug.parkingLot.models.ParkingSpot;
import designpatterns.ankush_LLD_Aug.parkingLot.models.Ticket;
import designpatterns.ankush_LLD_Aug.parkingLot.models.Vehicle;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotInstance {
    private static ParkingLotInstance parkingLotInstance = null;
    private  FareCalculator fareCalculator;
    private  PaymentProcessor paymentProcessor;
    Map<String, ParkingLevel> parkingLot;

    private ParkingLotInstance(){
        parkingLot = new HashMap<>();
    };

    public static ParkingLotInstance getParkingLotInstance(){
        if(parkingLotInstance == null) {
            parkingLotInstance = new ParkingLotInstance();
        }
        return parkingLotInstance;
    }

    public void setFareCalculator(FareCalculator fareCalculator){
        this.fareCalculator = fareCalculator;
    }

    public void setPaymentProcessor(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }

    public void addParkingLevel(ParkingLevel parkingLevel){
        parkingLot.put(parkingLevel.getParkingLevelId(),parkingLevel);
    }

    public void removeParkingLevel(ParkingLevel parkingLevel){
        parkingLot.remove(parkingLevel.getParkingLevelId());
    }

    public Ticket park(Vehicle vehicle){
        // check avaliablity
         if(!checkAvaliablity(vehicle)) {
             throw new RuntimeException("ParkingLot is Full, No Space Left");
         }
        // generateTicket
       return generateTicket(vehicle);

    }

    public void unpark(Ticket ticket){
        // calculateFare
        int fare = fareCalculator.calculate(ticket);
        // payement
         paymentProcessor.pay(fare);
        // free spot
        freeSpot(ticket.getParkingSpot());

    }

    private void freeSpot(ParkingSpot parkingSpot) {
       parkingSpot.freeSpot();
    }

    private Ticket generateTicket(Vehicle vehicle) {
        ParkingSpot parkingSpot = findParkingSpot(vehicle);
        if(parkingSpot.occupy()){
            Ticket ticket = new Ticket(vehicle,LocalDateTime.now(),parkingSpot,parkingSpot.getFloorId());
          return ticket;
        }else{
            throw new RuntimeException("Someone else booked this slot first, try again");
        }
    }

    private ParkingSpot findParkingSpot(Vehicle vehicle) {
        return parkingLot.values().stream()
                .flatMap(level -> level.getParkingSpotMap().values().stream())
                .filter(spot ->
                 spot.getVehicleType().equals(vehicle.getType())
                 && !spot.getIsOccupied().get())
                .findFirst().get();
    }

    private boolean checkAvaliablity(Vehicle vehicle) {
        if(!parkingLot.isEmpty()) {
            return parkingLot.values().stream()
                    .flatMap(level -> level.getParkingSpotMap().values().stream())
                    .anyMatch(spot ->
                            spot.getVehicleType().equals(vehicle.getType())
                            && !spot.getIsOccupied().get());
        }
        return false;
    }

}
