/**@author Jian Chun Hin,20207461, Ben */
//It is a program about Training program
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class Training {
    public static void main(String[] args){
        training();
    }


    public static void training(){
        try{
            JFrame frame = new JFrame();
            frame.setSize(500,500);
            frame.setLocation(400,400);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// It is necessary
        
            /*Create a Panel*/
            JPanel panel = new JPanel();//It create a Panel
            frame.add(panel); // Add the panel
            trainingP(panel); // Disgin the Panel + use the method // Please remember amend the function name when you copy this code.
            frame.setVisible(true);
            trainingP2(panel); // Re-product a new panel which replaces the older one  // Don't copy this code 

        }catch(Exception e){}
    }

    public static void trainingP(JPanel panel){
        JLabel TrainingLabel = new JLabel("Training");// Seting the position of Panel
        TrainingLabel.setBounds(10,20,80,40);  // setBounds(x,y,width,height);
        panel.add(TrainingLabel); //add the label into the Panel
    }


    public static void trainingP2(JPanel panel){// this function aims to provide a setting of second panel
        panel.setLayout(null);// A setting of layout: Very Important, if your program without this code, your panel element(such as JLabel/textField) will be mix.
        
        JLabel TrainingLabel = new JLabel("Training2");// Seting the position of Panel
        TrainingLabel.setBounds(10,20,80,40);  // setBounds(x,y,width,height);
        panel.add(TrainingLabel); //add the label into the Panel
    }
}

