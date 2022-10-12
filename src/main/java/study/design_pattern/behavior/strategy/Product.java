package study.design_pattern.behavior.strategy;

import lombok.Data;

@Data
public class Product {

    private String name;
    private Long price;
    private int stock;

    protected Product(){}

    public Product(String name, Long price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void buy() throws Exception {
        if (stock >= 1) {
            this.stock -= 1;
            return;
        }
        throw new Exception("재고 부족");
    }

}
