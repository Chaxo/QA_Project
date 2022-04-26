package qa_project;

import java.sql.*;
import java.util.Scanner;

public class Customer {

    //Database Credentials
    private String url = "jdbc:mysql://localhost:3306/qa_project_db";
    private String username = "root";
    private String password = "root";


    //Add a customer to database
    public void addCustomer() {

        //Gets user input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first name");
        String firstName = input.nextLine();
        System.out.println("Enter last name");
        String lastName = input.nextLine();
        System.out.println("Enter email");
        String email = input.nextLine();
        System.out.println("Enter address");
        String address = input.nextLine();
        System.out.println("Enter phone number");
        String phoneNumber = input.nextLine();

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
            myConn.close();
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
                System.out.println("Please select which field to update:\n");
                System.out.println(" 1) First Name\n 2) Last Name\n 3) Email\n 4) Address\n 5) Phone Number\n 6) All Fields\n 7) Exit");
                
                int choice = 0;
                choice = input.nextInt();

                while (choice != 7) {
                    switch (choice) {
                        case 1:
                            System.out.println("Enter the new first name:");
                            Scanner input1 = new Scanner (System.in);
                            String newFirstName = input1.nextLine();
                            String sql1 = "UPDATE customers SET firstName = ? WHERE customer_id = ?";
                            PreparedStatement stmt1 = myConn.prepareStatement(sql1);
                            stmt1.setString(1, newFirstName);
                            stmt1.setString(2, idChoice);
                            stmt1.executeUpdate();
                            System.out.println("\nFirst name has been updated to: " + newFirstName + "\nPlease select which field to update:\n");
                            break;
                        case 2:
                            System.out.println("Enter the new last name:");
                            Scanner input2 = new Scanner (System.in);
                            String newLastName = input2.nextLine();
                            String sql2 = "UPDATE customers SET lastName = ? WHERE customer_id = ?";
                            PreparedStatement stmt2 = myConn.prepareStatement(sql2);
                            stmt2.setString(1, newLastName);
                            stmt2.setString(2, idChoice);
                            stmt2.executeUpdate();
                            System.out.println("\nLast name has been updated to: " + newLastName + "\nPlease select which field to update:\n");
                            break;
                        case 3:
                            System.out.println("Enter the new email:");
                            Scanner input3 = new Scanner (System.in);
                            String newEmail = input3.nextLine();
                            String sql3 = "UPDATE customers SET email = ? WHERE customer_id = ?";
                            PreparedStatement stmt3 = myConn.prepareStatement(sql3);
                            stmt3.setString(1, newEmail);
                            stmt3.setString(2, idChoice);
                            stmt3.executeUpdate();
                            System.out.println("\nEmail has been updated to: " + newEmail + "\nPlease select which field to update:\n");
                            break;
                        case 4:
                            System.out.println("Enter the new address:");
                            Scanner input4 = new Scanner (System.in);
                            String newAddress = input4.nextLine();
                            String sql4 = "UPDATE customers SET address = ? WHERE customer_id = ?";
                            PreparedStatement stmt4 = myConn.prepareStatement(sql4);
                            stmt4.setString(1, newAddress);
                            stmt4.setString(2, idChoice);
                            stmt4.executeUpdate();
                            System.out.println("\nEmail has been updated to: " + newAddress + "\nPlease select which field to update:\n");
                            break;
                        case 5:
                            System.out.println("Enter the new phone number:");
                            Scanner input5 = new Scanner (System.in);
                            String newPhoneNumber = input5.nextLine();
                            String sql5 = "UPDATE customers SET phoneNumber = ? WHERE customer_id = ?";
                            PreparedStatement stmt5 = myConn.prepareStatement(sql5);
                            stmt5.setString(1, newPhoneNumber);
                            stmt5.setString(2, idChoice);
                            stmt5.executeUpdate();
                            System.out.println("\nEmail has been updated to: " + newPhoneNumber + "\nPlease select which field to update:\n");
                            break;
                        case 6:
                            Scanner input6 = new Scanner(System.in);
                            System.out.println("Enter the new first name");
                            String allFirstName = input6.nextLine();
                            System.out.println("Enter the new last name");
                            String allLastName = input6.nextLine();
                            System.out.println("Enter the new email");
                            String allEmail = input6.nextLine();
                            System.out.println("Enter the new address");
                            String allAddress = input6.nextLine();
                            System.out.println("Enter the new phone number");
                            String allPhoneNumber = input6.nextLine();

                            String sql6 = "UPDATE customers SET firstName = ?, lastName = ?, email = ?, address = ?, phoneNumber = ? WHERE customer_id = ?";
                            PreparedStatement stmt6 = myConn.prepareStatement(sql6);
                            stmt6.setString(1, allFirstName);
                            stmt6.setString(2, allLastName);
                            stmt6.setString(3, allEmail);
                            stmt6.setString(4, allAddress);
                            stmt6.setString(5, allPhoneNumber);
                            stmt6.setString(6, idChoice);
                            stmt6.executeUpdate();
                            System.out.println("\nCustomer has been updated. The new fields are:");
                            System.out.println("First Name: " + allFirstName + " Last Name: " + allLastName + " Email: " + allEmail + " Address: " + allAddress + " Phone Number: " + allPhoneNumber);
                            System.out.println("\nPlease select which field to update:\n");
                            break;
                        default:
                            System.out.println("Invalid number option. Please enter a valid option\n");
                            break;
                    }

                    System.out.println(" 1) First Name\n 2) Last Name\n 3) Email\n 4) Address\n 5) Phone Number\n 6) All Fields\n 7) Return to main menu");
                    choice = input.nextInt();

                }
        
                
            }

                myConn.close();
 
        }

        catch (Exception e) {
            //e.printStackTrace();
            System.out.println("This customer ID does not exist in the System. Please double check the customer ID and try again");
        }

    }

    public void deleteCustomer() {
        Scanner input = new Scanner (System.in);
        System.out.println("Select operation:\n1) Delete customer by customer ID\n2) Delete all customers\n3) Return to main menu");

        int choice = 0;
        choice = input.nextInt();

        while (choice != 3) {
            switch (choice) {
                case 1:
                System.out.println("Enter the customer ID:");
                Scanner input1 = new Scanner(System.in);
                String idChoice = "";
                idChoice = input1.nextLine();

                try {
                    Connection myConn = DriverManager.getConnection(url, username, password);
                    String sql = "Select * FROM customers WHERE customer_id = ?";
                    PreparedStatement stmt = myConn.prepareStatement(sql);
        
                    stmt.setString(1, idChoice);
                    ResultSet rs = stmt.executeQuery();
                    rs.next();
                    if (rs.getString("customer_id") != null) {
                        System.out.println("You have selected the following customer to delete:");
                        System.out.println("Customer ID: " + rs.getString("customer_id") + " | First Name: " + rs.getString("firstName") + " | Last Name: " + rs.getString("lastName") + " | Email: " + rs.getString("email") + " | Address: " + rs.getString("address") + " | Phone Number: " + rs.getString("phoneNumber"));
                        System.out.println("");
                        System.out.println("Delete this customer from the system?\n1) Yes\n2) No");
                        int deleteChoice = 0;
                        Scanner input2 = new Scanner(System.in);
                        deleteChoice = input2.nextInt();

                        if (deleteChoice == 1) {
                            String sqlDeleteOneCustomer = "DELETE FROM customers WHERE customer_id = ?";
                            PreparedStatement stmtDeleteOneCustomer = myConn.prepareStatement(sqlDeleteOneCustomer);
                            stmtDeleteOneCustomer.setString(1, idChoice);
                            stmtDeleteOneCustomer.executeUpdate();
                            System.out.println("Customer with ID " + idChoice + " has been deleted\nReturning to previous menu");
                        }

                        if (deleteChoice == 2){
                        System.out.println("Customer with ID " + idChoice + " has NOT been deleted\nReturning to previous menu");
                        }

                        if (deleteChoice != 1 && deleteChoice != 2){
                        System.out.println("Invalid number option. Please enter a valid option\n");
                        }
                    
                    }
                }

                    catch (Exception e) {
                        System.out.println("This customer ID does not exist in the System. Please double check the customer ID and try again");
                        break;
                        
                    }
                    break;
                case 2:
                    try {

                        System.out.println("Delete ALL customers from the system?\n1) Yes\n2) No");
                        int deleteChoice = 0;
                        Scanner input3 = new Scanner(System.in);
                        deleteChoice = input3.nextInt();

                        if (deleteChoice == 1) {
                            Connection myConn = DriverManager.getConnection(url, username, password);
                            String sql = "DELETE FROM customers";
                            Statement stmt = myConn.createStatement();
                            stmt.executeUpdate(sql);
                            System.out.println("All customers have been deleted from the system\nReturning to previous menu");
                        }

                        if (deleteChoice == 2) {
                            System.out.println("No customers have been deleted from the system\nReturning to previous menu");
                        }

                        if (deleteChoice != 1 && deleteChoice != 2) {
                            System.out.println("Invalid number option. Please enter a valid option\n");
                        }

                        



                    }

                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                    break;
                default:
                    System.out.println("Invalid number option. Please enter a valid option\n");


            }

            System.out.println("\nSelect operation:\n1) Delete customer by customer ID\n2) Delete all customers\n3) Return to main menu");
            choice = input.nextInt();

        }


    }
}
