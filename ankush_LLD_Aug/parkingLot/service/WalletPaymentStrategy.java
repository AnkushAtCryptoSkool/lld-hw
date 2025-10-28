package designpatterns.ankush_LLD_Aug.parkingLot.service;

public class WalletPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        try {
            System.out.println("Amount paid by Wallet : " + amount);
        }catch (Exception e){
            throw new RuntimeException("Exception occurred while paying via Wallet" + e.getMessage());
        }

    }
}
