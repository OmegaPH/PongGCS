package Pong;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends Applet implements Runnable, KeyListener {
    final int WIDTH = 700, HEIGHT = 500;
    private Image i;
    private Graphics g2;
    private String gameOverMsg = "Loser";
    Thread thread;
    Namamalo p1;
    Pinapalo b1 = new Pinapalo();

    public void init() {
        p1 = new Namamalo(2);
        this.resize(WIDTH, HEIGHT);
        this.addKeyListener(this);
        thread = new Thread(this);
        thread.start();
        b1 = new Pinapalo();
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        if (b1.getX() >= 695 || b1.getX() <= -5) { //if ball goes over left or right side of the screen
            g.setFont(new Font("TimesRoman", Font.BOLD, 32));
            g.setColor(Color.BLUE.brighter());
            g.drawString(gameOverMsg, 310, 250);
        }

        p1.draw(g);
        b1.draw(g);
    }

    public void update(Graphics g) {
        if ( i == null ) {
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

    public void run() { // asdsd
        for (;;) {

            p1.move();
            b1.move();
            b1.pinaloBa(p1, p1); //check if  pinalo ba si (___, ___) ?
            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //@Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            p1.setUpX(true);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            p1.setDownX(true);
        }

    }

    //@Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            p1.setUpX(false);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            p1.setDownX(false);
        }

    }

    //@Override find out bat niya inalis override
    public void keyTyped(KeyEvent e) {}
}
