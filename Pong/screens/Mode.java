package Pong.screens;
import java.awt.*;



public class Mode {
    final int WIDTH = 700, HEIGHT = 500;
    Font fnt0 = new Font("Calibri", Font.BOLD, 50);
    Font fnt1 = new Font("Jokerman", Font.BOLD, 30);
    public Rectangle playBtn = new Rectangle(250, 200, 200, 50);
    public Rectangle quitBtn = new Rectangle(250, 300, 200, 50);

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setFont(fnt0);
        g.setColor(Color.WHITE);
        g.drawString("SELECT YOUR GAME MODE", 85, HEIGHT / 2 - 100);
        g2d.draw(playBtn);
        g2d.draw(quitBtn);
        g.setColor(Color.ORANGE);
        g.setFont(fnt1);
        g.drawString("1 PLAYER", playBtn.x + 25, playBtn.y + 38);
        g.drawString("2 PLAYER", quitBtn.x + 32, quitBtn.y + 40);


    }


}
