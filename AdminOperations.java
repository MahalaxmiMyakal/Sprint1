package operations;

import java.util.List;
import java.util.Scanner;
import service.AdminService;
import serviceImplementation.AdminServiceImpl;
import models.Admin;

public class AdminOperations {
	
	private static AdminService adminService = new AdminServiceImpl();
	private static Scanner scanner = new Scanner(System.in);

	public static void adminMenu(AdminOperations adminOps) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("---------- Admin Management ----------");
			System.out.println("1. View Admin by ID");
			System.out.println("2. View All Admins");
			System.out.println("3. Update Admin");
			System.out.println("4. Delete Admin");
			System.out.println("5. Back to Main Menu");
			System.out.print("Enter your choice : ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				adminOps.viewAdmin();
				break;
			case 2:
				adminOps.viewAllAdmins();
				break;
			case 3:
				adminOps.updateAdmin();
				break;
			case 4:
				adminOps.deleteAdmin();
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid choice! Try again.");
			}
		}
	}

	public static void viewAdmin() {

		System.out.print("Enter Admin ID : ");
		int id = scanner.nextInt();
		scanner.nextLine();

		Admin admin = adminService.getAdminById(id);
		if (admin != null) {
			System.out.println(" Admin Found :");
			System.out.println("ID: " + admin.getAdmin_ID());
			System.out.println("Name: " + admin.getName());
			System.out.println("Contact: " + admin.getContact());
		} else {
			System.out.println("Admin not found.");
		}
	}

	public static void viewAllAdmins() {
		List<Admin> admins = adminService.getAllAdmins();
		if (admins.isEmpty()) {
			System.out.println("No Admin records found.");
		} else {
			System.out.println("All Admins :");
			for (Admin admin : admins) {
				System.out.println(admin.getAdmin_ID() + " | " + admin.getName() + " | " + admin.getContact());
			}
		}
	}

	public static void updateAdmin() {
		System.out.print("Enter Admin ID to update : ");
		int id = scanner.nextInt();

		Admin admin = adminService.getAdminById(id);
		if (admin != null) {
			System.out.print("Enter New Name : ");
			admin.setName(scanner.next());
			System.out.print("Enter New Contact : ");
			admin.setContact(scanner.next());

			adminService.updateAdmin(admin);
			System.out.println("Admin updated successfully!");
		} else {
			System.out.println("Admin not found.");
		}
	}

	public static void deleteAdmin() {

		System.out.print("Enter Admin ID to delete : ");
		int id = scanner.nextInt();

		adminService.deleteAdmin(id);
		System.out.println("Admin deleted successfully!");
	}
}