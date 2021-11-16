/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.plaf.FontUIResource;

/**
 * @author willian
 */
public class Stage extends JComponent implements ActionListener {
    Sound sound = new Sound();
    Ghost ghost = new Ghost();
    Food food = new Food();
    Boost bost = new Boost();
    Block bloco = new Block();

    public Color bgcolor;
    public List<Block> blocks;
    public List<Ghost> ghosts;
    public List<Food> foods;
    public List<Boost> boost;
    public Pac pac;
    public Rank rank;
    public String nome;
    public UserScore user;

    public Stage() {
        createGhosts();
        createFoods();
        createBoosts();
        createBlocks();
    }

    public void createGhosts() {

        ghosts = new ArrayList<>();
        /**
         * Aqui começa os Ghosts------------------------------------------------
         */
        ghosts = new ArrayList<>();
        Ghost g1 = new Ghost();
        g1.color = new Color(104, 249, 137, ghost.transparenciaGhost);
        g1.x = ghost.x;
        g1.y = ghost.y;
        ghosts.add(g1);

        Ghost g2 = new Ghost();
        g2.color = (new Color(210, 105, 30, ghost.transparenciaGhost));
        g2.x = ghost.x;
        g2.y = ghost.y;
        ghosts.add(g2);

        Ghost g3 = new Ghost();
        g3.color = (new Color(0, 0, 0, ghost.transparenciaGhost));
        g3.x = ghost.x;
        g3.y = ghost.y;
        ghosts.add(g3);

        Ghost g4 = new Ghost();
        g4.color = (new Color(255, 0, 0, ghost.transparenciaGhost));
        g4.x = ghost.x;
        g4.y = ghost.y;
        ghosts.add(g4);

        Ghost g5 = new Ghost();
        g5.color = (new Color(75, 0, 130, ghost.transparenciaGhost));
        g5.x = ghost.x;
        g5.y = ghost.y;
        ghosts.add(g5);
        /**
         * Aqui acaba os Ghosts
         */
    }

    public void createFoods() {
        foods = new ArrayList<>();
        /**
         * Aqui começa os Foods-------------------------------------------------
         */
        //parte esq. 1 linha
        foods = new ArrayList<>();
        for (int food1 = 0; food1 < 8; food1++) {
            Food f1 = new Food();
            f1.color = food.color;
            f1.x = 24 + food1 * 35;
            f1.y = 30;
            f1.width = food.width;
            f1.height = food.height;
            foods.add(f1);

            //parte esq. 4 linha
            Food f2 = new Food();
            f2.color = food.color;
            f2.x = 24 + food1 * 35;
            f2.y = 145;
            f2.width = food.width;
            f2.height = food.height;
            foods.add(f2);

            //parte esq. 7 linha
            Food f3 = new Food();
            f3.color = food.color;
            f3.x = 24 + food1 * 35;
            f3.y = 260;
            f3.width = food.width;
            f3.height = food.height;
            foods.add(f3);

            //parte esq. 10 linha
            Food f4 = new Food();
            f4.color = food.color;
            f4.x = 24 + food1 * 35;
            f4.y = 375;
            f4.width = food.width;
            f4.height = food.height;
            foods.add(f4);

            //parte dir. 1 linha
            Food f5 = new Food();
            f5.color = food.color;
            f5.x = 511 + food1 * 35;
            f5.y = 30;
            f5.width = food.width;
            f5.height = food.height;
            foods.add(f5);

            //parte dir. 4 linha
            Food f6 = new Food();
            f6.color = food.color;
            f6.x = 511 + food1 * 35;
            f6.y = 145;
            f6.width = food.width;
            f6.height = food.height;
            foods.add(f6);

            //parte dir. 7 linha
            Food f7 = new Food();
            f7.color = food.color;
            f7.x = 511 + food1 * 35;
            f7.y = 260;
            f7.width = food.width;
            f7.height = food.height;
            foods.add(f7);

            //parte dir. 10 linha
            Food f8 = new Food();
            f8.color = food.color;
            f8.x = 511 + food1 * 35;
            f8.y = 375;
            f8.width = food.width;
            f8.height = food.height;
            foods.add(f8);
        }

        for (int food1 = 0; food1 < 4; food1++) {
            //parte meio. 1 linha
            Food f9 = new Food();
            f9.color = food.color;
            f9.x = 338 + food1 * 35;
            f9.y = 30;
            f9.width = food.width;
            f9.height = food.height;
            foods.add(f9);

            //parte meio. 4 linha
            Food f10 = new Food();
            f10.color = food.color;
            f10.x = 338 + food1 * 35;
            f10.y = 145;
            f10.width = food.width;
            f10.height = food.height;
            foods.add(f10);

            //parte meio. 7 linha
            Food f11 = new Food();
            f11.color = food.color;
            f11.x = 338 + food1 * 35;
            f11.y = 260;
            f11.width = food.width;
            f11.height = food.height;
            foods.add(f11);

            //parte meio. 10 linha
            Food f12 = new Food();
            f12.color = food.color;
            f12.x = 338 + food1 * 35;
            f12.y = 375;
            f12.width = food.width;
            f12.height = food.height;
            foods.add(f12);
        }

        for (int food1 = 0; food1 < 13; food1++) {
            //parte meio. 3 linha
            Food f13 = new Food();
            f13.color = food.color;
            f13.x = 181 + food1 * 35;
            f13.y = 87;
            f13.width = food.width;
            f13.height = food.height;
            foods.add(f13);

            //parte meio. 9 linha
            Food f14 = new Food();
            f14.color = food.color;
            f14.x = 181 + food1 * 35;
            f14.y = 317;
            f14.width = food.width;
            f14.height = food.height;
            foods.add(f14);

        }

        for (int food1 = 0; food1 < 6; food1++) {
            //parte meio. 15 linha
            Food f15 = new Food();
            f15.color = food.color;
            f15.x = 181 + food1 * 35;
            f15.y = 432;
            f15.width = food.width;
            f15.height = food.height;
            foods.add(f15);

            //parte meio. 15 linha
            Food f16 = new Food();
            f16.color = food.color;
            f16.x = 426 + food1 * 35;
            f16.y = 432;
            f16.width = food.width;
            f16.height = food.height;
            foods.add(f16);
        }

        for (int food1 = 0; food1 < 4; food1++) {
            //parte esquerda. 3 linha
            Food f17 = new Food();
            f17.color = food.color;
            f17.x = 24 + food1 * 35;
            f17.y = 87;
            f17.width = food.width;
            f17.height = food.height;
            foods.add(f17);

            //parte esquerda. 9 linha
            Food f18 = new Food();
            f18.color = food.color;
            f18.x = 24 + food1 * 35;
            f18.y = 203;
            f18.width = food.width;
            f18.height = food.height;
            foods.add(f18);

            //parte esquerda. 12 linha
            Food f19 = new Food();
            f19.color = food.color;
            f19.x = 24 + food1 * 35;
            f19.y = 317;
            f19.width = food.width;
            f19.height = food.height;
            foods.add(f19);

            //parte esquerda. 15 linha
            Food f20 = new Food();
            f20.color = food.color;
            f20.x = 24 + food1 * 35;
            f20.y = 432;
            f20.width = food.width;
            f20.height = food.height;
            foods.add(f20);

            //parte dir. 3 linha
            Food f21 = new Food();
            f21.color = food.color;
            f21.x = 655 + food1 * 35;
            f21.y = 87;
            f21.width = food.width;
            f21.height = food.height;
            foods.add(f21);

            //parte dir. 9 linha
            Food f22 = new Food();
            f22.color = food.color;
            f22.x = 655 + food1 * 35;
            f22.y = 203;
            f22.width = food.width;
            f22.height = food.height;
            foods.add(f22);

            //parte dir. 12 linha
            Food f23 = new Food();
            f23.color = food.color;
            f23.x = 655 + food1 * 35;
            f23.y = 317;
            f23.width = food.width;
            f23.height = food.height;
            foods.add(f23);

            //parte dir. 15 linha
            Food f24 = new Food();
            f24.color = food.color;
            f24.x = 655 + food1 * 35;
            f24.y = 432;
            f24.width = food.width;
            f24.height = food.height;
            foods.add(f24);
        }

        for (int food1 = 0; food1 < 6; food1++) {
            //parte meio. 15 linha
            Food f25 = new Food();
            f25.color = food.color;
            f25.x = 170 + food1 * 35;
            f25.y = 203;
            f25.width = food.width;
            f25.height = food.height;
            foods.add(f25);

            //parte meio. 15 linha
            Food f26 = new Food();
            f26.color = food.color;
            f26.x = 437 + food1 * 35;
            f26.y = 203;
            f26.width = food.width;
            f26.height = food.height;
            foods.add(f26);
        }
        /**
         * Aqui acaba os Foods
         */
    }

    public void createBoosts() {
        boost = new ArrayList<>();
        /**
         * Aqui começa os Boosts------------------------------------------------
         */
        boost = new ArrayList<>();
        Boost bo1 = new Boost();
        bo1.color = bost.color;
        bo1.x = 25;
        bo1.y = 50;
        boost.add(bo1);

        Boost bo2 = new Boost();
        bo2.color = bost.color;
        bo2.x = 760;
        bo2.y = 50;
        boost.add(bo2);

        Boost bo3 = new Boost();
        bo3.color = bost.color;
        bo3.x = 25;
        bo3.y = 400;
        boost.add(bo3);

        Boost bo4 = new Boost();
        bo4.color = bost.color;
        bo4.x = 760;
        bo4.y = 400;
        boost.add(bo4);
        /**
         * Aqui acaba os Boosts
         */
    }

    public void createBlocks() {
        blocks = new ArrayList<>();
        /**
         * Aqui Começa o labirinto----------------------------------------------
         */
        // bloco cima
        Block b1 = new Block();
        b1.width = 800;
        b1.height = 10;
        b1.x = 0;
        b1.y = 0;
        b1.color = bloco.color;

        blocks.add(b1);
        // bloco baixo
        Block b2 = new Block();
        b2.width = 800;
        b2.height = 10;
        b2.x = 0;
        b2.y = 465;
        b2.color = bloco.color;

        blocks.add(b2);
        // bloco lado esquerdo
        Block b3 = new Block();
        b3.width = 10;
        b3.height = 465;
        b3.x = 0;
        b3.y = 10;
        b3.color = bloco.color;

        blocks.add(b3);
        //block lado direito
        Block b4 = new Block();
        b4.width = 10;
        b4.height = 465;
        b4.x = 790;
        b4.y = 10;
        b4.color = bloco.color;

        blocks.add(b4);

        //traço 1
        for (int block = 0; block < 3; block++) {
            Block b5 = new Block();
            b5.x = 0;
            b5.y = 115 + block * 115;
            b5.width = 50;
            b5.height = 10;
            b5.color = bloco.color;
            blocks.add(b5);

            Block b6 = new Block();
            b6.x = 750;
            b6.y = 115 + block * 115;
            b6.width = 50;
            b6.height = 10;
            b6.color = bloco.color;
            blocks.add(b6);
        }

        //traço 2
        for (int block = 0; block < 4; block++) {
            Block b7 = new Block();
            b7.x = 60;
            b7.y = 58 + block * 115;
            b7.width = 40;
            b7.height = 10;
            b7.color = bloco.color;
            blocks.add(b7);

            Block b8 = new Block();
            b8.x = 700;
            b8.y = 58 + block * 115;
            b8.width = 40;
            b8.height = 10;
            b8.color = bloco.color;
            blocks.add(b8);
        }

        //traço 3            
        for (int block = 0; block < 3; block++) {
            Block b9 = new Block();
            b9.x = 100;
            b9.y = 115 + block * 115;
            b9.width = 58;
            b9.height = 10;
            b9.color = bloco.color;
            blocks.add(b9);

            Block b10 = new Block();
            b10.x = 640;
            b10.y = 115 + block * 115;
            b10.width = 58;
            b10.height = 10;
            b10.color = bloco.color;
            blocks.add(b10);
        }

        //traço 4
        for (int block = 0; block < 4; block++) {
            Block b11 = new Block();
            b11.x = 214;
            b11.y = 58 + block * 115;
            b11.width = 40;
            b11.height = 10;
            b11.color = bloco.color;
            blocks.add(b11);

            Block b12 = new Block();
            b12.x = 545;
            b12.y = 58 + block * 115;
            b12.width = 40;
            b12.height = 10;
            b12.color = bloco.color;
            blocks.add(b12);
        }

        //traço 5
        for (int block = 0; block < 3; block++) {
            Block b13 = new Block();
            b13.x = 214;
            b13.y = 115 + block * 115;
            b13.width = 100;
            b13.height = 10;
            b13.color = bloco.color;
            blocks.add(b13);

            Block b14 = new Block();
            b14.x = 486;
            b14.y = 115 + block * 115;
            b14.width = 100;
            b14.height = 10;
            b14.color = bloco.color;
            blocks.add(b14);
        }

        //traço 6 meio
        for (int block = 0; block < 4; block++) {
            Block b15 = new Block();
            b15.x = 370;
            b15.y = 58 + block * 115;
            b15.width = 60;
            b15.height = 10;
            b15.color = bloco.color;
            blocks.add(b15);
        }

        for (int block = 0; block < 3; block++) {
            Block b16 = new Block();
            b16.x = 370;
            b16.y = 115 + block * 115;
            b16.width = 60;
            b16.height = 10;
            b16.color = bloco.color;
            blocks.add(b16);
        }

        //barra 1
        for (int block = 0; block < 4; block++) {
            Block b17 = new Block();
            b17.x = 152;
            b17.y = 57 + block * 115;
            b17.width = 13;
            b17.height = 68;
            b17.color = bloco.color;
            blocks.add(b17);

            Block b18 = new Block();
            b18.x = 635;
            b18.y = 57 + block * 115;
            b18.width = 13;
            b18.height = 68;
            b18.color = bloco.color;
            blocks.add(b18);
        }

        //barra 2
        for (int block = 0; block < 4; block++) {
            Block b19 = new Block();
            b19.x = 304;
            b19.y = 0 + block * 115;
            b19.width = 13;
            b19.height = 68;
            b19.color = bloco.color;
            blocks.add(b19);

            Block b20 = new Block();
            b20.x = 483;
            b20.y = 0 + block * 115;
            b20.width = 13;
            b20.height = 68;
            b20.color = bloco.color;
            blocks.add(b20);
        }

        //barra 3
        for (int block = 0; block < 1; block++) {
            Block b21 = new Block();
            b21.x = 370;
            b21.y = 180 + block * 115;
            b21.width = 10;
            b21.height = 60;
            b21.color = bloco.color;
            blocks.add(b21);

            Block b22 = new Block();
            b22.x = 420;
            b22.y = 180 + block * 115;
            b22.width = 10;
            b22.height = 60;
            b22.color = bloco.color;
            blocks.add(b22);
        }
        /**
         * fim labirinto com for Aqui acaba o labirinto
         */

    }

    public void win() {

    }

    public void gameOver() {

    }

    private void base(Graphics g) {
        /**
         * Background Color
         */
        // fundo
        g.setColor(new Color(16, 43, 237));
        g.fillRect(0, 0, getWidth(), getHeight());
        /**
         * Fim Background Color
         */

        // barra preta
        g.setColor(Color.BLACK);
        g.fillRect(0, 477, getWidth(), getHeight());

        // barra verde
        g.setColor(new Color(57, 159, 0));
        g.fillRect(0, 490, getWidth(), 40);

        // vidas
        for (int i = 0; i < pac.live; i++) {
            g.fillRect(50 + i * 31, 535, 20, 20);
        }

        // pontos
        g.setFont(new Font("Retro Gaming", Font.TRUETYPE_FONT, 36));
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(this.pac.score), (getWidth() / 2) + 40, 523);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //Base
        base(g);

        // desenhar os blocos
        for (Block b : this.blocks) {
            b.draw(g);
        }

        for (Food f : this.foods) {
            Collide d = pac.collideFood(f);
            if (d.c == true) {
                pac.score += 25;
            }
            f.draw(g);
        }

        // desenhar os boost
        for (Boost bo : this.boost) {
            Collide d = pac.collideBoost(bo);
            if (d.c == true) {
                pac.superPac();
            }
            bo.draw(g);
        }

        // desenhar o pac
        pac.draw(g);
        pac.move();

        for (Block b : this.blocks) {
            Collide d = pac.collideBlock(b);
            if (d.c == true) {
                pac.x = pac.x + d.dx;
                pac.y = pac.y + d.dy;
                break;
            }
        }

        // desenhar ghosts
        for (Ghost gh : this.ghosts) {
            gh.draw(g);
            gh.move();
            Collide d = pac.collideGhost(gh);
            if (pac.timeBoost == 0) {
                if (pac.live != 0) {
                    if (d.c == true) {
                        pac.live = pac.live - 1;
                        pac.x = 385;
                        pac.y = 425;
                    }
                }
            } else if (pac.timeBoost != 0) {
                if (d.c == true) {
                    gh.x = 385;
                    gh.y = 188;
                }
            }
            for (Block b : blocks) {
                gh.collideBlock3(b);
            }

        }

        /*
        //Retangulos de colisão pac
        g.setColor(Color.black);
        g.fillRect(pac.x - 3, pac.y - 30 - pac.vely, pac.width + 9, pac.height);
        g.fillRect(pac.x - 3, pac.y + 30 - pac.vely, pac.width + 9, pac.height);
        g.fillRect(pac.x - 30 - pac.velx, pac.y - 3, pac.width, pac.height + 9);
        g.fillRect(pac.x + 30 - pac.velx, pac.y - 3, pac.width, pac.height + 9);
         */
 /*
        //Retangulos de colisão ghost
        g.setColor(Color.black);
        g.fillRect(ghost.x - 3, ghost.y - 30 - ghost.vely, ghost.width + 9, ghost.height);
        g.fillRect(ghost.x - 3, ghost.y + 30 - ghost.vely, ghost.width + 9, ghost.height);
        g.fillRect(ghost.x - 30 - ghost.velx, ghost.y - 3, ghost.width, ghost.height + 9);
        g.fillRect(ghost.x + 30 - ghost.velx, ghost.y - 3, ghost.width, ghost.height + 9);
         */
        if (true) {
            //Score máximo é igual a 4050
            if (pac.score >= 4050 || pac.live == 0) {
                //Ghost
                ghost.velx = 0;
                ghost.vely = 0;
                //Pac
                pac.x = 385;
                pac.y = 425;
                pac.velx = 0;
                pac.vely = 0;
                //Pintar Janela Rank
                rank.paint(g);

                System.out.println(user.name);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
