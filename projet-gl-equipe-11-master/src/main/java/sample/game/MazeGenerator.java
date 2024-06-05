package sample.game;

import java.util.Random;

public class MazeGenerator {
    private final int width;
    private final int height;
    private final int[][] maze;

    public int[][] getMaze() {
        return maze;
    }

    public MazeGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        this.maze = new int[width][height];
    }

    public int[][] generateMaze() {
        Random random = new Random();
        int startX = 0;
        int startY = 0;
        maze[startX][startY] = 1;
        generateMaze(startX, startY);
        return maze;
    }

    private void generateMaze(int x, int y) {
        int[] directions = {1, 2, 3, 4};
        shuffleArray(directions);
        for (int direction : directions) {
            int newX = x;
            int newY = y;
            switch (direction) {
                case 1:
                    newY -= 2;
                    break;
                case 2:
                    newX += 2;
                    break;
                case 3:
                    newY += 2;
                    break;
                case 4:
                    newX -= 2;
                    break;
            }
            if (newX < 0 || newY < 0 || newX >= width || newY >= height || maze[newX][newY] != 0) {
                continue;
            }
            maze[newX][newY] = 1;
            maze[(newX + x) / 2][(newY + y) / 2] = 1;
            generateMaze(newX, newY);
        }
    }

    private void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
