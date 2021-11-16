/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Graphics;

/**
 *
 * @author willian
 */

public abstract class PieceMove extends Piece {

    public int velx;
    public int vely;
    public int ang1;
    public int ang2;
    public int sprite = 1;

    public void move() {

    }

    private void ress() {

    }

    @Override
    public void draw(Graphics g) {
    }
}
