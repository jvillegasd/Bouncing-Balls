package BouncingBalls;

import java.awt.Color;
import java.awt.Graphics;

public class World {
    int width;
    int height;
    Color color;

    public World(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillRect(0, 0, this.width, this.height);
    }
    
    public void refresh(int width, int height){
        this.height = height;
        this.width = width;
    }
}
