//It is a sub program of Training
/**@author Jian Chun Hin
 * this program aims to create the quiz in a new panel
 * It didn't finish.
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.lang.Math;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class QuestionMaking{
    public static void main(String [] args){
        System.out.printf("It is a sub program of Training\n");
        TextRead();
    }

    public static void Question(String[] Questionlist){
        try{
            System.out.println("Here is the Question Making\n");
            //Setting
            String[] qlist = new String[10]; // Array:Storage the dealed question
            String[] Answer = new String[10]; //Array:Storage the Answer
            int QNum = 0;//Storage the QuestionNumber
            // Dealing with the Questionlist
            for(int n = 0;n < Questionlist.length;n++){
                if(((int)(Math.random()*10+1)>=9)|| (QNum< 10)){
                    String interim = Questionlist[n];//Create a interim var, The structure: Nicholas Caradoc Hoult (born 7 December 1989) is an English actor.Nicholas;Caradoc;Hoult;(born;7;December;1989);is;an;English;       
                    String[] Newlist = interim.split("\\.");//Cut the data to be two part   #need a "\\" to make sure the problem can understand the "."
                    qlist[QNum] = Newlist[0]; // Acquired the question
                    Answer[QNum] = Newlist[1];//Acquired the answer
                    QNum = QNum + 1;
                }
                if(QNum >=10){// Checking the Question Number, if it is full, then break.
                    break;
                }
            }
            if(QNum<10){
                System.out.println("Question is not enough,please find anthor source");
                Question(Questionlist);//if question list is not full, run the code again
            }

            System.out.println("Create the interface");
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

    }

    public static void TextRead(){
        //Question list file is: QuestionFile.txt
        System.out.println("Text dealing");
        String[] Qlist;
        String data;
        String Question = "";
        Boolean Exit = false;
        try{
            BufferedReader bufferReader = new BufferedReader(new FileReader("QuestionFile.txt",StandardCharsets.UTF_8));
            // While aims to acquire all the data from Data.txt
            while ((( data = bufferReader.readLine()) != null)){
                if(data == " "){
                    break;
                }
                if(data.equals("False")){
                    System.out.println("Stop: There are not question can do");
                    JOptionPane.showMessageDialog(null,"You need to use another keywords");
                    Exit = true;
                }
                Question =  Question + data;
            }
            if(Exit == false){// checking the output of python file, if it doesn't catch the correct data, then it will stop the program and exit.
                Qlist = Question.split("#");// if work, dealing with the input data
                bufferReader.close();
                Question(Qlist);//call the function and QuestionMaking interface
            }else{}
        }catch(IOException e){}
    }
}
