import javax.swing.JFrame;
import game.GamePanel;
import game.DifficultyManager;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Falling Balls Game");
        GamePanel gamePanel = new GamePanel(DifficultyManager.Level.MEDIUM);

        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        gamePanel.startGame();
    }
}
