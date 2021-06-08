package finalproject;

/**
 *
 * @author Kevin
 */
import static finalproject.FinalProject.stulist;
import finalproject.Student.SType;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewStudent extends JFrame {

    JPanel pan1;
    JPanel pan2;
    JPanel pan3;
    JPanel pan4;
    JPanel pan5;
    JPanel pan6;
    JPanel pan7;
    JLabel flab;
    JLabel llab;
    JLabel plab;
    JLabel cplab;
    JLabel stlab;
    JLabel ablab;
    JTextField ftf;
    JTextField ltf;
    JTextField ptf;
    JTextField cptf;
    JTextField sttf;
    JTextField abtf;
    JButton conbu;

    public NewStudent() {
        setTitle("Student Records");
        setSize(325, 275);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buildPanel();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void buildPanel() {
        pan1 = new JPanel();
        pan2 = new JPanel();
        pan3 = new JPanel();
        pan4 = new JPanel();
        pan5 = new JPanel();
        pan6 = new JPanel();
        pan7 = new JPanel();
        setLayout(new GridLayout(7, 1));
        buttonListener BL = new buttonListener();
        flab = new JLabel("              First Name");
        llab = new JLabel("              Last Name");
        plab = new JLabel("               Password");
        cplab = new JLabel("Confirm Password");
        stlab = new JLabel("           Student Type");
        ablab = new JLabel("    Account Balance");
        ftf = new JTextField(15);
        ltf = new JTextField(15);
        ptf = new JTextField(15);
        cptf = new JTextField(15);
        sttf = new JTextField(15);
        abtf = new JTextField(15);
        conbu = new JButton("Add");
        conbu.addActionListener(BL);
        pan1.add(flab);
        pan2.add(llab);
        pan3.add(plab);
        pan4.add(cplab);
        pan5.add(stlab);
        pan6.add(ablab);
        pan1.add(ftf);
        pan2.add(ltf);
        pan3.add(ptf);
        pan4.add(cptf);
        pan5.add(sttf);
        pan6.add(abtf);
        pan7.add(conbu);
        add(pan1);
        add(pan2);
        add(pan3);
        add(pan4);
        add(pan5);
        add(pan6);
        add(pan7);
    }
    /**
    * 
    * Method that checks if the password contains the first name 
    * or last name of the student.
    */
    public boolean passnameCheck() {
        boolean x = true;
        boolean y = true;
        int xtracker = 0;
        int ytracker = 0;
        String tempp = ptf.getText();
        for (int i = ftf.getText().length(); ptf.getText().length() > i; i++) {
            if (tempp.regionMatches(true, xtracker, ftf.getText(), 0, ftf.getText().length())) {
                x = false;
            }
            xtracker++;
        }
        for (int i = ltf.getText().length(); ptf.getText().length() > i; i++) {
            if (tempp.regionMatches(true, ytracker, ltf.getText(), 0, ltf.getText().length())) {
                y = false;
            }
            ytracker++;
        }
        if (x == true && y == true) {
            return true;
        } else {
            return false;
        }
    }
    /**
    * 
    * Method that checks if the password contains the minimum required
    * characters: one upper case, one lower case, and one digit.
    */
    public boolean passcharCheck() {
        boolean x = false;
        boolean y = false;
        boolean z = false;
        String tempp = ptf.getText();
        for (int i = 0; tempp.length() > i; i++) {
            if (Character.isUpperCase(tempp.charAt(i)) == true) {
                x = true;
            }
        }
        for (int i = 0; tempp.length() > i; i++) {
            if (Character.isLowerCase(tempp.charAt(i)) == true) {
                y = true;
            }
        }
        for (int i = 0; tempp.length() > i; i++) {
            if (Character.isDigit(tempp.charAt(i)) == true) {
                z = true;
            }
        }
        if (x == true && y == true && z == true) {
            return true;
        } else {
            return false;
        }
    }

    private class buttonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton act = (JButton) e.getSource();
            if (act == conbu) {
                Student temp = new Student();
                boolean pcc = passcharCheck();
                boolean pnc = passnameCheck();
                if (ftf.getText().equals("") || ltf.getText().equals("") || ptf.getText().equals("") || sttf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Some required fields are blank!");
                } else {
                    if (ptf.getText().length() < 8) {

                        pan3.setBackground(Color.RED);
                        pan4.setBackground(Color.RED);
                        JOptionPane.showMessageDialog(null, "Password is too short!");
                    } else if (ptf.getText().length() > 10) {

                        pan3.setBackground(Color.RED);
                        pan4.setBackground(Color.RED);
                        JOptionPane.showMessageDialog(null, "Password is too Long!");
                    } else if (pcc == false) {

                        pan3.setBackground(Color.RED);
                        pan4.setBackground(Color.RED);
                        JOptionPane.showMessageDialog(null, "Password does not have the required characters!\n(1 upper case, 1 lower case, 1 digit)");
                    } else if (pnc == false) {

                        pan3.setBackground(Color.RED);
                        pan4.setBackground(Color.RED);
                        JOptionPane.showMessageDialog(null, "Password cannot contain the first or last name!");
                    } else {
                        if (ptf.getText().equals(cptf.getText()) == false) {
                            pan3.setBackground(Color.RED);
                            pan4.setBackground(Color.RED);
                            JOptionPane.showMessageDialog(null, "Passwords do not match!");
                        } else {
                            pan3.setBackground(new java.awt.Color(238, 238, 238));
                            pan4.setBackground(new java.awt.Color(238, 238, 238));
                            temp.fname = ftf.getText();
                            temp.lname = ltf.getText();
                            temp.email = ftf.getText().toLowerCase().charAt(0) + ltf.getText().toLowerCase() + "@mcc.edu";
                            String tempbal = abtf.getText();
                            if (tempbal.equals("")) {
                                temp.rbal = 0;
                            } else {
                                temp.rbal = Double.parseDouble(abtf.getText());
                            }
                            if (sttf.getText().equalsIgnoreCase("Full Time") || sttf.getText().equalsIgnoreCase("FullTime")) {
                                temp.stype = SType.FullTime;
                            } else if (sttf.getText().equalsIgnoreCase("Part Time") || sttf.getText().equalsIgnoreCase("PartTime")) {
                                temp.stype = SType.PartTime;
                            } else if (sttf.getText().equalsIgnoreCase("No Major") || sttf.getText().equalsIgnoreCase("NoMajor")) {
                                temp.stype = SType.NoMajor;
                            }
                            temp.passw = ptf.getText();
                            stulist.add(new Student(temp));
                            JOptionPane.showMessageDialog(null, "Student Added!");
                            dispose();
                        }
                    }
                }
            }
        }
    }
}
