/* *@author Chan Tze Hei Dawn 20219923 */
/*date created 24/12/2023 */

public class DocManager {
    //method
        public static void DocManager(){
        try{
            JFrame frame = new JFrame();
            frame.setSize(500,500);
            frame.setLocation(400,400);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// It is necessary
        
            /*Create a Panel*/
            JPanel panel = new JPanel();//It create a Panel
            frame.add(panel); // Add the panel
            ReminderP(panel); // Design the Panel + use the method
            frame.setVisible(true);
        }catch(Exception e){}
    }

        public static void DocManagerP(JPanel panel){
            panel.setLayout(null);

            JLabel ReminderLabel = new JLabel("DocManager");// Setting the position of Panel
            ReminderLabel.setBounds(10,20,80,40);  // setBounds(x,y,width,height);
            panel.add(DocManagerLabel); //add the label into the Panel

        
    }
        public static void NotesImport() {
        //Import selected files from files explorer to Learning buddy's library.
        }
        public static void FolderGroup() {
        // Add selected notes into folder, create a new folder if needed.
        } 
        public static void Folderedit() {
        //Changing Folder's Name, Icon and colour.
        }
        public static void Folderconvert() {
            //File format converter.
            }
    }
