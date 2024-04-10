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
import java.nio.*;
import java.util.Properties;

public class selected {
    File path;
    String propPath = "";
    String impDate = "1970-01-01 00:00:00";
    int dcount = -1;
    String lastview = "1970-01-01 00:00:00";
    String colour = "#000000";


    public void setimpDate(){

    }

    public static String getFileNameWoEx(File file){
        String fileName = file.getName();
        int pos = fileName.lastIndexOf(".");
        if (pos > 0) {
            fileName = fileName.substring(0, pos);
        }
        return fileName;
    }

    public void setprop(int propnum) {
        // Check if property file exist
        
        File propFile = new File(propPath);

        // modify selected property and save to properties file.
        switch (propnum){
            case 1:
            

        }
    }
    
}
