package hu.bencelaszlo.mybatis.dao;

import hu.bencelaszlo.mybatis.entity.Car;
import hu.bencelaszlo.mybatis.sqlsession.SessionHandler;
import hu.bencelaszlo.mybatis.utils.Constants;

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
        sessionHandler.insert(Constants.SQL_STATEMENT_INSERT_CAR, car, Car.class);
    }

    /**
     * Updates a car record.
     *
     * @param car the car
     */
    public void update(Car car) {
        sessionHandler.update(Constants.SQL_STATEMENT_UPDATE_PAINT_CAR, car, Car.class);
    }

    /**
     * Updates a car record by its conditionally. When the referenced car is newer than 2000, it modifies its color to
     * white, otherwise to black.
     *
     * @param id the id
     */
    public void updateConditionally(int id) {
        sessionHandler.update(Constants.SQL_STATEMENT_UPDATE_PAINT_CAR_CONDITIONALLY, id, int.class);
    }

    /**
     * Deletes a car record by its ID.
     *
     * @param id the id
     */
    public void delete(Integer id) {
        sessionHandler.delete(Constants.SQL_STATEMENT_DELETE_CAR, id, int.class);
    }

    /**
     * Cleans database, deletes every record.
     */
    public void cleanDatabase() {
        sessionHandler.delete(Constants.SQL_STATEMENT_DELETE_CLEAN_DATABASE);
    }

    /**
     * Gets one car by its ID.
     *
     * @param id the id
     * @return the data
     */
    public Car getData(Integer id) {
        return sessionHandler.select(Constants.SQL_STATEMENT_SELECT_CAR, id, int.class);
    }

    /**
     * Gets all car records.
     *
     * @return the all data
     */
    public List<Car> getAllData() {
        return sessionHandler.select(Constants.SQL_STATEMENT_SELECT_ALL_CAR);
    }
}
