package Pong.screens;
//screen while recording score in 1player game mode

import Pong.essentials.Main;
import Pong.essentials.numbers.TimerClock;

import java.applet.Applet;
import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

import static Pong.essentials.Main.playerMove;

public class Recording1p extends Applet {
    TimerClock time = new TimerClock();
    Font fnt0 = new Font("Comic Sans MS", Font.ITALIC | Font.BOLD, 50);
    Rectangle box = new Rectangle(285, 350, 125, 50);
    //public static boolean clickedOk = false;
    private String username;
    private String finalTime;
    private HashMap<String, String> RawScore = new HashMap();

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.WHITE);
        g.setFont(fnt0);
        g.drawString("ENTER USERNAME", 115, 300);

        g2d.draw(box);
        g.setColor(Color.GREEN);
        g.drawString("OK", 311, 390);

    }

   /* public HashMap<String, String> enterName() {
        if (playerMove || Main.State == Main.STATE.SINGLEGO2) {
            finalTime = time.getTimerScoreFinal();
            username = String.valueOf(JOptionPane.showInputDialog(null, "ENTER USERNAME", "Save Score", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("loggers"), null, ""));
            RawScore.put(username, finalTime);
            playerMove = false;
            if (username != null) {
                clickedOk = true;
                username = null;
            }
        }
        return RawScore;
    }

    public boolean getClickedOk() {
        return clickedOk;
    }
    */
}








