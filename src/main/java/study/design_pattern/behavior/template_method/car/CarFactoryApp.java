package study.design_pattern.behavior.template_method.car;

public class CarFactoryApp {
    public static void main(String[] args) {
        Sonata firstCar = new Sonata("18", "수동", "블랙");
        firstCar.setColor("red");
        K5 secondCar = new K5("18", "쥐색");

        firstCar.buildCar();
        secondCar.buildCar();
    }
}
