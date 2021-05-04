package Pong;

import java.awt.*;

public class Pinapalo {
    double xVelocity, yVelocity, x, y;

    public Pinapalo() {
        x = 350;
        y = 250;
        xVelocity = 2.5;
        yVelocity = 2;
    }

    public void pinaloBa (Pamalo p1, Pamalo p2) { //check if ball hits a paddle
        if (x <= 50) { // Width of Paddle + Radius of ball = 50
            if (y >= p1.getY() && y <= p1.getY()+80) { // Basing on the legnth of the paddle
                xVelocity = -xVelocity;
            }
        }
        else if (x >= 650){
            if (y >= p2.getY() && y <= p2.getY()+80) {
                xVelocity = -xVelocity;
            }

        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillOval((int)x-10, (int)y-10, 20, 20);
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;

        if (y < 10) {
            yVelocity = -yVelocity;
        }
        if (y > 490) {
            yVelocity = -yVelocity;
        }
    }

    public int getX (){
        return (int) x;
    }
    public int getY (){
        return (int) y;
    }
}
