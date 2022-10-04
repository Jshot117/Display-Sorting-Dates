import java.util.StringTokenizer;

/*
 *Project4 sorts Date212 with days
 *@author Jonnathan Saavedra Lab 22B
 */

public class Project4 {
    
    public static void main(String[] args) {
        Date212List unSorted = new UnsortedDate212List();
        Date212List sorted= new SortedDate212List();
        
        TextFileInput file = new TextFileInput("textInput1.txt");
        String line = file.readLine();
        int count = 0;
        int i = 0;

        /*First while loop counts the amount of inputs in the file*/
        StringTokenizer myTokens;
        int tokenCount;
        while( line != null ) {
            myTokens = new StringTokenizer(line, ",");
            tokenCount = myTokens.countTokens(); 
            count = count + tokenCount;
            line = file.readLine();
        }

        String[] tokenList = new String[count];
        //Fills the array with the dates from the input files
        TextFileInput secondFile = new TextFileInput("textInput1.txt");
        String secondLine = secondFile.readLine();
        while( secondLine != null ) {
            myTokens = new StringTokenizer(secondLine, ",");
            while (myTokens.hasMoreTokens()) {
                tokenList[i] = myTokens.nextToken();
                i++;
            }
            secondLine = secondFile.readLine();
        }
        /*Creates an array of object Date212 to create final Date and also adds Date212 objects into unsorted*/
        Date212[] out = new Date212[count];
        for( int c = 0; c < tokenList.length; c++ ){
            Date212 fDate = new Date212(tokenList[c]);
            unSorted.append(fDate);
            out[c] = fDate;
        }
        /*Display the final result with the input file on the left and the sorted formatted dates on the right*/
        DateGUI in = new DateGUI();
        in.appendUnsortedDates(unSorted);
        in.sortDate(out);
        in.display();
    }
}