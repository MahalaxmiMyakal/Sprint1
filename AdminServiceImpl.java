package serviceImplementation;

import java.util.List;
import models.Admin;
import models.Passenger;
import service.AdminService;
import dao.AdminDAO;
import daoImplementation.AdminDAOImpl;

public class AdminServiceImpl implements AdminService {
	
	private AdminDAO adminDAO = new AdminDAOImpl();

	@Override
	public Admin getAdminById(int Admin_ID) {
		return adminDAO.getAdminById(Admin_ID);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminDAO.getAllAdmins();
	}

	@Override
	public void updateAdmin(Admin admin) {
		adminDAO.updateAdmin(admin);
	}

	@Override
	public void deleteAdmin(int Admin_ID) {
		adminDAO.deleteAdmin(Admin_ID);
	}

	@Override
    public Admin login(String email, String password) {
        return adminDAO.getAdminByEmailAndPassword(email, password);
    }
}