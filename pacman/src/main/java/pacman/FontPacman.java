/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

/**
 *
 * @author Willian
 */
public class FontPacman {

    public Font carregarFonte(String pCaminhoFonte, int tipoFonte, int pTamanhoFonte) {
        Font minhaFonte = null;

        try {
            minhaFonte = Font.createFont(
                    Font.TRUETYPE_FONT, getClass().getResourceAsStream(pCaminhoFonte)
            ).deriveFont(tipoFonte, pTamanhoFonte);

        } catch (IOException | FontFormatException ex) {
            ex.printStackTrace();
        }
        return minhaFonte;
    }
    
    FontPacman fontePacman = new FontPacman();
    Font fontePacmanRG = fontePacman.carregarFonte("src/main/resources/fontes/Retro Gaming.ttf", Font.TRUETYPE_FONT, 36);
}
