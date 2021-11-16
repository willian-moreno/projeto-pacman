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
public class Boost extends Piece {

    public boolean eaten = false;

    public Boost() {
        this.x = 20;
        this.y = 40;
        this.width = 20;
        this.height = 20;
        this.color = new Color(166, 234, 142);
    }

    public void eaten() {
        eaten = true;
    }

    @Override
    public void draw(Graphics g) {
        /**
         * Frutas Boost
         */
        if (!eaten) {
            g.setColor(color);
            g.fillOval(x, y, width, height);
            g.setColor(new Color(16, 43, 237));
            g.fillOval(x+5, y+5, width/2, height/2);
        }
        /**
         * Fim Frutas Boost
         */

    }
}
