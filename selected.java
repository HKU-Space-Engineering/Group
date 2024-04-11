/* *@author Chan Tze Hei Dawn 20219923 */
//Module
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.nio.*;
import java.util.Properties;

public class selected {
    File note;
    File property;
    String propPath;
    Properties prop = new Properties();
    String dateTime = "1970-01-01 00:00:00";
    int dcount = -1;
    String colour = "#000000";

    selected(File propF){
        property = propF;
        propPath = propF.getPath();

        try (FileInputStream fis = new FileInputStream(propPath)){
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //dateTime = Current date and time
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        dateTime = dateFormat.format(date);

        // loading note file
 }

    public static String getFileNameWoEx(File file){
        String fileName = file.getName();
        int pos = fileName.lastIndexOf(".");
        if (pos > 0) {
            fileName = fileName.substring(0, pos);
        }
        return fileName;
    }

    public static String getFileEx(File file){
        String filePath = file.getName();
        filePath = filePath.substring(filePath.lastIndexOf("."), filePath.length());
        return filePath;
    }

    public void setProp(int propNum, String propValue) {
        // Check if property file exist
        try (FileInputStream fis = new FileInputStream(propPath)){
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // modify selected property and save to properties file.
        switch (propNum){

            case 1: //set import date
            prop.setProperty("Import_Date", dateTime);
                try (FileOutputStream fos = new FileOutputStream(propPath)){
                    prop.store(fos, null);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case 2: //set import date
            prop.setProperty("File_type", propValue);
            try (FileOutputStream fos = new FileOutputStream(propPath)){
                prop.store(fos, null);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case 3:
                prop.setProperty("Note_path", propValue);
                try (FileOutputStream fos = new FileOutputStream(propPath)){
                    prop.store(fos, null);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
                    

            

            case 4: //set group
            prop.setProperty("Group", propValue);
            try (FileOutputStream fos = new FileOutputStream(propPath)){
                prop.store(fos, null);
                    File nFile = new File(prop.getProperty("Note_path"));
                    setProp(3, System.getProperty("user.dir")+
                    "\\Notes\\" + propValue + nFile.getName());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                break;

            case 5:
            prop.setProperty("Colour", propValue);
            try (FileOutputStream fos = new FileOutputStream(propPath)){
                prop.store(fos, null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;

        }
    }

    public void dispProp(int propNum){
        try (FileInputStream fis = new FileInputStream(propPath)){
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (propNum) {
            case 0:
                
                break;
        
            default:
                break;
        }

    }
    
}
