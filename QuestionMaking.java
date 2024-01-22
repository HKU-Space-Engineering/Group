//It is a sub program of Training

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**@author Jian Chun Hin
 * this program aims to create the question in a new panel
*/
public class QuestionMaking{
    public static void main(String [] args){
        System.out.printf("It is a sub program of Training");
    }

    public void Question(){
    try{
            JFrame frame = new JFrame();
            frame.setSize(500,700); // setSize(width,height)
            frame.setLocation(800,300);    // setLocation(x,y)
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Use DIDPOSE_ON_CLOSE
        
            /*Create a Panel*/
            JPanel panel = new JPanel();//It create a Panel
            frame.add(panel); // Add the panel
            trainingP(panel); // Disgin the Panel + use the method
            frame.setVisible(true);

        }catch(Exception e){}
    }


    public static void QuestionPanel(JPanel panel){
        panel.setLayout(null);

        JLabel title = new JLabel("Question Page");
        title.setBounds(0,0,40,40);
        panel.add(title);

        JLabel Remind = new JLabel("You need to answer 10 questions in this quiz");
        Remind.setBounds(10,20,300,40);
        panel.add(Remind);

        JLabel Information1 = new JLabel("Keywords:");

        JLabel Information2 = new JLabel("");

        JLabel Information3 = new JLabel("-------------------------------------------------------------------");

        JLabel Q1L = new JLabel("1."+"");
        //Question Creat Section : 3 part of the question
        //part 1 and 2 
    }
}
