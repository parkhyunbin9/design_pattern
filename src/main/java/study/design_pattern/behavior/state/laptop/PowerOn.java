package study.design_pattern.behavior.state.laptop;

public class PowerOn implements PowerState{

    String curState = "켜진";

    @Override
    public void powerPush() {
        System.out.println("전원이 꺼집니다.");
        setCurState("꺼진");

    }

    public void setCurState(String state) {
        this.curState =state;
    }
    @Override
    public String getCurState() {
        return this.curState;
    }

    @Override
    public void changeState(Laptop laptop) {
        laptop.setPowerState(new PowerOff());
    }


}
