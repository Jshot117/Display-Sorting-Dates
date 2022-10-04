
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * DateGui
 * creates the Gui
 * Appends the input dates from the file and the formatted dates
 * Uses a sort method to call a compareTo method form Date212 to sort the formatted dates
 */
public class DateGUI extends JFrame {
    Container cPane = getContentPane();
    TextArea dates = new TextArea();
    TextArea finalDate = new TextArea();
    TextArea unSortedDates = new TextArea();
    TextArea sortedDates = new TextArea();
    TextFileInput file = new TextFileInput("textInput1.txt");
    TreeMap <Date212,String> Date212Map= new TreeMap<Date212,String>();
    private JMenuBar mainMenuBar;
    private JMenu fileMenu;
    private JMenuItem mOpen, mClose;
    private guiListener clicking;

    /* constructor used to call the function initialize and appendDates */
    public DateGUI() {
         initialize();
         appendDates(); 

        mainMenuBar = new JMenuBar();
        mOpen = new JMenuItem("Open");
        mClose = new JMenuItem("close");
        fileMenu = new JMenu("file JMenu");
        mainMenuBar.add(fileMenu);
        fileMenu.add(mOpen);
        fileMenu.addSeparator();
        fileMenu.add(mClose);
        //cPane.setLayout(new GridLayout(1, 2));
        //cPane.add(dates);
        //cPane.add(finalDate);
        //cPane.add(sortedDates);
       
        setJMenuBar(mainMenuBar);
        clicking = new guiListener(this);
        mOpen.addActionListener(clicking);
        mClose.addActionListener(clicking);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocation(100, 100);
        setVisible(true);
    }
    /* will append the file to Dates*/
    public void fileDisplayer(String line){
        dates.append(line + "\n");
    }
    /* will append the dates in words into final dates*/
    public void finalFileDisplayer(String line){
        finalDate.append(line + "\n");
    }
    /* will append the dates from a tree map into sorted Dates*/
    public void mapAppender(TreeMap a){
        Iterator <Map.Entry<Date212, String>> mapIterator = a.entrySet().iterator();
        while (mapIterator.hasNext()){
            sortedDates.append(mapIterator.next().getKey().toString() + "\n");
        }
        }
    


    /* Sets up the Gui to display the dates */
    public void initialize() {
        TextFileInput file = new TextFileInput("textInput1.txt");
        cPane.setLayout(new GridLayout(1, 2));
        cPane.add(dates);
        cPane.add(finalDate);
        cPane.add(unSortedDates);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /* allowing the user to see the Gui but not allowing the user to edit */
    public void display() {
        dates.setEditable(false);
        finalDate.setEditable(false);
        pack();
        setVisible(true);
        appendDates();

    }

    /* read input from the file and then append the input */
    public void appendDates() {
        String line = file.readLine();
        while (line != null) {
            dates.append(line + "\n");
            line = file.readLine();
        }
    }

    /*
     * The function appends the correct formatting for the date by taking in an
     * array of object Date212
     */
    public void appendFinalDates(Date212[] date) {
        for (int i = 0; i < date.length; i++) {
            finalDate.append(date[i].toString() + "\n");
        }
    }

    /* method to display the unsorted Date212 list on the Gui */
    public void appendUnsortedDates(Date212List unSorted) {
        Date212Node newNode = unSorted.firstNode.next;
        for (int i = 0; i < unSorted.getLength(); i++) {
            unSortedDates.append(newNode.data.toString() + "\n");
            newNode = newNode.next;
        }
    }

    /*
     * Sorts the Date from most recent to least in order to create a chronological
     * order
     */
    public void sortDate(Date212[] date) {
        for (int i = 0; i < date.length - 1; i++) {
            if (date[i].compareTo(date[i + 1]) == -1) {
                Date212 temp = date[i];
                date[i] = date[i + 1];
                date[i + 1] = temp;
                i = -1; // set i to -1 in order to make the first postition in the array the least date
            }
        }
        appendFinalDates(date); // sends results to appendFinalDates
    }
    /* will put a date212 into the Date212Map*/
    public void dateMapAdder(Date212 b){
        Date212Map.put(b,null);
    }

    
}