package iit.oop.cw;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {
    private final static  SkinConsultationManager manager = new WestminsterSkinConsultationManager();



    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("-----------------------------------------");
            System.out.println("----------------WELCOME------------------");
            System.out.println("------------------TO---------------------");
            System.out.println("------WESTMINSTER SKIN CONSULTATION------");
            System.out.println("-----------------------------------------");
            System.out.println("1. Add a new doctor");
            System.out.println("2. Delete a doctor from list");
            System.out.println("3. Print list of doctors");
            System.out.println("4. Save to file");
            System.out.println("5. Load from file");
            System.out.println("6. Exit");
            System.out.println("7. open GUI");
            System.out.println("-----------------------------------------");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                scanner.next(); // discard invalid input
                continue;
            }

            switch (choice) {

                //Add a new Doctor
                case 1:

                    //getting name as the input
                    System.out.print("Please enter your first name: ");
                    String fname = scanner.next();
                    while (!fname.matches("^[a-zA-Z]*$")) {
                        System.out.println("Error: Specialization must contain only letters.");
                        System.out.print("Enter specialization: ");
                        fname = scanner.next();
                    }


                    //to get only letters for the name

                    //getting surname as the input
                    System.out.print("Please enter your last name: ");
                    String lname = scanner.next();


                    //to get only letters for the surname

                    //getting Time as the input
                    /*System.out.print("Enter Date and Time :");
                    String TimeStr = scanner.next();
                    LocalDateTime dateTime = LocalDateTime.of(2022, 12, 21, 10, 0);


                    LocalDateTime Time = null;
                    while (Time == null) {
                        try {
                            Time = dateTime.parse(TimeStr);
                        }catch (ParseException e){
                            System.out.println("Error: Invalid date format. Please enter a date in the format dd/mm/yyyy.");

                            TimeStr = scanner.next();
                        }
                    }*/
                    //getting Date of Birth as the input


                    System.out.print("Please enter your date of birth (dd/MM/yyyy): ");
                    String DateStr = scanner.next();

                    DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
                    Date DOB = null;
                    while (DOB == null) {
                        try {
                            DOB = dateF.parse(DateStr);
                        } catch (ParseException e) {
                            System.out.println("Error: Invalid date format. Please enter a date in the format dd/mm/yyyy.");

                            DateStr = scanner.next();
                        }
                    }

                    //getting the mobile number as the input
                    int mNumber ;
                    while (true) {
                        try {
                            System.out.print("Please enter your mobile number: ");

                            mNumber = scanner.nextInt();
                            break; // exit the loop if a valid integer was entered
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Invalid input. Please enter a valid integer.");
                            scanner.nextLine(); // consume the invalid input and discard it
                        }
                    }
                    //getting medical_License_Number as the input
                    int mLicense ;
                    while (true) {
                        try {
                            System.out.print("Please enter your medical license number: ");
                            mLicense = scanner.nextInt();
                            break; // exit the loop if a valid integer was entered
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Invalid input. Please enter a valid integer.");
                            scanner.nextLine(); // consume the invalid input and discard it
                        }
                    }
                    //getting specialization as the input
                    System.out.print("Please enter your specialised field: ");
                    String special = scanner.next();
                    while (!special.matches("^[a-zA-Z]*$")) {
                        System.out.println("Error: Specialization must contain only letters.");
                        System.out.print("Please enter your specialised field: ");
                        special = scanner.next();
                    }



                    System.out.print("Enter available Date (dd/MM/yyyy): ");
                    String availableDateStr = scanner.next();
                    DateFormat aD = new SimpleDateFormat("dd/MM/yyyy");
                    Date availableDate = null;
                    while (availableDate == null) {
                        try {
                            availableDate = aD.parse(availableDateStr);
                        } catch (ParseException e) {
                            System.out.println("Error: Invalid date format. Please enter a date in the format dd/mm/yyyy.");
                            System.out.println("Enter Date");

                            availableDateStr = scanner.next();
                        }
                    }



                    System.out.print("Enter available time: ");
                    String availableTime1 = scanner.next();






                    Doctor doctor = new Doctor(fname, lname, DOB, mNumber, mLicense, special,availableTime1,availableDate);
                    manager.addDoctor(doctor);
                    break;

                case 2:
                    //Delete Doctor Details
                    System.out.print("Enter medical license number: ");
                    mLicense = scanner.nextInt();

                    manager.deleteDoctor(mLicense);
                    break;

                case 3:
                    //Print all the Doctor Details
                    manager.printDoctors();
                    break;

                case 4:
                    //Save the Doctor Details to a Fle
                    manager.saveToFile();
                    break;


                case 5:
                    //Load from the file
                    manager.loadFromFile();


                case 6:
                    //User exits the program
                    System.out.println("Thank You. Have a good day");
                    System.exit(0);



                case 7:
                    //Open GUI
                  new GUI((WestminsterSkinConsultationManager) manager);
                  break;




                default:
                    //User prints an invalid choice
                    System.out.println("Invalid choice.");
                    break;

            }
        }




        }



        }
























