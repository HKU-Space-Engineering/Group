//It is a sub program of Training
/**@author Jian Chun Hin
 * this program aims to create the quiz in a new panel
 * It didn't finish.
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;


public class QuestionMaking{
    public static void main(String [] args){
        System.out.printf("It is a sub program of Training\n");
        TextRead();
    }

    public static void Question(String[] Questionlist){
        try{
            System.out.println("Here is the Question Making\nYou can read the below paragraph to finish the quiz.\n");
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
                    System.out.printf("%d: %s\n",QNum,Newlist[0].toString());
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

            //After the question list and answer list was splited
            //Their output:
            //qlist[n]: Born in Liverpool, England, she emigrated to New Zealand with her family in 1868.
            //Answer[n]: Born;in;Liverpool,;England,;she;emigrated;to;New;Zealand;with;her;family;in;1868

            //The above output can not used on the table because it doesn't choose the word which will be ask in the question.
            //So we need to do the final dealing

            //br is want to find out which sentence are too long, if too long then let it have "\n"
            Boolean[] br = new Boolean[10];
            for(int n =0;n<10;n++){
                String[] words = Answer[n].split(";");
                int rnum = (int)(Math.random()*(words.length));
                Answer[n] = words[rnum]; //Get answer
                String[] q = qlist[n].split(" ");//cut the qlist to be : ['Born','in','Liverpool',....]
                for(int m = 0;m<q.length;m++){
                    if(q[m].equals(Answer[n])){
                        q[m] = "____";//Replace the answer to be ____
                    }
                }
                qlist[n] = "";
                for(int t=0;t<q.length;t++){
                    qlist[n] = qlist[n] + " " + q[t];
                }
            }
            //Create a frame of question part
            JFrame frame = new JFrame();
            frame.setSize(700,800); // setSize(width,height)
            frame.setLocation(300,100);    // setLocation(x,y)
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Use DIDPOSE_ON_CLOSE
        
            /*Create a Panel*/
            JPanel panel = new JPanel();//It create a Panel
            frame.add(panel); // Add the panel
            QuestionPanel(panel,qlist,Answer); // Disgin the Panel + use the method
            frame.setVisible(true);

            
        }catch(Exception e){}
    }


    public static void QuestionPanel(JPanel panel,String[] qlist,String[] Answer){
        panel.setLayout(null);

        JLabel title = new JLabel("Question Page");
        title.setBounds(0,0,100,40);
        panel.add(title);

        JLabel Remind = new JLabel("You need to answer 5 questions in this quiz");
        Remind.setBounds(10,40,300,30);
        panel.add(Remind);
        
        //Qnum = Question number
        int Qnum = 0; 
        //Question 1

        //Question 1 Label
        JLabel Q1 = new JLabel("<html>1: "+qlist[Qnum]+"</html>");
        Q1.setBounds(10,60,700,100);
        panel.add(Q1);

        //Question 1 Answer Label
        JLabel Q1L = new JLabel("Ans:"); 
        Q1L.setBounds(10,160,150,30);//y+100
        panel.add(Q1L);

        //Question 1 Answer TextField
        JTextField Q1A = new JTextField(20);
        Q1A.setBounds(40,160,150,30);
        panel.add(Q1A);

        // Question 2

        //Question 2 Label
        Qnum = Qnum + 1;//Next question
        JLabel Q2 = new JLabel("<html>2: "+qlist[Qnum]+"</html>");
        Q2.setBounds(10,170,700,100);//y +20
        panel.add(Q2);

        //Question 2 Answer Label
        JLabel Q2L = new JLabel("Ans:");
        Q2L.setBounds(10,260,150,30); //y + 100
        panel.add(Q2L);

        //Question 2 Answer TextField
        JTextField Q2A = new JTextField(20);
        Q2A.setBounds(40,260,150,30);
        panel.add(Q2A);

        // Question 3

        //Question 3 Label
        Qnum = Qnum + 1;//Next question
        JLabel Q3 = new JLabel("<html>3: "+qlist[Qnum]+"</html>");
        Q3.setBounds(10,280,700,100); //y +20
        panel.add(Q3);

        //Question 3 Answer Label
        JLabel Q3L = new JLabel("Ans:");
        Q3L.setBounds(10,380,150,30); //y + 100
        panel.add(Q3L);

        //Question 3 Answer TextField
        JTextField Q3A = new JTextField(20);
        Q3A.setBounds(40,380,150,30);
        panel.add(Q3A);

        // Question 4

        //Question 4 Label
        Qnum = Qnum + 1;//Next question
        JLabel Q4 = new JLabel("<html>4: "+qlist[Qnum]+"</html>");
        Q4.setBounds(10,400,700,100); //y +20
        panel.add(Q4);

        //Question 4 Answer Label
        JLabel Q4L = new JLabel("Ans:");
        Q4L.setBounds(10,500,150,30); //y + 100
        panel.add(Q4L);

        //Question 4 Answer TextField
        JTextField Q4A = new JTextField(20);
        Q4A.setBounds(40,500,150,30);
        panel.add(Q4A);

        // Question 5

        //Question 5 Label
        Qnum = Qnum + 1;//Next question
        JLabel Q5 = new JLabel("<html>5: "+qlist[Qnum]+"</html>");
        Q5.setBounds(10,520,700,100); //y +20
        panel.add(Q5);

        //Question 5 Answer Label
        JLabel Q5L = new JLabel("Ans:");
        Q5L.setBounds(10,600,150,30); //y + 100
        panel.add(Q5L);

        //Question 5 Answer TextField
        JTextField Q5A = new JTextField(20);
        Q5A.setBounds(40,600,150,30);
        panel.add(Q5A);

        //Submit Button
        JButton Submit = new JButton("Submit");
        Submit.setBounds(10,640,100,30);
        Submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                String[] UAnswer = {Q1A.getText(),Q2A.getText(),Q3A.getText(),Q4A.getText(),Q5A.getText()};
                int mark = 0;
                for(int n = 0;n<5;n++){
                    if(UAnswer[n].equals(Answer[n])){
                        mark = mark + 1;
                    }
                }
                JOptionPane.showMessageDialog(null,"Your mark is:"+" "+Integer.toString(mark));
            }
        });
        panel.add(Submit);
    }

    public static void TextRead(){ //Read
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
                    System.out.println("Stop: It doesn't have any question can do!");
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
