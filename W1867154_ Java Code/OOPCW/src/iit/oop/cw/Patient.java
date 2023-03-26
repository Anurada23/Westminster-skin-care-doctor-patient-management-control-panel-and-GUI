package iit.oop.cw;

import java.util.Date;
import java.util.Objects;

public  class Patient extends Person{
    private int patientID;
    private String patientNotes;



    public Patient(String fName, String lName, Date dob, int mNumber, int patientID, String patientNotes) {
        super(fName, lName, dob, mNumber);
        this.patientID = patientID;
        this.patientNotes = patientNotes;

    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(String patientNotes) {
        this.patientNotes = patientNotes;
    }



    @Override
    public String toString() {
        return "Patient{" +super.toString()+
                "patientID=" + patientID +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientID == patient.patientID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientID);
    }
}
