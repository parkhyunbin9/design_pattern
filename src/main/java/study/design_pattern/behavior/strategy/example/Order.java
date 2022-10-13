package study.design_pattern.behavior.strategy.example;

/*
*  유저가 선택한 구체적인 결제 전략을 모르고
* 인터페이스화된 결제 전략을 호출 선택한 결제 전략객체에 수행을 위임한다.
* */
public class Order {
    private int totalCost = 0;
    private boolean isClosed = false;

    public void processOrder(PayStrategy strategy) {
        strategy.collectPaymentDetails();
    }

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }
}
