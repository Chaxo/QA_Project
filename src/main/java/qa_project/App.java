package qa_project;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Customer customer = new Customer();
        MenuSystem menu = new MenuSystem();

        System.out.println(MenuSystem.welcomeMessage);
        menu.printMenu();

        int choice = 0;
        choice = scan.nextInt();

        
        while (choice != 5) {
            switch (choice) {
                case 1:
                    System.out.println(MenuSystem.optionOne + "Please enter customer details:\n");
                    customer.addCustomer();
                    break;
                case 2:
                    System.out.println(MenuSystem.optionTwo);
                    customer.viewAllCustomers();
                    break;
                case 3:
                    System.out.println(MenuSystem.optionThree);
                    customer.updateCustomer();
                    break;
                case 4:
                    System.out.println(MenuSystem.optionFour);
                    customer.deleteCustomer();
                    break;
                default:
                    System.out.println(MenuSystem.invalidMessage);
                    break;
            }

            menu.printMenu();
            choice = scan.nextInt();

        }

        System.out.println(MenuSystem.farewellMessage);
        scan.close();

    }


}
