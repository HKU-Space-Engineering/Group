/**@author Jian Chun Hin,20207461, Ben */
//It is a program about Training program

//Module
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.io.*;

//Field



//Class
public class Training {
    public static void main(String[] args){
        training();//For testing the training function
    }


    public static void training(){
        try{
            JFrame frame = new JFrame();
            frame.setSize(500,500); // setSize(width,height)
            frame.setLocation(400,400);    // setLocation(x,y)
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Use DIDPOSE_ON_CLOSE
        
            /*Create a Panel*/
            JPanel panel = new JPanel();//It create a Panel
            frame.add(panel); // Add the panel
            trainingP(panel); // Disgin the Panel + use the method
            frame.setVisible(true);

        }catch(Exception e){}
    }
    

    // This function is Panel for Training.java
    public static void trainingP(JPanel panel){

        panel.setLayout(null);// A setting of layout: Very Important, if your program without this code, your panel element(such as JLabel/textField) will be mix.

        JLabel TrainingLabel = new JLabel("Training",SwingConstants.LEFT);// Seting the position of Panel
        TrainingLabel.setBounds(0,0,80,80);  // setBounds(x,y,width,height);
        TrainingLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(TrainingLabel); //add the label into the Panel

        JLabel Describe1 = new JLabel("Write Key word",SwingConstants.LEFT);
        Describe1.setBounds(10,80,100,30); // setBounds(x,y,width,height);
        panel.add(Describe1);
        
        JLabel Describe2 = new JLabel("For example:Human Name,History,Technology,Event");
        Describe2.setBounds(10,100,350,30); // setBounds(x,y,width,height);
        panel.add(Describe2);

        JLabel Describe3 = new JLabel("Remind: All the data come from Wikipedia");
        Describe3.setBounds(10,120,300,30);// setBounds(x,y,width,height);
        panel.add(Describe3);

        JTextArea Area = new JTextArea("Kate_Sheppard ");
        Area.setBounds(10,150,165,40);// setBounds(x,y,width,height);
        panel.add(Area);

        JButton Search = new JButton("Search");//Create a Button
        Search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                String TextArea = Area.getText();
                Storage.TextFileDelete("Rearchfile.txt");   //delete the old file
                Storage.TextFileInput("Rearchfile.txt",TextArea);   //Storage the data in Rearchfile.txt
                System.out.println("Text Input done");
                try{
                    Process proc = Runtime.getRuntime().exec("Wiki_3.exe"); // Runing a exe program
                }catch(IOException e){
                    e.printStackTrace();
                    System.out.println("Error in the python part");
                }
                System.out.println("python part done");
                //Call the question panel
                QuestionMaking.TextRead();;//Call QuestionMaking

            }
        });   
        Search.setBounds(10,220,80,40);
        panel.add(Search);
    }
}

