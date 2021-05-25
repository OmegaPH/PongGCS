package Pong.essentials.numbers;


import Pong.essentials.Pinapalo;

import java.applet.Applet;
import java.awt.*;

public class Score extends Applet {
    Pinapalo b1 = new Pinapalo();
    int p1Score = 0;
    int p2Score = 0;
    String p1S;
    String p2S;
    Font fnt0 = new Font("Calibri", Font.BOLD, 50);

    public String p1ScoreCounter() {
        int x = b1.getX();
        if (x >= 678 && x <= 680) {
            //player 1 scores
            p1Score++;
        }
        return p1S = String.valueOf(p1Score);
    }

    public String p2ScoreCounter() {
        int x = b1.getX();
        if (x >= 15 && x <= 20) {
            //player 2 scores
            p2Score++;
        }
        return p2S = String.valueOf(p2Score);
    }

    public void draw(Graphics g) {

            g.setColor(Color.ORANGE);

        g.setFont(fnt0);
        g.drawString(p1S, 195, 270);
        g.drawString(p2S, 475, 270);
    }
}


