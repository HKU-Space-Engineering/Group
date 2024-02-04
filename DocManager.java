/* *@author Chan Tze Hei Dawn 20219923 */
/*date created 24/12/2023 */

//Module
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.*;
import java.io.IOException;

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
        JFrame filechoose = new JFrame();
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "PDF Only (Use File converter for other file formats)", "pdf"); //File format filter
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(filechoose);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            //move file to program directory, add file to file list.
            Path source = chooser.getSelectedFile().toPath();
            Path target = Paths.get(System.getProperty("user.dir"),"\\Notes",
            chooser.getSelectedFile().getName());
            try {
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
    public static void folderGroup() {
    // Add selected notes into folder, create a new folder if needed.
    } 
    public static void folderedit() {
    //Changing Folder's Name, Icon and colour.
    }
    public static void fileconvert() {
    //File format converter
        //Select a file to convert
        JFrame filechoose = new JFrame();
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "PDF Only (Use File converter for other file formats)", "docx", ""); //File format filter
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(filechoose);
        if (returnVal == JFileChooser.APPROVE_OPTION){
        }
    }
}