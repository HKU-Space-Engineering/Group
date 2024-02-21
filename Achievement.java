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
                GetAch();
            }
        });
    
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(200, 75, 80, 40);
        saveButton.addActionListener(event -> PrintAch());
        panel.add(saveButton);
    }

    public static List<String> achievements = new ArrayList<>();
    private static long startTime = System.currentTimeMillis();
    private static int clickCount = 0;
    public static void GetAch() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (elapsedTime >= 3600000 && !achievements.contains("TimeMaster")) {
            achievements.add("TimeMaster");
        }

        if (clickCount >= 10 && !achievements.contains("ClickMaster")) {
            achievements.add("ClickMaster");
        }
    }
    public static void PrintAch() {
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
