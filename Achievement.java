/* *@author Lam Tsun Ting 20219894 */
/*date created 24/12/2023 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;

    
public class Achievement {
    public static void main(String[] args){
        achievement();
    }

    public static void achievement(){
        try{
            JFrame frame = new JFrame();
            frame.setSize(500,500);
            frame.setLocation(400,400);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// It is necessary
        
            /*Create a Panel*/
            JPanel panel = new JPanel();//It create a Panel
            frame.add(panel); // Add the panel
            achievementP(panel); // Design the Panel + use the method
            frame.setVisible(true);

        }catch(Exception e){}
    }

    public static void achievementP(JPanel panel){
        panel.setLayout(null);
        
        JLabel AchievementLabel = new JLabel("Achievement");
        AchievementLabel.setBounds(200,25,80,40);
        panel.add(AchievementLabel);
    
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                clickCount++;
                Storage.TextFileDelete("clickCountFile.txt");
                Storage.TextFileInput("clickCountFile.txt", Integer.toString(clickCount));
                long newSpentTime = System.currentTimeMillis() - startTime;
                spentTime = newSpentTime;
                Storage.TextFileDelete("spentTimeFile.txt");
                Storage.TextFileInput("spentTimeFile.txt", Long.toString(spentTime));
                getAch();
            }
        });
    
        JButton saveButton = new JButton("Refresh and save");
        saveButton.setBounds(160, 75, 150, 50);
        saveButton.addActionListener(event -> printAch());
        panel.add(saveButton);
    }

    public static List<String> achievements = new ArrayList<>();
    private static long startTime = System.currentTimeMillis();
    private static int clickCount = 0;
    public static void getAch() {
        // TimeMaster, unlock after using 1 hour
        if (spentTime >= 3600000 && spentTime < 18000000 && !achievements.contains("TimeMaster    Continuously used Learning Buddy for 1 hour.")) {
            achievements.add("TimeMaster    Continuously used Learning Buddy for 1 hour.");
        }
            // Unlock 2nd stage if used over 5 hours
            else if (spentTime >= 18000000 && !achievements.contains("TimeMaster (II)   Continuously used Learning Buddy for 5 hours.")){
                achievements.remove("TimeMaster    Continuously used Learning Buddy for 1 hour.");
                achievements.add("TimeMaster (II)   Continuously used Learning Buddy for 5 hours.");
            }
        // ClickMaster, unlock after clicked mouse cursor for 1000 times
        if (clickCount >= 10 && clickCount < 20 && !achievements.contains("ClickMaster   Clicked mouse cursor in Learning Buddy for 1000 times.")) {
            achievements.add("ClickMaster   Clicked mouse cursor in Learning Buddy for 1000 times.");
        }
            // Unlock 2nd stage if clicked 2000 times
            else if (clickCount >= 20 && !achievements.contains("ClickMaster (II)   Clicked mouse cursor in Learning Buddy for 2000 times.")){
                achievements.remove("ClickMaster   Clicked mouse cursor in Learning Buddy for 1000 times.");
                achievements.add("ClickMaster (II)   Clicked mouse cursor in Learning Buddy for 2000 times.");
            }
        
        // 100 Questions!!!, unlock after answering 100 questions in Training.java
        String AQCount = Storage.TextFileRead("AQCount.txt");
        int AQdata = Integer.parseInt(AQCount); 
        if (AQdata >= 100 && !achievements.contains("100 Questions!!!    Answered over 100 questions in training section.")) {
            achievements.add("100 Questions!!!    Answered over 100 questions in training section.");
        }
        
        // 10 Reminders!!!, unlock after setting up 10 reminders in Reminder.java
        String RCount = Storage.TextFileRead("RCount.txt");
        int Rdata = Integer.parseInt(RCount); 
        if (Rdata >= 10 && !achievements.contains("10 Reminders!!!     Created over 10 reminders to remind yourself.")) {
            achievements.add("10 Reminders!!!     Created over 10 reminders to remind yourself.");
        }
        
        // 50 Documents!!!, unlock after opening 50 documents in DocManager.java
        String DCount = Storage.TextFileRead("DCount.txt");
        int Ddata = Integer.parseInt(RCount); 
        if (Ddata >= 50 && !achievements.contains("50 Documents!!!     Opened over 50 documents in Learning Buddy.")) {
            achievements.add("50 Documents!!!     Opened over 50 documents in Learning Buddy.");
        }
    }
    public static void printAch() {
        File file = new File(System.getProperty("user.home") + "/Desktop/Achievement.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Achievement List:\n");
            for (int i = 0; i < achievements.size(); i++) {
                writer.write((i + 1) + ") " + achievements.get(i) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
