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
 *
 * @author willian
 */
public class Ghost extends PieceMove {

    public boolean attack;
    public int transparenciaGhost = 200;

    public Ghost() {
        this.x = 385;
        this.y = 188;
        this.width = 30;
        this.height = 30;
        this.attack = true;
        this.velx = 5;
        this.vely = 5;
    }

    public void kill(Object pac) {
    }

    public void eaten() {
    }

    public void Ghost() {
    }

    /*
    public Collide collideGhost(Block b) { // Método de colisão do Ghost    Ps: Mantive por valor sentimental...
        Collide c = new Collide();

        for (int i = 0; i < 2; i++) { // For da colisão do ghost e do block
            int p1x, p1y, p2x, p2y, p3x, p3y, p4x, p4y;
            int b1x, b1y, b2x, b2y, b3x, b3y, b4x, b4y;
            if (i == 0) { // Colisão do ghost em Relação aos Blocks
                // Pontos de colisão do ghost
                p1x = this.x;// Canto superior esquerdo
                p1y = this.y;

                p2x = this.x + this.width;// Canto superior direito
                p2y = this.y;

                p3x = this.x + this.width;// Canto inferior direito
                p3y = this.y + this.height;

                p4x = this.x; // Canto inferior esquerdo
                p4y = this.y + this.height;

                // Pontos de colisão do(s) bloco(s)
                b1x = b.x;// Canto superior esquerdo
                b1y = b.y;

                b2x = b.x + b.width; // canto superior direito
                b2y = b.y;

                b3x = b.x + b.width;// Canto inferior direito
                b3y = b.y + b.height;

                b4x = b.x;// Canto inferior esquerdo
                b4y = b.y + b.height;

                // Calculo de distancia entre os blocos
                int d1x = p1x - b2x; // Distancia (X) do P1x até o B2x
                int d1y = p1y - b4y; // e etc... \_(º-º)_/
                int d2x = b1x - p2x;
                int d2y = p2y - b3y;
                int d3x = b4x - p3x;
                int d3y = b2y - p3y;
                int d4x = p4x - b3x;
                int d4y = b2y - p4y;

                // ghost ponto 1 (X,Y) Canto superior esquerdo
                if (p1x >= b1x && p1x <= b2x) {
                    if (p1y >= b1y && p1y <= b4y) {
                        if (velx == -5) {   // Ponto1 X
                            this.x = x - d1x + 5;
                            this.velx = 0;
                        }
                        if (vely == -5) {  // Ponto1 Y
                            this.y = y - d1y + 5;
                            this.vely = 0;
                        }
                    }
                }

                // ghost ponto 2 (X,Y) Canto superior direito
                if (p2x >= b1x && p2x <= b2x) {
                    if (p2y >= b1y && p2y <= b4y) {
                        if (velx == 5) {    // Ponto2 X
                            this.x = x + d2x - 5;
                            this.velx = 0;
                        }
                        if (vely == -5) {  // Ponto2 Y
                            this.y = y - d2y + 5;
                            this.vely = 0;
                        }
                    }
                }
                // ghost ponto 3 (X,Y) Canto inferior direito
                if (p3x >= b1x && p3x <= b2x) {
                    if (p3y >= b1y && p3y <= b4y) {
                        if (velx == 5) {    // Ponto3 X
                            this.x = x + d3x - 5;
                            this.velx = 0;
                        }
                        if (vely == 5) {   // Ponto3 Y
                            this.y = y + d3y - 5;
                            this.vely = 0;
                        }
                    }
                }
                // ghost ponto 4 (X,Y) Canto inferior esquerdo
                if (p4x >= b1x && p4x <= b2x) {
                    if (p4y >= b1y && p4y <= b4y) {
                        if (velx == -5) {   // Ponto4 X
                            this.x = x - d4x + 5;
                            this.velx = 0;
                        }
                        if (vely == 5) {   // Ponto4 Y
                            this.y = y + d4y - 5;
                            this.vely = 0;
                        }
                    }
                }
            } else { // Colisão dos Blocks em relção ao ghost

                b1x = this.x;// Canto superior esquerdo
                b1y = this.y;

                b2x = this.x + this.width;// Canto superior direito
                b2y = this.y;

                b3x = this.x + this.width;// Canto inferior direito
                b3y = this.y + this.height;

                b4x = this.x; // Canto inferior esquerdo
                b4y = this.y + this.height;

                // Pontos de colisão do(s) bloco(s)
                p1x = b.x;// Canto superior esquerdo
                p1y = b.y;

                p2x = b.x + b.width; // canto superior direito
                p2y = b.y;

                p3x = b.x + b.width;// Canto inferior direito
                p3y = b.y + b.height;

                p4x = b.x;// Canto inferior esquerdo
                p4y = b.y + b.height;

                // Calculo de distancia entre os blocos
                int d1x = b2x - p1x; // Distancia (X) do P1x até o B2x
                int d1y = b4y - p1y; // e etc... \_(º-º)_/
                int d2x = p2x - b1x;
                int d2y = b3y - p2y;
                int d3x = p3x - b4x;
                int d3y = p3y - b2y;
                int d4x = b3x - p4x;
                int d4y = p4y - b2y;

                // Block ponto 1 (X,Y) Canto superior esquerdo
                if (p1x >= b1x && p1x <= b2x) {
                    if (p1y >= b1y && p1y <= b4y) {
                        if (velx == 5) {   // Ponto1 X
                            this.x = x - d1x + 5;
                            this.velx = 0;
                        }
                        if (vely == 5) {  // Ponto1 Y
                            this.y = y - d1y + 5;
                            this.vely = 0;
                        }
                        return c;
                    }
                }
                // Block ponto 2 (X,Y) Canto superior direito
                if (p2x >= b1x && p2x <= b2x) {
                    if (p2y >= b1y && p2y <= b4y) {
                        if (velx == -5) {    // Ponto2 X
                            this.x = x + d2x - 5;
                            this.velx = 0;
                        }
                        if (vely == 5) {  // Ponto2 Y
                            this.y = y - d2y + 5;
                            this.vely = 0;
                        }
                        return c;
                    }
                }
                // Block ponto 3 (X,Y) Canto inferior direito
                if (p3x >= b1x && p3x <= b2x) {
                    if (p3y >= b1y && p3y <= b4y) {
                        if (velx == -5) {    // Ponto3 X
                            this.x = x + d3x - 5;
                            this.velx = 0;
                        }
                        if (vely == -5) {   // Ponto3 Y
                            this.y = y + d3y - 5;
                            this.vely = 0;
                        }
                        return c;
                    }
                }
                // Block ponto 4 (X,Y) Canto inferior esquerdo
                if (p4x >= b1x && p4x <= b2x) {
                    if (p4y >= b1y && p4y <= b4y) {
                        if (velx == 5) {   // Ponto4 X
                            this.x = x - d4x + 5;
                            this.velx = 0;
                        }
                        if (vely == -5) {   // Ponto4 Y
                            this.y = y + d4y - 5;
                            this.vely = 0;
                        }
                        return c;
                    }
                }
            }
        }
        return c; // Retornando os valores
    }
     */
    public Collide collideBlock3(Block blocks) {
        Collide c = new Collide();

        for (int i = 0; i < 2; i++) {
            int g1x, g1y, g2x, g2y, g3x, g3y, g4x, g4y;
            int b1x, b1y, b2x, b2y, b3x, b3y, b4x, b4y;

            if (i == 0) {
                // Ghost
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

                // BLOCK
                // ponto 1
                b1x = blocks.x;
                b1y = blocks.y;
                // ponto 2
                b2x = blocks.x + blocks.width;
                b2y = blocks.y;
                // ponto 3
                b3x = blocks.x + blocks.width;
                b3y = blocks.y + blocks.height;
                // ponto 4
                b4x = blocks.x;
                b4y = blocks.y + blocks.height;
            } else {
                // Ghost
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
                g1x = this.x - 5;
                g1y = this.y - 5;
                // ponto 2
                g2x = this.x + this.width + 5;
                g2y = this.y - 5;
                // ponto 3
                g3x = this.x + this.width + 5;
                g3y = this.y + this.height + 5;
                // ponto 4
                g4x = this.x - 5;
                g4y = this.y + this.height + 5;
            }

            // CHECAR PONTO1
            if (g1x >= b1x && g1x <= b2x) {
                if (g1y >= b1y && g1y <= b4y) {
                    c.c = true;

                    if (velx == 5) {
                        c.dx = b2x - g1x + 5;
                        this.velx = 0;
                    }
                    if (vely == 5) {
                        c.dy = b4y - g1y + 5;
                        this.vely = 0;
                    }

                    return c;
                }
            }

            // CHECAR PONTO2
            if (g2x >= b1x && g2x <= b2x) {
                if (g2y >= b1y && g2y <= b4y) {
                    c.c = true;

                    if (velx == -5) {
                        c.dx = ((g2x - b1x) * -1) - 5;
                        this.velx = 0;
                    }
                    if (vely == 5) {
                        c.dy = (b4y - g2y) + 5;
                        this.vely = 0;
                    }

                    return c;
                }
            }

            // CHECAR PONTO3
            if (g3x >= b1x && g3x <= b2x) {
                if (g3y >= b1y && g3y <= b4y) {
                    c.c = false;

                    if (velx == -5) {
                        c.dx = ((g3x - b1x) * -1) - 5;
                        this.velx = 0;
                    }
                    if (vely == -5) {
                        c.dy = ((g3y - b2y) * -1) - 5;
                        this.vely = 0;
                    }

                    return c;
                }
            }

            // CHECAR PONTO4
            if (g4x >= b1x && g4x <= b2x) {
                if (g4y >= b1y && g4y <= b4y) {
                    c.c = true;

                    if (velx == 5) {
                        c.dx = (b2x - g4x) + 5;
                        this.velx = 0;
                    }
                    if (vely == -5) {
                        c.dy = (g4y - b2y) - 5;
                        this.vely = 0;
                    }

                    return c;
                }
            }
        }

        return c;
    }

    /*
    public Collide collideBlock3(Block block) {
        Collide c = new Collide();

        // ghost
        Rectangle recGhost = new Rectangle(x, y, width, height);

        // blocka
        int bx = block.x;
        int by = block.y;
        Rectangle recBlock = new Rectangle(bx, by, block.width, block.height);

        if (recGhost.intersects(recBlock)) {
            if (velx > 0) {
                if (c.c == true) {
                    int dx = (x + width) - (block.x);
                    c.dx = dx;
                    velx = 0;
                } else {
                    velx = 5;
                }
            } else if (velx < 0) {
                if (c.c == true) {
                    int dx = (x - (block.x + block.width));
                    c.dx = dx;
                    velx = 0;
                } else {
                    velx = 5;
                }
            }

            if (vely > 0) {
                if (c.c == true) {
                    int dx = (y + height) - (block.y);
                    c.dy = dx;
                    vely = 0;
                } else {
                    velx = 5;
                }
            } else if (vely < 0) {
                if (c.c == true) {
                    int dx = (y - (block.y + block.height));
                    c.dy = dx;
                    vely = 0;
                } else {
                    velx = 5;
                }
            }
            c.c = true;
            return c;
        }

        return c;
    }
     */
    @Override
    public void draw(Graphics g) {
        /**
         * Ghost
         */
        g.setColor(color);
        g.fillArc(x, y + 4, width, height - 6, 180, -180);
        g.fillRect(x, y + 16, 30, 16);

        // olhos
        //esquerdo
        g.setColor(new Color(255, 255, 255, transparenciaGhost));
        g.fillArc(x + 5, y + 12, 9, 9, 135, 180);
        //direito
        g.fillArc(x + 16, y + 12, 9, 9, 225, 175);

        for (int saia = 0; saia < 3; saia++) {
            g.setColor(color);
            g.fillArc(x + saia * 10, y + 27, 10, 10, 180, 180);
        }

        // boca
        g.setColor(new Color(255, 255, 255, transparenciaGhost));
        g.fillArc(x + 10, y + 25, 9, 9, 195, -210);

        //Chapéu----------------------------------------------------------------
        g.setColor(new Color(0, 0, 0, transparenciaGhost));
        g.fillArc(x + 2, y - 1, 26, 13, 180, -180);
        g.fillRect(x, y + 7, 30, 4);
        g.fillOval(x - 2, y + 7, 4, 3);
        g.fillOval(x + 28, y + 7, 4, 3);
        g.setColor(new Color(255, 255, 255, transparenciaGhost));
        g.fillRect(x + 2, y + 5, 27, 2);

        /**
         * Fim Ghost
         */
    }

    public void move() {
        int a = (int) (Math.random() * 4);
        switch (a) {
            case 0:
                if (velx == 0 && vely == 0) {
                    velx = 5;
                }
                break;
            case 1:
                if (velx == 0 && vely == 0) {
                    velx = 5 * (-1);
                }
                break;
            case 2:
                if (velx == 0 && vely == 0) {
                    vely = 5;
                }
                break;
            case 3:
                if (velx == 0 && vely == 0) {
                    vely = 5 * (-1);
                }
                break;
            default:
        }

        if (velx != 0 || vely != 0) {
            this.x = this.x + this.velx;
            this.y = this.y + this.vely;
        }
    }
}
