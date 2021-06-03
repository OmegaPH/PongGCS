package Pong.screens;
import java.awt.*;



public class Menu {
    final int WIDTH = 700, HEIGHT = 500;
    Font fnt0 = new Font("Vladimir Script", Font.BOLD, 50);
    Font fnt1 = new Font("Calibri", Font.BOLD, 50);
    public Rectangle playBtn = new Rectangle(250, 200, 200, 50);
    public Rectangle quitBtn = new Rectangle(250, 300, 200, 50);

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setFont(fnt0);
        g.setColor(Color.WHITE);
        g.drawString("NOT A CRINGE TITLE", 70, HEIGHT / 2 - 100);
        g.setFont(fnt1);
        g2d.draw(playBtn);
        g2d.draw(quitBtn);
        g.setColor(Color.RED);
        g.drawString("PLAY", playBtn.x + 50, playBtn.y + 40);
        g.drawString("EXIT", quitBtn.x + 55, quitBtn.y + 40);


    }


}
