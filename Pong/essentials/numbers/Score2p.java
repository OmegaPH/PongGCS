package Pong.essentials.numbers;


import Pong.essentials.Pinapalo;

import java.applet.Applet;
import java.awt.*;

import static Pong.essentials.Pinapalo.outOfBounds;

public class Score2p extends Applet {
    Pinapalo b1 = new Pinapalo();
    int p1Score = 0;
    int p2Score = 0;
    String p1S;
    String p2S;
    Font fnt0 = new Font("Calibri", Font.BOLD, 50);

    public String p1ScoreCounter() {
        int x = b1.getX();
        if (x >= 675 && x <= 700) {
            //player 1 scores
            p1Score++;
        }
        return p1S = String.valueOf(p1Score);
    }

    public String p2ScoreCounter() {
        int x = b1.getX();
        if (x >= 24 && x <= 25) {
            //player 2 scores
            p2Score++;
        }
        return p2S = String.valueOf(p2Score);
    }

    public void scoreReset() {
        if (outOfBounds) {
            p2Score = 0;
            p1Score = 0;
        }
    }
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.setFont(fnt0);
        g.drawString(p1S, 195, 270);
        g.drawString(p2S, 475, 270);
    }
}


