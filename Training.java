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
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// It is necessary
        
            /*Create a Panel*/
            JPanel panel = new JPanel();//It create a Panel
            frame.add(panel); // Add the panel
            trainingP(panel); // Disgin the Panel + use the method
            frame.setVisible(true);

        }catch(Exception e){}
    }

    public static void trainingP(JPanel panel){
        JLabel TrainingLabel = new JLabel("Training");// Seting the position of Panel
        TrainingLabel.setBounds(10,20,80,40);  // setBounds(x,y,width,height);
        panel.add(TrainingLabel); //add the label into the Panel
    }
}
