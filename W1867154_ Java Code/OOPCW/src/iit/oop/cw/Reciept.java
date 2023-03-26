package iit.oop.cw;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;



public class Reciept extends JFrame {

    JPanel main1= new JPanel();
    JPanel mainly= new JPanel();
    JFrame text = new JFrame();








    public Reciept (String pId, String name, String dob, String mob,
                        String doctor, String cost, String conDate, String time,String note) {






        // consultationTopic
        JLabel consultationTopic1 = new JLabel("Consultation Details");
        consultationTopic1.setFont(new Font("Arial", Font.BOLD, 20));
      //  consultationTopic1.setSize(500, 30);
     //   consultationTopic1.setLocation(250, 40);
     //   add(consultationTopic);

        // Data
        JLabel patientId1 = new JLabel("Patient ID");
        patientId1.setFont(new Font("Arial", Font.BOLD, 16));
      //  patientId1.setSize(500, 30);
      //  patientId1.setLocation(50, 150);
     //   add(patientId);

        JLabel patientIdT1 = new JLabel();
        patientIdT1.setText(pId);
      //  patientIdT1.setFont(new Font("Arial", Font.PLAIN, 16));
      //  patientIdT1.setSize(500, 30);
     //   patientIdT1.setLocation(200, 150);
    //    add(patientIdT);

        JLabel firstName1 = new JLabel("Patient Name");
        firstName1.setFont(new Font("Arial", Font.BOLD, 16));
      //  firstName1.setSize(500, 30);
      //  firstName1.setLocation(50, 200);
     //   add(firstName);

        JLabel firstNameT1 = new JLabel();
        firstNameT1.setText(name);
      //  firstNameT1.setFont(new Font("Arial", Font.PLAIN, 16));
      //  firstNameT1.setSize(500, 30);
     //   firstNameT1.setLocation(200, 200);
     //   add(firstNameT);

        JLabel dobL1 = new JLabel("Date of Birth");
        dobL1.setFont(new Font("Arial", Font.BOLD, 16));
      //  dobL1.setSize(500, 30);
      //  dobL1.setLocation(50, 250);
      //  add(dobL);

        JLabel dobT1 = new JLabel();
        dobT1.setText(dob);
      //  dobT1.setFont(new Font("Arial", Font.PLAIN, 16));
      //  dobT1.setSize(500, 30);
      //  dobT1.setLocation(200, 250);
     //   add(dobT);

        JLabel mobL1 = new JLabel("Mobile Number");
        mobL1.setFont(new Font("Arial", Font.BOLD, 16));
      //  mobL1.setSize(500, 30);
      //  mobL1.setLocation(50, 300);
    //    add(mobL);

        JLabel mobT1 = new JLabel();
        mobT1.setText(mob);
        mobT1.setFont(new Font("Arial", Font.PLAIN, 16));
      //  mobT1.setSize(500, 30);
      //  mobT1.setLocation(200, 300);
    //    add(mobT);

        JLabel doctorL1 = new JLabel("Doctor Name");
        doctorL1.setFont(new Font("Arial", Font.BOLD, 16));
     //   doctorL1.setSize(500, 30);
      //  doctorL1.setLocation(450, 150);
    //    add(doctorL);

        JLabel doctorT1 = new JLabel();
        doctorT1.setText(doctor);
       //doctorT1.setFont(new Font("Arial", Font.PLAIN, 16));
      //  doctorT1.setSize(500, 30);
     //   doctorT1.setLocation(600, 150);
    //    add(doctorT);

        JLabel costL1 = new JLabel("Cost");
       costL1.setFont(new Font("Arial", Font.BOLD, 16));
     //   costL1.setSize(500, 30);
     //   costL1.setLocation(450, 200);
     //   add(costL);

        JLabel costT1 = new JLabel();
        costT1.setText("£" + cost);
       //costT1.setFont(new Font("Arial", Font.PLAIN, 16));
      //  costT1.setSize(500, 30);
     //   costT1.setLocation(600, 200);
    //    add(costT);

        JLabel conDateL1 = new JLabel("Date");
        conDateL1.setFont(new Font("Arial", Font.BOLD, 16));
      //  conDateL1.setSize(500, 30);
      //  conDateL1.setLocation(450, 250);
     //   add(conDateL);

        JLabel conDateT1 = new JLabel();
        conDateT1.setText(conDate);
       // conDateT1.setFont(new Font("Arial", Font.PLAIN, 16));
      //  conDateT1.setSize(500, 30);
      //  conDateT1.setLocation(600, 250);
     //   add(conDateT);

        JLabel timeL1 = new JLabel("Time");
        timeL1.setFont(new Font("Arial", Font.BOLD, 16));
       // timeL1.setSize(500, 30);
      //  timeL1.setLocation(450, 300);
     //   add(timeL);

        JLabel timeT1 = new JLabel();
        timeT1.setText(time);
      //  timeT1.setFont(new Font("Arial", Font.PLAIN, 16));
      //  timeT1.setSize(500, 30);
      //  timeT1.setLocation(600, 300);
    //    add(timeT);

        JLabel notes1 = new JLabel("Notes");
       notes1.setFont(new Font("Arial", Font.BOLD, 16));
      //  notes1.setSize(500, 30);
      //  notes1.setLocation(450, 350);
      //  add(notes);

        JLabel note11 = new JLabel();
        note11.setText(note);
       // note11.setFont(new Font("Arial", Font.PLAIN, 16));
     //   note11.setSize(500, 30);
      //  note11.setLocation(600, 350);
      //  add(note1);

//        setSize(900, 500);
//        getContentPane().setLayout(null);
//        setVisible(true);
//        setResizable(false);
//        setTitle("Consultation - Receipt ");

        main1.setLayout(new GridLayout(9,2));


        main1.add(patientId1);
        main1.add(patientIdT1);
        main1.add(firstName1);
        main1.add(firstNameT1);
        main1.add(dobL1);
        main1.add(dobT1);
        main1.add(mobL1);
        main1.add(mobT1);
        main1.add(doctorL1);
        main1.add(doctorT1);
        main1.add(costL1);
        main1.add(costT1);
        main1.add(conDateL1);
        main1.add(conDateT1);
        main1.add(timeL1);
        main1.add(timeT1 );
        main1.add(notes1);
        main1.add(note11);

        text.setVisible(true);
        text.setSize(700,700);
        mainly.setLayout(new BorderLayout());
        mainly.add(consultationTopic1,BorderLayout.NORTH);
        mainly.add(main1,BorderLayout.CENTER);
        mainly.setVisible(true);
        text.add(mainly);






    }


}