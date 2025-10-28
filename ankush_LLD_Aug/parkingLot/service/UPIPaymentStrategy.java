package designpatterns.ankush_LLD_Aug.parkingLot.service;

public class UPIPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        try {
            System.out.println("Amount paid by UPI : " + amount);
        }catch (Exception e){
            throw new RuntimeException("Exception occurred while paying via UPI" + e.getMessage());
        }

    }
}
