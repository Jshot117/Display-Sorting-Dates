

/*
 * class date212
 * There is a createDate string to set the year, month and day
 * There is a toString method to format the date heading
 * There is a compareTo method to compare the dates 
*/
public class Date212 implements Comparable<Date212>{
    private int year;
    private int month;
    private int day;
    public String date;
    String[] monthString = new String[] { "January", "Febuary", "March", "April", "May", "June", "July", "August",
            "September","october", "November", "December" };
    String[] monthDay = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
    int[] maxDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  
    public Date212(String data) {
        if(data.length()>8)throw  new IllegalDate212Exception(data);
        if(Integer.parseInt(data.substring(4, 6))>12 || Integer.parseInt(data.substring(4, 6))< 1) throw new IllegalDate212Exception(data);
        if(Integer.parseInt(data.substring(6, 8))>31 || Integer.parseInt(data.substring(6, 8))<1) throw new IllegalDate212Exception(data);
        if(Integer.parseInt(data.substring(0, 4))<0) throw new IllegalDate212Exception(data);

         setDate(data);
    }

    public void setYear(int newYear) {
        this.year = newYear;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int newMonth) {
        this.month = newMonth;
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int newDay) {
        this.day = newDay;
    }

    public int getDay() {
        return day;
    } 
     //setDate would break down the string and set the result into each variable
     public void setDate(String Data) {
        // used substring and integer.parseInt to break up the string into values of int for year,month,date
        this.year = Integer.parseInt(Data.substring(0, 4)); //Integer.parseInt changes the string into an int
        this.month = Integer.parseInt(Data.substring(4, 6)); //substring takes the starting positions inclusive
        this.day = Integer.parseInt(Data.substring(6, 8));  // and the ending position not inclusive this help sets each
        

    }
 
   /* createDate will parse the dateString in order to get the year, month and date separetly into ints */
    public String createDate(String dateString) {
        year = Integer.parseInt(dateString.substring(0, 4));
        month = Integer.parseInt(dateString.substring(4, 6));
        day = Integer.parseInt(dateString.substring(6));
        return date = toString();

    }
  /* it will create the date heading string when given month day and year */
    public String toString() {
            String name = monthString[month - 1];
            int h;
            int i = month + 1;
            int j = year % 100;
            int d = year / 100;
            h = ( day + ( (26 * i)/ 10 ) + j + (j/4) + (d/4) + (5*d) ) % 7; // Zeller's algorithm
            String nameD = monthDay[h]; //Made an array of day's name
            return ( nameD + " " + name + ", " + Integer.toString(this.year) );
        }

    /* if one Date212 object is equal to another Date212 object */
    public boolean equals(Date212 object) {
        return (this.month == object.month && this.day == object.day && this.year == object.year);
    }

    public int compareTo(Date212 object){
        /* if the current Date212 object date is less than the other object Date212 object date the function will return -1*/
        if (this.year < object.year) return -1;
        if (this.year > object.year) return 1;
        if (this.year == object.year && this.month < object.month) return -1;
        if (this.year == object.year && this.month > object.month) return 1;
        if (this.year == object.year && this.month == object.month && this.day < object.day) return -1;
        if (this.year == object.year && this.month == object.month && this.day > object.day) return 1;
        else return 0;
    }
    

}