package main;

import java.util.Scanner;

public class Bus_Tracking_System {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("---------- Welcome to Bus Tracking System ----------");
            System.out.println("1. Admin Menu");
            System.out.println("2. Passenger Menu");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showAdminPanel();
                    break;
                case 2:
                    showPassengerPanel();
                    break;

                case 3:
                    System.out.println("Thank you for using the Bus Tracking System. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void showAdminPanel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Admin Panel -----");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Enter your choice: ");
        int adminChoice = sc.nextInt();

        switch (adminChoice) {
            case 1:
                AdminLogin.registerNewAdmin();
                break;
            case 2:
                AdminLogin.login();
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    public static void showPassengerPanel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Passenger Panel -----");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Enter your choice: ");
        int passengerChoice = sc.nextInt();

        switch (passengerChoice) {
            case 1:
                PassengerLogin.registerNewPassenger();
                break;
            case 2:
                PassengerLogin.login();
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }
}