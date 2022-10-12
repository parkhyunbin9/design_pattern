package study.design_pattern.behavior.strategy;

import java.util.HashMap;

public class PriceDiscount implements DiscountStrategy {

    public static final HashMap<Grade, Long> discountPolicy = new HashMap<>();

    private Long discountTotal = 0L;

    public PriceDiscount() {
        discountPolicy.put(Grade.NEW, 5000L);
        discountPolicy.put(Grade.VIP, 2000L);
        discountPolicy.put(Grade.NORMAL, 1000L);
    }

    @Override
    public Long discount(User user, Long originalPrice) throws Exception {
        long discountedPrice = originalPrice;

        if(user.isMember()) {
            discountTotal = user.getGradeList().stream()
                    .filter(discountPolicy::containsKey)
                    .mapToLong(grade -> discountPolicy.get(grade))
                    .findAny().getAsLong();
            discountedPrice -= discountTotal;
        } else {
            System.out.println("고객이 아닙니다");
        }

        return discountedPrice;
    }

    @Override
    public String getName() {
        return (discountTotal > 0) ? "고객을 위한 정액 결제 방식" : "";
    }

    @Override
    public String discountTotal() {
        return "할인 금액 ["+ discountTotal+" 원]";
    }
}

