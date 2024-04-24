/**@author Jian Chun Hin,20207461, Ben */
//It is a program about Information

//Module
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.io.*;

//Class
public class Information {
    public static void main(String[] args){
        information();
    }


    public static void information(){
        try{
            JFrame frame = new JFrame();
            frame.setSize(500,500); // setSize(width,height)
            frame.setLocation(100,0);    // setLocation(x,y)
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Use DIDPOSE_ON_CLOSE
        
            /*Create a Panel*/
            JPanel panel = new JPanel();//It create a Panel
            frame.add(panel); // Add the panel
            showP(panel); // Disgin the Panel + use the method
            frame.setVisible(true);

        }catch(Exception e){}
    }
    

    // This function is Panel for Information.java
    public static void showP(JPanel panel){

        panel.setLayout(null);// A setting of layout: Very Important, if your program without this code, your panel element(such as JLabel/textField) will be mix.
        
        JLabel Title = new JLabel("Information");
        Title.setBounds(0,0,130,50);  // setBounds(x,y,width,height);
        Title.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(Title);

        JLabel T1 = new JLabel("<html>Group Project:Learner Buddy<br>Group:7<br>Class:CL12</html>");
        T1.setBounds(10,10,200,300);  // setBounds(x,y,width,height);
        T1.setFont(new Font("Verdana", Font.PLAIN, 14));
        panel.add(T1);

        JLabel T2 = new JLabel("<html>Groupmates:<br>Chan Tze Hei,Dawn<br>Lam Tsun Ting,Bryan<br>Lee Pak Lok,Leo<br>,Jian Chun Hin,Ben<br>Chau Siu Hong,Joe</html>");
        T2.setBounds(10,150,150,200);
        panel.add(T2);
		
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                Achievement.clickCount++;
                Storage.TextFileInput("clickCountFile.txt", Integer.toString(Achievement.clickCount));
                
                Achievement.getAch();
            }
        });
    }
}

