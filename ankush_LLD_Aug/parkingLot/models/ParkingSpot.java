package designpatterns.ankush_LLD_Aug.parkingLot.models;

import designpatterns.ankush_LLD_Aug.parkingLot.enums.VehicleType;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {

    private String parkingSpotId;
    private String floorId;
    private AtomicBoolean isOccupied;
    private VehicleType vehicleType;

    public ParkingSpot(String floorNo, VehicleType vehicleType) {
        this.parkingSpotId = String.valueOf(UUID.randomUUID());
        this.isOccupied = new AtomicBoolean(Boolean.FALSE);;
        this.vehicleType = vehicleType;
        floorId = floorNo;
    }

    public String getParkingSpotId(){
        return parkingSpotId;
    }
    public String getFloorId(){
        return floorId;
    }

    public AtomicBoolean getIsOccupied() {
        return isOccupied;
    }

    public boolean freeSpot() {
        return isOccupied.compareAndSet(true,false);
    }

    public boolean occupy() {
       return isOccupied.compareAndSet(false,true);
    }
    public String getVehicleType() {
        return String.valueOf(vehicleType);
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "parkingSpotId='" + parkingSpotId + '\'' +
                ", floorId='" + floorId + '\'' +
                ", isOccupied=" + isOccupied +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
