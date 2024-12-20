package org.dcistudent;

import java.util.Random;

class Ghost {
    private int x;
    private int y;

    public Ghost(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveRandom(int width, int height) {
        Random random = Randomizer.getInstance();
        int direction = random.nextInt(4);
        switch (direction) {
            case 0: if (this.y > 0) this.y--; break; // Up
            case 1: if (this.y < height - 1) this.y++; break; // Down
            case 2: if (this.x > 0) this.x--; break; // Left
            case 3: if (this.x < width - 1) this.x++; break; // Right
            default: break;
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}