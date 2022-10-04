import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.StringTokenizer;
public class guiListener extends JFrame implements ActionListener {
private DateGUI mainFrame;




//constructor
public guiListener(DateGUI GUI){
    mainFrame = GUI;
}
/*will open the file if the menu is clicked on open and then close if the action is clicked on close*/
public void actionPerformed(ActionEvent e){
    String chosenItem = e.getActionCommand();
    if(chosenItem.equals("Open")){
        fileOpen();
    
    }
    if(chosenItem.equals("Close")){
        System.exit(0);
    }
}
/* will opent the file to then read it in readsource*/
private void fileOpen(){
JFileChooser Chooser = new JFileChooser();
Chooser.showOpenDialog(null);
readSource(Chooser.getSelectedFile());
}

/* will read the file chosen to put them into the content pane*/
private void readSource(File fileChose){
    String fileChosenName =  fileChose.getAbsolutePath();
    TextFileInput file = new TextFileInput(fileChosenName);
    String fileRead = file.readLine();
    mainFrame.dates.setText("Raw dates:\n\n");
    mainFrame.finalDate.setText("final dates: \n\n");
    mainFrame.sortedDates.setText("Sorted dates: \n\n");
    while( fileRead != null){
        StringTokenizer lineToken = new StringTokenizer(fileRead,",");   
        while(lineToken.hasMoreTokens()){
            String token = lineToken.nextToken(); 
            try{
                Date212 a = new Date212(token);
                mainFrame.dateMapAdder(a);
                mainFrame.fileDisplayer(token);
                mainFrame.finalFileDisplayer(a.createDate(token));
              }
            catch(IllegalDate212Exception e) {
                System.out.println("The date "+token+" is invalid");
            }

            
        }
         fileRead = file.readLine();
    }
    mainFrame.mapAppender(mainFrame.Date212Map);
}
}
