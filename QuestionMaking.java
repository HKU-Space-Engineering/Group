//It is a sub program of Training

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.lang.Math;


/**@author Jian Chun Hin
 * this program aims to create the question in a new panel
*/
public class QuestionMaking{
    public static void main(String [] args){
        System.out.printf("It is a sub program of Training");
        Question();
        TextRead();
    }

    public static void Question(){
    try{
            //Create a frame of question part
            JFrame frame = new JFrame();
            frame.setSize(500,700); // setSize(width,height)
            frame.setLocation(800,300);    // setLocation(x,y)
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Use DIDPOSE_ON_CLOSE
        
            /*Create a Panel*/
            JPanel panel = new JPanel();//It create a Panel
            frame.add(panel); // Add the panel
            QuestionPanel(panel); // Disgin the Panel + use the method
            frame.setVisible(true);

        }catch(Exception e){}
    }


    public static void QuestionPanel(JPanel panel){
        //
        panel.setLayout(null);

        JLabel title = new JLabel("Question Page");
        title.setBounds(0,0,100,40);
        panel.add(title);

        JLabel Remind = new JLabel("You need to answer 10 questions in this quiz");
        Remind.setBounds(10,20,300,40);
        panel.add(Remind);

        JLabel Information1 = new JLabel("Keywords:");

        JLabel Information2 = new JLabel("");

        JLabel Information3 = new JLabel("-------------------------------------------------------------------");

        JLabel Q1L = new JLabel();
        Q1L.setText("");

    }

    public static void TextRead(){
        //Question list file is: QuestionFile.json
        String[] Qlist;
        String data;
        String Question = "";
        try{
            BufferedReader bufferReader = new BufferedReader(new FileReader("QuestionFile.json"));
            // While aims to acquire all the data from Data.txt
            while ((( data = bufferReader.readLine()) != null)){
                if(data == " "){
                    break;
                }
                Question =  Question + "\n" + data ;
            }
            System.out.println(Question);
            bufferReader.close();
        }catch(IOException e){}
    }
}
