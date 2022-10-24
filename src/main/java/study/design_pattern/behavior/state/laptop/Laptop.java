package study.design_pattern.behavior.state.laptop;

import lombok.Data;

@Data
public class Laptop {

    String user;
    PowerState powerState;

    protected Laptop() {}

    public Laptop(String user) {
        this.user = user;
    }

    public Laptop(PowerState powerState) {
        this.powerState = powerState;
    }

    public void powerPush() {
        powerState.powerPush();
        powerState.changeState(this);
    }

    public void powerPushBefore() {
        powerState.powerPush();
    }


    public void getStatus() {
        System.out.println("현재 전원은 "+ powerState.getCurState() +" 상태 입니다.");

    }



}
