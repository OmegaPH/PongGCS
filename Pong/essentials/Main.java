package Pong.essentials;


import Pong.essentials.numbers.Score2p;
import Pong.essentials.numbers.SingleScoreLB;
import Pong.essentials.numbers.TimerClock;
import Pong.listeners.MouseInputs;
import Pong.screens.Menu;
import Pong.screens.Mode;
import Pong.screens.Recording1p;
import Pong.screens.SingleGameOver;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

import static Pong.essentials.numbers.SingleScoreLB.clickedOk;

public class Main extends Applet implements Runnable, KeyListener {

        static final int WIDTH = 700, HEIGHT = 500;
        Pong.screens.Menu menu;
        Pong.screens.Mode mode;
        SingleScoreLB singleLB;
        SingleGameOver singleGameOver;
        Recording1p recordS;
        private Image i;
        private Graphics g2;
        Thread thread;
        Score2p score2p;
        Bot AI;
        Namamalo p1;
        Namamalo p2;
        Pinapalo b1 = new Pinapalo();
        TimerClock time;
        public static boolean playerMove = false;
        public enum STATE {
            MENU,
            MODE,
            SINGLE,
            SINGLEGO,
            SINGLEGO2, //put this for the time getter
            PLAYING,
            RECORDING1P,
        }
        ;
        public static STATE State = STATE.MENU; //tells the program na nasa menu when its first started

    public static void main(String[] args) {
        // create and set up the applet
        Main applet = new Main();
        applet.setPreferredSize(new Dimension(700, 500));
        applet.init();

        // create a frame to host the applet, which is just another type of Swing Component
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the applet to the frame and show it
        mainFrame.getContentPane().add(applet);
        mainFrame.pack();
        mainFrame.setVisible(true);

        // start the applet
        applet.start();
    }

        public void init () {
            time = new TimerClock();
            AI = new Bot(2, b1);
            score2p = new Score2p();
            recordS = new Recording1p();
            singleLB = new SingleScoreLB();
            p1 = new Namamalo(1);
            p2 = new Namamalo(2);
            menu = new Menu();
            mode = new Mode();
            singleGameOver = new SingleGameOver();
            this.resize(WIDTH, HEIGHT);
            this.addKeyListener(this);
            this.addMouseListener(new MouseInputs());
            thread = new Thread(this);
            thread.start();
        }

        public void paint (Graphics g) {
            if (State == STATE.PLAYING) {
                g.setColor(Color.GRAY);
                g.fillRect(0, 0, WIDTH, HEIGHT);
                p1.draw(g);
                p2.draw(g);
                b1.draw(g);
                score2p.draw(g);
            } else if (State == STATE.MENU) {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, WIDTH, HEIGHT);
                menu.paint(g);
            } else if (State == STATE.MODE) {
                try {
                    g.setColor(Color.RED);
                    g.fillRect(0, 0, WIDTH, HEIGHT);
                    mode.paint(g);
                    TimeUnit.SECONDS.sleep(1);
                    g.setColor(Color.CYAN);
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Jokerman", Font.BOLD, 30));
                    g.drawString("1 PLAYER", 250 + 25, 200 + 38);
                    g.drawString("2 PLAYER", 244 + 32, 300 + 40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (State == STATE.SINGLE) {
                g.setColor(Color.pink);
                g.fillRect(0, 0, WIDTH, HEIGHT);
                time.draw(g);
                p1.draw(g);
                b1.draw(g);
                AI.draw(g);
            } else if (State == STATE.SINGLEGO) {
                g.setColor(Color.pink);
                g.fillRect(0, 0, WIDTH, HEIGHT);
                singleGameOver.paint(g);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Calibri", Font.BOLD, 32));
                g.drawString("SAVE SCORE", 116, 333);
                g.drawString("PLAY AGAIN", 422, 333);
            } else if (State == STATE.RECORDING1P) {
                g.setColor(Color.pink);
                g.fillRect(0, 0, WIDTH, HEIGHT);
                recordS.draw(g);
            }
        }

        public void update (Graphics g){
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

        public void run () {
            singleLB.readLb();
            singleLB.writeLb();
            singleLB.getlbDir();
            for (; ; ) {
                p1.move();
                p2.move();
                b1.move();
                AI.move();
                score2p.p1ScoreCounter();
                score2p.p2ScoreCounter();
                score2p.scoreReset();
                if (Main.State == STATE.SINGLE) {
                    b1.AIcheck(p1, AI); //check if  pinalo ba si (___, ___) ?
                    time.startTimer();
                    time.isGameOver();
                } else if (Main.State == STATE.PLAYING) {
                    b1.playerCheck(p1, p2);
                } else if (Main.State == STATE.SINGLEGO) {

                } else if (Main.State == STATE.SINGLEGO2) {

                } else if (Main.State == STATE.RECORDING1P) {
                    //recordS.enterName();
                    singleLB.enterName();
                    //singleLB.Import();
                    if (clickedOk == true) { //checks if nag record ng score sa single player
                        System.out.println("AAA"); ///////////
                        clickedOk = false;
                        singleLB.readLb();
                        singleLB.writeLb();
                        singleLB.readLb();
                        System.out.println("BBB"); /////////////
                    }
                }
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void keyTyped (KeyEvent e){

        }

        public void keyPressed (KeyEvent e){
            if (State == STATE.PLAYING || State == STATE.SINGLE) {
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


        public void keyReleased (KeyEvent e){
            if (State == STATE.PLAYING || State == STATE.SINGLE) {
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

            if (e.getKeyCode() == KeyEvent.VK_P) {
                playerMove = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_L) {
                playerMove = false;
            }

        }

}
