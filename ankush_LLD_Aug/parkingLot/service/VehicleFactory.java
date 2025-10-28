package designpatterns.ankush_LLD_Aug.parkingLot.service;

import designpatterns.ankush_LLD_Aug.parkingLot.models.Bike;
import designpatterns.ankush_LLD_Aug.parkingLot.models.Car;
import designpatterns.ankush_LLD_Aug.parkingLot.models.Truck;
import designpatterns.ankush_LLD_Aug.parkingLot.models.Vehicle;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType,String vehicleNo) {
        switch (vehicleType) {
            case "CAR" :
                return new Car(vehicleNo);
            case "BIKE" :
                return new Bike(vehicleNo);
            case "TRUCK" :
                return new Truck(vehicleNo);
            default:
                throw new RuntimeException("Vehicle Type Not valid");
        }
    }
}
