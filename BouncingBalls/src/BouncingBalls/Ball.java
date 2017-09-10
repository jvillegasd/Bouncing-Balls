package BouncingBalls;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

    final static int RADIUS = 10;
    Color color;
    Physics physics;

    public Ball(int x, int y, int vx, int vy, Color color) {
        this.color = color;
        this.physics = new Physics(x, y, vx, vy);
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval(physics.x, physics.y, 2 * RADIUS, 2 * RADIUS);
    }

}
