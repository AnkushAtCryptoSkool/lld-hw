package designpatterns.ankush_LLD_Aug.parkingLot.models;

import designpatterns.ankush_LLD_Aug.parkingLot.enums.VehicleType;

public class Bike extends Vehicle{
    public Bike() {
    }

    public Bike(String vehicleNo) {
        super(vehicleNo);
    }
    public String getType(){
        return String.valueOf(VehicleType.BIKE);
    }
}
