package Pong.essentials;

import java.awt.*;

public class Bot implements Pamalo {
    double y, yVelocity; //y is location nung pamalo then yVelocity is speed niya
    boolean upX, downX; //is it moving up faster or down?
    int player, x; //this determines who is who (player 1 or 2)
    final double GRAVITY = 0.869; //nice
    int maxSpeed = (int) 5.5;
    int topBorder = 5;
    int bottomBorder = 415;
    Pinapalo b1;

    public Bot(int player, Pinapalo b) {
        upX = false; downX = false;
        y = 210; yVelocity = 0; //will set the pamalo to the center and 0 means not moving
        b1 = b;
        if (player == 1)
            x = 20;
        else
            x = 660;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, (int) y, 20, 80);
    }

    public void move() {
      y = b1.getY() - 40;

        if (y<topBorder) {
            y = topBorder;
        }
        if (y > bottomBorder) {
            y = bottomBorder;
        }
    }


    public int getY() {
        return (int) y;
    }
}
