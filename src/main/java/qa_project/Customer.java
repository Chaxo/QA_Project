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
        System.out.println("Enter your first name");
        firstName = input.nextLine();
        System.out.println("Enter your last name");
        lastName = input.nextLine();
        System.out.println("Enter your email");
        email = input.nextLine();
        System.out.println("Enter your address");
        address = input.nextLine();
        System.out.println("Enter your phone number");
        phoneNumber = input.nextLine();
        input.close();

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
            System.out.println("You have been added to the system succesfully!");
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
            System.out.println("Viewing all customer in the system");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("");
                while (rs.next()){
                    System.out.println("Customer ID: " + rs.getString("customer_id") + " | First Name: " + rs.getString("firstName") + " | Last Name: " + rs.getString("lastName") + " | Email: " + rs.getString("email") + " | Address: " + rs.getString("address") + " | Phone Number: " + rs.getString("phoneNumber"));
                    System.out.println("");
                }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
