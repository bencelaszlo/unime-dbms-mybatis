package hu.bencelaszlo.mybatis.utils;


/**
 * Common place to store constants.
 */
public class Constants {
    // MyBatis Configuration
    public static final String MYBATIS_CONFIG_FILE = "mybatis-config.xml";

    // SQL Statements
    public static final String SQL_STATEMENT_INSERT_CAR = "Car.insertCar";
    public static final String SQL_STATEMENT_UPDATE_PAINT_CAR = "Car.paintCar";
    public static final String SQL_STATEMENT_UPDATE_PAINT_CAR_CONDITIONALLY = "Car.paintCarConditionally";
    public static final String SQL_STATEMENT_DELETE_CAR = "Car.deleteCar";
    public static final String SQL_STATEMENT_DELETE_CLEAN_DATABASE = "Car.cleanDatabase";
    public static final String SQL_STATEMENT_SELECT_CAR = "Car.selectCar";
    public static final String SQL_STATEMENT_SELECT_ALL_CAR = "Car.selectAllCar";
}
