package game;

import java.awt.Color;
import java.awt.Graphics;

public class Bomb {
    public static final int SIZE = 20;
    private int x, y;
    private int speed;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
        this.speed = 3;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void move() {
        y += speed; // This line makes the bomb fall down
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, SIZE, SIZE);
    }
}
