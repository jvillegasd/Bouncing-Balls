package BouncingBalls;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class Frame extends JFrame {

    public Canvas canvas;
    public List<Ball> balls = new ArrayList<Ball>();
    World world;
    Thread engine;

    public Frame() {
        this.setTitle("Bouncing Balls");
        this.setSize(400, 400);
        this.canvas = new Canvas();
        this.setLayout(new BorderLayout());
        this.add(this.canvas, BorderLayout.CENTER);
        for (int i = 0; i < 10; i++) {
            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            int x = (int) (Math.random() * getWidth());
            int y = (int) (Math.random() * getHeight());
            int vx = (int) (Math.random() * 11) + 1;
            int vy = (int) (Math.random() * 11) + 1;
            Color color = new Color(r, g, b);
            balls.add(new Ball(x, y, vx, vy, color));
        }
        this.world = new World(this.getWidth(), this.getHeight(), Color.BLACK);
        this.engine = new Thread(new Runnable() {
            @Override
            public void run() {
                canvas.createBufferStrategy(3);
                try {
                    while (true) {
                        Graphics g = canvas.getBufferStrategy().getDrawGraphics();
                        world.refresh(getWidth(), getHeight());
                        world.draw(g);
                        for (Ball ball : balls) {
                            ball.physics.move(getWidth(), getHeight(), balls);
                            ball.draw(g);
                        }
                        canvas.getBufferStrategy().show();
                        Thread.sleep(13);
                    }
                } catch (Exception e) {
                }
            }

        });
    }

}
