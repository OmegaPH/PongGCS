package Pong.essentials.numbers;

import Pong.essentials.Main;
import Pong.screens.Recording1p;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static Pong.essentials.Main.playerMove;

public class SingleScoreLB extends Applet {
    TimerClock time = new TimerClock();
    Recording1p raw = new Recording1p();
    Font fnt0 = new Font("Calibri", Font.BOLD, 50);
    String path = System.getProperty("user.home") + File.separator + "PongGCS Data";
    final String lbtxtPath = path + File.separator + "leaderboard.txt";
    private String username;
    private String finalTime;
    public static boolean clickedOk = false;
    boolean lbCreated = false;
    boolean lbExist = false;
    boolean lbError = false;
    BufferedWriter bw;
    File lbDir = new File(path);

    private HashMap<String, String> scores = new HashMap();

    public void getlbDir() { //checks if directory exists or is created
        if (lbDir.exists()) {
            System.out.println(lbDir + " already exists");
            lbExist = true;
        } else if (lbDir.mkdirs()) {
            System.out.println(lbDir + " was created");
            lbCreated = true;
        } else {
            System.out.println(lbDir + " was not created");
            lbError = true;
        }
    }

    public void readLb() { //read the txt file and put in the hashmap
        System.out.println("READ"); /////////
        try {
            FileReader fileReader = new FileReader(lbtxtPath);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\\s+");
                scores.put(line[0], line[1]);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void writeLb() { //yo this writes or overrides text file containing leaderboard data
            try {
                bw = new BufferedWriter(new FileWriter(lbtxtPath));
                for (Map.Entry<String, String> record : scores.entrySet()) {
                    bw.write(record.getKey() + " " + record.getValue());
                    bw.newLine();
                }
                bw.flush();
                System.out.println("WRITE");
                System.out.println(scores); //////////////
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                try {
                    //always close the writer
                    bw.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

    public void enterName() {
        if (playerMove || Main.State == Main.STATE.SINGLEGO2) {
            finalTime = time.getTimerScoreFinal();
            username = String.valueOf(JOptionPane.showInputDialog(null, "ENTER USERNAME", "Save Score", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("loggers"), null, ""));
            scores.put(username, finalTime);
            playerMove = false;
            if (username != null) {
                clickedOk = true;
                username = null;
            }
        }
    }

    /*
    public void Import() {
        HashMap<String, String> importedScore = raw.enterName();
        for (Map.Entry<String, String> Import : importedScore.entrySet()) {
            scores.put(Import.getKey(), Import.getValue());
            System.out.println(scores + "CHECK IN IMPORT");
        }
    }
    */

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.setFont(fnt0);
    }

}
