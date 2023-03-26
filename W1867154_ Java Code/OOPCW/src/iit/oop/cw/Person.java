package iit.oop.cw;


import java.util.Date;

public class Person {
    private String fName;
    private String lName;
    private Date dob;
    private int mNumber;

    public Person(String fName, String lName, Date dob, int mNumber) {
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.mNumber = mNumber;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getmNumber() {
        return mNumber;
    }

    public void setmNumber(int mNumber) {
        this.mNumber = mNumber;
    }

    @Override
    public String toString() {
        return
                 fName + "/" +
                  lName + "/" +
                         String.format("%1$tb %1$te, %1$tY",
                                 getDob())  +"/"+
                 mNumber
                ;
    }


}
