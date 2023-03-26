package iit.oop.cw;

import java.io.File;
import java.util.Date;
import java.util.List;

public interface SkinConsultationManager {
    void addDoctor(Doctor doctor);
    void deleteDoctor(int mLicenseNumber);
    //void removeDoctor(Doctor doctor);
    List<Doctor> getDoctors();
    List<Doctor> getPatients();

    void bookConsultation(Doctor doctor, Patient patient, Date date, String timesSlot, Doctor selectedDoctor, Date consultationDateTime);
    List<Consultation> getConsultation();



    void printDoctors();
   // void save();

    void saveToFile();
    void loadFromFile();



    void uploadimage(File image);
}
