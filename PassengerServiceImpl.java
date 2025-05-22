package serviceImplementation;

import dao.PassengerDAO;
import daoImplementation.PassengerDAOImpl;
import models.Passenger;
import service.PassengerService;
import java.util.List;

public class PassengerServiceImpl implements PassengerService {

    private PassengerDAO passengerDAO = new PassengerDAOImpl();

    @Override
    public Passenger getPassengerById(int Passenger_ID) {
        return passengerDAO.getPassengerById(Passenger_ID);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerDAO.getAllPassengers();
    }

    @Override
    public void updatePassenger(Passenger passenger) {
        passengerDAO.updatePassenger(passenger);
    }

    @Override
    public void deletePassenger(int Passenger_ID) {
        passengerDAO.deletePassenger(Passenger_ID);
    }
    
    @Override
    public Passenger login(String email, String password) {
        return passengerDAO.getPassengerByEmailAndPassword(email, password);
    }
}