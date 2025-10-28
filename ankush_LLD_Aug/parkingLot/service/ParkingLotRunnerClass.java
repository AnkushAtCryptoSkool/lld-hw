package designpatterns.ankush_LLD_Aug.parkingLot.service;

import designpatterns.ankush_LLD_Aug.parkingLot.enums.VehicleType;
import designpatterns.ankush_LLD_Aug.parkingLot.models.*;

public class ParkingLotRunnerClass {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator(new DynamicFareStrategy());
        PaymentProcessor paymentProcessor = new PaymentProcessor(new WalletPaymentStrategy());
        ParkingSpot parkingSpot1 = new ParkingSpot("1",VehicleType.CAR);
        ParkingSpot parkingSpot2 = new ParkingSpot("2", VehicleType.BIKE);
        ParkingLevel floor1 = new ParkingLevel("1");
        floor1.addSpot(parkingSpot1);
        ParkingLevel floor2 = new ParkingLevel("2");
        floor2.addSpot(parkingSpot2);
        ParkingLotInstance parkingLotInstance =  ParkingLotInstance.getParkingLotInstance();
        parkingLotInstance.setFareCalculator(fareCalculator);
        parkingLotInstance.setPaymentProcessor(paymentProcessor);
        parkingLotInstance.addParkingLevel(floor1);
        parkingLotInstance.addParkingLevel(floor2);
        Car car = (Car) VehicleFactory.getVehicle("CAR","1");
        System.out.println("--------- Request coming for PARK vehicle ---------");
        Entrance entranceGate = new Entrance();
        Ticket ticket = entranceGate.park(car);
        System.out.println("Ticket generated : " + ticket.toString());
        System.out.println("--------- Request coming for UNPARK vehicle ------------");
        Exit exit = new Exit();
        exit.unpark(ticket);
    }
}
