package iit.oop.cw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

class ImageUploader extends JPanel {
    private JButton uploadButton;

    public ImageUploader() {
        uploadButton = new JButton("Upload Image");
        add(uploadButton);

        // Add action listener to the upload button
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a file chooser
                final JFileChooser fc = new JFileChooser();

                // Show the file chooser and store the result
                int result = fc.showOpenDialog(ImageUploader.this);

                // If the user chose a file, set it as the icon of the button
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    uploadButton.setIcon(new ImageIcon(file.getAbsolutePath()));
                }
            }
        });
    }

    private static void createAndShowGUI() {
        // Create the frame
        JFrame frame = new JFrame("Image Uploader");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the ImageUploader panel to the frame
        frame.add(new ImageUploader());

        // Display the frame
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {



        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}