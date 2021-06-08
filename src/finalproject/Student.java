package finalproject;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Kevin
 */
public class Student {

    enum SType {
        FullTime, PartTime, NoMajor
    }
    String lname;
    String fname;
    String email;
    String passw;
    String bid = Rand();
    SType stype;
    String major = "Not Declared";
    double rbal = 0;

    public Student() {

    }

    public Student(String l, String f, String e, String p, String b, SType s, double r) {
        lname = l;
        fname = f;
        email = e;
        passw = p;
        bid = b;
        stype = s;
        rbal = r;
    }

    public Student(Student s) {
        lname = s.lname;
        fname = s.fname;
        email = s.email;
        passw = s.passw;
        bid = s.bid;
        stype = s.stype;
        major = s.major;
        rbal = s.rbal;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return passw;
    }

    public String getBID() {
        return bid;
    }

    public SType getSType() {
        return stype;
    }

    public String getMajor() {
        return major;
    }

    public double getRbal() {
        return rbal;
    }

    public void setFname(String f) {
        fname = f;
    }

    public void setLname(String l) {
        lname = l;
    }

    public void setEmail(String e) {
        email = e;
    }

    public void setPass(String p) {
        passw = p;
    }

    public void setBID(String b) {
        bid = b;
    }

    public void setSType(SType s) {
        stype = s;
    }

    public void setMajor(String m) {
        major = m;
    }

    public void setRbal(double r) {
        rbal = r;
    }
    /**
    * 
    * A random number generator.
    * Generates number between 1-999,999 for the Banner ID,
    * places 0's in front of number less than 100,000.
    */
    public String Rand() {
        Random randomGenerator = new Random();
        int random = randomGenerator.nextInt(999999);
        String str = String.format("%06d", random);
        return str;
    }

    public String toString() {
        String str = "Name:" + fname + " " + lname + " Email: " + email + ", BannerID: " + bid + ", StudentType: " + stype;
        if (stype == SType.FullTime) {
            str = str + ", Major: " + major;
        }
        str = str + String.format(", Remaining Balance: $%.2f", rbal);
        return str;
    }
}
