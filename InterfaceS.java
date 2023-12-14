import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**@author Jian Chun Hin  */

/*Don't use Chinese to write, It will cause an Error when you compile the program */
public class InterfaceS {
    public static void main(String [] args){
        //A example for interface* by Jian CHun Hin
        JFrame frame = new JFrame("Example");

        // A setting of size
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*Don't ask me that what is it. I also don't know. */
        
        /*Create a Panel*/
        JPanel panel = new JPanel();//It create a Panel
        frame.add(panel); // Add the panel
        PComponent(panel); // Disgin the Panel + use the method

        frame.setVisible(true);
    }

    private static void PComponent(JPanel panel){
        //A Mehtod to design the panel
        panel.setLayout(null);// A setting of layout

        JLabel userLabel = new JLabel("User:");// Seting the position of Panel
        userLabel.setBounds(10,20,80,25);  // setBounds(x,y,width,height);
        panel.add(userLabel); //add the label into the Panel


        /*Create A TextBox for People to input */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

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
                String AccountID = userText.getText();
                System.out.println(AccountID);
            JOptionPane.showMessageDialog(null,AccountID);
            }
        });
        panel.add(loginButton);

        JTextArea textArea = new JTextArea();
        textArea.setText("Here is the text area\n");
        textArea.append("Hellow");
        textArea.setBounds(10,120,200,50);
        panel.add(textArea);
    }
    
}
