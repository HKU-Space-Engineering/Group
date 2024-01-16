/* *@author Chau Siu Hong 20186650 */
/*date created 24/12/2023 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Reminder {
//method
    public static void Reminder(){
        try{
            JFrame frame = new JFrame();
            frame.setSize(500,500);
            frame.setLocation(400,400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// It is necessary
        
            /*Create a Panel*/
            JPanel panel = new JPanel();//It create a Panel
            frame.add(panel); // Add the panel
            ReminderP(panel); // Disgin the Panel + use the method
            frame.setVisible(true);

        }catch(Exception e){}
    }

    public static void ReminderP(JPanel panel){
        JLabel ReminderLabel = new JLabel("Reminder");// Seting the position of Panel
        ReminderLabel.setBounds(10,20,80,40);  // setBounds(x,y,width,height);
        panel.add(ReminderLabel); //add the label into the Panel
    }

    public static void CreateBookmark() {
    //need GUI for users to input what to study,expected time to finish 
    //also can choose style/design of the bookmark(how to get the different design and apply it??)
    //and button to create it -> write into a txt file
    }

    public static void CheckBookmark() {
    //button to check the created bookmarks(read the file) -> a frame show the list 
    //the list jump out when run the program -> maybe connect to the login.java
    } 

    public static void main(String[] args){
        Reminder();
    }
}