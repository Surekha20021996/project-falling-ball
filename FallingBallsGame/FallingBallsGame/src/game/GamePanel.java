package game;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    private ArrayList<Ball> balls;
    private ArrayList<Bomb> bombs;
    private Timer gameTimer;
    private Timer ballSpawnTimer;
    private Timer bombSpawnTimer;
    private Timer countdownTimer; // New countdown timer
    private Random random;
    private Score score;
    private int timeRemaining; // Game duration in seconds
    private DifficultyManager difficultyManager;

    public GamePanel(DifficultyManager.Level difficultyLevel) {
        balls = new ArrayList<>();
        bombs = new ArrayList<>();
        random = new Random();
        score = new Score();
        timeRemaining = 30; // Game duration in seconds

        difficultyManager = new DifficultyManager(difficultyLevel);

        // Initialize main game timer
        gameTimer = new Timer(30, this); // Main game timer for smooth animation

        // Ball and bomb spawn timers with adjustable rates based on difficulty
        ballSpawnTimer = new Timer(difficultyManager.getBallSpawnRate(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewBall();
            }
        });
        bombSpawnTimer = new Timer(difficultyManager.getBombSpawnRate(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewBomb();
            }
        });

        // Countdown timer to handle game duration
        countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                System.out.println("Time remaining: " + timeRemaining); // Debug statement
                if (timeRemaining <= 0) {
                    countdownTimer.stop();
                    gameTimer.stop();
                    ballSpawnTimer.stop();
                    bombSpawnTimer.stop();
                    System.out.println("Game Over! Final Score: " + score.getPoints());
                }
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleClick(e.getX(), e.getY());
            }
        });
    }

    public void startGame() {
        System.out.println("Starting game...");
        gameTimer.start();
        ballSpawnTimer.start();
        bombSpawnTimer.start();
        countdownTimer.start(); // Start the countdown timer
        addNewBall(); // Initial ball to start
    }

    private void addNewBall() {
        int x = random.nextInt(getWidth() - Ball.SIZE);
        int y = 0;
        Ball ball = new Ball(x, y);
        ball.setSpeed(difficultyManager.getBallSpeed());
        balls.add(ball);
    }

    private void addNewBomb() {
        int x = random.nextInt(getWidth() - Bomb.SIZE);
        int y = 0;
        Bomb bomb = new Bomb(x, y);
        bomb.setSpeed(difficultyManager.getBallSpeed());
        bombs.add(bomb);
    }

    private void handleClick(int mouseX, int mouseY) {
        Iterator<Ball> iterator = balls.iterator();
        while (iterator.hasNext()) {
            Ball ball = iterator.next();
            if (ball.isClicked(mouseX, mouseY)) {
                iterator.remove();
                score.addPoints(10);
                break;
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        for (Ball ball : balls) {
            ball.draw(g);
        }

        for (Bomb bomb : bombs) {
            bomb.draw(g);
        }

        score.draw(g);

        g.setColor(Color.WHITE);
        g.drawString("Time: " + timeRemaining, getWidth() - 100, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Ball ball : balls) {
            ball.move();
        }
        for (Bomb bomb : bombs) {
            bomb.move();
        }
        repaint();
    }
}
