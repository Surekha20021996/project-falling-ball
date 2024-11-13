package game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Score {
    private int points;

    public Score() {
        this.points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + points, 10, 20);
    }
}
