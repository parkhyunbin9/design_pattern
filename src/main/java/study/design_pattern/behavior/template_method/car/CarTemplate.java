package study.design_pattern.behavior.template_method.car;

public abstract class CarTemplate {

    String wheelSize;
    String mission;
    String color;
    String engine;
    String brand;

    public final void buildCar() {
        setWheelSize(wheelSize);
        setColor(color);
        setMission(mission);
        setEngine();

        System.out.println("차 완성! ");
        System.out.println("차 스펙 [엔진 : "+ engine+", 미션 : "+mission+",  휠 사이즈 : "+ wheelSize +", 색상 : "+color+", 브랜드 : "+brand+" ] ");
    }

    public final void setEngine() {
        engine = "1.6 가솔린";
        System.out.println("선택된 엔진은 : "+ engine + "입니다.");
    }

    public abstract void setWheelSize(String size);
    public abstract void setColor(String color);
    public abstract void setMission(String mission);
    public abstract void setBrand(String brand);

}
