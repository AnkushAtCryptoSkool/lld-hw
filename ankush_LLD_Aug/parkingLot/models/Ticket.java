package designpatterns.ankush_LLD_Aug.parkingLot.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private  final String id = String.valueOf(UUID.randomUUID());
    LocalDateTime entryTime;
    Vehicle vehicle;
    ParkingSpot parkingSpot;
    String parkingLevel;

    public Ticket(Vehicle vehicle,LocalDateTime entryTime, ParkingSpot parkingSpot, String parkingLevel) {
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
        this.parkingLevel = parkingLevel;
        this.vehicle = vehicle;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getParkingLevel() {
        return parkingLevel;
    }

    public void setParkingLevel(String parkingLevel) {
        this.parkingLevel = parkingLevel;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", entryTime=" + entryTime +
                ", parkingSpot=" + parkingSpot +
                ", parkingLevel='" + parkingLevel + '\'' +
                '}';
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
