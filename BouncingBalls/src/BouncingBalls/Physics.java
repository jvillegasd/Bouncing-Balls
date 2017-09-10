package BouncingBalls;

import java.util.List;

public class Physics {

    int x, y, vx, vy;

    public Physics(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public void move(int width, int height, List balls) {
        this.collision(width, height, balls);
        this.x = this.x + this.vx;
        this.y = this.y + this.vy;
    }

    private void collision(int width, int height, List balls) {
        this.wallCollision(width, height);
        this.ballsCollision(width, height, balls);
    }
    
    private void wallCollision(int width, int height){
        if (this.x - 1 < 0) {
            this.vx *= -1;
            this.x = 3;
        }
        if (this.x > width - 37) {
            this.x = width - 37;
            this.vx *= -1;
        }
        if (this.y - 2 < 0) {
            this.vy *= -1;
            this.y = 3;
        }
        if (this.y > height - 62) {
            this.vy *= -1;
            this.y = height - 62;
        }
    }
    
    private void ballsCollision(int width, int height, List balls){
        
    }
}
