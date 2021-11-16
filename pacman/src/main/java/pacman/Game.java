/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.Timer;

/**
 *
 * @author willian
 */
public class Game extends JFrame implements KeyListener {

    public Pac pac;
    public Stage stage;
    private Timer timer;
    public Rank rank;
    public String nome;
    public UserScore user;

    public static void main(String args[]) {
        Game game = new Game();
        game.start();
        Sound sound = new Sound();
        sound.song();

    }

    public Game() {
        super("Pacman Atari 2600 by Willian");

        user = new UserScore();
        pac = new Pac();
        rank = new Rank();
        nome = new String();
        stage = new Stage();

        Dimension d = new Dimension(800, 600);
        setMinimumSize(d);
        setMaximumSize(d);
        setSize(d);

        //stage
        stage.setSize(800, 600);
        stage.pac = pac;
        stage.rank = rank;
        stage.user = user;
        stage.bgcolor = new Color(16, 43, 237);
        stage.nome = nome;
        stage.rank = rank;
        stage.user = user;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(this);
        setVisible(true);
        add(stage);

    }

    public void start() {
        timer = new Timer(33, stage);
        timer.start();
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        /**
         * Aqui começa a movimentação com o uso das teclas W A S D e Setas
         */

        //cima------------------------------------------------------------------
        if (e.getKeyCode() == 87 || e.getKeyCode() == 38) {
            // se o pac estiver andando para direita ou esquerda 
            // ele só pode ir para cima se possuir um buraco

            Rectangle avatarCima = new Rectangle(pac.x - 3, pac.y - 30 - pac.vely, pac.width + 9, pac.height);

            boolean naoPodeMoverCima = false;
            for (Block b : stage.blocks) {
                Rectangle block = new Rectangle(b.x, b.y, b.width, b.height);
                if (avatarCima.intersects(block)) {
                    naoPodeMoverCima = true;
                    break;
                }
            }

            if (pac.velx != 0) {
                if (naoPodeMoverCima == false) {
                    pac.velx = 0;
                    pac.vely = -5;
                    pac.ang1 = 120;
                    pac.ang2 = 300;
                }
            } else {
                if (pac.vely == 0) {
                    if (naoPodeMoverCima == false) {
                        pac.velx = 0;
                        pac.vely = -5;
                        pac.ang1 = 120;
                        pac.ang2 = 300;
                    }
                } else {
                    pac.velx = 0;
                    pac.vely = -5;
                    pac.ang1 = 120;
                    pac.ang2 = 300;
                }
            }
        } //baixo---------------------------------------------------------------
        else if (e.getKeyCode() == 83 || e.getKeyCode() == 40) {
            Rectangle avatarBaixo = new Rectangle(pac.x - 3, pac.y + 30 - pac.vely, pac.width + 9, pac.height);
            boolean naoPodeMoverBaixo = false;
            for (Block b : stage.blocks) {
                Rectangle block = new Rectangle(b.x, b.y, b.width, b.height);
                if (avatarBaixo.intersects(block)) {
                    naoPodeMoverBaixo = true;
                    break;
                }
            }

            if (pac.velx != 0) {
                if (naoPodeMoverBaixo == false) {
                    pac.velx = 0;
                    pac.vely = 5;
                    pac.ang1 = 300;
                    pac.ang2 = 300;
                }
            } else {
                if (pac.vely == 0) {
                    if (naoPodeMoverBaixo == false) {
                        pac.velx = 0;
                        pac.vely = 5;
                        pac.ang1 = 300;
                        pac.ang2 = 300;
                    }
                } else {
                    pac.velx = 0;
                    pac.vely = 5;
                    pac.ang1 = 300;
                    pac.ang2 = 300;
                }
            }
        } //esquerda------------------------------------------------------------
        else if (e.getKeyCode() == 65 || e.getKeyCode() == 37) {
            Rectangle avatarEsquerda = new Rectangle(pac.x - 30 - pac.velx, pac.y - 3, pac.width, pac.height + 9);
            boolean naoPodeMoverEsquerda = false;
            for (Block b : stage.blocks) {
                Rectangle block = new Rectangle(b.x, b.y, b.width, b.height);
                if (avatarEsquerda.intersects(block)) {
                    naoPodeMoverEsquerda = true;
                    break;
                }
            }

            if (pac.vely != 0) {
                if (naoPodeMoverEsquerda == false) {
                    pac.velx = -5;
                    pac.vely = 0;
                    pac.ang1 = 210;
                    pac.ang2 = 300;
                }
            } else {
                if (pac.velx == 0) {
                    if (naoPodeMoverEsquerda == false) {
                        pac.velx = -5;
                        pac.vely = 0;
                        pac.ang1 = 210;
                        pac.ang2 = 300;
                    }
                } else {
                    pac.velx = -5;
                    pac.vely = 0;
                    pac.ang1 = 210;
                    pac.ang2 = 300;
                }
            }

        } //direita-------------------------------------------------------------
        else if (e.getKeyCode() == 68 || e.getKeyCode() == 39) {
            Rectangle avatarDireita = new Rectangle(pac.x + 30 - pac.velx, pac.y - 3, pac.width, pac.height + 9);
            boolean naoPodeMoverDireita = false;
            for (Block b : stage.blocks) {
                Rectangle block = new Rectangle(b.x, b.y, b.width, b.height);
                if (avatarDireita.intersects(block)) {
                    naoPodeMoverDireita = true;
                    break;
                }
            }

            if (pac.vely != 0) {
                if (naoPodeMoverDireita == false) {
                    pac.velx = 5;
                    pac.vely = 0;
                    pac.ang1 = 30;
                    pac.ang2 = 300;
                }
            } else {
                if (pac.velx == 0) {
                    if (naoPodeMoverDireita == false) {
                        pac.velx = 5;
                        pac.vely = 0;
                        pac.ang1 = 30;
                        pac.ang2 = 300;
                    }
                } else {
                    pac.velx = 5;
                    pac.vely = 0;
                    pac.ang1 = 30;
                    pac.ang2 = 300;
                }
            }

            /**
             * Aqui acaba a movimentação com o uso das teclas W A S D e Setas
             */
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
