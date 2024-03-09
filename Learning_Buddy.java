import javax.accessibility.Accessible;
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
            /*Create a Panel*/
            JPanel panel = new JPanel();
            frame.add(panel); 
            PanelDesign(panel); // Disgin the Panel 
            frame.setVisible(true);

            // Make a Menu
            MenuBar mb = new MenuBar();  
            Menu menu = new Menu("Menu");  
            Menu submenu = new Menu("Sub Menu");  

            MenuItem i1 = new MenuItem("Reminder");
            i1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    LearnCalendar a = new LearnCalendar();//Call reminder interface 
                    a.createCal();
                }
            });

            MenuItem i2 = new MenuItem("Achievement");  
            i2.addActionListener(new ActionListener() {     // Call Training function
                public void actionPerformed(ActionEvent event){
                    Achievement.achievement();//Call Achievement interface
                } 
            });

            MenuItem i3 = new MenuItem("Document Management"); 
            i3.addActionListener(new ActionListener() {     // Call Training function
                public void actionPerformed(ActionEvent event){
                    //DocManager.interface();   This program didn't finish.
                    DocManager.docManager();
                } 
            });

            MenuItem i4 = new MenuItem("Training"); 

            i4.addActionListener(new ActionListener() {     // Call Training function
                public void actionPerformed(ActionEvent event){
                    Training.training();
                } 
            });

            MenuItem i5 = new MenuItem("Information Setting");  

            i5.addActionListener(new ActionListener() { // Call the NewPanel
                public void actionPerformed(ActionEvent event){  
                }
            });

            MenuItem i6 = new MenuItem("Logout"); 


            menu.add(submenu); 
            menu.add(i1);  
            menu.add(i2);  
            menu.add(i3); 
            menu.add(i4); 
            submenu.add(i5);  
            submenu.add(i6);   
            mb.add(menu);  
            frame.setMenuBar(mb);  
            frame.setSize(80,70);  
            frame.setLayout(null);  
            frame.setVisible(true);  

    }

    public static void PanelDesign(JPanel panel){
        panel.setLayout(null);// A setting of layout

        JLabel Label1 = new JLabel("Test1");// Seting the position of Panel
        Label1.setBounds(10,0,200,25);  // setBounds(x,y,width,height);
        panel.add(Label1); //add the label into the Panel

        JLabel Label2 = new JLabel("Test2");//The UserName
        Label2.setBounds(10,40,100,25);
        panel.add(Label2);
    }
}
