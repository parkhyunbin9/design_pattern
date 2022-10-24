package study.design_pattern.behavior.state.mediaPlayer;

public class demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
