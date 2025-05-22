package service;

import java.util.List;
import models.Admin;

public interface AdminService {
	Admin getAdminById(int Admin_ID);
	List<Admin> getAllAdmins();
	void updateAdmin(Admin admin);
	void deleteAdmin(int Admin_ID);
	Admin login(String email, String password);
}