package game;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    public static final int SIZE = 20;
    private int x, y;
    private int speed;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.speed = 3;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void move() {
        y += speed; // This line makes the ball fall down
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, SIZE, SIZE);
    }

    public boolean isClicked(int mouseX, int mouseY) {
        int centerX = x + SIZE / 2;
        int centerY = y + SIZE / 2;
        int distance = (int) Math.sqrt(Math.pow(mouseX - centerX, 2) + Math.pow(mouseY - centerY, 2));
        return distance <= SIZE / 2;
    }
}
