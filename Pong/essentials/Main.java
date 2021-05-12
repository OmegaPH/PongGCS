package Pong.essentials;

import Pong.listeners.MouseInputs;
import Pong.screens.Menu;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Main extends Applet implements Runnable, KeyListener {
    static final int WIDTH = 700, HEIGHT = 500;
    Pong.screens.Menu menu;
    private Image i;
    private Graphics g2;
    private String gameOverMsg = "Loser";
    Thread thread;
    Score score;
    Namamalo p1;
    Namamalo p2;
    Pinapalo b1 = new Pinapalo();
    public static boolean playerMove = false;
    public enum STATE {
        MENU,
        PLAYING
    };
    public static STATE State = STATE.MENU; //tells the program na nasa menu when its first started


    public void init() {
        score = new Score();
        p1 = new Namamalo(1);
        p2 = new Namamalo(2);
        menu = new Menu();
        this.resize(WIDTH, HEIGHT);
        this.addKeyListener(this);
        this.addMouseListener(new MouseInputs());
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g) {
        if (State == STATE.PLAYING) {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            if (b1.getX() >= 695 || b1.getX() <= -5) { //if ball goes over left or right side of the screen
                g.setFont(new Font("TimesRoman", Font.BOLD, 32));
                g.setColor(Color.BLUE.brighter());
                g.drawString(gameOverMsg, 310, 250);
            }
            p1.draw(g);
            p2.draw(g);
            b1.draw(g);
            score.draw(g);
        } else if (State == STATE.MENU) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            menu.paint(g);
        }
    }

    public void update(Graphics g) {
        if (i == null) {
            i = createImage(getHeight(), getHeight());
        }
        g2 = i.getGraphics();

        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(getForeground());
        paint(g2);
        g.drawImage(i, 0, 0, null);
        paint(g);
    }

    public void run() {
            for (;;) {
                p1.move();
                p2.move();
                b1.move();
                score.p1ScoreCounter();
                score.p2ScoreCounter();
                b1.pinaloBa(p1, p2); //check if  pinalo ba si (___, ___) ?
                repaint();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (State == STATE.PLAYING) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                playerMove = true;
                p1.setUpX(true);
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                playerMove = true;
                p1.setDownX(true);
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                playerMove = true;
                p2.setUpX(true);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                playerMove = true;
                p2.setDownX(true);
            }
        }
    }


    public void keyReleased(KeyEvent e) {
        if (State == STATE.PLAYING) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                playerMove = true;
                p1.setUpX(false);
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                playerMove = true;
                p1.setDownX(false);
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                playerMove = true;
                p2.setUpX(false);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                playerMove = true;
                p2.setDownX(false);
            }
        }

    }
}
