package serviceImplementation;

import java.util.List;
import dao.BusDAO;
import daoImplementation.BusDAOImpl;
import models.Bus;
import service.BusService;

public class BusServiceImpl implements BusService {
	
	private BusDAO busDAO = new BusDAOImpl();

	@Override
	public void addBus(Bus bus) {
		busDAO.addBus(bus);
	}

	@Override
	public Bus getBusByNumber(int Bus_Number) {
		return busDAO.getBusByNumber(Bus_Number);
	}

	@Override
	public List<Bus> getAllBuses() {
		return busDAO.getAllBuses();
	}

	@Override
	public void updateBus(Bus bus) {
		busDAO.updateBus(bus);
	}

	@Override
	public void deleteBus(int Bus_Number) {
		busDAO.deleteBus(Bus_Number);
	}
}