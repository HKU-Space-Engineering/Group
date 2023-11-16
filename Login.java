/**@author Jian Chun Hin 20207461 */
/*Date_Create:16/11/2023 */
/*It is a class for Login */

/*UML Diagram 
*  

Login
---------------
uName:String
uID:int
uBirth:int
uSchool:String
----------------
Login(Name:String, ID:int, Brith:int, School:String)

+ CreateAccount()


*/


public class Login {
//Field
    String uName;
    int uID;
    int uBirth;
    String uSchool;
//Constructor
    public Login(String Name,int ID,int Birth,String School){
        // Constructor for the class -> Login.java 
        uName = Name;
        uID = ID;
        uBirth = Birth;
        uSchool = School;
    }
//Method
    public void CreateAccount(){
        //出現資料填寫頁
        
    }
}
