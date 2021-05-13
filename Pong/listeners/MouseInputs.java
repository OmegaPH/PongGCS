package Pong.listeners;

import Pong.essentials.Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInputs implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) { //where the mouse is pressed
        int mx = e.getX();
        int my = e.getY();
        //System.out.println(mx + " " + my);
        if (Main.State == Main.State.MENU) {
            if (mx >= 250 && mx <= 450) {
                if (my >= 200 && my <= 250) {
                    //Pressed Play Button
                    Main.State = Main.State.MODE;
                }
            }
            if (mx >= 250 && mx <= 450) {
                if (my >= 300 && my <= 350) {
                    //Pressed Exit Button
                    System.exit(0);
                }
            }
        } else if (Main.State == Main.STATE.MODE) {
            if (mx >= 250 && mx <= 450) {
                if (my >= 300 && my <= 350) {
                    Main.State = Main.STATE.PLAYING;
                }
            }
            if (mx >= 250 && mx <= 450) {
                if (my >= 200 && my <= 250) {
                    Main.State = Main.STATE.SINGLE;
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }


    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
