import javax.accessibility.Accessible;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
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
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            MenuBar mb = new MenuBar();  
            Menu menu = new Menu("Menu");  
            Menu submenu = new Menu("Sub Menu");  
            MenuItem i1 = new MenuItem("Reminder");  
            MenuItem i2 = new MenuItem("Achievement");  
            MenuItem i3 = new MenuItem("Document Management"); 
            MenuItem i4 = new MenuItem("Training"); 
            i4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event){
                    
                } 
            });
            MenuItem i5 = new MenuItem("Information Setting");  
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
            frame.setSize(80,80);  
            frame.setLayout(null);  
            frame.setVisible(true);  

            /*Create a Panel*/
            JPanel panel = new JPanel();
            frame.add(panel); 
            PanelDesign(panel); // Disgin the Panel 
            frame.setVisible(true);

    }

    public static void PanelDesign(JPanel panel){
        panel.setLayout(null);// A setting of layout


    }
}
