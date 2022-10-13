package study.design_pattern.behavior.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        * 전략 패턴
        * - 유저가 A, B C, D 가 아래와 같은 상품을 모두 같이 구매할때 가격은 어떻게 될 것인가 ?
        *
        * - 유저의 종류 임직원, 일반 회원, 첫 구매 고객
        * - 결제 전략 :
        *       1. 정액 할인 : 1000원, 2000원, 5000원 할인
        *       2. 정률 할인 : 10%, 30%
        *
        * - 시나리오 : 첫 구매 고객일 경우 5000원 할인 가능
        *   임직원은 추가로 정률 할인 가능 (근속년수 5년 이상 -> 30퍼센트, 그외 10퍼센트)
        *   일반회원의 경우 VIP는 2000원 할인, 그외는 1000원 할인
        *
        * 상품 :
        *   이름  "book",      가격 5000원,
        *   이름  "computer",  가격 30000원,
        *   이름  "phone",     가격 10000원,
        *
        *  유저 A -> vip, 5년 이상 임직원
        *  유저 B -> vip, 5년 이하  임직원
        *  유저 C -> 일반 ,
        *  유저 D -> 일반 , 5년 이상 임직원
        *  유저 E -> 신규 회원
        *
        * */

        User userA = new User("memberA", Arrays.asList(Grade.VIP, Grade.EMPLOYEE));
        User userB = new User("memberB", Arrays.asList(Grade.VIP, Grade.NEWEMPLOYEE));
        User userC = new User("memberC", Arrays.asList(Grade.NORMAL));
        User userD = new User("memberD", Arrays.asList(Grade.EMPLOYEE));
        User userE = new User("memberE", Arrays.asList(Grade.NEW));

        System.out.println("memberA = " + userA);
        System.out.println("memberB = " + userB);
        System.out.println("memberC = " + userC);
        System.out.println("memberD = " + userD);
        System.out.println("memberE = " + userE);
        System.out.println();
        System.out.println();

        Product book = new Product("Book", 5000L, 100);
        Product computer = new Product("Computer", 30000L, 30);
        Product phone = new Product("Phone", 10000L, 60);

        Cart cartA = new Cart(userA);
        Cart cartB = new Cart(userB);
        Cart cartC = new Cart(userC);
        Cart cartD = new Cart(userD);
        Cart cartE = new Cart(userE);
        cartA.addCart(book);
        cartB.addCart(book, phone);
        cartC.addCart(book, computer, phone);
        cartD.addCart(computer, phone);

        System.out.println("cartA = " + cartA);
        System.out.println("cartB = " + cartB);
        System.out.println("cartC = " + cartC);
        System.out.println("cartD = " + cartD);
        System.out.println();
        System.out.println();
        // 금액 기준 결제 (회원 )
        PaymentService pricePaymentService = new PaymentService(new PriceDiscount());
//        Long pricePayA = pricePaymentService.pay(userA, cartA);
//        Long pricePayB = pricePaymentService.pay(userB, cartB);
//        Long pricePayC = pricePaymentService.pay(userC, cartC);
//        Long pricePayD = pricePaymentService.pay(userD, cartD);
//        Long pricePayE = pricePaymentService.pay(userE, cartE);

        // 퍼센트 기준 결제 (임직원)
        PaymentService percentPaymentService = new PaymentService(new PercentDiscount());
//        Long percentPayA = percentPaymentService.pay(userA, cartA);
//        Long percentPayB =percentPaymentService.pay(userB, cartB);
//        Long percentPayC =percentPaymentService.pay(userC, cartC);
//        Long percentPayD =percentPaymentService.pay(userD, cartD);
//        Long percentPayE =percentPaymentService.pay(userE, cartE);

        System.out.println(userA.getName()+", 할인 전 결제 총액 : " + cartA.getTotalPrice() +" 원 입니다.");
        getMaximunDiscountPrice(pricePaymentService.pay(userA, cartA),
                percentPaymentService.pay(userA, cartA));

        System.out.println(userB.getName()+", 할인 전 결제 총액 : " + cartB.getTotalPrice() +" 원 입니다.");
        getMaximunDiscountPrice(pricePaymentService.pay(userB, cartB),
                percentPaymentService.pay(userB, cartB));

        System.out.println(userC.getName()+", 할인 전 결제 총액 : " + cartC.getTotalPrice() +" 원 입니다.");
        getMaximunDiscountPrice(pricePaymentService.pay(userC, cartC),
                percentPaymentService.pay(userC, cartC));

        System.out.println(userD.getName()+", 할인 전 결제 총액 : " + cartD.getTotalPrice() +" 원 입니다.");
        getMaximunDiscountPrice(pricePaymentService.pay(userD, cartD),
                percentPaymentService.pay(userD, cartD));

        System.out.println(userE.getName()+", 할인 전 결제 총액 : " + cartE.getTotalPrice() +" 원 입니다.");
        getMaximunDiscountPrice(pricePaymentService.pay(userE, cartE),
                percentPaymentService.pay(userE, cartE));
    }

    public static void getMaximunDiscountPrice(Long priceDiscount, Long percentDiscount) {

        Long payPrice = Math.min(priceDiscount, percentDiscount);
        System.out.println("=======================================");
        System.out.println("최종 결제 금액은 "+ payPrice +" 원 입니다.");
        System.out.println("=======================================");
    }
}
