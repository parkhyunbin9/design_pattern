package study.design_pattern.behavior.strategy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentService {

    private final DiscountStrategy discountStrategy;

    public Long pay(User user, Cart cart) throws Exception {
        Long discount = 0L;

//        System.out.println("********************************************");
//        System.out.println(user +" 의 결제 상품 :" + cart.products.toString()+
//        " 할인 전 결제 총액 : " + cart.getTotalPrice() +" 원 입니다.");

        if(cart.getTotalPrice() > 0) {
            discount = discountStrategy.discount(user, cart.getTotalPrice());
            if(cart.getTotalPrice() != discount) {
                System.out.println("사용된 결제 방식 : ["+ discountStrategy.getName() +"]");
                System.out.println(discountStrategy.discountTotal());
            }
        }
        return discount;
    }

}
