package study.design_pattern.behavior.strategy;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    User user;
    List<Product> products = new ArrayList<>();

    public Cart() {
    }

    public Cart(User user) {
        this.user = user;
    }

    public Long getTotalPrice(){
        return products.stream().mapToLong(
                Product::getPrice
        ).sum();
    }

    public void addCart(Product ... productArray) throws Exception {
        for (Product product : productArray) {
            product.buy();
            products.add(product);
        }
    }
}
