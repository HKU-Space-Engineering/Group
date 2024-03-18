/**@author Jian Chun Hin,20207461,Ben */
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import javax.swing.JOptionPane;

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

    public static void TextFileDelete(String FName){
        File a = new File(FName);
        a.delete();
        System.out.println("Delete File Successfully");
    }

    public static String TextFileRead(String FName){
        String output = "";
        try{
            String data; //it is the var to store the data from the txt file
            BufferedReader bufferReader = new BufferedReader(new FileReader(FName,StandardCharsets.UTF_8));
            while ((( data = bufferReader.readLine()) != null)){
                if(data == " "){
                    break;
                }else{
                    output = data;
                }
            }
            bufferReader.close();
        }catch(IOException e){}
        return output;
    }
}
