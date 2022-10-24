package study.design_pattern.behavior.state.laptop;

public class PowerOff implements PowerState {

    String curState = "꺼진";

    @Override
    public void powerPush() {
        System.out.println("전원이 켜집니다.");
        setCurState("켜진");
    }


    public void setCurState(String state) {
        this.curState = state;
    }
    @Override
    public String getCurState() {
        return this.curState;
    }

    @Override
    public void changeState(Laptop laptop) {
        laptop.setPowerState(new PowerOn());
    }
}
