package Pong.screens;

import Pong.essentials.Main;
import Pong.essentials.numbers.TimerClock;

import java.applet.Applet;
import java.awt.*;

public class SingleGameOver extends Applet {
    TimerClock timerClock = new TimerClock();
    String time;
    Font fnt0 = new Font("Calibri", Font.ITALIC | Font.BOLD, 65);
    public Rectangle yesBtn = new Rectangle(100, 300, 200, 50);
    public Rectangle noBtn = new Rectangle(400, 300, 200, 50);

    public void paint(Graphics g) {
        time = timerClock.getTimerScoreFinal();
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.white);
        g.setFont(fnt0);
        g.drawString("YOUR SCORE", 188,150);
        g.setColor(Color.green);
        g.drawString(time, 235,200);
        g.setColor(Color.gray);
        g2d.draw(yesBtn);
        g2d.draw(noBtn);
    }
}
