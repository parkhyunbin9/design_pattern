package study.design_pattern.behavior.strategy.example;

public interface PayStrategy {

    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}
