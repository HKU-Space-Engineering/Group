/* *@author Chan Tze Hei Dawn 20219923 */
/*date created 24/12/2023 */

//Module
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.*;
import java.nio.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DocManager {
    public static void main(String[]args){
        docManager();
    }

    //method
    public static void docManager(){
    try{
        JFrame mainframe = new JFrame();
        mainframe.setSize(500,500);
        mainframe.setLocation(400,400);
        mainframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// It is necessary
    
        /*Create a Panel*/
        JPanel panel = new JPanel();//It create a Panel
        mainframe.add(panel); // Add the panel
        docManagerP(panel); // Design the Panel + use the method
        mainframe.setVisible(true);
    }catch(Exception e){}
    }

    public static void docManagerP(JPanel panel){
        panel.setLayout(null);

        //text
        JLabel docManagerLabel = new JLabel("Document Manager");// Setting the position of Panel
        docManagerLabel.setBounds(10,20,200,30);  // setBounds(x,y,width,height);
        panel.add(docManagerLabel); //add the label into the Panel

        //buttons
        JButton NotesImport = new JButton("Import a note");//Create a Button
        NotesImport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                notesImport();
            }
        });
        NotesImport.setBounds(10,100,200,25);
        panel.add(NotesImport);

        JButton FolderGroup = new JButton("Group folders");//Create a Button
        FolderGroup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                folderGroup();
            }
        });
        FolderGroup.setBounds(10,130,200,25);
        panel.add(FolderGroup);

        JButton Folderedit = new JButton("Edit folder");//Create a Button
        Folderedit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                folderedit();
            }
        });
        Folderedit.setBounds(10,160,200,25);
        panel.add(Folderedit);

        JButton Fileconvert = new JButton("Covert a file");//Create a Button
        Fileconvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                fileconvert();
            }
        });
        Fileconvert.setBounds(10,190,200,25);
        panel.add(Fileconvert);
    }

    //Set properties
    public void setsubject(Path targetf){

    }


    
        
    //main functions
    public static void notesImport() {
    //Import selected files from files explorer to Learning buddy's library.
        //Select file to import
        try {
            Files.createDirectories(Paths.get(System.getProperty("user.dir"),
                        "\\Notes\\ungrouped"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JFrame filechoose = new JFrame();
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        chooser.setApproveButtonText("Import");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "PDF/TXT Only (Files will be replaced if already exists)", "pdf", "txt"); //File format filter
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(filechoose);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            //move file to program directory, add file to file list.
            File cFile = chooser.getSelectedFile();
            Path source = cFile.toPath();
            Path target = Paths.get(System.getProperty("user.dir"),"\\Notes\\ungrouped",
            cFile.getName());
            try {
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //create property file
            try {
                String pFilename = System.getProperty("user.dir") + "\\Notes\\ungrouped\\" + 
                selected.getFileNameWoEx(cFile)+ ".properties";
                File pFile = new File(pFilename);
                System.out.print("Property file created in " + pFilename);
                pFile.createNewFile();

                selected impFile = new selected(pFile); //adding property fields
                impFile.setProp(1, null);//set import date
                String fileType = selected.getFileEx(cFile);//set file type
                impFile.setProp(2, fileType);
                impFile.setProp(3, target.toString());

                //D count +1
                String count = Storage.TextFileRead("DCount.txt"); //Read the number from the DCount.txt
                int n = Integer.parseInt(count);
                n++;
                Storage.TextFileDelete("DCount.txt"); // Delete the old file
                Storage.TextFileInput("DCount.txt",Integer.toString(n));

            }   catch(IOException e){
                e.printStackTrace();

            }

        }



    }
    public static void folderGroup() {
    // Add selected notes into folder, create a new folder if needed.
        JFrame filechoose = new JFrame();
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir") + "\\Notes");
        chooser.setApproveButtonText("Group");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "Choose the note you wanted to group", "properties"); //File format filter
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(filechoose);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            String gName = JOptionPane.showInputDialog("Input group name");
            //create folder if group not exist
            try {
                String groupPath = Files.createDirectories(Paths.get(System.getProperty("user.dir"),
                    "\\Notes\\", gName)).toString();
                Properties prop = new Properties();
                FileInputStream pStream = new FileInputStream(chooser.getSelectedFile());

                String pGroupname = System.getProperty("user.dir") + "\\Notes\\" +
                gName + ".properties";
                File pFile = new File(pGroupname);
                System.out.print("Property file created in " + pGroupname);
                pFile.createNewFile();
                selected impFile = new selected(pFile); //adding property fields
                impFile.setProp(1, null); //set import date
                String fileType = "group"; //set file type
                impFile.setProp(2, fileType);
            
                prop.load(pStream);

            //move note
            File nFile = new File(prop.getProperty("Note_path"));
            Path nsource = Paths.get(prop.getProperty("Note_path"));
            Path ntarget = Paths.get(groupPath, nFile.getName());
            Path psource = chooser.getSelectedFile().toPath();
            Path ptarget = Paths.get(groupPath, chooser.getSelectedFile().getName());
            pStream.close();
            Files.move(nsource, ntarget, StandardCopyOption.REPLACE_EXISTING);
            Files.move(psource, ptarget, StandardCopyOption.REPLACE_EXISTING);
            selected newProp = new selected(new File(ptarget.toString()));
            newProp.setProp(4, gName);
            
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } 
    public static void folderedit() {
        //Changing Folder's Name, Icon and colour.
        JFrame filechoose = new JFrame();
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir") + "\\Notes");
        chooser.setApproveButtonText("Edit");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "Choose the folder you wanted to edit", "properties"); //File format filter
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(filechoose);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            selected impFile = new selected(chooser.getSelectedFile());
            // Display a optionpane
            String[] options = { "Name", "Icon", "Colour"};
            int choice = JOptionPane.showOptionDialog(null, "Select options:", 
            "Edit Folder", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]); 

            // Check the user's choice and display a corresponding message 
            switch (choice) {
                case 0:
                    
                    break;
            
                case 2:
                String[] coptions = { "Red", "Green", "Blue", "White"};
                String input = (String) JOptionPane.showInputDialog(null, "",
                "Colours", JOptionPane.QUESTION_MESSAGE, null, coptions, coptions[1]);
                switch (input){
                    case "Red":
                    impFile.setProp(5, input);
                    

                }
                break;
            }
        } 
    }
    public static void fileconvert() {
    //File format converter
        //tell user to move photos to source folder
        JOptionPane.showMessageDialog(null,"You need to put all the jpg file into the Photo floder");

        //convert 
        try{
            System.out.println("convert");
            Process proc = Runtime.getRuntime().exec("img2pdf3.exe"); // Runing a exe program
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error in the python part");
        }
        
        
    }
}