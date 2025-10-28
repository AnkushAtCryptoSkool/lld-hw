package designpatterns.ankush_LLD_Aug.parkingLot.models;

import designpatterns.ankush_LLD_Aug.parkingLot.enums.GateType;
import designpatterns.ankush_LLD_Aug.parkingLot.service.ParkingLotInstance;

public class Entrance extends Gate{
    @Override
    public String getGateType() {
        return String.valueOf(GateType.ENTRANCE);
    }
    public Ticket park(Vehicle vehicle){
        return ParkingLotInstance.getParkingLotInstance().park(vehicle);
    }
}
