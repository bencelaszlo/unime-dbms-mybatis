package hu.bencelaszlo.mybatis;

import hu.bencelaszlo.mybatis.utils.SessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CarDAO {
    private SessionFactory sessionFactory;

    public CarDAO() {
        this.sessionFactory = new SessionFactory();
    }

    public void save(Car car) {
        SqlSession session = sessionFactory.getSqlSessionFactory().openSession();
        session.insert("Car.insertCar", car);
        session.commit();
        session.close();
    }

    public void update(Car car) {
        SqlSession session = sessionFactory.getSqlSessionFactory().openSession();
        session.update("Car.paintCar", car);
        session.commit();
        session.close();
    }

    public void updateConditionally(int id) {
        SqlSession session = sessionFactory.getSqlSessionFactory().openSession();
        session.update("Car.paintCarConditionally", id);
        session.commit();
        session.close();
    }

    public void delete(Integer id) {
        SqlSession session = sessionFactory.getSqlSessionFactory().openSession();
        session.delete("Car.deleteCar", id);
        session.commit();
        session.close();
    }

    public void cleanDatabase() {
        SqlSession session = sessionFactory.getSqlSessionFactory().openSession();
        session.delete("Car.cleanDatabase");
        session.commit();
        session.close();
    }

    public Car getData(Integer id) {
        SqlSession session = sessionFactory.getSqlSessionFactory().openSession();
        Car car = session.selectOne("Car.selectCar", id);
        session.close();
        return car;
    }

    public List<Car> getAllData() {
        SqlSession session = sessionFactory.getSqlSessionFactory().openSession();
        List<Car> cars = session.selectList("Car.selectAllCar");
        session.close();
        return cars;
    }
}
