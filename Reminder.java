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
            frame.setSize(350,300);
            frame.setLocation(500,300);
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

        //create bookmark
        //label
        JLabel bookmarkLabel = new JLabel("Please input your study plan");
        bookmarkLabel.setBounds(50,20,200,25);
        panel.add(bookmarkLabel);

        JLabel contentLabel = new JLabel("Content:");
        contentLabel.setBounds(50,50,100,25);
        panel.add(contentLabel);

        JLabel exptimeLabel = new JLabel("Expected time:");
        exptimeLabel.setBounds(50,80,100,25);
        panel.add(exptimeLabel);

        JLabel expYLabel = new JLabel("(yyyy)");
        expYLabel.setBounds(140, 100, 30, 25);
        panel.add(expYLabel);

        JLabel expMLabel = new JLabel("(m/mm)");
        expMLabel.setBounds(190,100,40,25);
        panel.add(expMLabel);

        JLabel expDLabel = new JLabel("(d/dd)");
        expDLabel.setBounds(245,100,40,25);
        panel.add(expDLabel);

        JLabel slash1 = new JLabel("/");
        slash1.setBounds(180,80,20,25);
        panel.add(slash1);
        
        JLabel slash2 = new JLabel("/");
        slash2.setBounds(235,80,20,25);
        panel.add(slash2);

        //textbox to input
        JTextField content = new JTextField(20);
        content.setBounds(100,50,100,25);
        panel.add(content);

        JTextField expyear = new JTextField(20);
        expyear.setBounds(140,80,40,25);
        panel.add(expyear);

        JTextField expmonth = new JTextField(20);
        expmonth.setBounds(190,80,40,25);
        panel.add(expmonth);

        JTextField expdate = new JTextField(20);
        expdate.setBounds(240,80,40,25);
        panel.add(expdate);

        //button to create
        JButton Create = new JButton("Create");
        Create.setBounds(100,160,100,25);
        Create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                try{
                    String c = content.getText();
                    String y = expyear.getText();
                    String m = expmonth.getText();
                    String d = expdate.getText();
                    if ((c.isEmpty()) && (y.isEmpty()) && (m.isEmpty()) && (d.isEmpty())){
                        JOptionPane.showMessageDialog(null,"Invalid input!Please input again!");
                    }else{
                        String text = content.getText() + "," + expyear.getText() + "/" + expmonth.getText() + "/" + expdate.getText();
                        Storage.TextFileInput("reminder.txt", text);
                        JOptionPane.showMessageDialog(null,"You create a bookmark Successfully!");
                        String count = Storage.TextFileRead("RCount.txt"); //Read the number from the RCount.txt
                        int n = Integer.parseInt(count);
                        n = n + 1;
                        Storage.TextFileDelete("RCount.txt"); // Delete the old file
                        Storage.TextFileInput("RCount.txt",Integer.toString(n)); 
                    
                    }
                }catch(Exception e){}
            }
        });
        panel.add(Create);
    }
    public static String[] CheckBookmark() {
        //check the created bookmarks(read the file)
        ArrayList<String> AList = new ArrayList<String>(); // arraylist
        try{
            BufferedReader bufferReader = new BufferedReader(new FileReader("reminder.txt"));
            // while loop to read file as string lines, until end (null string)
            String strLine;
            while ((strLine = bufferReader.readLine()) != null) { // read a line
                AList.add(strLine); // add read string line data to arraylist
            }
            bufferReader.close(); //close the stream
              
        } catch (IOException ioE){
        } // Convert ArrayList to String array 
        return AList.toArray(new String[AList.size()]);
    }
    
    public static void main(String[] args){
        Reminder();
    }
}