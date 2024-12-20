package org.dcistudent;

import java.util.Random;

class Board {
    private final char[][] grid;

    public Board(int width, int height) {
        this.grid = new char[height][width];
        this.initializeBoard();
    }

    private void initializeBoard() {
        Random random = Randomizer.getInstance();
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                if (random.nextDouble() < 0.2) {
                    this.grid[i][j] = '*'; // Power-up
                    continue;
                }
                this.grid[i][j] = '.'; // Dot
            }
        }
    }

    public void render(PacMan pacMan, Ghost[] ghosts, int score) {
        char[][] tempGrid = new char[this.grid.length][this.grid[0].length];

        // Copy board to temp grid
        for (int i = 0; i < this.grid.length; i++) {
            System.arraycopy(this.grid[i], 0, tempGrid[i], 0, this.grid[i].length);
        }

        // Place Pac-Man and Ghosts
        tempGrid[pacMan.getY()][pacMan.getX()] = 'P';
        for (Ghost ghost : ghosts) {
            tempGrid[ghost.getY()][ghost.getX()] = 'G';
        }

        // Render the board
        System.out.println("Score: " + score);
        for (char[] row : tempGrid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public char getCell(int x, int y) {
        return this.grid[y][x];
    }

    public void clearCell(int x, int y) {
        this.grid[y][x] = ' ';
    }
}