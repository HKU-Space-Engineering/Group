/* *@author Lam Tsun Ting 20219894 */
/*date created 24/12/2023 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Achievement {

    public static void achievement(){
        try{
            JFrame frame = new JFrame();
            frame.setSize(700,700);
            frame.setLocation(640,200);
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
        
        JLabel AchievementLabel = new JLabel("Achievement");// Seting the position of Panel
        AchievementLabel.setBounds(305,25,80,40);  // setBounds(x,y,width,height);
        panel.add(AchievementLabel); //add the label into the Panel
    }

public static void GetAch() {
    //if they unlock our achievements, they can get them on their achievement list

}
public static void PrintAch() {
    //convert user's achievement list into txt file
    //users can save it on desktop or print it out
    }
}
