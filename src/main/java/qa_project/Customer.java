package qa_project;

import java.sql.*;
import java.util.Scanner;

public class Customer {
    
    private String firstName, lastName, email, address, phoneNumber;

    //Database Credentials
    private String url = "jdbc:mysql://localhost:3306/qa_project_db";
    private String username = "root";
    private String password = "root";


    //Add a customer to database
    public void addCustomer() {

        //Gets user input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first name");
        firstName = input.nextLine();
        System.out.println("Enter last name");
        lastName = input.nextLine();
        System.out.println("Enter email");
        email = input.nextLine();
        System.out.println("Enter address");
        address = input.nextLine();
        System.out.println("Enter phone number");
        phoneNumber = input.nextLine();

        //Add input to database
        try{
            Connection myConn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO customers (firstName, lastName, email, address, phoneNumber) VALUES (?,?,?,?,?);";
            PreparedStatement stmt = myConn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, address);
            stmt.setString(5, phoneNumber);
            stmt.executeUpdate();
            System.out.println("Customer has been added to the system succesfully.\n" + "Returning to menu\n");
            myConn.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void viewAllCustomers() {

        try {
            Connection myConn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM customers";
            Statement stmt = myConn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("-----------------------------------------------------------------");
            System.out.println("");
                while (rs.next()){
                    System.out.println("Customer ID: " + rs.getString("customer_id") + " | First Name: " + rs.getString("firstName") + " | Last Name: " + rs.getString("lastName") + " | Email: " + rs.getString("email") + " | Address: " + rs.getString("address") + " | Phone Number: " + rs.getString("phoneNumber"));
                    System.out.println("");
                }
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Returning to menu\n");
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateCustomer() {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the customer ID of the customer that will be updated\n");
        String idChoice = "";
        idChoice = input.nextLine();


        try {
            Connection myConn = DriverManager.getConnection(url, username, password);
            String sql = "Select * FROM customers WHERE customer_id = ?";
            PreparedStatement stmt = myConn.prepareStatement(sql);

            stmt.setString(1, idChoice);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            if (rs.getString("customer_id") != null) {
                System.out.println("You have selected the following customer to update:");
                System.out.println("Customer ID: " + rs.getString("customer_id") + " | First Name: " + rs.getString("firstName") + " | Last Name: " + rs.getString("lastName") + " | Email: " + rs.getString("email") + " | Address: " + rs.getString("address") + " | Phone Number: " + rs.getString("phoneNumber"));
                System.out.println("");
                System.out.println("Please select which field to update:");
                System.out.println(" 1) First Name\n 2) Last Name\n 3) Email\n 4) Address\n 5) Phone Number\n 6) All");
                
            }




            

        }

        catch (Exception e) {
            //e.printStackTrace();
            System.out.println("This customer ID does not exist in the System. Please double check the customer ID and try again");
        }

    }

}
