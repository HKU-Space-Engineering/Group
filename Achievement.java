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
            // Read clickCount from file
            String clickCountStr = Storage.TextFileRead("clickCountFile.txt");
            clickCount = Integer.parseInt(clickCountStr);
            
            JFrame frame = new JFrame();
            frame.setSize(500,500);
            frame.setLocation(400,400);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// It is necessary
        
            /*Create a Panel*/
            JPanel panel = new JPanel();//It creates a Panel
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
    
        JTextArea achievementTextArea = new JTextArea(10, 30); // Create a JTextArea
        achievementTextArea.setEditable(false); // Make it read-only
        JScrollPane scrollPane = new JScrollPane(achievementTextArea); // Add a scroll pane
        scrollPane.setBounds(50, 75, 400, 300);
        panel.add(scrollPane);
        
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                clickCount++;
                Storage.TextFileInput("clickCountFile.txt", Integer.toString(clickCount));
                
                getAch();
                printAch(achievementTextArea); // Update the text area
            }
        });
    
        JButton refreshButton = new JButton("Refresh and Save");
        refreshButton.setBounds(160, 400, 150, 50);
        refreshButton.addActionListener(event -> {
            printAch(achievementTextArea); // Update the text area
			saveAch();
        });
        panel.add(refreshButton);
    }

    public static List<String> achievements = new ArrayList<>();
    public static int clickCount = 0;
    public static void getAch() {

        // ClickMaster, unlock after clicked mouse cursor for 1000 times
        if (clickCount >= 100 && clickCount < 200 &&!achievements.contains("ClickMaster   Clicked mouse cursor in Learning Buddy for 1000 times.")) {
            achievements.add("ClickMaster   Clicked mouse cursor in Learning Buddy for 1000 times.");
        }
            // Unlock 2nd stage if clicked 2000 times
            else if (clickCount >= 200 &&!achievements.contains("ClickMaster (II)   Clicked mouse cursor in Learning Buddy for 2000 times.")){
                achievements.remove("ClickMaster   Clicked mouse cursor in Learning Buddy for 1000 times.");
                achievements.add("ClickMaster (II)   Clicked mouse cursor in Learning Buddy for 2000 times.");
            }
        
        // 100 Questions!!!, unlock after answering 100 questions in Training.java
        String AQCount = Storage.TextFileRead("AQCount.txt");
        int AQdata = Integer.parseInt(AQCount); 
        if (AQdata >= 10 && AQdata < 50 &&!achievements.contains("10 Questions!!!    Answered over 10 questions in training section.")) {
            achievements.add("10 Questions!!!    Answered over 10 questions in training section.");
        }
			//2nd stage >=50
			else if (AQdata >= 50 &&!achievements.contains("50 Questions!!!    Answered over 50 questions in training section.")){
				achievements.remove("10 Questions!!!    Answered over 10 questions in training section.");
				achievements.add("50 Questions!!!    Answered over 50 questions in training section.");
			}
        
        // 10 Reminders!!!, unlock after setting up 10 reminders in Reminder.java
        String RCount = Storage.TextFileRead("RCount.txt");
        int Rdata = Integer.parseInt(RCount); 
        if (Rdata >= 1 && Rdata < 10 &&!achievements.contains("1 Reminder!!!     Created 1 reminder to remind yourself.")) {
            achievements.add("1 Reminder!!!     Created 1 reminder to remind yourself.");
        }
			//2nd stage >=10
			else if (Rdata >= 10 &&!achievements.contains("10 Reminders!!!     Created more than 10 reminders to remind yourself.")){
				achievements.remove("1 Reminder!!!     Created 1 reminder to remind yourself.");
				achievements.add("10 Reminders!!!    Created more than 10 reminders to remind yourself.");
			}
        
        // 50 Documents!!!, unlock after opening 50 documents in DocManager.java
        String DCount = Storage.TextFileRead("DCount.txt");
        int Ddata = Integer.parseInt(DCount); 
        if (Ddata >= 10 && Ddata < 50 &&!achievements.contains("10 Documents!!!     Opened more than 10 documents in Learning Buddy.")) {
            achievements.add("10 Documents!!!     Opened more than 10 documents in Learning Buddy.");
        }
			//2nd stage >=50
			else if (Ddata >= 50 &&!achievements.contains("50 Documents!!!     Opened more than 50 documents in Learning Buddy.")){
				achievements.remove("10 Documents!!!     Opened more than 10 documents in Learning Buddy.");
				achievements.add("50 Documents!!!     Opened more than 50 documents in Learning Buddy.");
			}
    }
    public static void printAch(JTextArea textArea) {
        StringBuilder sb = new StringBuilder();
        for (String achievement : achievements) {
            sb.append(achievement).append("\n");
        }
        textArea.setText(sb.toString());
    }
	
    public static void saveAch() {
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
