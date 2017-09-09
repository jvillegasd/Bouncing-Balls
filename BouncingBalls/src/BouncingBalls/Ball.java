package BouncingBalls;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

    int radius;
    int x;
    int y;
    int vx;
    int vy;
    int var = 0;
    int var2 = 0;
    Color color;

    public Ball(int radius, int x, int y, int vx, int vy, Color color) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval(x, y, 2 * this.radius, 2 * this.radius);
    }

    public void move(int width, int height) {
        if (this.x - 1 < 0) {
            this.vx *= -1;
            this.x = 3;
        }
        if (this.x > width - (58 + var2)) {
            this.x = width - (58 + var2);
            this.vx *= -1;
        }
        if (this.y - 2 < 0) {
            this.vy *= -1;
            this.y = 3;
        }
        if (this.y > height - (62 + var)) {
            this.vy *= -1;
            this.y = height - (62 + var);
        }
        this.x = this.x + this.vx;
        this.y = this.y + this.vy;
    }

    public void setVar() {
        String radius = this.radius + "";
        if (radius.length() > 1) {
            if (Integer.parseInt(radius.substring(0, 1)) > 1) {
                var = this.radius;
            }
            if (Integer.parseInt(radius.substring(0, 1)) == 1) {
                var2 = -21;
            }
        }
    }
}
