/**@author Jian Chun Hin,20207461,Ben */
import java.io.*;
import java.util.*;

/*This class aims to provide a FileIO function. Such as storage some text in a text file */
public class Storage {
    public static void main(String[] args){
        System.out.println("It is a Storage Class");
    }
    
    public static void TextFileInput(String FName,String text){
        try{
            PrintWriter outStream = new PrintWriter(new FileWriter(FName,true));
            outStream.println(text);
            outStream.close();
        }catch(IOException ioE){}
    }
}
