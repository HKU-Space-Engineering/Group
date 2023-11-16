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
*/


public class Learning_Buddy {
//field
String uName;
int uID;
int uBirth;
String uSchool;

    public void main(String[] args){
        System.out.printf("Welcome to the Learning Buddy");
        try{
            //Check does the user has created their account yet.
            //if not, then run "Login.CreateAccount()" in catch(),else keep running
        }catch(Exception e){
            //something we need to write
        }
    }
}
