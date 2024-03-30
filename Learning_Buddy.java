import javax.accessibility.Accessible;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/**Learning Buddy
 * @author Jian Chun Hin 
 * 
 */

/*UML Digram
 
Learning Buddy
---------------------
String uName;
int uID;
String uSchool;
-----------------------
+ main(args [] String)
+ MainInterface()
+ PamelDesign
*/ 

public class Learning_Buddy{
//field

    public static void main(String[] args){
        try{
            Login.Interface();
        }catch(Exception e){}
    }   

    public static void MainInterface(){
        JFrame frame = new JFrame();
            frame.setLocation(300,400);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(550,500);
            /*Create a Panel*/
            JPanel panel = new JPanel();
            frame.add(panel); 
            PanelDesign(panel); // Disgin the Panel 

            // Make a Menu
            JMenuBar mb = new JMenuBar();  
            JMenu menu = new JMenu("Menu");  
            JMenu submenu = new JMenu("Setting Menu");  

            JMenuItem i1 = new JMenuItem("Reminder");
            i1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    LearnCalendar a = new LearnCalendar();//Call reminder interface 
                    a.createCal();
                }
            });

            JMenuItem i2 = new JMenuItem("Achievement");  
            i2.addActionListener(new ActionListener() {     // Call Training function
                public void actionPerformed(ActionEvent event){
                    Achievement.achievement();//Call Achievement interface
                } 
            });

            JMenuItem i3 = new JMenuItem("Document Management",new ImageIcon("./src/icon1.jpg")); 
            i3.addActionListener(new ActionListener() {     // Call Training function
                public void actionPerformed(ActionEvent event){
                    //DocManager.interface();   This program didn't finish.
                    DocManager.docManager();
                } 
            });

            JMenuItem i4 = new JMenuItem("Training"); 

            i4.addActionListener(new ActionListener() {     // Call Training function
                public void actionPerformed(ActionEvent event){
                    Training.training();
                } 
            });

            JMenuItem i5 = new JMenuItem("Information Setting");  

            i5.addActionListener(new ActionListener() { // Call the NewPanel
                public void actionPerformed(ActionEvent event){  
                }
            });

            JMenuItem i6 = new JMenuItem("Logout");
            i6.addActionListener(new ActionListener() { // Call the NewPanel
                public void actionPerformed(ActionEvent event){  
                    Login.Interface(); 
                }
            });
             
            menu.add(i1);  
            menu.add(i2);  
            menu.add(i3); 
            menu.add(i4); 
            submenu.add(i5);  
            submenu.add(i6);   
            mb.add(menu);  
            mb.add(submenu);
            frame.setJMenuBar(mb);   
            frame.setLayout(null);  
            frame.setVisible(true);  

    }

    public static void PanelDesign(JPanel panel){
        panel.setLayout(null);// A setting of layout

        ImageIcon userimage = new ImageIcon("./src/UserImage.jpg");
        JLabel imagelabel = new JLabel(userimage);
        imagelabel.setBounds(0,0,247,221);
        panel.add(imagelabel);
    }
}
