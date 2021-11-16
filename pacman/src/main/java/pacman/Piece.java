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
public abstract class Piece {
    public int x;
    public int y;
    public int width;
    public int height;
    public Color color;
    public Color coloreyes;
    
    public abstract void draw(Graphics g);
}
