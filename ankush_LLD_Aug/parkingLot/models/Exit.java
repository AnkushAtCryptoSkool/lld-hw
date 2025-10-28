package designpatterns.ankush_LLD_Aug.parkingLot.models;

import designpatterns.ankush_LLD_Aug.parkingLot.enums.GateType;
import designpatterns.ankush_LLD_Aug.parkingLot.service.ParkingLotInstance;

public class Exit extends Gate{
    @Override
    public String getGateType() {
        return String.valueOf(GateType.EXIT);
    }

    public void unpark(Ticket ticket){
        ParkingLotInstance.getParkingLotInstance().unpark(ticket);
    }
}
