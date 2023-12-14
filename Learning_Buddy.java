/**Learning Buddy
 * @author Jian Chun Hin 
 * 
 */

/*UML Digram
 
Learning Buddy
---------------------
String uName;
int uID;
int uBirth;
String uSchool;
-----------------------
+ main(args [] String)
+ MainInterface()
*/


public class Learning_Buddy {
//field
String uName;
int uID;
int uBirth;
String uSchool;

    public static void main(String[] args){
        System.out.printf("Welcome to the Learning Buddy");
        try{
            Login.Interface();
        }catch(Exception e){}
    }   

    public static void MainInterface(){
        System.out.println("Find one people to finish it.");
    }
}
