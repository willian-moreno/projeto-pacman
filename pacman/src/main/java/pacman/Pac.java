/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author willian
 */
public class Pac extends PieceMove {

    public long timeBoost;
    public int killer;
    public int score;
    public int live;
    private int d = 1;

    public Pac() {
        this.live = 3;
        this.width = 30;
        this.height = 30;
        this.x = 385;
        this.y = 425;
        this.velx = 0;
        this.vely = 0;
        this.color = new Color(237, 235, 0);
        this.coloreyes = new Color(0, 0, 255);
        this.ang1 = 30;
        this.ang2 = 300;
    }

    public void eat(Food f) {
    }

    public void eat(Ghost g) {
    }

    public void eat(Boost b) {
    }

    public void die() {
    }

    public Collide collideGhost(Ghost ghosts) {
        Collide c = new Collide();

        for (int i = 0; i < 2; i++) {
            int p1x, p1y, p2x, p2y, p3x, p3y, p4x, p4y;
            int g1x, g1y, g2x, g2y, g3x, g3y, g4x, g4y;

            if (i == 0) {
                // PAC
                // ponto 1
                p1x = this.x;
                p1y = this.y;
                // ponto 2
                p2x = this.x + this.width;
                p2y = this.y;
                // ponto 3
                p3x = this.x + this.width;
                p3y = this.y + this.height;
                // ponto 4
                p4x = this.x;
                p4y = this.y + this.height;

                // Ghost
                // ponto 1
                g1x = ghosts.x;
                g1y = ghosts.y;
                // ponto 2
                g2x = ghosts.x + ghosts.width;
                g2y = ghosts.y;
                // ponto 3
                g3x = ghosts.x + ghosts.width;
                g3y = ghosts.y + ghosts.height;
                // ponto 4
                g4x = ghosts.x;
                g4y = ghosts.y + ghosts.height;
            } else {
                // PAC
                // ponto 1
                g1x = this.x;
                g1y = this.y;
                // ponto 2
                g2x = this.x + this.width;
                g2y = this.y;
                // ponto 3
                g3x = this.x + this.width;
                g3y = this.y + this.height;
                // ponto 4
                g4x = this.x;
                g4y = this.y + this.height;

                // Ghost
                // ponto 1
                p1x = ghosts.x;
                p1y = ghosts.y;
                // ponto 2
                p2x = ghosts.x + ghosts.width;
                p2y = ghosts.y;
                // ponto 3
                p3x = ghosts.x + ghosts.width;
                p3y = ghosts.y + ghosts.height;
                // ponto 4
                p4x = ghosts.x;
                p4y = ghosts.y + ghosts.height;
            }

            // CHECAR PONTO1
            if (p1x >= g1x && p1x <= g2x) {
                if (p1y >= g1y && p1y <= g4y) {
                    c.c = true;
                    System.out.println("Colidiu com ghost");
                    if (velx != 0) {
                        c.dx = g2x - p1x;
                    }
                    if (vely != 0) {
                        c.dy = g4y - p1y;
                    }

                    return c;
                }
            }

            // CHECAR PONTO2
            if (p2x >= g1x && p2x <= g2x) {
                if (p2y >= g1y && p2y <= g4y) {
                    c.c = true;
                    if (velx != 0) {
                        c.dx = ((p2x - g1x) * -1);
                    }
                    if (vely != 0) {
                        c.dy = (g4y - p2y);
                    }

                    return c;
                }
            }

            // CHECAR PONTO3
            if (p3x >= g1x && p3x <= g2x) {
                if (p3y >= g1y && p3y <= g4y) {
                    c.c = true;
                    if (velx != 0) {
                        c.dx = ((p3x - g1x) * -1);
                    }
                    if (vely != 0) {
                        c.dy = ((p3y - g2y) * -1);
                    }

                    return c;
                }
            }

            // CHECAR PONTO4
            if (p4x >= g1x && p4x <= g2x) {
                if (p4y >= g1y && p4y <= g4y) {
                    c.c = true;

                    if (velx != 0) {
                        c.dx = (g2x - p4x);
                    }
                    if (vely != 0) {
                        c.dy = (p4y - g2y);
                    }

                    return c;
                }
            }
        }

        return c;

    }

    /**
     * Colisão Pac e Block------------------------------------------------------
     */
    public Collide collideBlock(Block block) {
        Collide c = new Collide();

        for (int i = 0; i < 2; i++) {
            int p1x, p1y, p2x, p2y, p3x, p3y, p4x, p4y;
            int b1x, b1y, b2x, b2y, b3x, b3y, b4x, b4y;

            if (i == 0) {
                // PAC
                // ponto 1
                p1x = this.x;
                p1y = this.y;
                // ponto 2
                p2x = this.x + this.width;
                p2y = this.y;
                // ponto 3
                p3x = this.x + this.width;
                p3y = this.y + this.height;
                // ponto 4
                p4x = this.x;
                p4y = this.y + this.height;

                // BLOCK
                // ponto 1
                b1x = block.x;
                b1y = block.y;
                // ponto 2
                b2x = block.x + block.width;
                b2y = block.y;
                // ponto 3
                b3x = block.x + block.width;
                b3y = block.y + block.height;
                // ponto 4
                b4x = block.x;
                b4y = block.y + block.height;
            } else {
                // PAC
                // ponto 1
                b1x = this.x;
                b1y = this.y;
                // ponto 2
                b2x = this.x + this.width;
                b2y = this.y;
                // ponto 3
                b3x = this.x + this.width;
                b3y = this.y + this.height;
                // ponto 4
                b4x = this.x;
                b4y = this.y + this.height;

                // BLOCK
                // ponto 1
                p1x = block.x;
                p1y = block.y;
                // ponto 2
                p2x = block.x + block.width;
                p2y = block.y;
                // ponto 3
                p3x = block.x + block.width;
                p3y = block.y + block.height;
                // ponto 4
                p4x = block.x;
                p4y = block.y + block.height;
            }

            // CHECAR PONTO1
            if (p1x >= b1x && p1x <= b2x) {
                if (p1y >= b1y && p1y <= b4y) {
                    c.c = true;

                    if (velx != 0) {
                        c.dx = b2x - p1x + 6;
                        if (i == 1) {
                            c.dx = c.dx * -6;
                        }
                        this.velx = 0;

                    }
                    if (vely != 0) {
                        c.dy = b4y - p1y + 6;
                        if (i == 1) {
                            c.dy = c.dy * -6;
                        }
                        this.vely = 0;
                    }

                    return c;
                }
            }

            // CHECAR PONTO2
            if (p2x >= b1x && p2x <= b2x) {
                if (p2y >= b1y && p2y <= b4y) {
                    c.c = true;

                    if (velx != 0) {
                        c.dx = ((p2x - b1x) * -1) - 6;
                        if (i == 1) {
                            c.dx = c.dx * -6;
                        }
                        this.velx = 0;

                    }
                    if (vely != 0) {
                        c.dy = (b4y - p2y) + 6;
                        if (i == 1) {
                            c.dy = c.dy * -6;
                        }
                        this.vely = 0;

                    }

                    return c;
                }
            }

            // CHECAR PONTO3
            if (p3x >= b1x && p3x <= b2x) {
                if (p3y >= b1y && p3y <= b4y) {
                    c.c = true;

                    if (velx != 0) {
                        c.dx = ((p3x - b1x) * -1) - 6;
                        if (i == 1) {
                            c.dx = c.dx * -6;
                        }
                        this.velx = 0;

                    }
                    if (vely != 0) {
                        c.dy = ((p3y - b2y) * -1) - 6;
                        if (i == 1) {
                            c.dy = c.dy * -6;
                        }
                        this.vely = 0;

                    }

                    return c;
                }
            }

            // CHECAR PONTO4
            if (p4x >= b1x && p4x <= b2x) {
                if (p4y >= b1y && p4y <= b4y) {
                    c.c = true;

                    if (velx != 0) {
                        c.dx = (b2x - p4x) + 6;
                        if (i == 1) {
                            c.dx = c.dx * -6;
                        }
                        this.velx = 0;
                    }
                    if (vely != 0) {
                        c.dy = (p4y - b2y) - 6;
                        if (i == 1) {
                            c.dy = c.dy * -6;
                        }
                        this.vely = 0;

                    }

                    return c;
                }
            }
        }

        return c;
    }

    /**
     * Fim Colisão Pac e
     * Block------------------------------------------------------
     */
    /**
     * d
     * Colisão Pac e Food------------------------------------------------------
     */
    public Collide collideFood(Food foods) {
        Collide c = new Collide();
        if (foods.eaten == false) {

            // pac
            Rectangle recPac = new Rectangle(x, y, width, height);

            // Food
            int f1x = foods.x;
            int f1y = foods.y;
            Rectangle recFood = new Rectangle(f1x - 3, f1y - 3, foods.width + 6, foods.height + 6);

            if (recPac.intersects(recFood)) {
                foods.eaten();

                c.c = true;
                return c;
            }
        }

        return c;
    }

    /**
     * Fim Colisão Pac e
     * Food------------------------------------------------------
     */
    /**
     * Colisão Pac e Boost------------------------------------------------------
     */
    public Collide collideBoost(Boost boost) {
        Collide c = new Collide();
        if (boost.eaten == false) {

            // pac
            Rectangle recPac = new Rectangle(x, y, width, height);

            // Food
            int bo1x = boost.x;
            int bo1y = boost.y;
            Rectangle recFood = new Rectangle(bo1x, bo1y, boost.width, boost.height);

            if (recPac.intersects(recFood)) {
                boost.eaten();

                c.c = true;
                return c;
            }
        }

        return c;
    }

    /**
     * Fim Colisão Pac e
     * Boost------------------------------------------------------
     */
    @Override
    public void draw(Graphics g) {
        if ((System.currentTimeMillis() - timeBoost) > 10000) {
            timeBoost = 0;
        }

        /**
         * Aqui começa o Pac----------------------------------------------------
         */
        //Condições Boost-------------------------------------------------------
        if (timeBoost != 0) {
            if (sprite == 1) {
                this.color = Color.ORANGE;
            } else if (sprite == 2) {
                this.color = Color.RED;
            } else if (sprite == 3) {
                this.color = Color.YELLOW;
            } else {
                this.color = Color.DARK_GRAY;
            }
        } else if (this.score == 4050 || this.live <= 0) {
            if (sprite == 1) {
                this.color = Color.ORANGE;
            } else if (sprite == 2) {
                this.color = Color.YELLOW;
            } else if (sprite == 3) {
                this.color = Color.ORANGE;
            } else {
                this.color = Color.YELLOW;
            }
        } else {
            this.color = new Color(237, 235, 0);
        } 
        //Fim Condições Boost---------------------------------------------------

        if (velx == 0 && vely == 0) {
            if (this.live == 1 || this.live == 2 || this.live == 3) {
                g.setColor(color);
                g.fillArc(x, y, width, height, ang1, ang2);
                g.setColor(coloreyes);
                if (ang1 == 120 || ang1 == 300) {
                    g.fillOval(x + 5, y + 13, 5, 5);
                } else {
                    g.fillOval(x + 13, y + 5, 5, 5);
                }
            }
        } else if (velx > 0) {
            /**
             * Direita----------------------------------------------------------
             *
             */
            if (sprite == 1) {
                g.setColor(color);
                g.fillArc(x, y, width, height, 30, 300);

                g.setColor(Color.BLUE);
                g.fillOval(x + 13, y + 5, 5, 5);
            } else if (sprite == 2) {
                g.setColor(color);
                g.fillArc(x, y, width, height, 15, 315);

                g.setColor(Color.BLUE);
                g.fillOval(x + 13, y + 5, 5, 5);
            } else {
                g.setColor(color);
                g.fillArc(x, y, width, height, 0, 360);

                g.setColor(Color.BLUE);
                g.fillOval(x + 13, y + 5, 5, 5);
            }

        } else if (velx < 0) {
            /**
             * Esquerda---------------------------------------------------------
             *
             */
            if (sprite == 1) {
                g.setColor(color);
                g.fillArc(x, y, width, height, 210, 300);

                g.setColor(Color.BLUE);
                g.fillOval(x + 13, y + 5, 5, 5);
            } else if (sprite == 2) {
                g.setColor(color);
                g.fillArc(x, y, width, height, 195, 315);

                g.setColor(Color.BLUE);
                g.fillOval(x + 13, y + 5, 5, 5);
            } else {
                g.setColor(color);
                g.fillArc(x, y, width, height, 180, 360);

                g.setColor(Color.BLUE);
                g.fillOval(x + 13, y + 5, 5, 5);
            }
        } else if (vely > 0) {
            /**
             * Baixo------------------------------------------------------------
             *
             */
            if (sprite == 1) {
                g.setColor(color);
                g.fillArc(x, y, width, height, 300, 300);

                g.setColor(Color.BLUE);
                g.fillOval(x + 5, y + 13, 5, 5);
            } else if (this.sprite == 2) {
                g.setColor(color);
                g.fillArc(x, y, width, height, 285, 315);

                g.setColor(Color.BLUE);
                g.fillOval(x + 5, y + 13, 5, 5);
            } else {
                g.setColor(color);
                g.fillArc(x, y, width, height, 270, 360);

                g.setColor(Color.BLUE);
                g.fillOval(x + 5, y + 13, 5, 5);
            }

        } else if (vely < 0) {
            /**
             * Cima----------------------------------------------------------
             *
             */
            if (sprite == 1) {
                g.setColor(color);
                g.fillArc(x, y, width, height, 120, 300);

                g.setColor(Color.BLUE);
                g.fillOval(x + 5, y + 13, 5, 5);
            } else if (sprite == 2) {
                g.setColor(color);
                g.fillArc(x, y, width, height, 105, 315);

                g.setColor(Color.BLUE);
                g.fillOval(x + 5, y + 13, 5, 5);
            } else {
                g.setColor(color);
                g.fillArc(x, y, width, height, 90, 360);

                g.setColor(Color.BLUE);
                g.fillOval(x + 5, y + 13, 5, 5);
            }
        }
        this.d++;
        if (d > 1) {
            if (this.sprite == 1) {
                this.sprite = 2;
            } else if (this.sprite == 2) {
                this.sprite = 3;
            } else if (this.sprite == 3) {
                this.sprite = 1;
            }
            d = 0;
        }

    }

    /**
     * Aqui acaba o Pac
     */
    @Override
    public void move() {
        this.x = this.x + this.velx;
        this.y = this.y + this.vely;
    }

    public void superPac() {
        timeBoost = System.currentTimeMillis();// 10s em milliseconds 
    }
}
