package designpatterns.ankush_LLD_Aug.parkingLot.models;

import designpatterns.ankush_LLD_Aug.parkingLot.enums.VehicleType;

public class Car extends Vehicle{
    public Car() {
    }

    public Car(String vehicleNo) {
        super(vehicleNo);
    }

    public void setVehicleNo(String vehicleNo){

    }
    public String getType(){
        return String.valueOf(VehicleType.CAR);
    }
}
