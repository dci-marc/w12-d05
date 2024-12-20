package org.dcistudent;

class PacMan {
    private int x;
    private int y;
    private int invincibleTurns;

    public PacMan(int x, int y) {
        this.x = x;
        this.y = y;
        this.invincibleTurns = 0;
    }

    public void move(char direction, int width, int height) {
        switch (direction) {
            case 'U': if (this.y > 0) this.y--; break;
            case 'D': if (this.y < height - 1) this.y++; break;
            case 'L': if (this.x > 0) this.x--; break;
            case 'R': if (this.x < width - 1) this.x++; break;
            default: System.out.println("Invalid move!");
        }
    }

    public boolean isInvincible() {
        return this.invincibleTurns > 0;
    }

    public void setInvincible(boolean invincible) {
        this.invincibleTurns = invincible ? 5 : 0; // Invincibility lasts for 5 turns
    }

    public void reduceInvincibility() {
        if (this.invincibleTurns > 0) this.invincibleTurns--;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}