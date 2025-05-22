package main;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import daoImplementation.AdminDAOImpl;
import dao.AdminDAO;
import models.Admin;
import operations.AdminOperations;
import operations.BusOperations;
import operations.PassengerOperations;
import operations.RouteOperations;
import operations.TicketOperations;

public class AdminLogin {
	
	public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        AdminOperations adminOps = new AdminOperations();
        RouteOperations routeOps = new RouteOperations();
        BusOperations busOps = new BusOperations();
        PassengerOperations passengerOps = new PassengerOperations();
        TicketOperations ticketOps = new TicketOperations();

        while (true) {
            System.out.println("---------- Admin Dashboard -----------");
            System.out.println("1️. Admin Management");
            System.out.println("2️. Route Management");
            System.out.println("3️. Bus Management");
            System.out.println("4️. Passenger Management");
            System.out.println("5️. Ticket Management");
            System.out.println("6️. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    AdminOperations.adminMenu(adminOps);
                    break;
                case 2:
                    RouteOperations.routeMenu(routeOps);
                    break;
                case 3:
                    BusOperations.busMenu(busOps);
                    break;
                case 4:
                    PassengerOperations.passengerMenu(passengerOps);
                    break;
                case 5:
                    TicketOperations.ticketMenu(ticketOps, null);
                    break;
                case 6:
                    return;  
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void registerNewAdmin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.println("Enter contact :");
        String contact = sc.nextLine();
        
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Admin admin = new Admin();
        admin.setName(name);
        admin.setContact(contact);
        admin.setAdmin_Email(email);
        admin.setAdmin_Password(password);

        AdminDAO adminDAO = new AdminDAOImpl();
        adminDAO.saveAdmin(admin);
        System.out.println("Admin registered successfully.");
    }

    public static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        AdminDAO adminDAO = new AdminDAOImpl();
        Admin admin = adminDAO.getAdminByEmailAndPassword(email, password);

        if (admin != null) {
            System.out.println("Login successful. Welcome, " + admin.getName() + "!");
            
              adminMenu();

        } else {
            System.out.println("Invalid credentials.");
        }
    }
}