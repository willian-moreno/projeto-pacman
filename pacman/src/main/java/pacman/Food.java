/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author willian
 */
public class Food extends Piece {

    public boolean eaten = false;
    
    public Food food;

    public Food() {
        this.x = 25;
        this.y = 25;
        this.width = 10;
        this.height = 10;
        this.color = Color.ORANGE;
        
    }

    public void eaten() {
        eaten = true;
    }

    @Override
    public void draw(Graphics g) {
        if (!eaten) {
            g.setColor(color);
            g.fillOval(x, y, width, height);
        }
    }
}
