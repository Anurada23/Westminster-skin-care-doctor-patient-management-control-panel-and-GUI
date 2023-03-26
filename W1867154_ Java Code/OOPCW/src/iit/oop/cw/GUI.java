package iit.oop.cw;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class GUI extends JFrame implements ActionListener {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "1Hbfh667adfDEJ78";

    private WestminsterSkinConsultationManager manager;
    private JPanel mainPanel;
    private JTable doctorsTable;
    private JButton printDoctorsButton;
    private JButton bookConsultationButton;
    private JButton cancelConsultationButton;

    private JButton saveToFileButton;

    private JButton checkAvailabilityButton;
    private JTextField patientIdField;
    private JTextField patientNameField;
    private JTextField patientSurnameField;
    private JTextField patientDOBField;
    private JTextField patientMobileNumberField;
    private JTextField consultationDateField;
    private JTextField consultationTimeField;
    private JTextField patientNotes;
    private JTextField conHoursField;

    private JTextField availabilityDateField;
    private JTextField availabilityTimeField;

    private JButton checkConsultationsButton;

    private JButton sortButton;

    private JButton uploadButton;
    private JLabel fileLabel;


    public GUI(WestminsterSkinConsultationManager manager) {
        this.manager = manager;
        this.mainPanel = new JPanel();


        // Set up the doctors table
        String[] columnNames = {"First name", "Last name", "Date of birth", "Mobile number", "Medical license number", "Specialization","Available Date","Available Time"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        this.doctorsTable = new JTable(model);
        doctorsTable.setPreferredScrollableViewportSize(new Dimension(800, 200));
        doctorsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        doctorsTable.setShowGrid(true);
        doctorsTable.setGridColor(Color.BLACK);


        // Set up the buttons
        this.printDoctorsButton = new JButton("Print Doctors");
        this.bookConsultationButton = new JButton("Book Consultation");
        this.cancelConsultationButton = new JButton("Cancel Consultation");
        this.saveToFileButton = new JButton("Save to File");
        this.checkAvailabilityButton = new JButton("Check Availability");
        this.sortButton = new JButton("Sort");
        this.uploadButton=new JButton("Upload");

        // Set up the text fields
        this.patientIdField = new JTextField(10);
        this.patientNameField = new JTextField(10);
        this.patientSurnameField = new JTextField(10);
        this.patientDOBField = new JTextField(10);
        this.patientMobileNumberField = new JTextField(10);
        this.consultationDateField = new JTextField(10);
        this.consultationTimeField = new JTextField(10);

        this.availabilityDateField = new JTextField(10);
        this.availabilityTimeField = new JTextField(10);
        this.checkConsultationsButton = new JButton("Check Consultations");
        this.patientNotes=new JTextField(40);






        // Set up the main panel



        // Set up the doctors table panel
        JPanel doctorsTablePanel = new JPanel();
        doctorsTablePanel.add(new JScrollPane(doctorsTable));
        doctorsTablePanel.add(printDoctorsButton);
        doctorsTablePanel.add(sortButton);

        // Set up the patient information panel
        JPanel patientInformationPanel = new JPanel();
        patientInformationPanel.setLayout(new GridLayout(15, 2));
        patientInformationPanel.add(new JLabel("PATIENT DETAILS "));
        patientInformationPanel.add(new JLabel(":"));
        patientInformationPanel.add(new JLabel("Patient Id : "));
        patientInformationPanel.add(patientIdField);
        patientInformationPanel.add(new JLabel("Patient Name:"));
        patientInformationPanel.add(patientNameField);
        patientInformationPanel.add(new JLabel("Patient Surname:"));
        patientInformationPanel.add(patientSurnameField);
        patientInformationPanel.add(new JLabel("Patient DOB:"));
        patientInformationPanel.add(patientDOBField);
        patientInformationPanel.add(new JLabel("Patient Mobile Number:"));
        patientInformationPanel.add(patientMobileNumberField);
        patientInformationPanel.add(new JLabel("Add notes"));
        patientInformationPanel.add(patientNotes);
        patientInformationPanel.add(new JLabel("Upload images here"));
        patientInformationPanel.add(uploadButton);   //patientInformationPanel.add(new JLabel("."));
        patientInformationPanel.add(new JLabel("Consultation Date:"));
        patientInformationPanel.add(consultationDateField);
        patientInformationPanel.add(new JLabel("Consultation Time:"));
        patientInformationPanel.add(consultationTimeField);
        patientInformationPanel.add(new JLabel("Save your info"));
        patientInformationPanel.add(saveToFileButton);
        patientInformationPanel.add(bookConsultationButton);
        patientInformationPanel.add(cancelConsultationButton);






        JPanel checkPanel = new JPanel();
        checkPanel.setLayout(new GridLayout(5,2));
        checkPanel.add(new JLabel("DOCTORS INFO"));
        checkPanel.add(new JLabel(":"));
        checkPanel.add(new JLabel("Availability Date:"));
        checkPanel.add(availabilityDateField);
        checkPanel.add(new JLabel("Availability Time:"));
        checkPanel.add(availabilityTimeField);
        checkPanel.add(new JLabel("."));
        checkPanel.add(checkAvailabilityButton);
        checkPanel.add(new JLabel("."));
        checkPanel.add(checkConsultationsButton);



        // Add the panels to the main panel
        mainPanel.add(doctorsTablePanel);
        mainPanel.add(patientInformationPanel);
        mainPanel.add(checkPanel);


        add(mainPanel);
        setTitle("Westminster Skin Consultation Manager");
        setSize(1000, 800);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        bookConsultationButton.addActionListener(this);
        cancelConsultationButton.addActionListener(this);
        printDoctorsButton.addActionListener(this);
        saveToFileButton.addActionListener(this);
        checkAvailabilityButton.addActionListener(this);
        checkConsultationsButton.addActionListener(this);
        sortButton.addActionListener(this);

    }

    //Encrypting the notes that the patient gives

    public static String encrypt(String value) throws Exception {



        SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
        return Base64.getEncoder().encodeToString(encryptedByteValue);
    }


    //Decrypting the notes that the patient gives

    public static String decrypt(String value) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptedByteValue = cipher.doFinal(Base64.getDecoder().decode(value));
        return new String(decryptedByteValue, "utf-8");
    }








    // Get the selected doctor from the table

    private void bookConsultation() throws Exception {

        int selectedRow = doctorsTable.getSelectedRow();
        String fname1 = (String) doctorsTable.getValueAt(selectedRow, 0);
        String lname1 = (String) doctorsTable.getValueAt(selectedRow, 1);
        String dob1 = (String) doctorsTable.getValueAt(selectedRow, 2);
        String mobileNumber1 = (String) doctorsTable.getValueAt(selectedRow, 3);
        String medicalLicenseNumber1 = (String) doctorsTable.getValueAt(selectedRow, 4);
        String special1 = (String) doctorsTable.getValueAt(selectedRow, 5);
        String availableTime1 = (String)doctorsTable.getValueAt(selectedRow,7);
        String availableDate1 = (String) doctorsTable.getValueAt(selectedRow,6);



        SimpleDateFormat DateFor = new SimpleDateFormat( "EEE MMM dd HH:mm:ss zzz yyyy");    //EEE MMM dd HH:mm:ss zzz yyyy
        Date dob2 = DateFor.parse(dob1);
        int number = Integer.parseInt(mobileNumber1);
        int licenseNumber = Integer.parseInt(medicalLicenseNumber1);
        String availableTime2 =String.valueOf(availableTime1);
        Date availableDate2 = DateFor.parse(availableDate1);

        Doctor doctor= new Doctor(fname1,  lname1,dob2, number, licenseNumber,  special1,  availableTime2,  availableDate2);


        // Get the patient information from the text fields

        int patientId1 = Integer.parseInt(patientIdField.getText());
        String patientnotes=patientNotes.getText();
        String patientName = patientNameField.getText();
        String patientSurname = patientSurnameField.getText();
        SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
        Date patientDOB = DF.parse(patientDOBField.getText());
        int patientMobileNumber = Integer.parseInt(patientMobileNumberField.getText());



        //Encrypting notes here
        String originalValue = patientnotes;
        String encryptedValue = encrypt(originalValue);



        // Create a Patient object from the text field data

        Patient patient = new Patient(patientName,  patientSurname, patientDOB, patientMobileNumber, patientId1, encryptedValue);


        // Decrypting the value again

        String decryptedValue=decrypt(encryptedValue);


        double cost = manager.calculateCost(patientId1);




        // Parse the consultation date and time from the text fields
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date DateconsultationDate;
        DateconsultationDate = null;
        try {
            DateconsultationDate = dateFormat.parse(consultationDateField.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String consultationTime = consultationTimeField.getText();


        // Create a new Consultation object and add it to the list of consultations
        Consultation consultation = new Consultation(doctor, patient, DateconsultationDate, consultationTime);



        manager.addConsultation(consultation);

         //Calling the Reciept GUI

        Reciept R1 = new
          Reciept (String.valueOf(patient.getPatientID()),patient.getfName()+" "+patient.getlName(),String.valueOf(patient.getDob()),String.valueOf(
           patient.getmNumber()),doctor.getfName()+" "+doctor.getlName(),String.valueOf(cost),String.valueOf(Consultation.getDate()),Consultation.getTimeSlot(),decryptedValue);




    }








    //   printDoctorsButton.addActionListener(new ActionListener()

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==printDoctorsButton){
            List<Doctor> doctors = manager.getDoctors();
            String[][] data = new String[doctors.size()][8];
            for (int i = 0; i < doctors.size(); i++) {
                Doctor doctor = doctors.get(i);
                data[i][0] = doctor.getfName();
                data[i][1] = doctor.getlName();
                data[i][2] = String.valueOf(doctor.getDob());
                data[i][3] = String.valueOf(doctor.getmNumber());
                data[i][4] = String.valueOf(doctor.getmLicenseNumber());
                data[i][5] = doctor.getSpecial();
                data[i][6] = String.valueOf(doctor.getAvailableDate())  ;
                data[i][7] = String.valueOf(doctor.getAvailableTime());

            }
            String[] columnNames = {"Name", "Surname", "Date of birth", "Mobile number", "Medical license number", "Specialization","Available Date","Available Time"};
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            doctorsTable.setModel(model);
        }
        else if (e.getSource() == checkAvailabilityButton){
            String availabilityDateString = availabilityDateField.getText();
            String availabilityTimeString = availabilityTimeField.getText();


            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date availabilityDate = null;
            try {
                if (availabilityDate == null) {
                    // show an error message or take some other action
                    JOptionPane.showMessageDialog(null, "Please ,Enter a date with the valid format", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // use the availabilityDate variable as needed
                    availabilityDate = dateFormat.parse(availabilityDateString);
                }
                //availabilityDate = dateFormat.parse(availabilityDateString);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            List<Doctor> availableDoctors = manager.getAvailableDoctors(availabilityDate, availabilityTimeString);
            for (int i = 0; i < availableDoctors.size();i++)
            {
                System.out.println(availableDoctors.get(i));
            }

            DefaultTableModel model = (DefaultTableModel) doctorsTable.getModel();
            model.setRowCount(0);

            // Clear the table
            for (Doctor doctor : availableDoctors) {
                model.addRow(new Object[]{
                        doctor.getfName(),
                        doctor.getlName(),
                        doctor.getDob(),
                        doctor.getmNumber(),
                        doctor.getmLicenseNumber(),
                        doctor.getSpecial(),
                        doctor.getAvailableDate(),
                        doctor.getAvailableTime()
                });
            }
        }if (e.getSource() == bookConsultationButton) {
            // Validating the input
            if (doctorsTable.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Please select a doctor from the table.");
                return;
            }
            if (patientNameField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the patient's name.");
                return;
            }
            if (patientSurnameField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the patient's surname.");
                return;
            }
            if (patientDOBField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the patient's date of birth.");
                return;
            }
            if (patientMobileNumberField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the patient's mobile number.");
                return;
            }
            if (consultationDateField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the consultation date.");
                return;
            }
            if (consultationTimeField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the consultation time.");
                return;
            }



            try {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.parse(consultationDateField.getText());
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid consultation date in the format dd/MM/yyyy.");
                return;
            }







            //if  All inputs are valid, book the consultation
            try {
                bookConsultation();

            } catch (ParseException ex) {
                ex.printStackTrace();
            } catch (NoSuchPaddingException ex) {
                ex.printStackTrace();
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            } catch (IllegalBlockSizeException ex) {
                ex.printStackTrace();
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            } catch (BadPaddingException ex) {
                ex.printStackTrace();
            } catch (InvalidKeyException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        } else if (e.getSource()==checkConsultationsButton){

            // Get the list of consultations from the manager
            List<Consultation> consultations = manager.getConsultations();



            // Iterate through the list of consultations and print the information for each consultation

            for (Consultation consultation : consultations) {
                Doctor doctor = consultation.getDoctor();
                Patient patient = consultation.getPatient();
                Date consultationDate = consultation.getDate();

                System.out.println("Doctor: " + doctor.getfName() + " " + doctor.getlName());
                System.out.println("Medical license number: " + doctor.getmLicenseNumber());
                System.out.println("Mobile number: " + doctor.getmNumber());
                System.out.println("Patient: " + patient.getfName() + " " + patient.getlName());
                System.out.println("Patient mobile number: " + patient.getmNumber());
                System.out.println("Consultation date: " + consultationDate);
                System.out.println();
            }






        }else if (e.getSource()==sortButton){
            List<Doctor> doc = manager.getDoctors();

            // Sort the list of doctors alphabetically by name
            Collections.sort(doc, Comparator.comparing(Person::getfName));
            DefaultTableModel model = (DefaultTableModel) doctorsTable.getModel();


            // Clear the table

            model.setRowCount(0);


            // Add the sorted list of doctors to the table

            for (Doctor doctor : doc) {
                Object[] row = {doctor.getfName(), doctor.getlName(), doctor.getDob(), doctor.getmNumber(), doctor.getmLicenseNumber(), doctor.getSpecial(), doctor.getAvailableDate(), doctor.getAvailableTime()};
                model.addRow(row);
            }
        }
        else if(e.getSource()==uploadButton){


            // Create a file chooser object

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            fileChooser.setMultiSelectionEnabled(true);

            // Set the file filter to only allow image files to be selected

            fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "png", "gif", "jpeg"));

            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {

                // Get the selected files

                File[] selectedFiles = fileChooser.getSelectedFiles();

                // Add the files to the list of images in the WestminsterSkinConsultationManager class

                for (File file : selectedFiles) {
                    manager.uploadimage(file);
                }
                // Set the text of the fileLabel to the number of selected files

                fileLabel.setText(selectedFiles.length + " files selected");

                // Get the selected file

                File selectedFile = fileChooser.getSelectedFile();

                // Add the file to the list of images in the WestminsterSkinConsultationManager class

                manager.uploadimage(selectedFile);


            }
        }


        }


        }









