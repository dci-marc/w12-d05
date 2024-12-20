package org.dcistudent;

import java.util.Scanner;

class Game {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private final Board board;
    private final PacMan pacMan;
    private final Ghost[] ghosts;
    private int score;
    private boolean isRunning;

    public Game() {
        this.board = new Board(WIDTH, HEIGHT);
        this.pacMan = new PacMan(WIDTH / 2, HEIGHT / 2);
        this.ghosts = new Ghost[] { new Ghost(0, 0), new Ghost(HEIGHT - 1, WIDTH - 1) };
        this.score = 0;
        this.isRunning = true;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (this.isRunning) {
            this.board.render(this.pacMan, this.ghosts, this.score);
            System.out.print("Move (U/D/L/R): ");
            char move = scanner.next().toUpperCase().charAt(0);

            // Move Pac-Man
            this.pacMan.move(move, WIDTH, HEIGHT);

            // Check for collisions
            if (this.checkCollision()) {
                System.out.println("Game Over! Final Score: " + this.score);
                this.isRunning = false;
                break;
            }

            // Check for dots or power-ups
            char currentCell = this.board.getCell(this.pacMan.getX(), this.pacMan.getY());
            if (currentCell == '.') {
                this.score += 10;
                this.board.clearCell(this.pacMan.getX(), this.pacMan.getY());
            } else if (currentCell == '*') {
                this.pacMan.setInvincible(true);
                this.board.clearCell(this.pacMan.getX(), this.pacMan.getY());
            }

            // Move Ghosts
            for (Ghost ghost : this.ghosts) {
                ghost.moveRandom(WIDTH, HEIGHT);
            }

            // Handle invincibility
            if (this.pacMan.isInvincible()) {
                this.pacMan.reduceInvincibility();
            }
        }
        scanner.close();
    }

    private boolean checkCollision() {
        for (Ghost ghost : this.ghosts) {
            if (this.pacMan.getX() == ghost.getX() && this.pacMan.getY() == ghost.getY()) {
                return !this.pacMan.isInvincible();
            }
        }
        return false;
    }
}