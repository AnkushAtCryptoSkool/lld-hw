package designpatterns.ankush_LLD_Aug.parkingLot.models;

import designpatterns.ankush_LLD_Aug.parkingLot.enums.VehicleType;

public class Truck extends Vehicle{
    public Truck(String vehicleNo) {
        super(vehicleNo);
    }
     public String getType(){
        return String.valueOf(VehicleType.TRUCK);
    }
}
