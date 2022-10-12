package study.design_pattern.behavior.strategy;

import java.util.HashMap;

public class PercentDiscount implements DiscountStrategy {

    public static final HashMap<Grade, Double> discountPolicy = new HashMap<>();

    private Double discountTotal = 0D;
    private Double disCountRate = 0D;

    public PercentDiscount() {
        discountPolicy.put(Grade.NEWEMPLOYEE, 0.9);
        discountPolicy.put(Grade.EMPLOYEE, 0.7);
    }

    @Override
    public Long discount(User user, Long originalPrice) throws Exception {
        long discountedPrice = originalPrice;
        discountTotal = 0D;
        disCountRate = 0D;
        if(user.isEmployee()) {
            double rate =user.getGradeList().stream()
                    .filter(discountPolicy::containsKey)
                    .mapToDouble(grade -> discountPolicy.get(grade))
                    .findFirst().getAsDouble();
            discountedPrice *= rate;
            disCountRate = 1 - rate;
            discountTotal = (double) (originalPrice - discountedPrice);
        } else {
            System.out.println("임직원이 아닙니다");
        }
        return discountedPrice;
    }

    @Override
    public String getName() {
        return (disCountRate > 0.0) ? "임직원을 위한 정률 결제 방식" : "";
    }

    @Override
    public String discountTotal() {
        return (disCountRate > 0.0) ? ("할인 금액 ["+discountTotal + " 원], 할인율 : "+ disCountRate)   : "";
    }
}

