package study.design_pattern.behavior.strategy;

public interface DiscountStrategy {
    Long discount(User user, Long originalPrice) throws Exception;

    String getName();

    String discountTotal();
}
