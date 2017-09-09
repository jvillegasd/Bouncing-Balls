package BouncingBalls;

public class Physics {

    int x, y, vx, vy;

    public Physics(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public void move(int width, int height) {
        this.collide(width, height);
        this.x = this.x + this.vx;
        this.y = this.y + this.vy;
    }

    private void collide(int width, int height) {
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
}
