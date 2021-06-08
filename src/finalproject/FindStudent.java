package finalproject;

/**
 *
 * @author Kevin
 */
import static finalproject.FinalProject.stulist;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FindStudent extends JFrame {

    JPanel pan1;
    JLabel lab1;
    JLabel lab2;
    JLabel lab3;
    JTextField btf;
    JButton abu;

    public FindStudent() {
        setTitle("Student Records");
        setSize(200, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buildPanel();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void buildPanel() {
        pan1 = new JPanel();
        buttonListener BL = new buttonListener();
        lab1 = new JLabel("<html>Enter the Banner ID of the<br>student you want to find:</html>");
        lab2 = new JLabel("           ");
        lab3 = new JLabel("           ");
        btf = new JTextField(6);
        abu = new JButton("Find");
        abu.addActionListener(BL);
        pan1.add(lab1);
        pan1.add(lab2);
        pan1.add(btf);
        pan1.add(lab3);
        pan1.add(abu);
        add(pan1);
    }
    /**
    * 
    * ButtonListener checks the ArrayList of students by their Banner ID.
    */
    private class buttonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton act = (JButton) e.getSource();
            if (act == abu) {
                Student temp = new Student();
                boolean there = false;
                for(Student x: stulist){
                    if(x.getBID().equals(btf.getText())){
                        temp = new Student(x);
                        there = true;
                    }
                }
                if(there == true){
                    JOptionPane.showMessageDialog(null, temp.toString());
                }
                else if(there == false){
                    JOptionPane.showMessageDialog(null, "There is no student with that Banner ID!");
                }
                dispose();
            }
        }
    }
}
