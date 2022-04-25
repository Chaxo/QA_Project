package qa_project;

public class MenuSystem {

    //Menu options and messages
    static String welcomeMessage = "Welcome to the Customer Management System";
    static String selectMessage = "Select an operation:\n";
    static String farewellMessage = "Thank you for using the Customer Management System";
    static String invalidMessage = "Invalid number option. Please enter a valid option.\n";

    static String optionOne = "1) Add a customer to the system\n";
    static String optionTwo = "2) View all customers in the system\n";
    static String optionThree = "3) Update a customer in the system\n";
    static String optionFour = "4) Delete a customer in the system\n";
    static String optionFive = "5) Exit the Customer Management System";
    
    public void printMenu() {
        System.out.println("");
        System.out.println(selectMessage + optionOne + optionTwo + optionThree + optionFour + optionFive);
    }

}
