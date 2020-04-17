package emailApp;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class email {

    private String firstname;
    private String lastName;
    private String password;
    private String email;
    private int passwordLength = 8;
    private String department;
    private int mailboxCapacity=500;
    private String alternateEmail;
    private String companySuffix = "company.com";

    /**
     * the constructor for the email object.
     */
    public email(){
        this.firstname = setFirstName();
        this.lastName = setLastName();
        this.department = setDepartment();
        this.password= setPassword(passwordLength);
        System.out.println("YOUR PASSWORD IS: "+ this.password);
        email= firstname.toLowerCase()+"."+lastName.toLowerCase()
                +"@"+department.toLowerCase()+"."+companySuffix;
        System.out.println(toString());

    }

    /**
     * asks the user for their first name and saves it to the instance firstname in the constructor
     * @return the first name of the user
     */
    private String setFirstName(){
        System.out.println("PLEASE ENTER YOUR FIRST NAME");
        Scanner in = new Scanner(System.in);
        return in.next();


    }

    /**
     * asks the user for their last name and saves it to the instance variable lastName in the constructor
     * @return the lastNae=me of the user
     */
    private String setLastName(){
        System.out.println("PLEASE ENTER YOUR LAST NAME");
        Scanner in = new Scanner(System.in);
        return in.next();


    }

    /**
     * asks the user to choose the department they are in based on the department codes
     * returns blank if the user does not have a department
     * @return the department that the user is in
     */
    private  String setDepartment(){
        System.out.println("PLEASE ENTER THE DEPARTMENT CODE\n1 for Sales\n2 for Development" +
                "\n3 for Accounting\n0 for None");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        switch (departmentChoice) {
            case 1:
                return "Sales";
            case 2:
                return "Development";
            case 3:
                return "Accounting";
            default:
                return "";
        }

    }

    /**
     * sets a random password for the user based on the characters specified in the String passwordSet
     * @param length the length of the random password
     * @return the random password that has been set
     */
    private String setPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$&*";
        char[] password = new char[length];
        for(int i=0;i<length;i++){
            int random = (int)(Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new   String(password );
    }

    /**
     * updatesthe capacity of the mailbox of the user's email(in megabytes)
     * @param capacity the int specifying the capacity of the mailbox intended to be set
     */
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity=capacity;
    }

    /**
     * adds an alternate email to contact for the user's company email
     * @param alternateEmail the alternate email that has been set
     */
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    /**
     * updates the password if the user does not want to use the random password generated
     * @param password the updates password that was picked by the user
     */
    public void changePassword(String password){
        this.password = password;
    }

    /**
     *
     * @return the mailbox capacity of the email
     */
    public int getMailboxCapacity(){ return mailboxCapacity; }

    /**
     *
     * @return the alternate email that was set by the user
     */
    public String getAlternateEmail(){ return alternateEmail; }

    /**
     *
     * @return the password set for email. if the user had changed the password, the new password is returned
     */
    public String getPassword(){ return password; }

    /**
     * displays a string containing all the info of the email once it has been creted
     * @return string with all the info of the email.
     */
    public String toString(){
        return "DISPLAY NAME: " + firstname + " "+ lastName+
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY :" + mailboxCapacity + "mb";
    }





}
