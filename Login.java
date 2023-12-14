/**@author Jian Chun Hin 20207461 */
/*Date_Create:16/11/2023 */
/*It is a class for Login */

/*UML Diagram 
*  

Login
---------------
uName:String
uID:int
uBirth:int
uSchool:String
uEmail:String
----------------
Login(Name:String, ID:int, Brith:int, School:String)
+ CreateAccount()
+getName()
+getAgg()
+getInfo()
+CheckAccount(AccountID:String,Passowrd:int):Boolean
+Interface()
+PComponent(panel:JPanel)


*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Login {
//Field
    public static String uName;
    public static int uID;
    public static int uBirth;
    public static String uSchool;
    public static String uEmail;
//Constructor
    public Login(String Name,int ID,int Birth,String School,String Email){
        // Constructor for the class -> Login.java 
        uName = Name;
        uID = ID;
        uBirth = Birth;
        uSchool = School;
        uEmail = Email;
    }
//Method
    public void CreateAccount(){
        //Data Input page
        
    }

    public String getName(){
        // return name
        return uName;
    }

    public String getAge(){
        // measure the age 
        //Need to use some module about time
        return "18";
    }

    public String getInfo(){
        //return info
        String data = uName + uID + uBirth + uSchool + uEmail;
        return data;
    }

    public static Boolean CheckAccount(String AccountID,int password){
        //1. Read the Account.txt file
        //2.check the account and password
        Boolean exist = false;
        String Strline;
        try{
            BufferedReader bufferReader = new BufferedReader(new FileReader("Account.txt"));
            while((Strline = bufferReader.readLine()) != null){
            //The format of the file: 
            //     AccountID +" " + password
            //E.g. 20207461 1234567890 
                if(Strline == AccountID +" " + password){
                    exist = true;
                }
            }
            bufferReader.close();
        }catch(IOException e){}
        return exist;
    }

    public static void Interface(){
        try{
            JFrame frame = new JFrame();
            frame.setSize(500,500);
            frame.setLocation(400,400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*Don't ask me that what is it. I also don't know. */
        
            /*Create a Panel*/
            JPanel panel = new JPanel();//It create a Panel
            frame.add(panel); // Add the panel
            PComponent(panel); // Disgin the Panel + use the method
            frame.setVisible(true);

        }catch(Exception e){
            //something we need to write
        }
    }

    private static void PComponent(JPanel panel){
        //A Mehtod to design the panel
        panel.setLayout(null);// A setting of layout

        JLabel userLabel = new JLabel("User Account:");// Seting the position of Panel
        userLabel.setBounds(10,20,80,25);  // setBounds(x,y,width,height);
        panel.add(userLabel); //add the label into the Panel


        /*Create A TextBox for People to input */
        JTextField userAccountID = new JTextField(20);
        userAccountID.setBounds(100,20,165,25);
        panel.add(userAccountID);

        /*Create a Password TextBox */
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        /*Create a PassWord TextBox(High Level)[The String was repersented by . ] */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        /*Create a Login Button */
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10,80,80,25);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                //Already solve the GUI event problem
                String AccountID = userAccountID.getText(); // Get the AccountID from the box.
                String Password = passwordText.getPassword().toString(); // Get the Password from the password boc.
                if(CheckAccount(AccountID,Integer.valueOf(Password))){//Check the Existance of account
                    //if yes, login
                    System.out.println("Successful Login");
                    //Call function, from the Learning
                }else{
                    //
                    System.out.printf("123");
                    JOptionPane.showMessageDialog(null,"The AccountID or Password don't Exist!");//I hope it can return a Joption but it doesn't work!
                }
            }
        });
        panel.add(loginButton,BorderLayout.SOUTH);

        JButton CreateAccount = new JButton("Create Account");
        CreateAccount.setBounds(100,80,150,25);
        CreateAccount.addActionListener(new ActionListener() { // Actionlistener
            public void actionPerformed(ActionEvent event){ // Event
                System.out.println("2");
            }
        }); // Listener
        panel.add(CreateAccount,BorderLayout.SOUTH);
    }
    public static void main(String [] args){
        System.out.printf("This main fuction just for testing the method");
    }
}
