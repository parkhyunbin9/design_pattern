package study.design_pattern.behavior.state.laptop;

public interface PowerState {
    String curState = null;

    void powerPush();

    String getCurState();

    void changeState(Laptop laptop);
}
