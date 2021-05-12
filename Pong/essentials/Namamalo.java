package Pong.essentials;

import java.awt.*;

public class Namamalo implements Pamalo {
    double y, yVelocity; //y is location nung pamalo then yVelocity is speed niya
    boolean upX, downX; //is it moving up faster or down?
    int player, x; //this determines who is who (player 1 or 2)
    final double GRAVITY = 0.869; //nice
    int maxSpeed = (int) 5.5;
    int topBorder = 5;
    int bottomBorder = 415;

    public Namamalo(int player) {
        upX = false; downX = false;
        y = 210; yVelocity = 0; //will set the pamalo to the center and 0 means not moving
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
        if (upX) {
            yVelocity -= 2.2;
        }
        else if (downX) {
            yVelocity += 2.2;
        }
        else if (!upX && !downX) {
            yVelocity *= GRAVITY;
        }

        if (yVelocity >= maxSpeed) {
            yVelocity = maxSpeed;
        }
        else if (yVelocity <= maxSpeed*-1) {
            yVelocity = maxSpeed*-1;
        }

        y += yVelocity;

        if (y<topBorder) {
            y = topBorder;
        }
        if (y > bottomBorder) {
            y = bottomBorder;
        }
    }

    public void setUpX (boolean input) {
        upX = input;
    }
    public void setDownX (boolean input) {
        downX = input;
    }

    public int getY() {
        return (int) y;
    }
}
