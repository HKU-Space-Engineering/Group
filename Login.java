/**@author Jian Chun Hin 20207461 */
/*Date_Create:16/11/2023 */
/*It is a class for Login */

/*UML Diagram 
*  

Login
---------------
uName:String
uID:int
uSchool:String
uEmail:String
----------------
Login(Name:String, ID:int, School:String)
+ CreateAccount()
-CAPanel
+getName()
+getAgg()
+getInfo()
+CheckAccount(AccountID:String,Passowrd:String):Boolean
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
    public static String uID;
    public static String uSchool;
    public static String uEmail;
//Constructor
    public Login(String Name,String ID,String School,String Email){
        // Constructor for the class -> Login.java 
        uName = Name;
        uID = ID;
        uSchool = School;
        uEmail = Email;
    }
//Method
    public static void CreateAccount(){
        try{
            JFrame frame = new JFrame();
            frame.setSize(300,300);
            frame.setLocation(900,400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*Don't ask me that what is it. I also don't know. */
            /*Create a Panel*/
            JPanel panel = new JPanel();//It create a Panel
            frame.add(panel); // Add the panel
            CAPanel(panel); // Call the CAPane, fullname of this is CreateAccountPanel
            frame.setVisible(true);
        }catch(Exception e){}
    }

    private static void CAPanel(JPanel panel){
        panel.setLayout(null);// A setting of layout

        JLabel userLabel = new JLabel("Please Input your information");// Seting the position of Panel
        userLabel.setBounds(10,0,200,25);  // setBounds(x,y,width,height);
        panel.add(userLabel); //add the label into the Panel

        JLabel JName = new JLabel("UserName:");//The UserName
        JName.setBounds(10,40,100,25);
        panel.add(JName);

        /*Create A TextBox for People to input */
        JTextField UserName = new JTextField(20);
        UserName.setBounds(130,40,100,25);
        panel.add(UserName);

        JLabel JID = new JLabel("UserID:");//The username, which will be a accountID
        JID.setBounds(10,80,100,25);
        panel.add(JID);

        /*Create A TextBox for People to input */
        JTextField UserID = new JTextField(20);
        UserID.setBounds(130,80,100,25);
        panel.add(UserID);

        JLabel JSchool = new JLabel("Your School:");//The username, which will be a accountID
        JSchool.setBounds(10,120,100,25);
        panel.add(JSchool);

        /*Create A TextBox for People to input */
        JTextField UserSchool = new JTextField(20);
        UserSchool.setBounds(130,120,100,25);
        panel.add(UserSchool);

        JLabel JEmail = new JLabel("Your Email:");//The username, which will be a accountID
        JEmail.setBounds(10,160,100,25);
        panel.add(JEmail);

        /*Create A TextBox for People to input */
        JTextField UserEmail = new JTextField(20);
        UserEmail.setBounds(130,160,100,25);
        panel.add(UserEmail);

        JLabel JPassword = new JLabel("Set Password:");//The username, which will be a accountID
        JPassword.setBounds(10,200,100,25);
        panel.add(JPassword);

        /*Create A TextBox for People to input */
        JTextField UserPassword = new JTextField(20);
        UserPassword.setBounds(130,200,100,25);
        panel.add(UserPassword);

        JButton Confirm = new JButton("Confirm");
        Confirm.setBounds(10,240,100,25);
        Confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                Login newUser = new Login(UserName.getText(), UserID.getText(), UserSchool.getText(), UserEmail.getText());
                String Text = newUser.getName()+UserPassword.getText();
                Storage.TextFileInput("Account.txt", Text);
            } 
        });
        panel.add(Confirm,BorderLayout.SOUTH);

    }





    public String getName(){
        // return name
        return uName;
    }

    public String getInfo(){
        //return info
        String data = uName + uID + uSchool + uEmail;
        return data;
    }






    // A method was used to check the account existance
    public static Boolean CheckAccount(String AccountID,String password){
        // This function hava a seriou bug: 
        //1. Read the Account.txt file
        //2.check the account and password <- bug is here
        // Jian Chun Hin use a print function to print the file password and the user input password.
        // Even though they are same, they are still no equal to each other.
        // For example, file password is "1b", user input "1b" 
        Boolean exist = false;
        String Strline;
        try{
            BufferedReader bufferReader = new BufferedReader(new FileReader("Account.txt"));
            while((Strline = bufferReader.readLine()) != null){
            //The format of the file: 
            //E.g. 
            //20207461
            //1234567890 
            String Password = AccountID+password;
                if(Strline.equals(Password)){//Occur a bug######
                    exist = true;
                    break;
                }
            }
            bufferReader.close();
        }catch(IOException e){}
        return exist;
    }





    public static void Interface(){
        try{
            JFrame frame = new JFrame();
            frame.setSize(600,400);
            frame.setLocation(300,400);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
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

        ImageIcon userimage = new ImageIcon("./src/UserImage.jpg");
        JLabel imagelabel = new JLabel(userimage);
        imagelabel.setBounds(20,20,247,221);
        panel.add(imagelabel);

        JLabel title = new JLabel("Login");
        Font T = new Font("Times New Roman",Font.BOLD+Font.ITALIC,50);
        title.setFont(T);
        title.setBounds(350, 25, 200, 100);
        panel.add(title);

        JLabel userLabel = new JLabel("User Account:");// Seting the position of Panel
        userLabel.setBounds(300,120,100,40);  // setBounds(x,y,width,height);
        panel.add(userLabel); //add the label into the Panel


        /*Create A TextBox for People to input */
        JTextField userAccountID = new JTextField(20);
        userAccountID.setBounds(400,120,165,25);
        panel.add(userAccountID);

        /*Create a Password TextBox */
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(300, 150, 80, 40);
        panel.add(passwordLabel);

        /*Create a PassWord TextBox(Password)*/
        JTextField passwordText = new JTextField(20);
        passwordText.setBounds(400,150,165,25);
        panel.add(passwordText);

        /*Create a Login Button */
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(300,200,80,25);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                //Already solve the GUI event problem
                String AccountID = userAccountID.getText(); // Get the AccountID from the box.
                String Password = passwordText.getText(); // Get the Password from the password boc.
                if(CheckAccount(AccountID,Password)){//Check the Existance of account
                    //if yes, login
                    JOptionPane.showMessageDialog(null,"Login Successfully");
                    //Call function, from the Learning_Buddy.java
                    Learning_Buddy.MainInterface();
                }else{
                    //
                    JOptionPane.showMessageDialog(null,"The AccountID or Password don't Exist!");
                    Learning_Buddy.MainInterface();
                }
                
            }
        });
        panel.add(loginButton,BorderLayout.SOUTH);

        JButton CreateAccount = new JButton("Create Account");
        CreateAccount.setBounds(400,200,150,25);
        CreateAccount.addActionListener(new ActionListener() { // Actionlistener
            public void actionPerformed(ActionEvent event){ // Event
                CreateAccount();
            }
        }); // Listener
        panel.add(CreateAccount,BorderLayout.SOUTH);
    }







    public static void main(String [] args){
        System.out.printf("This main fuction just for testing the method");
        Interface();
    }
}
