package designpatterns.ankush_LLD_Aug.parkingLot.models;

import java.util.HashMap;
import java.util.Map;

public class ParkingLevel {
   private String parkingLevelId;
    private Map<String,ParkingSpot> parkingSpotMap;

    public ParkingLevel(String parkingLevelNo) {
        this.parkingSpotMap = new HashMap<>();
        parkingLevelId = parkingLevelNo;
    }

    public String getParkingLevelId(){
        return parkingLevelId;
    }

    public Map<String,ParkingSpot> getParkingSpotMap(){
        return parkingSpotMap;
    }
    public ParkingSpot getParkingSpot(String id){
        return parkingSpotMap.get(id);
    }

    public void addSpot(ParkingSpot parkingSpot){
        parkingSpotMap.put(parkingSpot.getParkingSpotId(),parkingSpot);
    }
    public void removeSpot(ParkingSpot parkingSpot){
        parkingSpotMap.remove(parkingSpot.getParkingSpotId());
    }
}
