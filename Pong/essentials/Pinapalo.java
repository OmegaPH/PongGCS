package Pong.essentials;
import com.sun.org.apache.xml.internal.serializer.NamespaceMappings;

import java.awt.*;


import static Pong.essentials.Main.playerMove;

public class Pinapalo {
    public static boolean outOfBounds = false;
    public static double xVelocity, yVelocity, x, y;

    public Pinapalo() {
        x = 350;
        y = 250;
        xVelocity = 3.5;
        yVelocity = 3;

    }

    public void playerCheck (Pamalo p1, Pamalo p2) { //checker for 2 player
        if (x <= 50) { // Width of Paddle + Radius of ball = 50
            if (y >= p1.getY() && y <= p1.getY()+79) { // Basing on the legnth of the paddle
                xVelocity = -xVelocity;
            }
        }
        else if (x >= 650){
            if (y >= p2.getY() && y <= p2.getY()+79) {
                xVelocity = -xVelocity;
            }

        }
    }
    public void AIcheck (Pamalo p1, Bot AI) { //checker for single player
        if (x <= 50) { // Width of Paddle + Radius of ball = 50
            if (y >= p1.getY() && y <= p1.getY()+79) { // Basing on the legnth of the paddle
                xVelocity = -xVelocity;
            }
        }
        else if (x >= 650){
            if (y >= AI.getY() && y <= AI.getY()+79) {
                xVelocity = -xVelocity;
            }

        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillOval((int)x-10, (int)y-10, 20, 20);
        g.setColor(Color.BLUE);

    }

    public void move() {
        if (Main.State == Main.STATE.PLAYING || Main.State == Main.STATE.SINGLE) {
            if (playerMove == true) { //para habang di gumagalaw di gagalaw yung bola
                x += xVelocity;
                y += yVelocity;

                if (y < 10) {
                    yVelocity = -yVelocity;
                }
                if (y > 490) {
                    yVelocity = -yVelocity;
                }
                if (x >= 15 && x <= 20 || x >= 678 && x <= 680) { // Returns the ball to the center
                    x = 350;
                    y = 250;
                    outOfBounds = true;
                    playerMove = false;
                }
            }
        }
    }

    public int getX (){
        return (int) x;
    }
    public int getY (){
        return (int) y;
    }

}
