package game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class TimerManager {
    private int timeRemaining;

    public TimerManager(int startTime) {
        this.timeRemaining = startTime;
    }

    public void decrementTime() {
        if (timeRemaining > 0) {
            timeRemaining--;
        }
    }

    public boolean isTimeUp() {
        return timeRemaining <= 0;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Time: " + timeRemaining, 700, 20);
    }
}
