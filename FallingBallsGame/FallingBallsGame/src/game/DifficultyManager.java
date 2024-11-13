package game;

public class DifficultyManager {
    public enum Level {
        EASY, MEDIUM, HARD
    }

    private Level difficultyLevel;
    private int ballSpeed;
    private int ballSpawnRate;
    private int bombSpawnRate;

    public DifficultyManager(Level level) {
        setDifficulty(level);
    }

    public void setDifficulty(Level level) {
        this.difficultyLevel = level;

        switch (level) {
            case EASY:
                ballSpeed = 3;
                ballSpawnRate = 1500; // milliseconds
                bombSpawnRate = 5000; // milliseconds
                break;
            case MEDIUM:
                ballSpeed = 5;
                ballSpawnRate = 1000;
                bombSpawnRate = 3000;
                break;
            case HARD:
                ballSpeed = 7;
                ballSpawnRate = 500;
                bombSpawnRate = 1500;
                break;
        }
    }

    public int getBallSpeed() {
        return ballSpeed;
    }

    public int getBallSpawnRate() {
        return ballSpawnRate;
    }

    public int getBombSpawnRate() {
        return bombSpawnRate;
    }

    public Level getDifficultyLevel() {
        return difficultyLevel;
    }
}
