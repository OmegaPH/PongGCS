package Pong.essentials.numbers;

import Pong.essentials.Main;
import Pong.essentials.Namamalo;
import Pong.essentials.Pinapalo;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static Pong.essentials.Main.playerMove;
import static Pong.essentials.Pinapalo.outOfBounds;


public class TimerClock extends Applet {
    private int elapsedTime = 0;
    private int miliseconds = 0;
    private int seconds = 0;
    private int minutes = 0;
    final private String zero = "00:00.00";
    private String miliseconds_string = String.format("%02d", miliseconds);
    private String seconds_string = String.format("%02d", seconds);
    private String minutes_string = String.format("%02d", minutes);
    private String timerOutput = " ";
    static String timerScoreFinal = " ";
    Font fnt0 = new Font("Calibri", Font.BOLD, 50);

    Timer timer = new Timer(1, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            elapsedTime =+ elapsedTime + 1;
            miliseconds = elapsedTime % 100;
            seconds = (elapsedTime / 100) % 60;
            minutes = (elapsedTime / 6000) % 60;
            miliseconds_string = String.format("%02d", miliseconds);
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            timerOutput = minutes_string + ":" + seconds_string + "." + miliseconds_string;
        }
    });

    public void startTimer() {
        if (playerMove == true) {
            timer.start();
        } else if (!playerMove){
            timer.stop();
            elapsedTime = 0;
            miliseconds = 0;
            seconds = 0;
            minutes = 0;
            miliseconds_string = String.format("%02d", miliseconds);
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
        }
    }

    public void isGameOver() {
        if (outOfBounds) {
            timerScoreFinal = timerOutput;
            Main.State = Main.STATE.SINGLEGO;
            outOfBounds = false;
        }
    }

    public void draw (Graphics g) {
        if (!playerMove) { //ensures that the timer will be at 0 at the start
            g.setColor(Color.WHITE);
            g.setFont(fnt0);
            g.drawString(zero, 257, 350);
        }
        else if (playerMove) { //prints the running timer as soon as player moves
            g.setColor(Color.WHITE);
            g.setFont(fnt0);
            g.drawString(timerOutput, 257, 350);
        }
    }

    public String getTimerScoreFinal() {
        return timerScoreFinal;
    }
}
