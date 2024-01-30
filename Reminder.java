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
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// It is necessary
        
            /*Create a Panel*/
            JPanel panel = new JPanel();//It create a Panel
            frame.add(panel); // Add the panel
            ReminderP(panel); // Design the Panel + use the method
            frame.setVisible(true);
        }catch(Exception e){}
    }

    public static void ReminderP(JPanel panel){
        panel.setLayout(null);

        JLabel ReminderLabel = new JLabel("Reminder");// Setting the position of Panel
        ReminderLabel.setBounds(120,20,80,40);  // setBounds(x,y,width,height);
        panel.add(ReminderLabel); //add the label into the Panel

        //create bookmark
        //label
        JLabel bookmarkLabel = new JLabel("Please input your study plan");
        bookmarkLabel.setBounds(120,50,200,25);
        panel.add(bookmarkLabel);

        JLabel contentLabel = new JLabel("Content:");
        contentLabel.setBounds(120,80,100,25);
        panel.add(contentLabel);

        JLabel exptimeLabel = new JLabel("Expected time:");
        exptimeLabel.setBounds(120,110,100,25);
        panel.add(exptimeLabel);

        JLabel slash = new JLabel("/");
        slash.setBounds(250,110,30,25);
        panel.add(slash);

        //textbox to input
        JTextField content = new JTextField(20);
        content.setBounds(190,80,100,25);
        panel.add(content);

        JTextField expmonth = new JTextField(20);
        expmonth.setBounds(210,110,30,25);
        panel.add(expmonth);

        JTextField expdate = new JTextField(20);
        expdate.setBounds(260,110,30,25);
        panel.add(expdate);

        //button to create
        JButton Create = new JButton("Create");
        Create.setBounds(170,170,100,25);
        Create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                String text = content.getText() + expmonth.getText() + expdate.getText();
                Storage.TextFileInput("reminder.txt", text);
                JOptionPane.showMessageDialog(null,"You create a bookmark Successfully!");
            }
        });
        panel.add(Create);
    }

    public static void CreateBookmark() {
    //need GUI for users to input what to study,expected time to finish 
    //also can choose style/design of the bookmark(how to get the different design and apply it??)
    //and button to create it -> write into a txt file
    }

    public static void CheckBookmark() {
    //button to check the created bookmarks(read the file) -> a frame show the list 
    //the list jump out when run the program -> maybe connect to the login.java
        try{
            BufferedReader bufferReader = new BufferedReader(new FileReader("reminder.txt"));
            ArrayList<String> AList = new ArrayList<String>(); // arraylist
            // while loop to read file as string lines, until end (null string)
            String strLine;
            while ((strLine = bufferReader.readLine()) != null) { // read a line
                AList.add(strLine); // add read string line data to arraylist
            }
            bufferReader.close(); //close the stream
            // BELOW: Convert ArrayList to String array
            String[] bookmarks = AList.toArray(new String[retAList.size()]);
        } catch (IOException ioE){

        }

    }
    public static void main(String[] args){
        Reminder();
    }
}