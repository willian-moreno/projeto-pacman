/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author willian
 */
public class Rank extends JComponent {

    UserScore u = new UserScore();
    
    public Pac pac;
    public int x = 300;
    public int y = 100;
    public int width;
    public int height;
    public Color color;
    public String player;
    public int score;
    public UserScore usScore[] = new UserScore[5];
    
    public Rank() {
    }

    public void loadData() {
        File file = new File("src/main/resources/saveplayers/ScoreAndName.txt");
        FileInputStream input;
        try {
            input = new FileInputStream(file);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            while (true) {
                int d = input.read();
                if (d == -1) {
                    break;
                }
                buffer.write(d);
            }
            String convertido = new String(buffer.toByteArray());

            String linhas[] = convertido.split("\n");

            int i = 0;
            for (String linha : linhas) {
                String coluna[] = linha.split(";");

                u.name = coluna[0];
                u.score = Integer.parseInt(coluna[1]);

                usScore[i] = u;
                i++;
                if (i > 4) {
                    break;
                }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void gravaNome() {
        while (player == null || player.equals("")) {
            player = JOptionPane.showInputDialog("Qual o seu nome?");
            if (player == null || player.equals("")) {
                JOptionPane.showMessageDialog(null, "Você não respondeu a pergunta.");
            }
        }
    }

    public void savegame() {

        File textgame = new File("src/main/resources/saveplayers/ScoreAndName.txt");
        FileOutputStream out;
        UserScore user = new UserScore();
        try {
            user.name = player;
            user.score = this.score;

            out = new FileOutputStream(textgame);
            out.write(user.name.getBytes());
            out.write(" = ".getBytes());
            out.write(String.valueOf(user.score).getBytes());
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Deu Ruim");
        } catch (IOException ex) {
            System.out.println("Deu Muito Ruim");
        }

    }

    public void returnGame() {
        
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(new Color(255, 255, 255, 150));
        g.fillRect(0, 0, 800, 477);

        //Borda fora------------------------------------------------------------
        g.setColor(new Color(241, 62, 0, 200));
        g.fillOval(x - 8, y - 8, 8, 8);
        g.fillOval(x + 200, y - 8, 8, 8);
        g.fillOval(x - 8, y + 200, 8, 8);
        g.fillOval(x + 200, y + 200, 8, 8);
        g.fillRect(x - 8, y - 5, 8, 209);
        g.fillRect(x + 200, y - 5, 8, 209);
        g.fillRect(x - 5, y - 8, 209, 8);
        g.fillRect(x - 5, y + 200, 209, 8);

        //Borda dentro----------------------------------------------------------
        g.setColor(Color.WHITE);
        g.fillOval(x - 4, y - 4, 8, 8);
        g.fillOval(x + 196, y - 4, 8, 8);
        g.fillOval(x - 4, y + 196, 8, 8);
        g.fillOval(x + 196, y + 196, 8, 8);
        g.fillRect(x - 4, y - 1, 4, 201);
        g.fillRect(x + 200, y - 1, 4, 201);
        g.fillRect(x - 1, y - 4, 201, 4);
        g.fillRect(x - 1, y + 200, 201, 4);

        //Fundo-----------------------------------------------------------------
        g.setColor(new Color(255, 255, 255, 200));
        g.fillRect(x, y, 200, 200);

        //Desenho Ghost---------------------------------------------------------        
        g.setColor(new Color(241, 62, 0));
        g.fillOval(x + 181, y + 180, 40, 40 - 6);
        g.fillRect(x + 181, y + 197, 40, 20);

        //olhos
        //esquerdo
        g.setColor(Color.WHITE);
        g.fillArc(x + 191, y + 189, 10, 10, 135, 180);
        //direito
        g.setColor(Color.WHITE);
        g.fillArc(x + 203, y + 189, 10, 10, 225, 175);
        //boca
        g.setColor(Color.WHITE);
        g.fillArc(x + 196, y + 206, 10, 5, 130, 270);
        //saia
        for (int saia = 0; saia < 4; saia++) {
            g.setColor(new Color(241, 62, 0));
            g.fillOval(x + 181 + saia * 10, y + 211, 10, 10);
        }

        //Desenho Pac-----------------------------------------------------------
        /*g.setColor(new Color(241, 62, 0));
        g.fillArc(x + 181, y + 181, 40, 38, 158, -316);
        g.setColor(Color.YELLOW);
        g.fillArc(x + 185, y + 185, 30, 30, 150, -300);
        g.setColor(Color.BLUE);
        g.fillOval(x + 197, y + 190, 5, 5);*/
        //Desenho Pac
        g.setColor(new Color(241, 62, 0, 200));
        g.fillArc(x - 19, y - 15, 38, 38, 30, 215);

        //corpo
        g.setColor(new Color(237, 235, 0));
        g.fillArc(x - 15, y - 11, 30, 30, 30, 300);
        //olhos        
        g.setColor(Color.BLUE);
        g.fillOval(x - 3, y - 6, 5, 5);

        //texto-----------------------------------------------------------------
        g.setColor(new Color(241, 62, 0));
        g.setFont(new Font("Retro Gaming", Font.TRUETYPE_FONT, 17));
        g.drawString("Rank Pacnautas", 310, 130);

        /*g.setColor(Color.BLACK);
        g.setFont(new Font("Retro Gaming", Font.TRUETYPE_FONT, 15));
        g.drawString(u.nome + " = " + u.score, 330, 160);*/

        int i = 0;
        if (usScore != null) {
            for (UserScore us : usScore) {
                if (g != null && us != null) {
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Retro Gaming", Font.TRUETYPE_FONT, 15));
                    g.drawString(u.name + " = " + u.score, 330, 160 + i);
                }
                i++;
            }
        }

    }

}
