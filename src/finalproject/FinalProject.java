package finalproject;

/**
 *
 * @author Kevin
 */
import finalproject.Student.SType;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;

public class FinalProject extends JFrame {

    static ArrayList<Student> stulist = new ArrayList<>();
    JPanel pa1;
    JLabel la1;
    JButton bu1;
    JButton bu2;
    JButton bu3;
    JButton bu4;
    JButton bu5;

    public FinalProject() {
        setTitle("Student Records");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void buildPanel() {
        pa1 = new JPanel();
        buttonListener BL = new buttonListener();
        la1 = new JLabel("<html>Welcome to MCC's Student Record System. <br>Please choose from the following options:</html>", SwingConstants.CENTER);
        bu1 = new JButton("1. Upload Student Records from File");
        bu1.setPreferredSize(new Dimension(250, 25));
        bu1.addActionListener(BL);
        bu2 = new JButton("2. Add New Student");
        bu2.setPreferredSize(new Dimension(250, 25));
        bu2.addActionListener(BL);
        bu3 = new JButton("3. Download Statistics");
        bu3.setPreferredSize(new Dimension(250, 25));
        bu3.addActionListener(BL);
        bu4 = new JButton("4. Find Student");
        bu4.setPreferredSize(new Dimension(250, 25));
        bu4.addActionListener(BL);
        bu5 = new JButton("5. Exit Program");
        bu5.setPreferredSize(new Dimension(250, 25));
        bu5.addActionListener(BL);
        pa1.add(la1);
        pa1.add(bu1);
        pa1.add(bu2);
        pa1.add(bu3);
        pa1.add(bu4);
        pa1.add(bu5);
        add(pa1);
    }

    private class buttonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton act = (JButton) e.getSource();
            if (act == bu1) {
                int temp = stulist.size();
                try {
                    but1();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "File not found!");
                }
                if (stulist.size() != temp) {
                    JOptionPane.showMessageDialog(null, "File successfully loaded!");
                }
            } else if (act == bu2) {
                NewStudent temp = new NewStudent();

            } else if (act == bu3) {
                try {
                    but3();
                } catch (IOException ex) {
                    Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (act == bu4) {
                FindStudent temp = new FindStudent();

            } else if (act == bu5) {
                JOptionPane.showMessageDialog(null, "Program will now exit.");
                System.exit(0);
            }
        }
    }
    /**
    *
    * Method that adds Student information from a file,
    * whose name is specified by a user input via pop-up.
    */
    public static void but1() throws FileNotFoundException {
        String fn = JOptionPane.showInputDialog("What is the name of the File?");
        File f = new File(fn + ".txt");
        Scanner fr = new Scanner(f);
        Student temp = new Student();
        while (fr.hasNext()) {
            temp.lname = fr.next();
            fr.useDelimiter(", ");
            temp.fname = fr.next();
            temp.email = fr.next();
            temp.passw = fr.next();
            temp.bid = fr.next();
            String stemp = fr.next();
            if (stemp.equals("FullTime") || stemp.equals("Full Time")) {
                temp.stype = SType.FullTime;
                temp.major = fr.next();
            } else if (stemp.equals("PartTime") || stemp.equals("Part Time")) {
                temp.stype = SType.PartTime;
                temp.major = fr.next();
            } else if (stemp.equals("NoMajor") || stemp.equals("No Major")) {
                temp.stype = SType.NoMajor;
            }
            fr.reset();
            fr.next();
            temp.rbal = fr.nextDouble();
            stulist.add(new Student(temp));
        }
    }
    /**
    * 
    * Method for downloading the information of all the Students
    * on record, into a file specified by the user, via pop-up
    */
    public static void but3() throws IOException {
        String fn = JOptionPane.showInputDialog("What would you like to name the file?");
        FileWriter fw = new FileWriter(fn + ".txt", true);
        PrintWriter pw = new PrintWriter(fw);
        for (Student s : stulist) {
            pw.println(s);
        }
        pw.close();
        JOptionPane.showMessageDialog(null, "Statistic file created!");
    }

    public static void main(String[] args) throws IOException {
        FinalProject temp = new FinalProject();
    }

}
