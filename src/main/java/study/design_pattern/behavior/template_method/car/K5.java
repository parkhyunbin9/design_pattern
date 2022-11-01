package study.design_pattern.behavior.template_method.car;

public class K5 extends CarTemplate{
    public K5(String wheelSize, String color) {
        this.wheelSize = wheelSize;
        this.mission = "오토";
        this.color = color;
        this.brand = "기아";
    }

    @Override
    public void setWheelSize(String size) {
        System.out.println("선택된 바퀴 사이즈는 "+ size +" 입니다.");
    }

    @Override
    public void setColor(String color) {
        System.out.println("선택된 색상은 "+ color +" 입니다.");
    }

    @Override
    public void setMission(String mission) {
        System.out.println("선택된 미션은 "+ mission +" 입니다.");
    }

    @Override
    public void setBrand(String brand) {
        System.out.println("선택된 브랜드는 "+ brand +" 입니다.");
    }
}
