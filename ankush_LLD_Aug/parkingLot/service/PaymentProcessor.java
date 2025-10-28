package designpatterns.ankush_LLD_Aug.parkingLot.service;

public class PaymentProcessor {
    private final PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void pay(int amount) {
        paymentStrategy.pay(amount);
    }
}
