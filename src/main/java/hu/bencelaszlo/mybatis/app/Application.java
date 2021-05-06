package hu.bencelaszlo.mybatis.app;

import hu.bencelaszlo.mybatis.dao.CarDAO;
import hu.bencelaszlo.mybatis.entity.Car;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Application {
    public static void main(String[] args) throws ParseException {     
        CarDAO carDAO = new CarDAO();
        
        try {
            System.out.println("Table is empty");
            // LIST CARS
            List<Car> cars = carDAO.getAllData();
            for (Car c : cars) {
                System.out.println(c);
            }

            System.out.println("Create new records");
            // CREATE CARS
            Car car = new Car();
            car.setId(0);
            car.setBrand("Toyota");
            car.setModel("Avensis");
            car.setManufactureDate(new SimpleDateFormat("yyyy-MM-dd").parse( "1999-10-10"));
            car.setColor("yellow");
            carDAO.save(car);

            Car car2 = new Car();
            car2.setId(1);
            car2.setBrand("Toyota");
            car2.setModel("Corolla");
            car2.setManufactureDate(new SimpleDateFormat("yyyy-MM-dd").parse( "2001-01-11"));
            car2.setColor("dark green");
            carDAO.save(car2);

            Car car3 = new Car();
            car3.setId(2);
            car3.setBrand("Opel");
            car3.setModel("Astra");
            car3.setManufactureDate(new SimpleDateFormat("yyyy-MM-dd").parse( "1998-03-12"));
            car3.setColor("red");
            carDAO.save(car3);

            Car car4= new Car();
            car4.setId(3);
            car4.setBrand("Audi");
            car4.setModel("A4");
            car4.setManufactureDate(new SimpleDateFormat("yyyy-MM-dd").parse( "2003-01-01"));
            car4.setColor("silver");
            carDAO.save(car4);

            Car car5 = new Car();
            car5.setId(4);
            car5.setBrand("Suzuki");
            car5.setModel("Swift");
            car5.setManufactureDate(new SimpleDateFormat("yyyy-MM-dd").parse( "1992-08-10"));
            car5.setColor("orange");
            carDAO.save(car5);

            Car car6 = new Car();
            car6.setId(5);
            car6.setBrand("Skoda");
            car6.setModel("Octavia");
            car6.setManufactureDate(new SimpleDateFormat("yyyy-MM-dd").parse( "2012-14-15"));
            car6.setColor("gray");
            carDAO.save(car6);

            System.out.println("Now, there a records in the table");
            // LIST CARS
            cars = carDAO.getAllData();
            for (Car c : cars) {
                System.out.println(c);
            }

            System.out.println("Update car with id = 0 with an orange color");
            // UPDATE CAR
            car.setColor("orange");
            carDAO.update(car);

            System.out.println("Get the freshly painted car");
            // GET THE UPDATED CAR
            Car paintedCar = carDAO.getData(0);
            System.out.println(paintedCar);

            System.out.println("List cars");
            // LIST CARS
            cars = carDAO.getAllData();
            for (Car c : cars) {
                System.out.println(c);
            }

            System.out.println("Delete car with id = 0");
            // DELETE CAR
            carDAO.delete(0);
            System.out.println("Delete car with id = 4");
            carDAO.delete(4);

            // LIST CARS
            cars = carDAO.getAllData();
            for (Car c : cars) {
                System.out.println(c);
            }

            System.out.println("Update car with id = 2 with a conditional statement, it should be black, since it's manufacture date is earlier than 2000");
            // UPDATE CAR
            // it should be black
            carDAO.updateConditionally(2);

            // LIST CARS
            cars = carDAO.getAllData();
            for (Car c : cars) {
                System.out.println(c);
            }

            System.out.println("Update car with id = 3 with a conditional statement, it should be black, since it's manufacture date is after 2000");
            // it should be white
            carDAO.updateConditionally(3);

            // LIST CARS
            cars = carDAO.getAllData();
            for (Car c : cars) {
                System.out.println(c);
            }

            System.out.println("Clean the database, remove all records");
            // DELETE ALL CARS
            carDAO.cleanDatabase();


            System.out.println("List all data from the table, it should be empty");
            // LIST CARS
            cars = carDAO.getAllData();
            for (Car c : cars) {
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();

            carDAO.cleanDatabase();
        }

    }

}