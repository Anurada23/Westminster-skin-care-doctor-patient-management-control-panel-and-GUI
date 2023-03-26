package iit.oop.cw;
import java.util.Date;

import java.util.Objects;

public class Doctor extends Person  {

    private int mLicenseNumber;
    private String Special;
    private  String availableTime;
    private Date availableDate;

    public Doctor(String fName, String lName, Date dob, int mNumber, int mLicenseNumber, String special, String availableTime, Date availableDate) {
        super(fName, lName, dob, mNumber);
        this.mLicenseNumber = mLicenseNumber;
        this.Special = special;
        this.availableTime= String.valueOf(availableTime);
        this.availableDate = availableDate;
    }
    public int getmLicenseNumber() {

        return mLicenseNumber;
    }

    public void setmLicenseNumber(int mLicenseNumber) {

        this.mLicenseNumber = mLicenseNumber;
    }

    public String getSpecial() {

        return Special;
    }

    public void setSpecial(String special) {

        Special = special;
    }

    public String getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(String availableTime) {
        this.availableTime = availableTime;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    @Override
    public String toString() {
        return  super.toString()+"/"+
                 mLicenseNumber +"/"+
                  Special+"/"+
                availableTime+"/"+
                String.format("%1$tb %1$te, %1$tY",
                        getAvailableDate())
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return mLicenseNumber == doctor.mLicenseNumber && Objects.equals(Special, doctor.Special);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mLicenseNumber, Special);
    }


}
