package hu.bencelaszlo.mybatis;

import hu.bencelaszlo.mybatis.utils.SessionHandler;

import java.util.List;


/**
 * DAO for the car table.
 */
public class CarDAO {
    private SessionHandler sessionHandler;

    /**
     * Instantiates a new CarDAO instance.
     */
    public CarDAO() {
        this.sessionHandler = new SessionHandler();
    }

    /**
     * Saves a new car record to the database table.
     *
     * @param car the car
     */
    public void save(Car car) {
        sessionHandler.insert("Car.insertCar", car, Car.class);
    }

    /**
     * Updates a car record.
     *
     * @param car the car
     */
    public void update(Car car) {
        sessionHandler.update("Car.paintCar", car, Car.class);
    }

    /**
     * Updates a car record by its conditionally. When the referenced car is newer than 2000, it modifies its color to
     * white, otherwise to black.
     *
     * @param id the id
     */
    public void updateConditionally(int id) {
        sessionHandler.update("Car.paintCarConditionally", id, int.class);
    }

    /**
     * Deletes a car record by its ID.
     *
     * @param id the id
     */
    public void delete(Integer id) {
        sessionHandler.delete("Car.deleteCar", id, int.class);
    }

    /**
     * Cleans database, deletes every record.
     */
    public void cleanDatabase() {
        sessionHandler.delete("Car.cleanDatabase");
    }

    /**
     * Gets one car by its ID.
     *
     * @param id the id
     * @return the data
     */
    public Car getData(Integer id) {
        return sessionHandler.select("Car.selectCar", id, int.class);
    }

    /**
     * Gets all car records.
     *
     * @return the all data
     */
    public List<Car> getAllData() {
        return sessionHandler.select("Car.selectAllCar");
    }
}
