package dao;

import java.util.List;
import models.Admin;
import models.Passenger;

public interface AdminDAO {
	void saveAdmin(Admin admin);
	Admin getAdminById(int Admin_ID);
	List<Admin> getAllAdmins();
	void updateAdmin(Admin admin);
	void deleteAdmin(int Admin_ID);
	Admin getAdminByEmailAndPassword(String email, String password);
}