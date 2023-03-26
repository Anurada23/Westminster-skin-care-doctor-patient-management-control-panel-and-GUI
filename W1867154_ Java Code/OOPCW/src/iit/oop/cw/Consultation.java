package iit.oop.cw;

import java.util.Date;


public class Consultation {
    private static Date date;
    private static String timeSlot;
    private static double cost;
    private String notes;
    private Doctor doctor;
    private Patient patient;



    public Consultation(Doctor doctor, Patient patient, Date date, String timeSlot) {
        this.date = date;
        this.timeSlot = timeSlot;
        this.patient =patient;
        this.doctor=doctor;


    }




    public static Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static String getTimeSlot() {
        return timeSlot;
    }

    public static double getCost() {
        return cost;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }


    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
