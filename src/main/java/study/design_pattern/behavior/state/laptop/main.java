package study.design_pattern.behavior.state.laptop;

public class main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop(new PowerOff());
        laptop.powerPush();
        laptop.getStatus();

        System.out.println("========= 다시 한번 전원 버튼 누름 =======");
        laptop.powerPush();
        laptop.getStatus();
/**
*        laptop을 실행하는 컨텍스트가  현재 상황을 알아야함
*         -> 각 상태에 따른 상태 전환은 콘텍스트에서도 할 수 있지만 ,
*         각 상태, 클라이언트에서 수행 가능
*
*        laptop.powerPushBefore();
*        laptop.setPowerState(new PowerOff());
*        laptop.getStatus();
*
*        laptop.powerPushBefore();
*        laptop.setPowerState(new PowerOn());
*/        laptop.getStatus();


    }
}
