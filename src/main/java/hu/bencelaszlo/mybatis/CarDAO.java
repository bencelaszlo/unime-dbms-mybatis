package hu.bencelaszlo.mybatis;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CarDAO {
    public void save(Car car) {
        SqlSession session = CarDbSessionManager.getSqlSessionFactory().openSession();
        session.insert("Car.insertCar", car);
        session.commit();
        session.close();
    }

    public void update(Car car) {
        SqlSession session = CarDbSessionManager.getSqlSessionFactory().openSession();
        session.update("Car.paintCar", car);
        session.commit();
        session.close();
    }

    public void updateConditionally(int id) {
        SqlSession session = CarDbSessionManager.getSqlSessionFactory().openSession();
        session.update("Car.paintCarConditionally", id);
        session.commit();
        session.close();
    }

    public void delete(Integer id) {
        SqlSession session = CarDbSessionManager.getSqlSessionFactory().openSession();
        session.delete("Car.deleteCar", id);
        session.commit();
        session.close();
    }

    public void cleanDatabase() {
        SqlSession session = CarDbSessionManager.getSqlSessionFactory().openSession();
        session.delete("Car.cleanDatabase");
        session.commit();
        session.close();
    }

    public Car getData(Integer id) {
        SqlSession session = CarDbSessionManager.getSqlSessionFactory().openSession();
        Car car = session.selectOne("Car.selectCar", id);
        session.close();
        return car;
    }

    public List<Car> getAllData() {
        SqlSession session = CarDbSessionManager.getSqlSessionFactory().openSession();
        List<Car> cars = session.selectList("Car.selectAllCar");
        session.close();
        return cars;
    }
}
