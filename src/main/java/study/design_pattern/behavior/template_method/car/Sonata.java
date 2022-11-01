package study.design_pattern.behavior.template_method.car;

public class Sonata extends CarTemplate{
    public Sonata(String wheelSize, String mission, String color) {
        this.wheelSize = wheelSize;
        this.mission = mission;
        this.color = color;
        this.brand = "현대";
    }

    @Override
    public void setWheelSize(String size) {
        this.wheelSize = size;
        System.out.println("선택된 바퀴 사이즈는 "+ size +" 입니다.");
    }

    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.println("선택된 색상은 "+ color +" 입니다.");
    }

    @Override
    public void setMission(String mission) {
        this.mission = mission;
        System.out.println("선택된 미션은 "+ mission +" 입니다.");
    }

    @Override
    public void setBrand(String brand) {
        System.out.println("선택된 브랜드는 "+ brand +" 입니다.");
    }
}
