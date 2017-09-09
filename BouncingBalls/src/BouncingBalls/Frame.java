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
    Thread motor;

    public Frame() {
        this.setTitle("Bouncing Balls");
        this.setSize(400, 400);
        this.canvas = new Canvas();
        this.setLayout(new BorderLayout());
        this.add(this.canvas, BorderLayout.CENTER);
        for (int i = 0; i < 100; i++) {
            Color color = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
            balls.add(new Ball(10, (int)(Math.random()*getHeight()), (int)(Math.random()*getWidth()), 8, 4, color));
            balls.get(i).setVar();
        }
        this.world = new World(this.getWidth(), this.getHeight(), Color.BLACK);    
        this.motor = new Thread(new Runnable() {
            @Override
            public void run() {
                canvas.createBufferStrategy(3);
                try {
                    while (true) {
                        Graphics g = canvas.getBufferStrategy().getDrawGraphics();                        
                        world.refresh(getWidth(), getHeight());
                        world.draw(g);
                        for(Ball ball: balls){
                            ball.move(getWidth(), getHeight());
                            ball.draw(g);
                        }
                        canvas.getBufferStrategy().show();
                        Thread.sleep(10);
                    }
                } catch (Exception e) {
                }
            }

        });
    }

}
