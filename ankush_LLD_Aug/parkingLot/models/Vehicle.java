package designpatterns.ankush_LLD_Aug.parkingLot.models;

public abstract class Vehicle {
    private String vehicleNo;

    public Vehicle() {
    }

    public abstract String getType();
    public  void setVehicleNo(String vehicleNo){
        this.vehicleNo = vehicleNo;
    }

    public Vehicle(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
}
