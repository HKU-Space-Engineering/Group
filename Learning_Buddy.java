import javax.swing.JFrame;
import javax.swing.JPanel;

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


public class Learning_Buddy {
//field

    public static void main(String[] args){
        try{
            Login.Interface();
        }catch(Exception e){}
    }   

    public static void MainInterface(){
        JFrame frame = new JFrame();
            frame.setSize(500,500);
            frame.setLocation(400,400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
