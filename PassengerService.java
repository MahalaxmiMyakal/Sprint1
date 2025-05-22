package service;

import models.Passenger;
import java.util.List;

public interface PassengerService {
	Passenger getPassengerById(int Passenger_ID);
	List<Passenger> getAllPassengers();
	void updatePassenger(Passenger passenger);
	void deletePassenger(int Passenger_ID);
	Passenger login(String email, String password);
}