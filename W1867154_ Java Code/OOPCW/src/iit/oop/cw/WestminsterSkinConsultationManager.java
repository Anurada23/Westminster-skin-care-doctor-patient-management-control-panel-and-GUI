package iit.oop.cw;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.*;

public  class WestminsterSkinConsultationManager implements SkinConsultationManager {

    public  static final int MAX = 2;
    private List<Doctor> doctorList;
    private List<Patient> patientList ;
    private int freeSlots=2;

    //Initialize consultation Arraylist
    private ArrayList<Consultation> consultations;

    public WestminsterSkinConsultationManager() {


        this.doctorList = new ArrayList<Doctor>();
        this.consultations = new ArrayList<Consultation>();
        this.patientList = new ArrayList<Patient>();

    }






    public List<Doctor> getAvailableDoctors(Date consultationDate, String consultationTime) {
        List<Doctor> availableDoctors = new ArrayList<>();

        System.out.println(consultationTime);
        System.out.println(consultationDate);
        for (Doctor doctor : doctorList) {
            if (doctor.getAvailableDate().equals(consultationDate) && doctor.getAvailableTime().equals(consultationTime)) {
                availableDoctors.add(doctor);
                System.out.println(doctor);

            }
        }
        for (Doctor doctor : doctorList) {
            System.out.println(doctor.getAvailableDate());
            System.out.println( doctor.getAvailableTime());

        }
        return availableDoctors;
    }





    @Override
    public void addDoctor(Doctor doctor) {

        if (this.doctorList.size() < MAX) {
            this.doctorList.add(doctor);

            System.out.println(doctor.getDob());


            System.out.println("Doctor added.");
        } else {
            System.out.println("Cannot add more Doctors\nMemory Full");
        }

    }


    @Override
    public void deleteDoctor(int mLicenseNumber) {
        try {
            for (Doctor doctor : this.doctorList) {
                if (doctor.getmLicenseNumber() == mLicenseNumber) {
                    this.doctorList.remove(doctor);
                    System.out.println("Doctor with medical license number " + mLicenseNumber + " has been deleted.");
                    System.out.println("Total number of doctors: " + this.doctorList.size());
                    return;
                }
            }
            System.out.println("Error: Doctor with medical license number " + mLicenseNumber + " not found.");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input , enter a numerical value");
        }
    }



    @Override
    public void saveToFile() {
        if (this.doctorList.isEmpty()) {
            System.out.println("Error: The list of doctors is empty.");
            System.out.println("Try again after adding a new doctor to the list");
            return;
        }
        try {

            File file = new File("doctors.txt");
           FileWriter writer = new FileWriter(file);
            for (Doctor doctor : this.doctorList) {
                writer.write(doctor.toString());
            }
            for (Doctor doctor : this.doctorList) {
                String line = doctor.getfName() + "," + doctor.getlName() + "," + doctor.getDob() + "," + doctor.getmNumber() + "," + doctor.getmLicenseNumber() + "," + doctor.getSpecial();
               writer.write(line);
           }

            writer.close();

            System.out.println("Information saved to file successfully at: " + file.getAbsolutePath());
        }
        catch (NullPointerException e) {
            System.out.println("Error: The list of doctors is null.");
        }
        catch (IOException e) {
            System.out.println("Error : saving to file.");
        }

    }


    @Override
    public void loadFromFile() {
        try {
            File file = new File("doctors.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/");
                String fName = parts[0];
                String lName = parts[1];
                String dob1 = parts[2];
                int mNumber = Integer.parseInt(parts[3]);
                int mLicenceNumber = Integer.parseInt(parts[4]);
                String special = parts[5];
                String availableTime = parts[6];
                String  availableDate1 = parts[7];

                SimpleDateFormat DateFor1 = new SimpleDateFormat("dd/MM/yyyy");
                Date dob=DateFor1.parse(dob1);
                Date availableDate=DateFor1.parse(availableDate1);




                Doctor doctor = new Doctor( fName, lName,  dob,  mNumber,mLicenceNumber, special,  availableTime,  availableDate);
                this.doctorList.add(doctor);
            }

            reader.close();

            System.out.println("Information loaded from file successfully at: " + file.getAbsolutePath());
        } catch (IOException | ParseException e) {
            System.out.println("Error: Unable to load from file.");
        }
    }




    public void addConsultation(Consultation consultation) {
    }

    public void cancelConsultation(Consultation consultation) {
        consultations.remove(consultation);
    }


    public List<Consultation> getConsultations() {
        return consultations;


    }



    @Override
    public List<Doctor> getDoctors() {
        return doctorList;
    }

    @Override
    public List<Doctor> getPatients() {
        return getPatients();
    }




    @Override
    public void bookConsultation(Doctor doctor, Patient patient, Date date, String timesSlot, Doctor selectedDoctor, Date consultationDateTime) {

    }



 //   @Override
 //  public void cancelConsultation(Consultation consultation) {
//
//       for (Doctor doctor : this.doctors) {
//            if (doctor.getMedicalLicenceNumber() == medical_License_Number) {
//                this.doctors.remove(doctor);
//                System.out.println("Doctor with medical license number " + medical_License_Number + " has been deleted.");
//                System.out.println("Total number of doctors: " + this.doctors.size());
//                return;
//            }
//        }*/
//
//    }

    @Override
    public List<Consultation> getConsultation() {return consultations;}


    //Initialize the printDoctor Method
    public void printDoctors() {
        if (this.doctorList.isEmpty()) {
            System.out.println("Error: The list of doctors is empty.");
            return;
        }
        try {
            Collections.sort(this.doctorList, Comparator.comparing(Person::getlName));
            for (Doctor doctor : this.doctorList) {

                //ToString Method to print Doctor Details
                System.out.println(doctor.toString());



            }
        } catch (NullPointerException e) {
            System.out.println("Error: The list of doctors is null.");
        } catch (ClassCastException e) {
            System.out.println("Error: The list of doctors contains an element that is not a Doctor.");
        }
    }



    private boolean checkAvailability(Doctor doctor, Patient patient, Date consultationDate, String consultationTime){
        if(doctorList.contains(doctor)){
            System.out.println("Doc not found in the list");

        }
        return false;
    }





    public double calculateCost(int PatientID){

        boolean ForFirstConsultation = ForFirstConsultation(PatientID);
        if (ForFirstConsultation){
            return 15;
        }
        else {
            return 25;
        }

    }

    public boolean ForFirstConsultation(int patientId){
        for (Consultation consultation : consultations){
            if (consultation.getPatient().getPatientID() == patientId){
                return false;
            }
        }
        return true;
    }

    @Override
    public void uploadimage(File image) {


    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WestminsterSkinConsultationManager that = (WestminsterSkinConsultationManager) o;
        return freeSlots == that.freeSlots && Objects.equals(doctorList, that.doctorList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorList, freeSlots);
    }
}
