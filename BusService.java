package service;

import java.util.List;
import models.Bus;

public interface BusService {
	void addBus(Bus bus);
	Bus getBusByNumber(int Bus_Number);
	List<Bus> getAllBuses();
	void updateBus(Bus bus);
	void deleteBus(int Bus_Number);
}